package com.rosoa0475.hospital.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rosoa0475.hospital.DTO.HospitalDTO;
import com.rosoa0475.hospital.entity.HospitalEntity;
import com.rosoa0475.hospital.service.HospitalService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class HospitalController {
    private final HospitalService hospitalService;

    @GetMapping("/")
    public String main(Model model) {
        List<String> first = hospitalService.findLocation1();
        model.addAttribute("first", first);
        return "layout";
    }
    
    @GetMapping("/search")
    public String search(Model model, @RequestParam(name = "selectBox1") String select1, @RequestParam(name = "selectBox2") String select2) {
        List<String> first = hospitalService.findLocation1();
        model.addAttribute("first", first);
        List<HospitalEntity> hosList = hospitalService.findHospital(select1, select2);
        model.addAttribute("hospitalList", hosList);
        return "layout";
    }

    @PostMapping("/select")
    @ResponseBody
    public List<String> secondSelect(@RequestParam(name = "value") String value){
        List<String> list = hospitalService.findLocation2(value);
        return list;
    }

    @GetMapping("/getData")
    @ResponseBody
    public String getData() throws MalformedURLException, IOException {
        HttpURLConnection connection = (HttpURLConnection) new URL(
                "https://api.odcloud.kr/api/15043191/v1/uddi:02b4fbd8-892d-4f04-bc93-9df5801d7e0c?page=1&perPage=320&serviceKey=XniR0cmCs%2FCY4S7Daivr1s9itdBFH47%2BxN8WoR1OmYaAbJVdoyRCx1jR5vXDyfcuu1VCQu%2FSiNw4zY1zIx0sMA%3D%3D")
                .openConnection();
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);
        connection.setRequestMethod("GET");
        connection.setDoInput(true);
        if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
            return "오류발생";
        }
        BufferedReader bf = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
        StringBuffer sb = new StringBuffer();
        String line;
        while ((line = bf.readLine()) != null) {
            sb.append(line).append("\n");
        }
        ObjectMapper om = new ObjectMapper();
        JsonNode jn = om.readTree(sb.toString());
        jn = jn.findValue("data");
        HospitalDTO hospitalDTO[] = om.treeToValue(jn, HospitalDTO[].class);
        for (int i = 0; i < hospitalDTO.length; i++) {
            HospitalEntity hospitalEntity;
            String[] tokens = hospitalDTO[i].getE().split(" ");
            if (tokens.length >= 2)
                hospitalEntity = hospitalDTO[i].toEntity(tokens[0], tokens[1]);
            else
                hospitalEntity = hospitalDTO[i].toEntity(tokens[0], "없음");
            hospitalService.saveData(hospitalEntity);
        }
        return "OK";
    }
}
