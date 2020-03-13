package org.linlinjava.litemall.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.linlinjava.litemall.db.domain.Npc;
import org.linlinjava.litemall.db.domain.example.NpcExample;

public interface NpcMapper {
    long countByExample(NpcExample example);

    int deleteByExample(NpcExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Npc record);

    int insertSelective(Npc record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table npc
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    Npc selectOneByExample(NpcExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table npc
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    Npc selectOneByExampleSelective(@Param("example") NpcExample example, @Param("selective") Npc.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table npc
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    List<Npc> selectByExampleSelective(@Param("example") NpcExample example, @Param("selective") Npc.Column ... selective);

    List<Npc> selectByExample(NpcExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table npc
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    Npc selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") Npc.Column ... selective);

    Npc selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table npc
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    Npc selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") Npc record, @Param("example") NpcExample example);

    int updateByExample(@Param("record") Npc record, @Param("example") NpcExample example);

    int updateByPrimaryKeySelective(Npc record);

    int updateByPrimaryKey(Npc record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table npc
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    int logicalDeleteByExample(@Param("example") NpcExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table npc
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    int logicalDeleteByPrimaryKey(Integer id);
}