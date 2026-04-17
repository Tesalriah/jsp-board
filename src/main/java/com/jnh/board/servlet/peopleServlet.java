package com.jnh.board.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/people")
public class peopleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Rq rq = new Rq(req, resp);

        String name = rq.getParam("name", "이름없음");
        int age = rq.getIntParam("age", 0);
        int height = rq.getIntParam("height", 0);

        rq.writer("<p>이름 : " + name + "</p>" +
                "<p>나이 : " + age + "</p>" +
                "<p>키 : " + height + "</p>"
        );
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
