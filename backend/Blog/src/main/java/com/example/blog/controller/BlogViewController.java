package com.example.blog.controller;

import com.example.blog.domain.Article;
import com.example.blog.dto.ArticleListViewResponse;
import com.example.blog.dto.ArticleViewResponse;
import com.example.blog.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * 블로그 글, 글 목록 뷰 구현
 * /article GET 요청 처리 코드
 */
@RequiredArgsConstructor
@Controller
public class BlogViewController {

    private final BlogService blogService;

    // 글 목록
    @GetMapping("/articles")
    public String getArticles(Model model) {
        List<ArticleListViewResponse> articles = blogService.findAll()
                .stream()
                .map(ArticleListViewResponse::new)
                .toList();

        model.addAttribute("articles", articles);   // 블로그 글 리스트 저장

        return "articleList";   // articleList.html 뷰 조회
    }

    // 글 뷰
    @GetMapping("/articles/{id}")
    public String getArticle(@PathVariable Long id, Model model) {
        Article article = blogService.findById(id);
        model.addAttribute("article", new ArticleViewResponse(article));

        return "article";
    }

}
