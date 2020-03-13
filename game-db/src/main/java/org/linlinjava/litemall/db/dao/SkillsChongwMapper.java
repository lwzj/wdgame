package org.linlinjava.litemall.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.linlinjava.litemall.db.domain.SkillsChongw;
import org.linlinjava.litemall.db.domain.example.SkillsChongwExample;

public interface SkillsChongwMapper {
    long countByExample(SkillsChongwExample example);

    int deleteByExample(SkillsChongwExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SkillsChongw record);

    int insertSelective(SkillsChongw record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skills_chongw
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    SkillsChongw selectOneByExample(SkillsChongwExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skills_chongw
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    SkillsChongw selectOneByExampleSelective(@Param("example") SkillsChongwExample example, @Param("selective") SkillsChongw.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skills_chongw
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    List<SkillsChongw> selectByExampleSelective(@Param("example") SkillsChongwExample example, @Param("selective") SkillsChongw.Column ... selective);

    List<SkillsChongw> selectByExample(SkillsChongwExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skills_chongw
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    SkillsChongw selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") SkillsChongw.Column ... selective);

    SkillsChongw selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skills_chongw
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    SkillsChongw selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") SkillsChongw record, @Param("example") SkillsChongwExample example);

    int updateByExample(@Param("record") SkillsChongw record, @Param("example") SkillsChongwExample example);

    int updateByPrimaryKeySelective(SkillsChongw record);

    int updateByPrimaryKey(SkillsChongw record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skills_chongw
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    int logicalDeleteByExample(@Param("example") SkillsChongwExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skills_chongw
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    int logicalDeleteByPrimaryKey(Integer id);
}