package org.linlinjava.litemall.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.linlinjava.litemall.db.domain.Experience;
import org.linlinjava.litemall.db.domain.example.ExperienceExample;

public interface ExperienceMapper {
    long countByExample(ExperienceExample example);

    int deleteByExample(ExperienceExample example);

    int deleteByPrimaryKey(Integer attrib);

    int insert(Experience record);

    int insertSelective(Experience record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table experience
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    Experience selectOneByExample(ExperienceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table experience
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    Experience selectOneByExampleSelective(@Param("example") ExperienceExample example, @Param("selective") Experience.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table experience
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    List<Experience> selectByExampleSelective(@Param("example") ExperienceExample example, @Param("selective") Experience.Column ... selective);

    List<Experience> selectByExample(ExperienceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table experience
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    Experience selectByPrimaryKeySelective(@Param("attrib") Integer attrib, @Param("selective") Experience.Column ... selective);

    Experience selectByPrimaryKey(Integer attrib);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table experience
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    Experience selectByPrimaryKeyWithLogicalDelete(@Param("attrib") Integer attrib, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") Experience record, @Param("example") ExperienceExample example);

    int updateByExample(@Param("record") Experience record, @Param("example") ExperienceExample example);

    int updateByPrimaryKeySelective(Experience record);

    int updateByPrimaryKey(Experience record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table experience
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    int logicalDeleteByExample(@Param("example") ExperienceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table experience
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    int logicalDeleteByPrimaryKey(Integer attrib);
}