package aws.function.graalvm.database.h2.postgres.controller;

import aws.function.graalvm.database.h2.postgres.entity.Friend;
import aws.function.graalvm.database.h2.postgres.service.FriendService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;

import javax.validation.Valid;
import java.util.List;

@ExecuteOn(TaskExecutors.IO)
@Controller("/friend")
public class FriendController {

    private final FriendService service;

    public FriendController(FriendService service) {
        this.service = service;
    }

    @Get("/{id}")
    public Friend show(Long id) {
        return service.findById(id).orElse(null);
    }

//    @Get
//    public List<Friend> findAll() {
//        return service.findAll();
//    }
//
//    @Post
//    public HttpResponse<Friend> save(@Body @Valid Friend friend) {
//        return HttpResponse.created(service.save(friend));
//    }
//
//    @Delete("/{id}")
//    public HttpResponse delete(Long id) {
//        service.deleteById(id);
//        return HttpResponse.noContent();
//    }
}
