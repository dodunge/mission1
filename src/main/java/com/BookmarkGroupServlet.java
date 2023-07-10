package com;

import com.dao.BookmarkGroupDAO;
import com.vo.BookmarkGroupVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.List;

@WebServlet("/BookmarkGroupServlet")
public class BookmarkGroupServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        req.setCharacterEncoding("UTF-8");

        BookmarkGroupDAO bookmarkGroupDAO = new BookmarkGroupDAO();
        List<BookmarkGroupVO> bookmarkGroupVOs = bookmarkGroupDAO.selectBookmarkGroup();

        req.setAttribute("bookmarkGroupVOs", bookmarkGroupVOs);
        ServletContext app = getServletContext();
        RequestDispatcher dispatcher = app.getRequestDispatcher("/bookmark-group.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            out.println(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        req.setCharacterEncoding("UTF-8");

        BookmarkGroupVO bookmarkGroupVO = new BookmarkGroupVO();
        bookmarkGroupVO.setBookmarkName(req.getParameter("bookmarkName"));
        bookmarkGroupVO.setBookmarkOrder(Integer.parseInt(req.getParameter("bookmarkOrder")));
        bookmarkGroupVO.setInsertDate(LocalDateTime.now());

        BookmarkGroupDAO bookmarkGroupDAO= new BookmarkGroupDAO();
        bookmarkGroupDAO.insertBookmarkGroup(bookmarkGroupVO);

        resp.sendRedirect("/BookmarkGroupServlet");
    }
}