package com.company.service;

import com.company.dto.PostDTO;
import com.company.entities.PostEntity;
import com.company.exp.BadRequestException;
import com.company.exp.ItemNotFoundException;
import com.company.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public void create(PostDTO dto) {
        PostEntity entity = new PostEntity();
        entity.setTitle(dto.getTitle());
        entity.setContent(dto.getContent());
        postRepository.save(entity);
        dto.setId(entity.getId());
    }
    public PostDTO getById(Integer id) {

        Optional<PostEntity> optional = postRepository.findById(id);

        if (optional.isEmpty()) {
            throw new ItemNotFoundException("Profile not fount");
        }
        PostEntity entity = optional.get();

        PostDTO dto = new PostDTO();
        dto.setTitle(entity.getTitle());
        dto.setContent(entity.getContent());
        return dto;
    }

    public void update(Integer id, PostDTO dto) {
        Optional<PostEntity> entity = postRepository.findById(id);
        if (entity.isEmpty()) {
            throw new BadRequestException("Mazgi post topilmadi");
        }
        postRepository.update_profile(dto.getTitle(), dto.getContent(), id);
    }

    public void delete(Integer id) {
        Optional<PostEntity> entity = postRepository.findById(id);
        if (entity.isEmpty()) {
            throw new BadRequestException("Mazgayob blin ezvoring bunaqa id li foydalanuvchi yo'q");
        } else {
            postRepository.deleteById(id);
        }
    }
}
