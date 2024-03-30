package com.rosoa0475.hospital.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HospitalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column
    // @JsonProperty("감염병전담기관 여부")
    private String a;

    @Column
    // @JsonProperty("감염병전담기관 외래진료 가능여부")
    private String b;
    
    @Column
    // @JsonProperty("국민안심병원 여부")
    private String c;

    @Column
    // @JsonProperty("병상수")
    private String d;

    @Column
    // @JsonProperty("시군구")
    private String e;
    private String ee;

    @Column
    // @JsonProperty("의료기관명")
    private String f;

    @Column
    // @JsonProperty("전화번호")
    private String g;

    @Column
    // @JsonProperty("주소")
    private String h;

    @Column
    // @JsonProperty("진료과수")
    private String i;
}
