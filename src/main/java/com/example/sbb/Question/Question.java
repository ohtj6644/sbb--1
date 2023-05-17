package com.example.sbb.Question;

import java.time.LocalDateTime;
import java.util.List;
import jakarta.persistence.ManyToOne;
import com.example.sbb.user.SiteUser;
import com.example.sbb.Answer.Answer;
import jakarta.persistence.*;
import java.util.Set;
import jakarta.persistence.ManyToMany;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
// db 자동 엔티티
public class Question {
    @Id
    // 아래는 아이디값이라고 선언
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200)
    //컬럼 이라고 선언.
    private String subject;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createDate;
    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    private List<Answer> answerList;

    @ManyToOne
    private SiteUser author;
    private LocalDateTime modifyDate;

    @ManyToMany
    Set<SiteUser> voter;
}