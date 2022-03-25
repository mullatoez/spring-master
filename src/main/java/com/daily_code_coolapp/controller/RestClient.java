package com.daily_code_coolapp.controller;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public class RestClient {
    public static final String departments_url = "http://localhost:8000/departments";

    static RestTemplate restTemplate = new RestTemplate();

    public static void main(String[] args) {
        //getAllDepartments();
       /* getDeprtmentsNew();*/

        List<Object> departs = getDepartments();
        System.out.println(departs);
    }

    private static  void getAllDepartments(){
        HttpHeaders httpHeaders = new org.springframework.http.HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<>("parameters", httpHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(departments_url, HttpMethod.GET,entity,String.class);
        System.out.print(responseEntity);
    }

    static void getDeprtmentsNew(){
        String res = restTemplate.getForObject(departments_url,String.class);
        System.out.println(res);
    }

    static List<Object> getDepartments(){
        Object[] deps = restTemplate.getForObject(departments_url,Object[].class);
        return Arrays.asList(deps);
    }

}
