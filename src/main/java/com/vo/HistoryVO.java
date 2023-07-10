package com.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter @Setter @ToString
public class HistoryVO {
    private int id;
    private double historyX;
    private double historyY;
    private LocalDateTime historyDate;
}
