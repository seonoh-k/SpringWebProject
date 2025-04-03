package org.nonage.domain;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class OrderVO {
    private int odseq;
    private int oseq;
    private String id;
    private Timestamp indate;
    private int pseq;
    private int quantity;
    private String mname;
    private String zipNum;
    private String address;
    private String phone;
    private String pname;
    private int price2;
    private String result;
}
