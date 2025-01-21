package com.example.work.common;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        // 获取当前日期
        LocalDate currentDate = LocalDate.now();

        // 存储结果的列表
        List<String> result = new ArrayList<>();

        // 循环计算当前日期往前半年的日期
        for (int i = 1; i < 7; i++) {
            // 计算当前月份和年份
            LocalDate previousMonth = currentDate.minusMonths(i);

            // 格式化日期为字符串，结果为yyyy-MM格式
            String formattedDate = previousMonth.format(DateTimeFormatter.ofPattern("yyyy-MM"));

            // 将格式化后的日期添加到结果列表中
            result.add(formattedDate);
        }

        // 打印结果列表
        System.out.println(result);
    }
}
