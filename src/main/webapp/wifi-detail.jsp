<%@ page import="com.vo.WifiInfoVO" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: dodun
  Date: 2023-07-05
  Time: 오후 8:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("utf-8");
    WifiInfoVO wifiInfoVO = (WifiInfoVO) request.getAttribute("wifiInfoVO");
    List<String> bookmarkNames = (List<String>) request.getAttribute("bookmarkNames");
%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>와이파이 정보 구하기</title>
</head>
<link rel="stylesheet" href="./static/css/common.css">
<link rel="stylesheet" href="./static/css/wifi-detail.css">
<script type="text/javascript"  src="./static/js/header.js"></script>
<body>
    <header id="header" class="fixed-top">
        <script>loadHTML("header.jsp");</script>
    </header>
    <br>
    <form name="wifiDetailForm" id="wifiDetailForm" method="post" action="">
        <input type="hidden" name="wifiName" value="<%=wifiInfoVO.getWifiName()%>">
        <div class="bookmark-div">
            <select id="bookmark" name="bookmark">
                <option value="default">북마크 그룹 이름 선택</option>
                <%if(bookmarkNames.size() > 0) {
                    for(String name : bookmarkNames) {
                %>
                    <option name="bookmarkName" value="<%=name %>"><%=name %></option>
                <%
                    }
                }
                %>
            </select>
            <input type="button" value="북마크 추가하기" onclick="bookmarkAdd()">
        </div>
        <div>
            <table>
                <tr>
                    <th>거리(Km)</th>
                    <td><%=wifiInfoVO.getWifiDistance()%></td>
                </tr>
                <tr>
                    <th>관리번호</th>
                    <td><%=wifiInfoVO.getWifiMngNo()%></td>
                </tr>
                <tr>
                    <th>자치구</th>
                    <td><%=wifiInfoVO.getWifiBorough()%></td>
                </tr>
                <tr>
                    <th>와이파이명</th>
                    <td><%=wifiInfoVO.getWifiName()%></td>
                </tr>
                <tr>
                    <th>도로명주소</th>
                    <td><%=wifiInfoVO.getWifiAddress()%></td>
                </tr>
                <tr>
                    <th>상세주소</th>
                    <td><%=wifiInfoVO.getWifiAddressDetail()%></td>
                </tr>
                <tr>
                    <th>설치위치(층)</th>
                    <td><%=wifiInfoVO.getWifiFloor()%></td>
                </tr>
                <tr>
                    <th>설치유형</th>
                    <td><%=wifiInfoVO.getWifiType()%></td>
                </tr>
                <tr>
                    <th>설치기관</th>
                    <td><%=wifiInfoVO.getWifiAgency()%></td>
                </tr>
                <tr>
                    <th>서비스구분</th>
                    <td><%=wifiInfoVO.getWifiService()%></td>
                </tr>
                <tr>
                    <th>망종류</th>
                    <td><%=wifiInfoVO.getWifiNetType()%></td>
                </tr>
                <tr>
                    <th>설치년도</th>
                    <td><%=wifiInfoVO.getWifiInstallYear()%></td>
                </tr>
                <tr>
                    <th>실내외구분</th>
                    <td><%=wifiInfoVO.getWifiInOutDoor()%></td>
                </tr>
                <tr>
                    <th>WIFI접속환경</th>
                    <td><%=wifiInfoVO.getWifiConnectEnv()%></td>
                </tr>
                <tr>
                    <th>X좌표</th>
                    <td><%=wifiInfoVO.getWifiLat()%></td>
                </tr>
                <tr>
                    <th>Y좌표</th>
                    <td><%=wifiInfoVO.getWifiLnt()%></td>
                </tr>
                <tr>
                    <th>작업일자</th>
                    <td><%=wifiInfoVO.getWifiDate()%></td>
                </tr>
            </table>
        </div>
    </form>
</body>
<script type="text/javascript"  src="./static/js/bookmark-group.js"></script>
</html>
