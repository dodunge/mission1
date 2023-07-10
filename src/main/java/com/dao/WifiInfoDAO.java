package com.dao;

import com.vo.WifiInfoVO;

import java.sql.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class WifiInfoDAO {
    Connection con = null;
    public int insertWifiInfo(List<WifiInfoVO> wifiInfos) {
        int result = 0;
        PreparedStatement pstmt = null;

        try {
            // SQLite JDBC 체크
            Class.forName("org.sqlite.JDBC");

            // SQLite 데이터베이스 파일에 연결
            String dbFile = "D:\\zero-base\\sqlite-tools-win32-x86-3420000\\mission1.db";
            con = DriverManager.getConnection("jdbc:sqlite:" + dbFile);

            con.setAutoCommit(false);

            // SQL 수행
            for(WifiInfoVO wifiInfo : wifiInfos) {
                StringBuilder query = new StringBuilder();
                query.append("insert into tbl_wifi_info (wifi_mng_no, ");
                query.append("wifi_borough, wifi_name, wifi_address, ");
                query.append("wifi_address_detail, wifi_floor, wifi_type, ");
                query.append("wifi_agency, wifi_service, wifi_net_type, ");
                query.append("wifi_install_year, wifi_in_out_door, wifi_connect_env, ");
                query.append("wifi_lat, wifi_lnt, wifi_date) ");
                query.append("values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?); ");

                pstmt = con.prepareStatement(query.toString());
                pstmt.setString(1, wifiInfo.getWifiMngNo());
                pstmt.setString(2, wifiInfo.getWifiBorough());
                pstmt.setString(3, wifiInfo.getWifiName());
                pstmt.setString(4, wifiInfo.getWifiAddress());
                pstmt.setString(5, wifiInfo.getWifiAddressDetail());
                pstmt.setString(6, wifiInfo.getWifiFloor());
                pstmt.setString(7, wifiInfo.getWifiType());
                pstmt.setString(8, wifiInfo.getWifiAgency());
                pstmt.setString(9, wifiInfo.getWifiService());
                pstmt.setString(10, wifiInfo.getWifiNetType());
                pstmt.setString(11, wifiInfo.getWifiInstallYear());
                pstmt.setString(12, wifiInfo.getWifiInOutDoor());
                pstmt.setString(13, wifiInfo.getWifiConnectEnv());
                pstmt.setDouble(14, wifiInfo.getWifiLat());
                pstmt.setDouble(15, wifiInfo.getWifiLnt());
                pstmt.setString(16, wifiInfo.getWifiDate());
                result += pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                if (con != null) {
                    con.rollback();
                }
            } catch (SQLException e2) {
                System.out.println("error:" + e2);
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
                if (con != null) {
                    con.rollback();
                }
            } catch (SQLException e2) {
                System.out.println("error:" + e2);
            }
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (con != null) {
                    con.commit();
                    con.setAutoCommit(true);
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("error:" + e);
            }
        }
        return result;
    }
    public List<WifiInfoVO> selectWifiInfo(String lat, String lnt) {
        List<WifiInfoVO> wifiInfoVOs = new ArrayList<>();
        PreparedStatement pstmt = null;
        try {
            // SQLite JDBC 체크
            Class.forName("org.sqlite.JDBC");

            // SQLite 데이터베이스 파일에 연결
            String dbFile = "D:\\zero-base\\sqlite-tools-win32-x86-3420000\\mission1.db";
            con = DriverManager.getConnection("jdbc:sqlite:" + dbFile);

            // SQL 수행
            StringBuilder query = new StringBuilder();
            query.append("select SQRT((wifi_lat - ?) * (wifi_lat - ?) ");
            query.append("+ (wifi_lnt - ?) * (wifi_lnt - ?)) * 100  as distance,");
            query.append(" * from tbl_wifi_info order by distance limit 20;");
            pstmt  = con.prepareStatement(query.toString());
            pstmt.setDouble(1, Double.parseDouble(lat));
            pstmt.setDouble(2, Double.parseDouble(lat));
            pstmt.setDouble(3, Double.parseDouble(lnt));
            pstmt.setDouble(4, Double.parseDouble(lnt));
            ResultSet rs = pstmt .executeQuery();
            while (rs.next()) {
                WifiInfoVO wifiInfoVO = new WifiInfoVO();
                wifiInfoVO.setId(rs.getInt("id"));
                wifiInfoVO.setWifiDistance(Double.parseDouble(new DecimalFormat("#.####").format(rs.getDouble("distance"))));
                wifiInfoVO.setWifiMngNo(rs.getString("wifi_mng_no"));
                wifiInfoVO.setWifiBorough(rs.getString("wifi_borough"));
                wifiInfoVO.setWifiName(rs.getString("wifi_name"));
                wifiInfoVO.setWifiAddress(rs.getString("wifi_address"));
                wifiInfoVO.setWifiAddressDetail(rs.getString("wifi_address_detail"));
                wifiInfoVO.setWifiFloor(rs.getString("wifi_floor"));
                wifiInfoVO.setWifiType(rs.getString("wifi_type"));
                wifiInfoVO.setWifiAgency(rs.getString("wifi_agency"));
                wifiInfoVO.setWifiService(rs.getString("wifi_service"));
                wifiInfoVO.setWifiNetType(rs.getString("wifi_net_type"));
                wifiInfoVO.setWifiInstallYear(rs.getString("wifi_install_year"));
                wifiInfoVO.setWifiInOutDoor(rs.getString("wifi_in_out_door"));
                wifiInfoVO.setWifiConnectEnv(rs.getString("wifi_connect_env"));
                wifiInfoVO.setWifiLat(rs.getDouble("wifi_lat"));
                wifiInfoVO.setWifiLnt(rs.getDouble("wifi_lnt"));
                wifiInfoVO.setWifiDate(rs.getString("wifi_date"));
                wifiInfoVOs.add(wifiInfoVO);
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
        return wifiInfoVOs;
    }
}
