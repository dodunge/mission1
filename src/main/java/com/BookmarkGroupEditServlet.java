package com;

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

@WebServlet("/BookmarkGroupEditServlet")
public class BookmarkGroupEditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        req.setCharacterEncoding("UTF-8");

        String mod = req.getParameter("editMod");

        BookmarkGroupVO bookmarkGroupVO = new BookmarkGroupVO();

        bookmarkGroupVO.setId(Integer.parseInt(req.getParameter("id")));
        bookmarkGroupVO.setBookmarkName(req.getParameter("bookmarkName"));
        bookmarkGroupVO.setBookmarkOrder(Integer.parseInt(req.getParameter("bookmarkOrder")));

        req.setAttribute("bookmarkGroupVO", bookmarkGroupVO);
        ServletContext app = getServletContext();

        RequestDispatcher dispatcher = null;

        if("1".equals(mod)) {
            dispatcher = app.getRequestDispatcher("/bookmark-group-edit.jsp");
        } else {
            dispatcher = app.getRequestDispatcher("/bookmark-group-delete.jsp");
        }

        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            out.println(e);
        }

    }
}