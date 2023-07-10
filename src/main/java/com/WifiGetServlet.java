package com;

import com.dao.HistoryDAO;
import com.dao.WifiInfoDAO;
import com.vo.HistoryVO;
import com.vo.WifiInfoVO;

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

@WebServlet("/WifiGetServlet")
public class WifiGetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        req.setCharacterEncoding("UTF-8");

        String wifiLat = req.getParameter("lat");
        String wifiLnt = req.getParameter("lnt");

        WifiInfoDAO wifiInfoDAO = new WifiInfoDAO();
        List<WifiInfoVO> wifiInfoVOs = wifiInfoDAO.selectWifiInfo(wifiLat, wifiLnt);

        HistoryVO historyVO = new HistoryVO();
        historyVO.setHistoryX(Double.parseDouble(wifiLat));
        historyVO.setHistoryY(Double.parseDouble(wifiLnt));
        historyVO.setHistoryDate(LocalDateTime.now());

        HistoryDAO historyDAO = new HistoryDAO();
        historyDAO.insertHistory(historyVO);

        req.setAttribute("wifiLat", wifiLat);
        req.setAttribute("wifiLnt", wifiLnt);
        req.setAttribute("wifiInfoVOs", wifiInfoVOs);
        ServletContext app = getServletContext();
        RequestDispatcher dispatcher = app.getRequestDispatcher("/index.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            out.println(e);
        }

    }
}