package com.dao;

import com.vo.BookmarkVO;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BookmarkDAO {
    Connection con = null;
    public int insertBookmarkGroup(BookmarkVO bookmarkVO) {
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
            query.append("insert into tbl_bookmark ");
            query.append("(bookmark_name, wifi_name, insert_date) ");
            query.append("values (?, ?, ?)");
            pstmt = con.prepareStatement(query.toString());
            pstmt.setString(1, bookmarkVO.getBookmarkName());
            pstmt.setString(2, bookmarkVO.getWifiName());
            pstmt.setString(3, bookmarkVO.getInsertDate().toString());
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
    public List<BookmarkVO> selectBookmarks() {
        List<BookmarkVO> bookmarkVOs = new ArrayList<>();
        PreparedStatement pstmt = null;
        try {
            // SQLite JDBC 체크
            Class.forName("org.sqlite.JDBC");

            // SQLite 데이터베이스 파일에 연결
            String dbFile = "D:\\zero-base\\sqlite-tools-win32-x86-3420000\\mission1.db";
            con = DriverManager.getConnection("jdbc:sqlite:" + dbFile);

            // SQL 수행
            StringBuilder query = new StringBuilder();
            query.append("select * from tbl_bookmark;");
            pstmt  = con.prepareStatement(query.toString());
            ResultSet rs = pstmt .executeQuery();
            while (rs.next()) {
                BookmarkVO bookmarkVO = new BookmarkVO();
                bookmarkVO.setId(rs.getInt("id"));
                bookmarkVO.setBookmarkName(rs.getString("bookmark_name"));
                bookmarkVO.setWifiName(rs.getString("wifi_name"));
                bookmarkVO.setInsertDate(LocalDateTime.parse(rs.getString("insert_date")));
                bookmarkVOs.add(bookmarkVO);
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
        return bookmarkVOs;
    }
    public int deleteBookmark(int id) {
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
            query.append("delete from tbl_bookmark ");
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
