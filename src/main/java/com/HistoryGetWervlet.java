package com;

import com.dao.HistoryDAO;
import com.vo.HistoryVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/HistoryGetServlet")
public class HistoryGetWervlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        req.setCharacterEncoding("UTF-8");

        HistoryDAO historyDAO = new HistoryDAO();
        List<HistoryVO> historyVOs = historyDAO.selectHistory();

        req.setAttribute("historyVOs", historyVOs);
        ServletContext app = getServletContext();
        RequestDispatcher dispatcher = app.getRequestDispatcher("/history.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            out.println(e);
        }
    }
}