package com;

import com.dao.BookmarkGroupDAO;
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
import java.util.List;

@WebServlet("/WifiDetailServlet")
public class WifiDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        req.setCharacterEncoding("UTF-8");

        WifiInfoVO wifiInfoVO = new WifiInfoVO();

        wifiInfoVO.setId(Integer.parseInt(req.getParameter("id")));
        wifiInfoVO.setWifiDistance(Double.parseDouble(req.getParameter("distance")));
        wifiInfoVO.setWifiMngNo(req.getParameter("mng_no"));
        wifiInfoVO.setWifiBorough(req.getParameter("borough"));
        wifiInfoVO.setWifiName(req.getParameter("name"));
        wifiInfoVO.setWifiAddress(req.getParameter("address"));
        wifiInfoVO.setWifiAddressDetail(req.getParameter("addressDetail"));
        wifiInfoVO.setWifiFloor(req.getParameter("floor"));
        wifiInfoVO.setWifiType(req.getParameter("type"));
        wifiInfoVO.setWifiAgency(req.getParameter("agency"));
        wifiInfoVO.setWifiService(req.getParameter("service"));
        wifiInfoVO.setWifiNetType(req.getParameter("netType"));
        wifiInfoVO.setWifiInstallYear(req.getParameter("installYear"));
        wifiInfoVO.setWifiInOutDoor(req.getParameter("inOutDoor"));
        wifiInfoVO.setWifiConnectEnv(req.getParameter("connectEnv"));
        wifiInfoVO.setWifiLat(Double.parseDouble(req.getParameter("lat")));
        wifiInfoVO.setWifiLnt(Double.parseDouble(req.getParameter("lnt")));
        wifiInfoVO.setWifiDate(req.getParameter("date"));

        BookmarkGroupDAO bookmarkGroupDAO = new BookmarkGroupDAO();
        List<String> bookmarkNames = bookmarkGroupDAO.selectBookmarkGroupNames();

        req.setAttribute("bookmarkNames", bookmarkNames);
        req.setAttribute("wifiInfoVO", wifiInfoVO);
        ServletContext app = getServletContext();
        RequestDispatcher dispatcher = app.getRequestDispatcher("/wifi-detail.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            out.println(e);
        }
    }
}