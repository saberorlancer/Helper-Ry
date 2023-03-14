package com.ruoyi.develop.service;

import com.ruoyi.develop.domain.GkWxUser;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户Service接口
 * 
 * @author ruoyi
 * @date 2023-03-12
 */
public interface IGkWxUserService 
{
    /**
     * 查询用户
     * 
     * @param openId 用户ID
     * @return 用户
     */
    public GkWxUser selectGkWxUserById(String openId);

    /**
     * 查询用户列表
     * 
     * @param gkWxUser 用户
     * @return 用户集合
     */
    public List<GkWxUser> selectGkWxUserList(GkWxUser gkWxUser);

    /**
     * 新增用户
     * 
     * @param gkWxUser 用户
     * @return 结果
     */
    public int insertGkWxUser(GkWxUser gkWxUser);

    /**
     * 修改用户
     * 
     * @param gkWxUser 用户
     * @return 结果
     */
    public int updateGkWxUser(GkWxUser gkWxUser);

    /**
     * 批量删除用户
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteGkWxUserByIds(String ids);

    /**
     * 删除用户信息
     * 
     * @param openId 用户ID
     * @return 结果
     */
    public int deleteGkWxUserById(String openId);


    List<LinkedHashMap<String, BigDecimal>> statistics(String startCreateTime, String endCreateTime, String lastStartCreateTime, String lastEndCreateTime);

    LinkedHashMap<String, BigDecimal> getCountByUser(String dateTime);
}
