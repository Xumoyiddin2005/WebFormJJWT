package com.company.repository;

import com.company.entities.CommentEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface CommentRepository extends CrudRepository<CommentEntity, Integer> {
    @Transactional
    @Modifying
    @Query("Update CommentEntity set content=:content where id =:id")
    int update_profile(@Param("content") String content, @Param("id") Integer id);

    void deleteById(Integer id);
}
