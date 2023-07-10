package com.dao;

import com.vo.BookmarkGroupVO;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BookmarkGroupDAO {
    Connection con = null;
    public int insertBookmarkGroup(BookmarkGroupVO bookmarkGroupVO) {
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
            query.append("insert into tbl_bookmark_group ");
            query.append("(bookmark_name, bookmark_order, insert_date) ");
            query.append("values (?, ?, ?)");
            pstmt = con.prepareStatement(query.toString());
            pstmt.setString(1, bookmarkGroupVO.getBookmarkName());
            pstmt.setInt(2, bookmarkGroupVO.getBookmarkOrder());
            pstmt.setString(3, bookmarkGroupVO.getInsertDate().toString());
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
    public List<BookmarkGroupVO> selectBookmarkGroup() {
        List<BookmarkGroupVO> bookmarkGroupVOs = new ArrayList<>();
        PreparedStatement pstmt = null;
        try {
            // SQLite JDBC 체크
            Class.forName("org.sqlite.JDBC");

            // SQLite 데이터베이스 파일에 연결
            String dbFile = "D:\\zero-base\\sqlite-tools-win32-x86-3420000\\mission1.db";
            con = DriverManager.getConnection("jdbc:sqlite:" + dbFile);

            // SQL 수행
            StringBuilder query = new StringBuilder();
            query.append("select * from tbl_bookmark_group order by bookmark_order;");
            pstmt  = con.prepareStatement(query.toString());
            ResultSet rs = pstmt .executeQuery();
            while (rs.next()) {
                BookmarkGroupVO bookmarkGroupVO = new BookmarkGroupVO();
                bookmarkGroupVO.setId(rs.getInt("id"));
                bookmarkGroupVO.setBookmarkName(rs.getString("bookmark_name"));
                bookmarkGroupVO.setBookmarkOrder(rs.getInt("bookmark_order"));
                bookmarkGroupVO.setInsertDate(LocalDateTime.parse(rs.getString("insert_date")));
                if(rs.getString("update_date") != null) {
                    bookmarkGroupVO.setUpdateDate(LocalDateTime.parse(rs.getString("update_date")));
                }
                bookmarkGroupVOs.add(bookmarkGroupVO);
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
        return bookmarkGroupVOs;
    }
    public List<String> selectBookmarkGroupNames() {
        List<String> bookmarkNames = new ArrayList<>();
        PreparedStatement pstmt = null;
        try {
            // SQLite JDBC 체크
            Class.forName("org.sqlite.JDBC");

            // SQLite 데이터베이스 파일에 연결
            String dbFile = "D:\\zero-base\\sqlite-tools-win32-x86-3420000\\mission1.db";
            con = DriverManager.getConnection("jdbc:sqlite:" + dbFile);

            // SQL 수행
            StringBuilder query = new StringBuilder();
            query.append("select bookmark_name from tbl_bookmark_group order by bookmark_order;");
            pstmt  = con.prepareStatement(query.toString());
            ResultSet rs = pstmt .executeQuery();
            while (rs.next()) {
                String bookmarkName = rs.getString("bookmark_name");
                bookmarkNames.add(bookmarkName);
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
        return bookmarkNames;
    }
    public int updateBookmarkGroup(BookmarkGroupVO bookmarkGroupVO) {
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
            query.append("update tbl_bookmark_group ");
            query.append("set bookmark_name = ?, bookmark_order = ?, update_date = ? ");
            query.append("where id = ? ");
            pstmt = con.prepareStatement(query.toString());
            pstmt.setString(1, bookmarkGroupVO.getBookmarkName());
            pstmt.setInt(2, bookmarkGroupVO.getBookmarkOrder());
            pstmt.setString(3, bookmarkGroupVO.getUpdateDate().toString());
            pstmt.setInt(4, bookmarkGroupVO.getId());
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
    public int deleteBookmarkGroup(int id) {
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
            query.append("delete from tbl_bookmark_group ");
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
