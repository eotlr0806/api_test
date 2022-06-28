package com.example.api_test.dto.dart;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Company {

    private String status;
    private String message;
    private String adres;

    @JsonProperty("corp_code")
    private String corpCode;

    @JsonProperty("corp_name")
    private String corpName;

    @JsonProperty("corp_name_eng")
    private String corpNameEng;

    @JsonProperty("stock_name")
    private String stockName;

    @JsonProperty("stock_code")
    private String stockCode;

    @JsonProperty("ceo_nm")
    private String ceoNm;

    @JsonProperty("corp_cls")
    private String corpCls;

    @JsonProperty("jurir_no")
    private String jurirNo;

    @JsonProperty("bizr_no")
    private String bizrNo;

    @JsonProperty("hm_url")
    private String hmUrl;

    @JsonProperty("ir_url")
    private String irUrl;

    @JsonProperty("phn_no")
    private String phnNo;

    @JsonProperty("fax_no")
    private String faxNo;

    @JsonProperty("induty_code")
    private String indutyCode;

    @JsonProperty("est_dt")
    private String estDt;

    @JsonProperty("acc_mt")
    private String accMt;
}
