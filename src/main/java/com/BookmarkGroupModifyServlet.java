package com;

import com.dao.BookmarkGroupDAO;
import com.vo.BookmarkGroupVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet("/BookmarkGroupModifyServlet")
public class BookmarkGroupModifyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        req.setCharacterEncoding("UTF-8");

        BookmarkGroupVO bookmarkGroupVO = new BookmarkGroupVO();

        bookmarkGroupVO.setId(Integer.parseInt(req.getParameter("bookmarkGroupId")));
        bookmarkGroupVO.setBookmarkName(req.getParameter("bookmarkName"));
        bookmarkGroupVO.setBookmarkOrder(Integer.parseInt(req.getParameter("bookmarkOrder")));
        bookmarkGroupVO.setUpdateDate(LocalDateTime.now());

        BookmarkGroupDAO bookmarkGroupDAO = new BookmarkGroupDAO();
        bookmarkGroupDAO.updateBookmarkGroup(bookmarkGroupVO);

        resp.sendRedirect("/BookmarkGroupServlet");

    }
}