package com.example.blog.dto;

import com.example.blog.domain.Article;
import lombok.Getter;

/*
/api/articles GET 요청이 오면 글 목록 조회
 */
@Getter
public class ArticleResponse {

    private final String title;
    private final String content;

    public ArticleResponse(Article article) {
        this.title = article.getTitle();
        this.content = article.getContent();
    }

}
