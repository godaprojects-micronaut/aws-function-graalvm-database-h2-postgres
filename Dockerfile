FROM maven:3.6.3-openjdk-8 as builder
COPY . /home/application
WORKDIR /home/application
RUN mvn clean package
FROM amazonlinux:2018.03.0.20191014.0 as graalvm

ENV LANG=en_US.UTF-8

RUN yum install -y gcc gcc-c++ libc6-dev  zlib1g-dev curl bash zlib zlib-devel zip

ENV GRAAL_VERSION 20.1.0
ENV JDK_VERSION java8
ENV GRAAL_FILENAME graalvm-ce-${JDK_VERSION}-linux-amd64-${GRAAL_VERSION}.tar.gz

RUN curl -4 -L https://github.com/graalvm/graalvm-ce-builds/releases/download/vm-${GRAAL_VERSION}/${GRAAL_FILENAME} -o /tmp/${GRAAL_FILENAME}

RUN tar -zxvf /tmp/${GRAAL_FILENAME} -C /tmp \
    && mv /tmp/graalvm-ce-${JDK_VERSION}-${GRAAL_VERSION} /usr/lib/graalvm

RUN rm -rf /tmp/*
CMD ["/usr/lib/graalvm/bin/native-image"]

FROM graalvm
COPY --from=builder /home/application/ /home/application/
WORKDIR /home/application
RUN /usr/lib/graalvm/bin/gu install native-image
RUN /usr/lib/graalvm/bin/native-image --no-server -cp target/aws-function-graalvm-database-h2-postgres-*.jar
RUN chmod 777 bootstrap
RUN chmod 777 aws-function-graalvm-database-h2-postgres
RUN zip -j function.zip bootstrap aws-function-graalvm-database-h2-postgres
EXPOSE 8080
ENTRYPOINT ["/home/application/aws-function-graalvm-database-h2-postgres"]
