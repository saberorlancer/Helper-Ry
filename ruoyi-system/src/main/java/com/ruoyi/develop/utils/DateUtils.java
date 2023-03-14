package com.ruoyi.develop.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtils {
    public static void main(String[] args) {
        String [] dateArray = {"2013-04-01","2013-04-08","2013-04-28","2013-04-08", "2013-11-11"};
        showMaxDate(dateArray);
    }

    public static Map<String, String> showMaxDate(String[] dateArray) {
        Map<String, Integer> dateMap = new TreeMap<String, Integer>();
        int i, arrayLen;
        arrayLen = dateArray.length;
        for(i = 0; i < arrayLen; i++){
            String dateKey = dateArray[i];
            if(dateMap.containsKey(dateKey)){
                int value = dateMap.get(dateKey) + 1;
                dateMap.put(dateKey, value);
            }else{
                dateMap.put(dateKey, 1);
            }
        }
        Set<String> keySet = dateMap.keySet();
        String []sorttedArray = new String[keySet.size()];
        Iterator<String> iter = keySet.iterator();
        int index = 0;
        while (iter.hasNext()) {
            String key = iter.next();
            //    System.out.println(key + ":" + dateMap.get(key));
            sorttedArray[index++] = key;
        }
        int sorttedArrayLen = sorttedArray.length;
        System.out.println("最小日期是：" + sorttedArray[0] + "," +
                " 天数为" + dateMap.get(sorttedArray[0]));
        System.out.println("最大日期是：" + sorttedArray[sorttedArrayLen - 1] + "," +
                " 天数为" + dateMap.get(sorttedArray[sorttedArrayLen - 1]));
        Map<String,String> data = new HashMap<>();
        data.put("max",sorttedArray[sorttedArrayLen - 1]);
        data.put("min",sorttedArray[0]);
        return data;
    }


    /**
     * 获取两个日期之间的所有月份 (年月)
     *
     * @param startTime
     * @param endTime
     * @return：YYYY-MM
     */
    public static LinkedList<String> getMonthBetweenDate(String startTime, String endTime){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        // 声明保存日期集合
        LinkedList<String> list = new LinkedList<>();
        try {
            // 转化成日期类型
            Date startDate = sdf.parse(startTime);
            Date endDate = sdf.parse(endTime);

            //用Calendar 进行日期比较判断
            Calendar calendar = Calendar.getInstance();
            while (startDate.getTime()<=endDate.getTime()){
                // 把日期添加到集合
                list.add(sdf.format(startDate));
                // 设置日期
                calendar.setTime(startDate);
                //把日期增加一天
                calendar.add(Calendar.MONTH, 1);
                // 获取增加后的日期
                startDate=calendar.getTime();
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return list;
    }
}
