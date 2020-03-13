package org.linlinjava.litemall.db.service.base;

import org.linlinjava.litemall.db.dao.ExperienceMapper;
import org.linlinjava.litemall.db.domain.Experience;
import org.linlinjava.litemall.db.domain.example.ExperienceExample;
import org.linlinjava.litemall.db.domain.example.ExperienceExample.Criteria;
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
public class BaseExperienceService{
    @Autowired
    protected ExperienceMapper mapper;

    @Cacheable(cacheNames="Experience", key="#id")
	public Experience findById(int id) {
        return mapper.selectByPrimaryKeyWithLogicalDelete(id,false);
    }
    @Cacheable(cacheNames="Experience", key="#id",condition="#result.deleted == 0")
	public Experience findByIdContainsDelete(int id) {
        return mapper.selectByPrimaryKey(id);
    }

    public void add(Experience experience) {
        experience.setAddTime(LocalDateTime.now());
        experience.setUpdateTime(LocalDateTime.now());
        mapper.insertSelective(experience);
    }
    
    @CachePut(cacheNames="Experience", key="#experience.id")
	public int updateById(Experience experience) {
        experience.setUpdateTime(LocalDateTime.now());
        return mapper.updateByPrimaryKeySelective(experience);
    }
    
   	@CacheEvict(cacheNames="Experience", key="#id")
	public void deleteById(int id) {
        mapper.logicalDeleteByPrimaryKey(id);
    }
    
    
    
    
    
 	public List<Experience> findByAttrib(Integer attrib) {
        ExperienceExample example = new ExperienceExample();
        ExperienceExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andAttribEqualTo(attrib);
		return mapper.selectByExample(example);
	}

 	public List<Experience> findByMaxLevel(Integer maxLevel) {
        ExperienceExample example = new ExperienceExample();
        ExperienceExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andMaxLevelEqualTo(maxLevel);
		return mapper.selectByExample(example);
	}

 	public Experience findOneByAttrib(Integer attrib) {
        ExperienceExample example = new ExperienceExample();
        ExperienceExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andAttribEqualTo(attrib);
		return mapper.selectOneByExample(example);
	}

 	public Experience findOneByMaxLevel(Integer maxLevel) {
        ExperienceExample example = new ExperienceExample();
        ExperienceExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andMaxLevelEqualTo(maxLevel);
		return mapper.selectOneByExample(example);
	}

	
	public List<Experience> findAll(int page, int size, String sort, String order) {
        ExperienceExample example = new ExperienceExample();
        ExperienceExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }
        PageHelper.startPage(page, size);
        return mapper.selectByExample(example);
    }
    
    public List<Experience> findAll() {
        ExperienceExample example = new ExperienceExample();
        ExperienceExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        return mapper.selectByExample(example);
    }
}
