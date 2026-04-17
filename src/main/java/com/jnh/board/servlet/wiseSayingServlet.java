package com.jnh.board.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/wiseSaying")
public class wiseSayingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Rq rq = new Rq(req, resp);

        String content = rq.getParam("content", "");
        String author = rq.getParam("author", "");

        rq.writer("<h1>명언</h1>" +
                "<div>명언 :" + content +"</div>" +
                "작가 : " + author);
    }
}
