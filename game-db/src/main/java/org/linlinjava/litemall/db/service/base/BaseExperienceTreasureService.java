package org.linlinjava.litemall.db.service.base;

import org.linlinjava.litemall.db.dao.ExperienceTreasureMapper;
import org.linlinjava.litemall.db.domain.ExperienceTreasure;
import org.linlinjava.litemall.db.domain.example.ExperienceTreasureExample;
import org.linlinjava.litemall.db.domain.example.ExperienceTreasureExample.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.PageHelper;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.math.BigDecimal;
@Service
public class BaseExperienceTreasureService{
    @Autowired
    protected ExperienceTreasureMapper mapper;

    @Cacheable(cacheNames="ExperienceTreasure", key="#id")
	public ExperienceTreasure findById(int id) {
        return mapper.selectByPrimaryKeyWithLogicalDelete(id,false);
    }
    @Cacheable(cacheNames="ExperienceTreasure", key="#id",condition="#result.deleted == 0")
	public ExperienceTreasure findByIdContainsDelete(int id) {
        return mapper.selectByPrimaryKey(id);
    }

    public void add(ExperienceTreasure experienceTreasure) {
        experienceTreasure.setAddTime(LocalDateTime.now());
        experienceTreasure.setUpdateTime(LocalDateTime.now());
        mapper.insertSelective(experienceTreasure);
    }
    
    @CachePut(cacheNames="ExperienceTreasure", key="#experienceTreasure.id")
	public int updateById(ExperienceTreasure experienceTreasure) {
        experienceTreasure.setUpdateTime(LocalDateTime.now());
        return mapper.updateByPrimaryKeySelective(experienceTreasure);
    }
    
   	@CacheEvict(cacheNames="ExperienceTreasure", key="#id")
	public void deleteById(int id) {
        mapper.logicalDeleteByPrimaryKey(id);
    }
    
    
    
    
    
 	public List<ExperienceTreasure> findByAttrib(Integer attrib) {
        ExperienceTreasureExample example = new ExperienceTreasureExample();
        ExperienceTreasureExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andAttribEqualTo(attrib);
		return mapper.selectByExample(example);
	}

 	public List<ExperienceTreasure> findByMaxLevel(Integer maxLevel) {
        ExperienceTreasureExample example = new ExperienceTreasureExample();
        ExperienceTreasureExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andMaxLevelEqualTo(maxLevel);
		return mapper.selectByExample(example);
	}

 	public ExperienceTreasure findOneByAttrib(Integer attrib) {
        ExperienceTreasureExample example = new ExperienceTreasureExample();
        ExperienceTreasureExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andAttribEqualTo(attrib);
		return mapper.selectOneByExample(example);
	}

 	public ExperienceTreasure findOneByMaxLevel(Integer maxLevel) {
        ExperienceTreasureExample example = new ExperienceTreasureExample();
        ExperienceTreasureExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andMaxLevelEqualTo(maxLevel);
		return mapper.selectOneByExample(example);
	}

	
	public List<ExperienceTreasure> findAll(int page, int size, String sort, String order) {
        ExperienceTreasureExample example = new ExperienceTreasureExample();
        ExperienceTreasureExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }
        PageHelper.startPage(page, size);
        return mapper.selectByExample(example);
    }
    
    public List<ExperienceTreasure> findAll() {
        ExperienceTreasureExample example = new ExperienceTreasureExample();
        ExperienceTreasureExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        return mapper.selectByExample(example);
    }
}
