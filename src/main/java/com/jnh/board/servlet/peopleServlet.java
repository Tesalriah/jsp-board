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
        req.setCharacterEncoding("UTF-8"); // 들어오는 데이터를 UTF-8로 인코딩
        resp.setCharacterEncoding("UTF-8"); // 응답 데이터를 UTF-8로 인코딩
        resp.setContentType("text/html; charset=UTF-8"); // 브라우저한테 우리가 만든 결과물은 UTF-8로 인코딩된 HTML임을 알려줌

        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        int height = Integer.parseInt(req.getParameter("height"));

        resp.getWriter().append("<p>이름 : " + name + "</p>");
        resp.getWriter().append("<p>나이 : " + age + "</p>");
        resp.getWriter().append("<p>키 : " + height + "</p>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
