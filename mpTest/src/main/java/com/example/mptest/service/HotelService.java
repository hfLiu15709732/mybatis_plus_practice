package com.example.mptest.service;

import com.example.mptest.pojo.entity.Hotel;

import java.util.List;

/**
 * @author M
 * @version 1.0
 * @description:
 * @date 2023/12/5 21:24
 */
public interface HotelService {

    List<Hotel> getAllList ();

    List<Hotel> getByCity(String city);
}
