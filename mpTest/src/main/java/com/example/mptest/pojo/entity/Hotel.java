package com.example.mptest.pojo.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.*;

/**
 * @author hfLiuX
 * @version 1.0
 * @description: 宾馆信息实体类
 * @date 2023/12/5 15:11
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@TableName("tb_hotel")
public class Hotel {

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    private String name;
    private String address;
    private double price;
    private int score;
    private String brand;
    private String city;
    private String starName;
    private String business;
    private String latitude;
    private String longitude;
    private String pic;

    @TableLogic(value = "0",delval = "1")//这个也可以在yml文件进行全局配置
    private int deleted;//软删除字段，0代表未删除，1代表已删除

    @TableField(exist = false)//代表数据库中没有这个字段
    private boolean status;


    // 省略getter和setter方法
}