package com.ruoyi.develop.mapper;

import com.ruoyi.develop.domain.GkWxUser;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 用户Mapper接口
 * 
 * @author ruoyi
 * @date 2023-03-12
 */
public interface GkWxUserMapper 
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
     * 删除用户
     * 
     * @param openId 用户ID
     * @return 结果
     */
    public int deleteGkWxUserById(String openId);

    /**
     * 批量删除用户
     * 
     * @param openIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteGkWxUserByIds(String[] openIds);
    @Select("SELECT\n" +
            "\tto_char( CREATE_TIME, 'yyyy-mm' ) as DATES,\n" +
            "\tcount( * ) \n as count " +
            "FROM\n" +
            "\tGK_WX_USER \n" +
            "\twhere CREATE_TIME between to_timestamp(#{startTime},'yyyy-MM-dd') and to_timestamp(#{endTime},'yyyy-MM-dd') \n" +
            "GROUP BY\n" +
            "\tto_char( CREATE_TIME, 'yyyy-mm' )")
    @MapKey("DATES")
    Map<String, Map<String, BigDecimal>> statistics(@Param("startTime") String startCreateTime,@Param("endTime") String endCreateTime);

    @Select("SELECT\n" +
            "\tcount(*) as COUNT \n" +
            "FROM\n" +
            "\tGK_WX_USER \n" +
            "WHERE \n" +
            "\tcreate_time >= TRUNC( NEXT_DAY( to_timestamp( #{dateTime}, 'yyyy-MM-dd' ) - 8, 1 ) + 1 ) \n" +
            "\tAND create_time < TRUNC( NEXT_DAY( to_timestamp( #{dateTime}, 'yyyy-MM-dd' ) - 8, 1 ) + 7 ) + 1")
    BigDecimal getCountByUserOfWeek(@Param("dateTime") String dateTime);
    @Select("SELECT\n" +
            "\tcount( * ) as COUNT\n" +
            "FROM\n" +
            "\tGK_WX_USER \n" +
            "WHERE\n" +
            "\tto_timestamp( to_char( CREATE_TIME, 'yyyy-MM' ), 'yyyy-MM' ) = to_timestamp( #{dateTime}, 'yyyy-MM' )")
    BigDecimal getCountByUserOfMonth(@Param("dateTime") String dateTime);
    @Select("SELECT\n" +
            "\tcount( * ) as COUNT\n" +
            "FROM\n" +
            "\tGK_WX_USER \n" +
            "WHERE\n" +
            "\tto_timestamp( to_char( CREATE_TIME, 'yyyy-MM-dd' ), 'yyyy-MM-dd' ) = to_timestamp( #{dateTime}, 'yyyy-MM-dd' )")
    BigDecimal getCountByUserOfDay(@Param("dateTime") String dateTime);
}
