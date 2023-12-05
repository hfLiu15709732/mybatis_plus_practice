package com.example.mptest;

import com.example.mptest.mapper.HotelMapper;
import com.example.mptest.pojo.entity.Hotel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author M
 * @version 1.0
 * @description:
 * @date 2023/12/5 15:48
 */
@SpringBootTest
public class TestAdd {

    @Autowired
    private HotelMapper hotelMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- 插入单条数据数据 ------"));
        Hotel hotel1=new Hotel(null,"天津唐拉雅秀国际酒店","和平路199号",999,47,"唐拉雅秀","天津","二钻","小白楼","40.10144","116.380641","https://m.tuniucdn.com/fb2/t1/G2/M00/C7/CB/Cii-T1km_5eICnpJAAHOWN1GylMAAKYJwF0Hp8AAc5w000_w200_h200_c1_t0.jpg",0,false);
        int insert = hotelMapper.insert(hotel1);
        System.out.println(insert);
    }

}
