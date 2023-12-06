package com.example.mptest.controller;

import com.example.mptest.mapper.HotelMapper;
import com.example.mptest.pojo.entity.Hotel;
import com.example.mptest.service.HotelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author M
 * @version 1.0
 * @description:
 * @date 2023/12/5 21:20
 */
@RestController
@RequestMapping(value = "/hotel")
@Slf4j

public class HotelController {

    @Autowired
    HotelMapper hotelMapper;

    @Autowired
    HotelService hotelService;

    @GetMapping(value = "/all")
    public List<Hotel> getAll(){
        log.info("查询所有酒店信息：{}",100);
        List<Hotel> allList = hotelService.getAllList();
        return allList;
    }

    @GetMapping(value = "/search/city")
    public List<Hotel> getByCity(String city){
        log.info("根据城市查询酒店信息：{}",100);
        List<Hotel> allList = hotelService.getByCity(city);
        return allList;
    }

}
