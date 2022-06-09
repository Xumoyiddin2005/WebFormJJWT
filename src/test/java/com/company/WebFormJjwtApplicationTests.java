package com.company;

import com.company.dto.ProfileDTO;
import com.company.entities.CommentEntity;
import com.company.entities.PostEntity;
import com.company.entities.ProfileEntity;
import com.company.enums.ProfileStatus;
import com.company.repository.CommentRepository;
import com.company.repository.PostRepository;
import com.company.repository.ProfileRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class WebFormJjwtApplicationTests {
    @Autowired
    ProfileRepository profileRepository;
    @Autowired
    PostRepository postRepository;
    @Autowired
    CommentRepository commentRepository;

    @Test
    void contextLoads() {

        ProfileEntity entity = new ProfileEntity();
        entity.setName("Xumoyun");
        entity.setSurname("Xolmuminov");
        entity.setLogin("fgkf");
        entity.setPassword("123456");
        entity.setCreatedDate(LocalDateTime.now());
        entity.setStatus(ProfileStatus.ACTIVE);
        entity.setVisible(Boolean.FALSE);
        profileRepository.save(entity);

        PostEntity profileEntity = new PostEntity();
        profileEntity.setTitle("Buxanka");
        profileEntity.setProfile(entity);
        profileEntity.setContent("Qimmat");
        postRepository.save(profileEntity);

        CommentEntity comment = new CommentEntity();
        comment.setProfile(entity);
        comment.setCreatedDate(LocalDateTime.now());
        comment.setPostId(profileEntity);
        comment.setVisible(Boolean.TRUE);
        comment.setContent("Malades");
        commentRepository.save(comment);

    }

    @Test
    void createPassportDetail() {

        ProfileEntity entity = new ProfileEntity();
        entity.setName("Xumoyun");
        entity.setSurname("Xolmuminov");
        entity.setLogin("olma");
        entity.setPassword("123456");
        entity.setCreatedDate(LocalDateTime.now());
        entity.setStatus(ProfileStatus.ACTIVE);
        entity.setVisible(Boolean.FALSE);
        profileRepository.save(entity);

        PostEntity profileEntity = new PostEntity();
        profileEntity.setTitle("Buxanka");
        profileEntity.setProfile(entity);
        profileEntity.setContent("Qimmat");
        postRepository.save(profileEntity);
    }
}

