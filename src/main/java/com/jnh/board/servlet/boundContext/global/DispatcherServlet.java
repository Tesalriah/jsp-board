package com.jnh.board.servlet.boundContext.global;

import com.jnh.board.servlet.boundContext.article.controller.ArticleController;
import com.jnh.board.servlet.boundContext.base.Container;
import com.jnh.board.servlet.boundContext.global.base.Rq;
import com.jnh.board.servlet.boundContext.member.controller.MemberController;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/usr/*")
public class DispatcherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Rq rq = new Rq(req, resp);

        MemberController memberController = Container.memberController;
        ArticleController articleController = Container.articleController;

        switch (rq.getMethod()) {
            case "GET" -> {
                switch (rq.getActionPath()) {
                    case "/usr/article/write" -> articleController.showWrite(rq);
                    case "/usr/article/list" -> articleController.showList(rq);
                    case "/usr/article/detail" -> articleController.showDetail(rq);
                    case "/usr/article/modify" -> articleController.showModify(rq);
                    case "/usr/member/join" -> memberController.showJoin(rq);
                    case "/usr/member/login" -> memberController.showLogin(rq);
                    case "/usr/member/logout" -> memberController.doLogout(rq);
                }
            }
            case "POST" ->{
                switch (rq.getActionPath()) {
                    case "/usr/article/write" -> articleController.doWrite(rq);
                    case "/usr/article/modify" -> articleController.doModify(rq);
                    case "/usr/article/delete" -> articleController.doDelete(rq);
                    case "/usr/member/join" -> memberController.doJoin(rq);
                    case "/usr/member/login" -> memberController.doLogin(rq);
                }
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}