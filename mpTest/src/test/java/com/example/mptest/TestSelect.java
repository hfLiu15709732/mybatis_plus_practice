package com.example.mptest;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mptest.mapper.HotelMapper;
import com.example.mptest.pojo.entity.Hotel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * @author M
 * @version 1.0
 * @description:
 * @date 2023/12/5 15:29
 */
@SpringBootTest
public class TestSelect {

    @Autowired
    private HotelMapper hotelMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- 查询所有数据 ------"));
        List<Hotel> hotels = hotelMapper.selectList(null);//里面是查询条件
        for (int i=0;i<hotels.size();i++){
            System.out.println(hotels.get(i).toString());
        }
    }


    @Test
    public void testSelectById() {
        System.out.println(("----- 根据ID查询单条酒店数据 ------"));
        Hotel hotel = hotelMapper.selectById(609023);//里面是查询条件
        System.out.println(hotel);
    }
    @Test
    public void testSelectBathById() {
        System.out.println(("----- 根据ID查询多条酒店数据 ------"));
        List<Integer> IDList = Arrays.asList(648219, 672207, 5871652, 200214538);
        List<Hotel> hotels = hotelMapper.selectBatchIds(IDList);//里面是查询条件
        for (int i=0;i<hotels.size();i++){
            System.out.println(hotels.get(i).toString());
        }
    }



    @Test
    public void testSelectPagination() {
        System.out.println(("----- 分页查询所有数据 ------"));
        IPage page = new Page(1, 10);//页面对象
        hotelMapper.selectPage(page, null);

        System.out.println("当前页码值"+page.getCurrent());
        System.out.println("每页显示数"+page.getSize());
        System.out.println("总共页数"+page.getPages());
        System.out.println("总共条数"+page.getTotal());
        System.out.println("页面数据"+page.getRecords());
    }



    @Test
    public void testSelectByQuery() {
        System.out.println(("----- 第一种一般条件查询 ------"));
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.gt("price",1000);//价格大于800的约束
        List list = hotelMapper.selectList(wrapper);
        for (int i=0;i<list.size();i++){
            System.out.println(list.get(i).toString());
        }

    }

    @Test
    public void testSelectByQuery2() {
        System.out.println(("----- 第二种（lambma）的一般条件查询 ------"));
        QueryWrapper<Hotel> wrapper=new QueryWrapper<Hotel>();
        wrapper.lambda().le(Hotel::getPrice,400);//价格小于400的约束
        List<Hotel> List = hotelMapper.selectList(wrapper);
        for (int i=0;i<List.size();i++){
            System.out.println(List.get(i).toString());
        }

    }

    @Test
    public void testSelectByQueryMuti() {
        System.out.println(("----- 较为复杂的条件查询 ------"));
        QueryWrapper<Hotel> wrapper=new QueryWrapper<Hotel>();
        wrapper.lambda().le(Hotel::getPrice,800).like(Hotel::getName,"深圳");//表示和的情况不需要加and，但表示或的情况需要加or（）
        List<Hotel> List = hotelMapper.selectList(wrapper);
        for (int i=0;i<List.size();i++){
            System.out.println(List.get(i).toString());
        }

    }

    @Test
    public void testSelectByQueryMuti2() {
        System.out.println(("----- 较为复杂的条件查询（更加规范与间接） ------"));
        LambdaQueryWrapper<Hotel> lqw=new LambdaQueryWrapper<Hotel>();
        lqw.le(Hotel::getPrice,800).like(Hotel::getName,"深圳");//表示和的情况不需要加and，但表示或的情况需要加or（）
        List<Hotel> List = hotelMapper.selectList(lqw);
        for (int i=0;i<List.size();i++){
            System.out.println(List.get(i).toString());
        }

    }



    @Test
    public void testSelectByQueryMutiSwitch() {
        System.out.println(("----- 带有判断的条件查询 ------"));
        LambdaQueryWrapper<Hotel> lqw=new LambdaQueryWrapper<Hotel>();
        Hotel hotel1=new Hotel();
        hotel1.setCity("天津");
        lqw.lt(hotel1.getId()!=null,Hotel::getPrice,2000);//条件选择判断，先进行判断是否进行限制筛选
        lqw.gt(Hotel::getPrice,1500);
        List<Hotel> hotels = hotelMapper.selectList(lqw);
        for (int i=0;i<hotels.size();i++){
            System.out.println(hotels.get(i).toString());
        }

    }




}
