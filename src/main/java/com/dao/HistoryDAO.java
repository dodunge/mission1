package com.dao;

import com.vo.HistoryVO;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class HistoryDAO {
    Connection con = null;
    public int insertHistory(HistoryVO historyVO) {
        //insert실패하면 -1반환
        int result = -1;
        PreparedStatement pstmt = null;

        try {
            // SQLite JDBC 체크
            Class.forName("org.sqlite.JDBC");

            // SQLite 데이터베이스 파일에 연결
            String dbFile = "D:\\zero-base\\sqlite-tools-win32-x86-3420000\\mission1.db";
            con = DriverManager.getConnection("jdbc:sqlite:" + dbFile);

            // SQL 수행
            StringBuilder query = new StringBuilder();
            query.append("insert into tbl_history ");
            query.append("(history_x, history_y, history_date) ");
            query.append("values (?, ?, ?)");
            pstmt = con.prepareStatement(query.toString());
            pstmt.setDouble(1, historyVO.getHistoryX());
            pstmt.setDouble(2, historyVO.getHistoryY());
            pstmt.setString(3, historyVO.getHistoryDate().toString());
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("error:" + e);
            }
        }
        return result;
    }
    public List<HistoryVO> selectHistory() {
        List<HistoryVO> historyVOs = new ArrayList<>();
        PreparedStatement pstmt = null;
        try {
            // SQLite JDBC 체크
            Class.forName("org.sqlite.JDBC");

            // SQLite 데이터베이스 파일에 연결
            String dbFile = "D:\\zero-base\\sqlite-tools-win32-x86-3420000\\mission1.db";
            con = DriverManager.getConnection("jdbc:sqlite:" + dbFile);

            // SQL 수행
            StringBuilder query = new StringBuilder();
            query.append("select * from tbl_history;");
            pstmt  = con.prepareStatement(query.toString());
            ResultSet rs = pstmt .executeQuery();
            while (rs.next()) {
                HistoryVO historyVO = new HistoryVO();
                historyVO.setId(rs.getInt("id"));
                historyVO.setHistoryX(rs.getDouble("history_x"));
                historyVO.setHistoryY(rs.getDouble("history_y"));
                historyVO.setHistoryDate(LocalDateTime.parse(rs.getString("history_date")));
                historyVOs.add(historyVO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("error:" + e);
            }
        }
        return historyVOs;
    }
    public int deleteHistory(int id) {
        //insert실패하면 -1반환
        int result = -1;
        PreparedStatement pstmt = null;

        try {
            // SQLite JDBC 체크
            Class.forName("org.sqlite.JDBC");

            // SQLite 데이터베이스 파일에 연결
            String dbFile = "D:\\zero-base\\sqlite-tools-win32-x86-3420000\\mission1.db";
            con = DriverManager.getConnection("jdbc:sqlite:" + dbFile);

            // SQL 수행
            StringBuilder query = new StringBuilder();
            query.append("delete from tbl_history ");
            query.append("where id = ? ");
            pstmt = con.prepareStatement(query.toString());
            pstmt.setInt(1, id);
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("error:" + e);
            }
        }
        return result;
    }
}
