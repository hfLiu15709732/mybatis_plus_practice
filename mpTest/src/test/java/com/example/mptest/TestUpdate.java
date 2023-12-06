package com.example.mptest;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
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

    @Test
    public void testUpdateMuti() {
        System.out.println(("----- 根据条件进行修改符合的数据 ------"));
        Hotel hotel1=new Hotel();
        hotel1.setPrice(1999);
        LambdaQueryWrapper<Hotel> lqw=new LambdaQueryWrapper<Hotel>();
        lqw.eq(Hotel::getCity,"天津");
        int i = hotelMapper.update(hotel1,lqw);//将成为为天津的酒店的价格统一为1999元
        System.out.println(i);
    }

}
