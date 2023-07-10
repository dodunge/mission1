package com.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter @Setter @ToString
public class BookmarkGroupVO {
    private int id;
    private String bookmarkName;
    private int bookmarkOrder;
    private LocalDateTime insertDate;
    private LocalDateTime updateDate;
}
