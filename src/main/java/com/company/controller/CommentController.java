package com.company.controller;

import com.company.dto.CommentDTO;
import com.company.dto.ProfileDTO;
import com.company.entities.ProfileEntity;
import com.company.service.CommentService;
import com.company.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody CommentDTO dto,
                                    @RequestHeader("Authorization") String jwtToken) {
        Integer pId = JwtUtil.decode(jwtToken);
        commentService.create(dto, dto.getPostId());
        return ResponseEntity.ok().body("Successfully created");
    }
    @GetMapping("/list/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Integer id) {
        CommentDTO dto = commentService.getList(id);
        return ResponseEntity.ok().body(dto);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody CommentDTO dto){
        commentService.update(id, dto);
        ResponseEntity<Object> build = ResponseEntity.ok().body("Successfully updated");
        return build;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id){
        commentService.delete(id);
        ResponseEntity<Object> build = ResponseEntity.ok().body("Successfully deleted");
        return build;
    }
}
