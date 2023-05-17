package com.example.sbb.Answer;

import com.example.sbb.Question.Question;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import com.example.sbb.user.SiteUser;
import org.springframework.data.annotation.CreatedDate;
import java.util.Set;
import jakarta.persistence.ManyToMany;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "TEXT")
    private String content;
@CreatedDate
    private LocalDateTime createDate;
@ManyToOne
    private Question question;

    @ManyToOne
    private SiteUser author;
    private LocalDateTime modifyDate;

    @ManyToMany
    Set<SiteUser> voter;
}
