package com.ruoyi.develop.service.impl;


import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.develop.domain.GkWxUser;
import com.ruoyi.develop.mapper.GkWxUserMapper;
import com.ruoyi.develop.service.IGkWxUserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;

import java.math.BigDecimal;
import java.util.*;

/**
 * 用户Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-03-12
 */
@Service
public class GkWxUserServiceImpl implements IGkWxUserService
{
    @Autowired
    private GkWxUserMapper gkWxUserMapper;

    /**
     * 查询用户
     * 
     * @param openId 用户ID
     * @return 用户
     */
    @Override
    public GkWxUser selectGkWxUserById(String openId)
    {
        return gkWxUserMapper.selectGkWxUserById(openId);
    }

    /**
     * 查询用户列表
     * 
     * @param gkWxUser 用户
     * @return 用户
     */
    @Override
    public List<GkWxUser> selectGkWxUserList(GkWxUser gkWxUser)
    {
        return gkWxUserMapper.selectGkWxUserList(gkWxUser);
    }

    /**
     * 新增用户
     * 
     * @param gkWxUser 用户
     * @return 结果
     */
    @Override
    public int insertGkWxUser(GkWxUser gkWxUser)
    {
        gkWxUser.setCreateTime(DateUtils.getNowDate());
        return gkWxUserMapper.insertGkWxUser(gkWxUser);
    }

    /**
     * 修改用户
     * 
     * @param gkWxUser 用户
     * @return 结果
     */
    @Override
    public int updateGkWxUser(GkWxUser gkWxUser)
    {
        gkWxUser.setUpdateTime(DateUtils.getNowDate());
        return gkWxUserMapper.updateGkWxUser(gkWxUser);
    }

    /**
     * 删除用户对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteGkWxUserByIds(String ids)
    {
        return gkWxUserMapper.deleteGkWxUserByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除用户信息
     * 
     * @param openId 用户ID
     * @return 结果
     */
    @Override
    public int deleteGkWxUserById(String openId)
    {
        return gkWxUserMapper.deleteGkWxUserById(openId);
    }

    @Override
    public List<LinkedHashMap<String, BigDecimal>> statistics(@Param("startCreateTime") String startCreateTime,@Param("endCreateTime") String endCreateTime,@Param("lastStartCreateTime") String lastStartCreateTime,@Param("lastEndCreateTime") String lastEndCreateTime) {
        String[] dates = {startCreateTime,endCreateTime,lastStartCreateTime,lastEndCreateTime};
        Map<String,String> maxDate = com.ruoyi.develop.utils.DateUtils.showMaxDate(dates);
        LinkedList<String> allDates = com.ruoyi.develop.utils.DateUtils.getMonthBetweenDate(maxDate.get("min"),maxDate.get("max"));
        Map<String, Map<String,BigDecimal>> dateOne = gkWxUserMapper.statistics(startCreateTime,endCreateTime);
        Map<String, Map<String, BigDecimal>> dateTwo = gkWxUserMapper.statistics(lastStartCreateTime,lastEndCreateTime);

        List<LinkedHashMap<String, BigDecimal>> data = new ArrayList<>();
        LinkedHashMap<String, BigDecimal> dataOne  = new LinkedHashMap<>();
        LinkedHashMap<String, BigDecimal> dataTwo  = new LinkedHashMap<>();
        for (String allDate : allDates) {
            if(Objects.isNull(dateOne.get(allDate))){
                dataOne.put(allDate,new BigDecimal(0));
            }else{
                dataOne.put(allDate,(dateOne.get(allDate)).get("COUNT"));
            }
        }

        for (String allDate : allDates) {
            if(Objects.isNull(dateTwo.get(allDate))){
                dataTwo.put(allDate,new BigDecimal(0));
            }else{
                dataTwo.put(allDate,(dateTwo.get(allDate)).get("COUNT"));
            }
        }
        data.add(dataOne);
        data.add(dataTwo);

        return data;
    }

    @Override
    public LinkedHashMap<String, BigDecimal> getCountByUser(String dateTime) {
        BigDecimal week = gkWxUserMapper.getCountByUserOfWeek(dateTime);
        BigDecimal month = gkWxUserMapper.getCountByUserOfMonth(dateTime.substring(0,dateTime.length()-3));
        BigDecimal day = gkWxUserMapper.getCountByUserOfDay(dateTime);
        LinkedHashMap<String,BigDecimal> data = new LinkedHashMap<>();
        data.put("今日新增用户",day);
        data.put("本周新增用户",week);
        data.put("本月新增用户",month);
        return data;
    }


}
