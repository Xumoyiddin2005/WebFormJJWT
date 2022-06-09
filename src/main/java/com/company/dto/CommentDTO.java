package com.company.dto;

import com.company.entities.PostEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommentDTO {
    private Integer id;
    private String content;
    private Integer profileId;
    private PostEntity postId;
    private Boolean visible;
    private LocalDateTime createdDate;
}
