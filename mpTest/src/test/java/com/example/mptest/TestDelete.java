package com.example.mptest;

import com.example.mptest.mapper.HotelMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author M
 * @version 1.0
 * @description:
 * @date 2023/12/5 15:48
 */
@SpringBootTest
public class TestDelete {

    @Autowired
    HotelMapper hotelMapper;

    @Test
    public void testDeleteCommon() {
        System.out.println(("----- 根据ID删除单条数据------"));
        int i = hotelMapper.deleteById(2048047291L);
        System.out.println(i);
    }
}
