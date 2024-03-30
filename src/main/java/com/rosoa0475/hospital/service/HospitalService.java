package com.rosoa0475.hospital.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rosoa0475.hospital.entity.HospitalEntity;
import com.rosoa0475.hospital.repository.HospitalRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HospitalService {
    private final HospitalRepository hospitalRepository;

    @SuppressWarnings("null")
    public void saveData(HospitalEntity hospitalEntity){
        hospitalRepository.save(hospitalEntity);
    }

    public List<String> findLocation1(){
        return hospitalRepository.findE();
    }

    public List<String> findLocation2(String value) {
        return hospitalRepository.findEE(value);
    }

    public List<HospitalEntity> findHospital(String E, String EE) {
        return hospitalRepository.findByEAndEe(E, EE);
    }
}
