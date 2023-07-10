package com.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class WifiInfoVO {
    //인덱스
    private Integer id;
    //거리(Km)
    private double wifiDistance;
    //관리번호
    private String wifiMngNo;
    //자치구
    private String wifiBorough;
    //와이파이명
    private String wifiName;
    //도로명주소
    private String wifiAddress;
    //상세주소
    private String wifiAddressDetail;
    //설치위치(층)
    private String wifiFloor;
    //설치유형
    private String wifiType;
    //설치기관
    private String wifiAgency;
    //서비스구분
    private String wifiService;
    //망종류
    private String wifiNetType;
    //설치년도
    private String wifiInstallYear;
    //실내외구분
    private String wifiInOutDoor;
    //WIFI접속환경
    private String wifiConnectEnv;
    //X좌표
    private double wifiLat;
    //Y좌표
    private double wifiLnt;
    //작업일자
    private String wifiDate;
}
