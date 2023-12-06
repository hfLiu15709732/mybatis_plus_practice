package com.example.mptest.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mptest.pojo.entity.Hotel;

import java.util.Collection;
import java.util.List;

/**
 * @author M
 * @version 1.0
 * @description:
 * @date 2023/12/5 15:20
 */
public interface HotelMapper extends BaseMapper<Hotel> {

    boolean saveHotelsByNative(List<Hotel> list);
}
