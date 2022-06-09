package com.company.repository;

import com.company.entities.ProfileEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Optional;
public interface ProfileRepository extends CrudRepository<ProfileEntity, Integer> {

    Optional<ProfileEntity> findById(Integer integer);

    Optional<ProfileEntity> findByLogin(String login);

    @Transactional
    @Modifying
    @Query("Update ProfileEntity set name=:name, surname=:sur where id =:id")
    int update_profile(@Param("name") String name, @Param("sur") String surname, @Param("id") Integer id);

    void deleteById(Integer id);
}
