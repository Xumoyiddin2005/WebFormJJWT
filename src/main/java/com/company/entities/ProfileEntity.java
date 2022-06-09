package com.company.entities;

import com.company.enums.ProfileStatus;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "profile")
public class ProfileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String surname;
    @Column(nullable = false, unique = true)
    private String login;
    @Column(nullable = false)
    private String password;
    @Column(name = "created_date")
    private LocalDateTime createdDate;
    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private ProfileStatus status;
    @Column
    private Boolean visible = Boolean.TRUE;
    @OneToMany(mappedBy = "profile")
    List<PostEntity> postList;

    @OneToMany(mappedBy = "profile")
    List<CommentEntity> comment;
}
