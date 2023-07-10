package com;

import com.dao.BookmarkDAO;
import com.vo.BookmarkVO;

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

@WebServlet("/BookmarkServlet")
public class BookmarkServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        req.setCharacterEncoding("UTF-8");

        BookmarkDAO bookmarkDAO = new BookmarkDAO();
        List<BookmarkVO> bookmarkVOs = bookmarkDAO.selectBookmarks();

        req.setAttribute("bookmarkVOs", bookmarkVOs);
        ServletContext app = getServletContext();
        RequestDispatcher dispatcher = app.getRequestDispatcher("/bookmark-list.jsp");
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

        BookmarkVO bookmarkVO = new BookmarkVO();
        bookmarkVO.setBookmarkName(req.getParameter("bookmarkName"));
        bookmarkVO.setWifiName(req.getParameter("wifiName"));
        bookmarkVO.setInsertDate(LocalDateTime.now());

        BookmarkDAO bookmarkDAO = new BookmarkDAO();
        bookmarkDAO.insertBookmarkGroup(bookmarkVO);

        resp.sendRedirect("/BookmarkServlet");

    }
}