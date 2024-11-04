package com.example.blog.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity // 엔티티로 지정
@Getter // get 관련 메서드 대체
@NoArgsConstructor(access = AccessLevel.PROTECTED)  // 기본 생성자 자동 생성
public class Article {

    @Id // 기본키로 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키를 자동으로 1씩 증가
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Builder    // 빌더 패턴으로 객체 생성
    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }

    // 수정하기 위한 메서드
    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }

    // 글 생성, 수정 시간
    @CreatedDate    // 엔티티가 생성될 때 생성 시간 저장
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate   // 엔티티가 수정될 때 마지막 수정 시간 저장
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;


}
