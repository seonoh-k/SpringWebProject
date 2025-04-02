package org.nonage.domain;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class OrderDetailVO {
    private int odseq;
    private int pseq;
    private int oseq;
    private int quantity;
    private Timestamp indate;
}
