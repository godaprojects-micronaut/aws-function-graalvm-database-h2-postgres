package aws.function.graalvm.database.h2.postgres.service;

import aws.function.graalvm.database.h2.postgres.entity.Friend;
import io.micronaut.transaction.annotation.ReadOnly;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Singleton
public class FriendService {

//    private EntityManager entityManager;
//
//    public FriendService(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }

    @ReadOnly
    public Optional<Friend> findById(@NotNull Long id) {
        return Optional.ofNullable(new Friend("Goda"));
    }

//    @Transactional
//    public Friend save(Friend hero) {
//        entityManager.persist(hero);
//        return hero;
//    }
//
//    @ReadOnly
//    public List<Friend> findAll() {
//        TypedQuery<Friend> query = entityManager.createQuery("SELECT h FROM Friend as h order by h.name", Friend.class);
//        return query.getResultList();
//    }
//
//    @Transactional
//    public void deleteById(@NotNull Long id) {
//        findById(id).ifPresent(entityManager::remove);
//    }

}
