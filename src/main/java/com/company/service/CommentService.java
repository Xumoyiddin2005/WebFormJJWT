package com.company.service;

import com.company.dto.CommentDTO;
import com.company.entities.CommentEntity;
import com.company.entities.PostEntity;
import com.company.entities.ProfileEntity;
import com.company.exp.BadRequestException;
import com.company.exp.ItemNotFoundException;
import com.company.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public void create(CommentDTO dto, PostEntity poId) {
        CommentEntity entity = new CommentEntity();
        entity.setContent(dto.getContent());
        entity.setPostId(poId);
        commentRepository.save(entity);
    }

    public CommentDTO getList(Integer id){
        Optional<CommentEntity> optional = commentRepository.findById(id);
        if (optional.isEmpty()){
            throw new BadRequestException("Mazgi bunaqa comment yo'qku");
        }

        CommentEntity entity = optional.get();

        CommentDTO dto = new CommentDTO();
        dto.setContent(entity.getContent());
        dto.setProfileId(Integer.parseInt(String.valueOf(entity.getProfile())));
        dto.setPostId(entity.getPostId());

        return dto;
    }

    public void update(Integer id, CommentDTO dto) {

        Optional<CommentEntity> optional = commentRepository.findById(id);
        if (optional.isEmpty()) {
            throw new ItemNotFoundException("Profile not fount");
        }
        commentRepository.update_profile(dto.getContent(), id);
    }

    public void delete(Integer id) {
        Optional<CommentEntity> entity = commentRepository.findById(id);
        if (entity.isEmpty()) {
            throw new BadRequestException("Mazgayob blin ezvoring bunaqa id li foydalanuvchi yo'q");
        } else {
            commentRepository.deleteById(id);
        }
    }
}
