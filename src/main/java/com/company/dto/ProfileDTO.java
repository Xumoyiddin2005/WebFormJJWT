package com.company.dto;

import com.company.enums.ProfileStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProfileDTO {
    private Integer id;
    private String name;
    private String surname;
    private String login;
    private String password;
    private LocalDateTime createdDate = LocalDateTime.now();
    private ProfileStatus status = ProfileStatus.ACTIVE;
    private Boolean visible = Boolean.TRUE;
    private String jjwtToken;
}
