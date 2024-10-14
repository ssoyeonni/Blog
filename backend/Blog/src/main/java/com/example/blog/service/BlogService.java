package com.example.blog.service;

import com.example.blog.domain.Article;
import com.example.blog.dto.AddArticleRequest;
import com.example.blog.dto.UpdateArticleRequest;
import com.example.blog.repository.BlogRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor    // final이 붙거나 @NotNull이 붙은 필드의 생성자 추가
@Service    // 빈으로 등록
public class BlogService {

    private final BlogRepository blogRepository;

    public Article save(AddArticleRequest request) {
        return blogRepository.save(request.toEntity());
    }

    // 데이터베이스에 저장되어 있는 글 모두 조회
    public List<Article> findAll() {
        return blogRepository.findAll();
    }

    // 블로그 글의 ID를 받은 뒤 JPA에서 제공하는 메서드 이용해 데이터 삭제
    public void delete(long id) {
        blogRepository.deleteById(id);
    }

    // 블로그 글 수정
    @Transactional
    public Article update(long id, UpdateArticleRequest request) {
        Article article = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: "+id));

        article.update(request.getTitle(), request.getContent());

        return  article;
    }

}
