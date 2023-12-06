package com.example.mptest;

import com.baomidou.mybatisplus.extension.toolkit.SqlRunner;
import com.example.mptest.mapper.HotelMapper;
import com.example.mptest.pojo.entity.Hotel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author M
 * @version 1.0
 * @description:
 * @date 2023/12/5 20:05
 */
@SpringBootTest
public class RawOperation {
    @Autowired
    private HotelMapper hotelMapper;


    @Test
    public void testAddMuti() {
        System.out.println(("----- 插入多条数据数据 ------"));
        Hotel hotel1=new Hotel(1999999l,"天津喜马拉雅快捷酒店","和平路133号",198,47,"喜马拉雅","天津","二钻","小白楼","40.10144","116.380641","https://m.tuniucdn.com/fb2/t1/G2/M00/C7/CB/Cii-T1km_5eICnpJAAHOWN1GylMAAKYJwF0Hp8AAc5w000_w200_h200_c1_t0.jpg",0,false);
        Hotel hotel2=new Hotel(1999992l,"天津四季酒店","和平路111号",1999,47,"唐拉雅秀","天津","二钻","小白楼","40.10144","116.380641","https://m.tuniucdn.com/fb2/t1/G2/M00/C7/CB/Cii-T1km_5eICnpJAAHOWN1GylMAAKYJwF0Hp8AAc5w000_w200_h200_c1_t0.jpg",0,false);
        Hotel hotel3=new Hotel(1999991l,"天津北国宾馆","和平路222号",799,47,"唐拉雅秀","天津","二钻","小白楼","40.10144","116.380641","https://m.tuniucdn.com/fb2/t1/G2/M00/C7/CB/Cii-T1km_5eICnpJAAHOWN1GylMAAKYJwF0Hp8AAc5w000_w200_h200_c1_t0.jpg",0,false);
        ArrayList hotelList=new ArrayList<Hotel>();
        hotelList.add(hotel1);
        hotelList.add(hotel2);
        hotelList.add(hotel3);
        //使用sql-runner方法实现执行原生sql
//       SqlRunner.db().insert()
//        System.out.println(mapList);
        boolean insert = hotelMapper.saveHotelsByNative(hotelList);
        System.out.println(insert);

    }

}
