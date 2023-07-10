package com;

import com.dao.BookmarkDAO;
import com.vo.BookmarkVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

@WebServlet("/BookmarkDeleteServlet")
public class BookmarkDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        req.setCharacterEncoding("UTF-8");

        int id = Integer.parseInt(req.getParameter("bookmarkId"));

        BookmarkDAO bookmarkDAO = new BookmarkDAO();
        bookmarkDAO.deleteBookmark(id);

        resp.sendRedirect("/BookmarkServlet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        req.setCharacterEncoding("UTF-8");

        BookmarkVO bookmarkVO = new BookmarkVO();
        bookmarkVO.setId(Integer.parseInt(req.getParameter("bookmarkId")));
        bookmarkVO.setBookmarkName(req.getParameter("bookmarkName"));
        bookmarkVO.setWifiName(req.getParameter("wifiName"));
        bookmarkVO.setInsertDate(LocalDateTime.parse(req.getParameter("insertDate")));

        req.setAttribute("bookmarkVO", bookmarkVO);
        ServletContext app = getServletContext();
        RequestDispatcher dispatcher = app.getRequestDispatcher("/bookmark-delete.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            out.println(e);
        }

    }
}