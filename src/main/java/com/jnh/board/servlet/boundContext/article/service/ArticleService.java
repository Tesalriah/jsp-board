package com.jnh.board.servlet.boundContext.article.service;

import com.jnh.board.servlet.boundContext.article.dto.ArticleDto;
import com.jnh.board.servlet.boundContext.article.entity.Article;
import com.jnh.board.servlet.boundContext.article.repository.ArticleRepository;
import com.jnh.board.servlet.boundContext.base.Container;
import com.jnh.board.servlet.boundContext.member.dto.Member;

import java.util.List;

public class ArticleService {
    private ArticleRepository articleRepository;

    public ArticleService() {
        articleRepository = Container.articleRepository;
    }

    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    public long write(String title, String content, Member member) {
        return articleRepository.save(title, content, member);
    }

    public List<ArticleDto> joinMenmberFindAll(){
        return articleRepository.joinMemberFindAll();
    }

    public ArticleDto joinMemberFindById(long id){
        return articleRepository.joinMemberFindById(id);
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
