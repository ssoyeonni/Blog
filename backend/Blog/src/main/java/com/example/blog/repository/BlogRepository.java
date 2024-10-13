package com.example.blog.repository;

import com.example.blog.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

// Jpa 상속 받을 때 엔티티 Article과 엔티티 기본키 타입의 Long을 인수로 받음
public interface BlogRepository extends JpaRepository<Article, Long> {
}
