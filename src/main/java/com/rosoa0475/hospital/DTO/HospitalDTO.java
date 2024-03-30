package com.rosoa0475.hospital.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rosoa0475.hospital.entity.HospitalEntity;

import lombok.Data;

@Data
public class HospitalDTO {
    @JsonProperty("감염병전담기관 여부")
    private String a;

    @JsonProperty("감염병전담기관 외래진료 가능여부")
    private String b;

    @JsonProperty("국민안심병원 여부")
    private String c;

    @JsonProperty("병상수")
    private String d;

    @JsonProperty("시군구")
    private String e;

    @JsonProperty("의료기관명")
    private String f;

    @JsonProperty("전화번호")
    private String g;

    @JsonProperty("주소")
    private String h;

    @JsonProperty("진료과수")
    private String i;

    public HospitalEntity toEntity(String e, String ee){
        return HospitalEntity.builder()
            .a(a)
            .b(b)
            .c(c)
            .d(d)
            .e(e)
            .ee(ee)
            .f(f)
            .g(g)
            .h(h)
            .i(i).build();
    }
}
