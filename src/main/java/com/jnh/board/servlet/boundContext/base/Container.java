package com.jnh.board.servlet.boundContext.base;

import com.jnh.board.db.DBConnection;
import com.jnh.board.servlet.boundContext.article.controller.ArticleController;
import com.jnh.board.servlet.boundContext.article.repository.ArticleRepository;
import com.jnh.board.servlet.boundContext.article.service.ArticleService;
import com.jnh.board.servlet.boundContext.member.controller.MemberController;
import com.jnh.board.servlet.boundContext.member.repository.MemberRepository;
import com.jnh.board.servlet.boundContext.member.service.MemberService;

public class Container {
    public static DBConnection dbConnection;
    public static ArticleRepository articleRepository;
    public static ArticleService articleService;
    public static ArticleController articleController;
    public static MemberRepository memberRepository;
    public static MemberService memberService;
    public static MemberController memberController;

    static {
        dbConnection = new DBConnection();
        dbConnection.connect();
        memberRepository = new MemberRepository();
        memberService = new MemberService();
        memberController = new MemberController();
        articleRepository = new ArticleRepository();
        articleService = new ArticleService();
        articleController = new ArticleController();
    }
}