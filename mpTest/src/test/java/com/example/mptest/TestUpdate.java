package com.example.mptest;

import com.example.mptest.mapper.HotelMapper;
import com.example.mptest.pojo.entity.Hotel;
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
public class TestUpdate {

    @Autowired
    private HotelMapper hotelMapper;


    @Test
    public void testUpdate() {
        System.out.println(("----- 根据ID修改单条数据 ------"));
        Hotel hotel1=new Hotel();
        hotel1.setId(2056105938L);
        hotel1.setAddress("丽泽金融商务区凤凰路新址");
        int i = hotelMapper.updateById(hotel1);
        System.out.println(i);
    }

}
