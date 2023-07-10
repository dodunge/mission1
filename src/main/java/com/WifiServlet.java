package com;

import com.dao.WifiInfoDAO;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.vo.WifiInfoVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/WifiServlet")
public class WifiServlet extends HttpServlet {
    static final String KEY = "5065764857646f643131306547487576";
    static int TOTALCNT;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf8");
        PrintWriter out = resp.getWriter();
        try{
            req.setAttribute("wifiCnt", addWifi());
        }catch (ParseException e) {
            out.println(e);
        }

        ServletContext app = getServletContext();
        RequestDispatcher dispatcher = app.getRequestDispatcher("/load-wifi.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            out.println(e);
        }

    }
    public static int totalCnt() throws IOException{
        StringBuilder urlBuilder = new StringBuilder("http://openapi.seoul.go.kr:8088"); /*URL*/
        urlBuilder.append("/" +  URLEncoder.encode(KEY,"UTF-8") ); /*인증키 (sample사용시에는 호출시 제한됩니다.)*/
        urlBuilder.append("/" +  URLEncoder.encode("json","UTF-8") ); /*요청파일타입 (xml,xmlf,xls,json) */
        urlBuilder.append("/" + URLEncoder.encode("TbPublicWifiInfo","UTF-8")); /*서비스명 (대소문자 구분 필수입니다.)*/
        urlBuilder.append("/" + URLEncoder.encode("1","UTF-8")); /*요청시작위치 (sample인증키 사용시 5이내 숫자)*/
        urlBuilder.append("/" + URLEncoder.encode("1","UTF-8")); /*요청종료위치(sample인증키 사용시 5이상 숫자 선택 안 됨)*/
        // 상위 5개는 필수적으로 순서바꾸지 않고 호출해야 합니다.

        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode()); /* 연결 자체에 대한 확인이 필요하므로 추가합니다.*/
        BufferedReader rd;

        // 서비스코드가 정상이면 200~300사이의 숫자가 나옵니다.
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream(),"UTF-8"));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        JsonObject result =  (JsonObject) new JsonParser().parse(sb.toString());
        JsonObject infos = result.getAsJsonObject("TbPublicWifiInfo");
        int totalGet = Integer.parseInt(infos.get("list_total_count").toString());

        System.out.println(totalGet);

        return totalGet;
    }

    public static int addWifi() throws IOException, ParseException {
        int start = 0;
        int end = 0;
        int total = 0;

        TOTALCNT = totalCnt();
        int pageEnd = TOTALCNT / 1000;
        int pageEndRemain = TOTALCNT % 1000;

        for (int k = 0; k <= pageEnd; k++) {
            start = (int) Math.pow(10, 3) * k + 1;

            if (k == pageEnd) {
                end = start + pageEndRemain - 1;
            } else {
                end = (int) Math.pow(10, 3) * (k + 1);
            }

            StringBuilder urlBuilder = new StringBuilder("http://openapi.seoul.go.kr:8088");
            urlBuilder.append("/" +  URLEncoder.encode(KEY,"UTF-8") );
            urlBuilder.append("/" +  URLEncoder.encode("json","UTF-8") );
            urlBuilder.append("/" + URLEncoder.encode("TbPublicWifiInfo","UTF-8"));
            urlBuilder.append("/" + URLEncoder.encode(String.valueOf(start),"UTF-8"));
            urlBuilder.append("/" + URLEncoder.encode(String.valueOf(end),"UTF-8"));


            URL url = new URL(urlBuilder.toString());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-type", "application/json");
            System.out.println("Response code: " + conn.getResponseCode()); /* 연결 자체에 대한 확인이 필요하므로 추가합니다.*/
            BufferedReader rd;

            // 서비스코드가 정상이면 200~300사이의 숫자가 나옵니다.
            if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
                rd = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
            } else {
                rd = new BufferedReader(new InputStreamReader(conn.getErrorStream(),"UTF-8"));
            }
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = rd.readLine()) != null) {
                sb.append(line);
            }
            rd.close();
            conn.disconnect();
            JsonObject result =  (JsonObject) new JsonParser().parse(sb.toString());

            JsonObject data = (JsonObject) result.get("TbPublicWifiInfo");
            JsonArray array = (JsonArray) data.get("row");

            JsonObject tmp;

            List<WifiInfoVO> wifiInfoVOs = new ArrayList<>();

            for (int i = 0; i < array.size(); i++) {
                try{
                    tmp = (JsonObject) array.get(i);
                    WifiInfoVO wifiInfo = new WifiInfoVO();
                    wifiInfo.setWifiDistance(new Double(0.0));
                    wifiInfo.setWifiMngNo(tmp.get("X_SWIFI_MGR_NO").getAsString());
                    wifiInfo.setWifiBorough(tmp.get("X_SWIFI_WRDOFC").getAsString());
                    wifiInfo.setWifiName(tmp.get("X_SWIFI_MAIN_NM").getAsString());
                    wifiInfo.setWifiAddress(tmp.get("X_SWIFI_ADRES1").getAsString());
                    wifiInfo.setWifiAddressDetail(tmp.get("X_SWIFI_ADRES2").getAsString());
                    wifiInfo.setWifiFloor(tmp.get("X_SWIFI_INSTL_FLOOR").getAsString());
                    wifiInfo.setWifiType(tmp.get("X_SWIFI_INSTL_TY").getAsString());
                    wifiInfo.setWifiAgency(tmp.get("X_SWIFI_INSTL_MBY").getAsString());
                    wifiInfo.setWifiService(tmp.get("X_SWIFI_SVC_SE").getAsString());
                    wifiInfo.setWifiNetType(tmp.get("X_SWIFI_CMCWR").getAsString());
                    wifiInfo.setWifiInstallYear(tmp.get("X_SWIFI_CNSTC_YEAR").getAsString());
                    wifiInfo.setWifiInOutDoor(tmp.get("X_SWIFI_INOUT_DOOR").getAsString());
                    wifiInfo.setWifiConnectEnv(tmp.get("X_SWIFI_REMARS3").getAsString());
                    wifiInfo.setWifiLat(tmp.get("LNT").getAsDouble());
                    wifiInfo.setWifiLnt(tmp.get("LAT").getAsDouble());
                    wifiInfo.setWifiDate(tmp.get("WORK_DTTM").getAsString());
                    wifiInfoVOs.add(wifiInfo);
                }catch (Exception e) {
                    System.out.println(e);
                }
            }
            WifiInfoDAO dto = new WifiInfoDAO(); // 가져오고자 하는 인자를 작성하면 됨.
            total += dto.insertWifiInfo(wifiInfoVOs);
        }
        return total;
    }
}