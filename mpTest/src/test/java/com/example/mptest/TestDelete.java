package com.example.mptest;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.mptest.mapper.HotelMapper;
import com.example.mptest.pojo.entity.Hotel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

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

    @Test
    public void testDeleteMuti() {
        System.out.println(("----- 根据ID删除多条数据------"));
        ArrayList hotelList=new ArrayList();
        hotelList.add(2048047291L);
        hotelList.add(727679);
        hotelList.add(1457521002);
        int i = hotelMapper.deleteBatchIds(hotelList);
        System.out.println(i);
    }


    @Test
    public void testDeleteByQuery() {
        System.out.println(("----- 根据查询删除单条数据------"));
        LambdaQueryWrapper<Hotel> lqt=new LambdaQueryWrapper<Hotel>();
        lqt.like(Hotel::getName,"深圳大中华");
        int i = hotelMapper.delete(lqt);
        System.out.println(i);
    }

}
