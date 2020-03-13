package org.linlinjava.litemall.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.linlinjava.litemall.db.domain.Pet;
import org.linlinjava.litemall.db.domain.example.PetExample;

public interface PetMapper {
    long countByExample(PetExample example);

    int deleteByExample(PetExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Pet record);

    int insertSelective(Pet record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pet
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    Pet selectOneByExample(PetExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pet
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    Pet selectOneByExampleSelective(@Param("example") PetExample example, @Param("selective") Pet.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pet
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    List<Pet> selectByExampleSelective(@Param("example") PetExample example, @Param("selective") Pet.Column ... selective);

    List<Pet> selectByExample(PetExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pet
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    Pet selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") Pet.Column ... selective);

    Pet selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pet
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    Pet selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") Pet record, @Param("example") PetExample example);

    int updateByExample(@Param("record") Pet record, @Param("example") PetExample example);

    int updateByPrimaryKeySelective(Pet record);

    int updateByPrimaryKey(Pet record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pet
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    int logicalDeleteByExample(@Param("example") PetExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pet
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    int logicalDeleteByPrimaryKey(Integer id);
}