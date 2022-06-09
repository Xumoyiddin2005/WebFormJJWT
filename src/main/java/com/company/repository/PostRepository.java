package com.company.repository;

import com.company.entities.PostEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Optional;

public interface PostRepository extends CrudRepository<PostEntity, Integer> {
    @Override
    Optional<PostEntity> findById(Integer integer);

    @Transactional
    @Modifying
    @Query("Update PostEntity set title=:title, content=:content where id =:id")
    int update_profile(@Param("title") String title, @Param("content") String content, @Param("id") Integer id);

    void deleteById(Integer id);
}
