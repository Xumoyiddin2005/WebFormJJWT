package com.company.controller;

import com.company.dto.PostDTO;
import com.company.dto.ProfileDTO;
import com.company.service.PostService;
import com.company.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody PostDTO dto,
                                    @RequestHeader("Authorization") String jwtToken) {
        Integer pId = JwtUtil.decode(jwtToken);
        postService.create(dto);
        return ResponseEntity.ok().body("Successfully created");
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Integer id) {
        PostDTO postDTO = postService.getById(id);
        return ResponseEntity.ok().body(postDTO);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody PostDTO dto){
        postService.update(id, dto);
        return ResponseEntity.ok().<Object>body("Successfully updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id){
        postService.delete(id);
        ResponseEntity<Object> build = ResponseEntity.ok().body("Successfully deleted");
        return build;
    }
}
