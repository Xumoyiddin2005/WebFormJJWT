package com.company.dto;

import com.company.entities.ProfileEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PostDTO {
    private Integer id;
    private String title;
    private String content;
    private boolean visible;
    private LocalDateTime createdDate;

    private ProfileEntity profileId;
}
