package com;

import com.dao.BookmarkGroupDAO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;

@WebServlet("/BookmarkGroupDeleteServlet")
public class BookmarkGroupDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        req.setCharacterEncoding("UTF-8");

        int id = Integer.parseInt(req.getParameter("bookmarkGroupId"));

        BookmarkGroupDAO bookmarkGroupDAO = new BookmarkGroupDAO();
        bookmarkGroupDAO.deleteBookmarkGroup(id);

        resp.sendRedirect("/BookmarkGroupServlet");
    }
}