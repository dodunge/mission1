package com.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter @Setter @ToString
public class BookmarkVO {
    private int id;
    private String bookmarkName;
    private String wifiName;
    private LocalDateTime insertDate;
}
