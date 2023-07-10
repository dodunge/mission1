<%@ page import="com.vo.WifiInfoVO" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    request.setCharacterEncoding("utf-8");
    List<WifiInfoVO> wifiInfoVOs = (List<WifiInfoVO>) request.getAttribute("wifiInfoVOs");
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
<script type="text/javascript"  src="./static/js/header.js"></script>
<body>
<div>
    <header id="header" class="fixed-top">
        <script>loadHTML("header.jsp");</script>
    </header>
    <br>
    <form id="getWifiInfoForm" name="getWifiInfoForm" method="get" action="/WifiGetServlet">
        <div style="padding-bottom: 10px">
            <%
                if(wifiInfoVOs != null) {
            %>
                <label for="lat">LAT:</label>
                <input type="text" name="lat" id="lat" value="<%=request.getAttribute("wifiLat")%>"/> ,
                <label for="lnt">LNT</label>
                <input type="text" name="lnt" id="lnt" value="<%=request.getAttribute("wifiLnt")%>"/>
            <%  } else { %>
                <label for="lat">LAT:</label>
                <input type="text" name="lat" id="lat" value="0.0"/> ,
                <label for="lnt">LNT</label>
                <input type="text" name="lnt" id="lnt" value="0.0"/>
            <%
                }
            %>
            <input type="button" value="내 위치 가져오기" onclick="getLocation();"/>
            <input type="submit" value="근처 WIPI 정보 보기"/>
        </div>
    </form>
    <div class="wifi-table-container">
        <table>
            <th>거리(Km)</th>
            <th>관리번호</th>
            <th>자치구</th>
            <th>와이파이명</th>
            <th>도로명주소</th>
            <th>상세주소</th>
            <th>설치위치(층)</th>
            <th>설치유형</th>
            <th>설치기관</th>
            <th>서비스구분</th>
            <th>망종류</th>
            <th>설치년도</th>
            <th>실내외구분</th>
            <th>WIFI접속환경</th>
            <th>X좌표</th>
            <th>Y좌표</th>
            <th>작업일자</th>
            <%
                if(wifiInfoVOs != null) {
                    for(WifiInfoVO wifiInfoVO : wifiInfoVOs) {
            %>
            <tr class="data-exit wifi-info" onclick="goWifiDetail(
                '<%=wifiInfoVO.getId()%>', '<%=wifiInfoVO.getWifiDistance()%>',
                '<%=wifiInfoVO.getWifiMngNo()%>', '<%=wifiInfoVO.getWifiBorough()%>',
                '<%=wifiInfoVO.getWifiName()%>', '<%=wifiInfoVO.getWifiAddress()%>',
                '<%=wifiInfoVO.getWifiAddressDetail()%>', '<%=wifiInfoVO.getWifiFloor()%>',
                '<%=wifiInfoVO.getWifiType()%>', '<%=wifiInfoVO.getWifiAgency()%>',
                '<%=wifiInfoVO.getWifiService()%>', '<%=wifiInfoVO.getWifiNetType()%>',
                '<%=wifiInfoVO.getWifiInstallYear()%>', '<%=wifiInfoVO.getWifiInOutDoor()%>',
                '<%=wifiInfoVO.getWifiConnectEnv()%>', '<%=wifiInfoVO.getWifiLat()%>',
                '<%=wifiInfoVO.getWifiLnt()%>', '<%=wifiInfoVO.getWifiDate()%>')">
                <td><%=wifiInfoVO.getWifiDistance() %></td>
                <td><%=wifiInfoVO.getWifiMngNo() %></td>
                <td><%=wifiInfoVO.getWifiBorough() %></td>
                <td><%=wifiInfoVO.getWifiName() %></td>
                <td><%=wifiInfoVO.getWifiAddress() %></td>
                <td><%=wifiInfoVO.getWifiAddressDetail() %></td>
                <td><%=wifiInfoVO.getWifiFloor() %></td>
                <td><%=wifiInfoVO.getWifiType() %></td>
                <td><%=wifiInfoVO.getWifiAgency() %></td>
                <td><%=wifiInfoVO.getWifiService() %></td>
                <td><%=wifiInfoVO.getWifiNetType() %></td>
                <td><%=wifiInfoVO.getWifiInstallYear() %></td>
                <td><%=wifiInfoVO.getWifiInOutDoor() %></td>
                <td><%=wifiInfoVO.getWifiConnectEnv() %></td>
                <td><%=wifiInfoVO.getWifiLat() %></td>
                <td><%=wifiInfoVO.getWifiLnt() %></td>
                <td><%=wifiInfoVO.getWifiDate() %></td>
            </tr>
            <%
                }
            } else {
            %>
            <tr class="data-not-exit">
                <td colspan="17">위치 정보를 입력한 후에 조회해 주세요.</td>
            </tr>
            <%
                }
            %>
        </table>
    </div>
</div>
</body>
<script>
    function getLocation() {
        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(function(position) {
                let lat = position.coords.latitude; //위도
                let lnt = position.coords.longitude; //경도
                document.getElementById("lat").value = lat;
                document.getElementById("lnt").value = lnt;
            }, function(error) {
                console.error(error);
            }, {
                enableHighAccuracy: false,
                maximumAge: 0,
                timeout: Infinity
            });
        }
    }
</script>
<script type="text/javascript"  src="./static/js/index.js"></script>
</html>