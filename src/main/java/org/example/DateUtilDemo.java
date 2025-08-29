package org.example;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;

import java.util.Date;

public class DateUtilDemo {
    public static void main(String[] args) {
        // 当前时间与格式化
        DateTime now = DateUtil.date();
        System.out.println("now: " + now);
        System.out.println("format: " + DateUtil.format(now, "yyyy-MM-dd HH:mm:ss"));

        // 解析与转换
        DateTime parsed = DateUtil.parse("2025-08-29 12:34:56");
        Date legacyDate = parsed.toJdkDate();
        System.out.println("parsed: " + parsed + ", legacy: " + legacyDate);

        // 偏移与起止
        DateTime nextWeek = DateUtil.offset(now, DateField.WEEK_OF_YEAR, 1);
        DateTime beginOfDay = DateUtil.beginOfDay(now);
        DateTime endOfDay = DateUtil.endOfDay(now);
        System.out.println("nextWeek: " + nextWeek);
        System.out.println("beginOfDay: " + beginOfDay + ", endOfDay: " + endOfDay);

        // 间隔计算
        long hours = DateUtil.between(parsed, now, DateUnit.HOUR, true);
        System.out.println("between hours(parsed -> now): " + hours);

        // 计时器
        TimeInterval timer = DateUtil.timer();
        for (int i = 0; i < 100000; i++) {
            Math.sqrt(i);
        }
        System.out.println("cost ms: " + timer.intervalMs());
    }
}


