package com.juanba.talkie_toki_api.comment.entity;

import com.juanba.talkie_toki_api.user.entity.User;
import com.juanba.talkie_toki_api.util.CommunityTopic;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_topic")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(unique = true)
    private String title;

    @NotNull
    @Column(unique = true)
    private String message;

    @NotNull
    @JoinColumn(name = "user_name")
    @ManyToOne(targetEntity = User.class)
    private User user;

    private LocalDateTime date;

    @NotNull
    @Enumerated(EnumType.STRING)
    private CommunityTopic communityTopic;

    private Boolean isActive;

    public void deactivateComment() {
        isActive = false;
    }
}
