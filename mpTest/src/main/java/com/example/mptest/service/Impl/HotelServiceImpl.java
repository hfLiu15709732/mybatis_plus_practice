package com.example.mptest.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.mptest.mapper.HotelMapper;
import com.example.mptest.pojo.entity.Hotel;
import com.example.mptest.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author M
 * @version 1.0
 * @description:
 * @date 2023/12/5 21:30
 */
@Service
public class HotelServiceImpl implements HotelService {


    @Autowired
    HotelMapper hotelMapper;


    @Override
    public List<Hotel> getAllList() {
        List<Hotel> hotels = hotelMapper.selectList(null);
        return hotels;
    }

    @Override
    public List<Hotel> getByCity(String city) {
        LambdaQueryWrapper<Hotel> lqw =new LambdaQueryWrapper<Hotel>();
        lqw.like(Hotel::getCity,city);
        List<Hotel> hotels = hotelMapper.selectList(lqw);
        return hotels;
    }
}
