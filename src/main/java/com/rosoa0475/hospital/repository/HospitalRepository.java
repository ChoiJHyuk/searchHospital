package com.rosoa0475.hospital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rosoa0475.hospital.entity.HospitalEntity;

public interface HospitalRepository extends JpaRepository<HospitalEntity, Long>{
    @Query("select distinct e from HospitalEntity")
    public List<String> findE();

    @Query("select distinct ee from HospitalEntity where e=?1")
    public List<String> findEE(String value);
    public List<HospitalEntity> findByEAndEe(String E, String EE);
}
