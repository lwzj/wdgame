package org.linlinjava.litemall.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.linlinjava.litemall.db.domain.CreepsStore;
import org.linlinjava.litemall.db.domain.example.CreepsStoreExample;

public interface CreepsStoreMapper {
    long countByExample(CreepsStoreExample example);

    int deleteByExample(CreepsStoreExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CreepsStore record);

    int insertSelective(CreepsStore record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table creeps_store
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    CreepsStore selectOneByExample(CreepsStoreExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table creeps_store
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    CreepsStore selectOneByExampleSelective(@Param("example") CreepsStoreExample example, @Param("selective") CreepsStore.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table creeps_store
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    List<CreepsStore> selectByExampleSelective(@Param("example") CreepsStoreExample example, @Param("selective") CreepsStore.Column ... selective);

    List<CreepsStore> selectByExample(CreepsStoreExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table creeps_store
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    CreepsStore selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") CreepsStore.Column ... selective);

    CreepsStore selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table creeps_store
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    CreepsStore selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") CreepsStore record, @Param("example") CreepsStoreExample example);

    int updateByExample(@Param("record") CreepsStore record, @Param("example") CreepsStoreExample example);

    int updateByPrimaryKeySelective(CreepsStore record);

    int updateByPrimaryKey(CreepsStore record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table creeps_store
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    int logicalDeleteByExample(@Param("example") CreepsStoreExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table creeps_store
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    int logicalDeleteByPrimaryKey(Integer id);
}