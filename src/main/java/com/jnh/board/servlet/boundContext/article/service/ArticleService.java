package com.jnh.board.servlet.boundContext.article.service;

import com.jnh.board.servlet.boundContext.article.dto.Article;
import com.jnh.board.servlet.boundContext.article.repository.ArticleRepository;
import com.jnh.board.servlet.boundContext.base.Container;

import java.util.List;

public class ArticleService {
    private ArticleRepository articleRepository;

    public ArticleService() {
        articleRepository = Container.articleRepository;
    }

    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    public long write(String title, String content) {
        return articleRepository.save(title, content);
    }

    public Article findById(long id) {
        return articleRepository.findById(id);
    }

    public void modify(long id, String title, String content) {
        articleRepository.modify(id,title, content);
    }

    public void delete(long id) {
        articleRepository.delete(id);
    }
}
