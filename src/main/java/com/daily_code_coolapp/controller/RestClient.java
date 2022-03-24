package com.daily_code_coolapp.controller;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

public class RestClient {
    public static final String GET_ALL_DEPARTMENTS_API = "http://localhost:8000/departments";

    static RestTemplate restTemplate = new RestTemplate();

    public static void main(String[] args) {
        callGetAllDepartmentsApi();
    }

    private static  void callGetAllDepartmentsApi(){
        HttpHeaders httpHeaders = new org.springframework.http.HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<>("parameters", httpHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(GET_ALL_DEPARTMENTS_API, HttpMethod.GET,entity,String.class);
        System.out.print(responseEntity);
    }
}
