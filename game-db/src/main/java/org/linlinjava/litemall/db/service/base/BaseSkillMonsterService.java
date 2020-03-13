package org.linlinjava.litemall.db.service.base;

import org.linlinjava.litemall.db.dao.SkillMonsterMapper;
import org.linlinjava.litemall.db.domain.SkillMonster;
import org.linlinjava.litemall.db.domain.example.SkillMonsterExample;
import org.linlinjava.litemall.db.domain.example.SkillMonsterExample.Criteria;
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
public class BaseSkillMonsterService{
    @Autowired
    protected SkillMonsterMapper mapper;

    @Cacheable(cacheNames="SkillMonster", key="#id")
	public SkillMonster findById(int id) {
        return mapper.selectByPrimaryKeyWithLogicalDelete(id,false);
    }
    @Cacheable(cacheNames="SkillMonster", key="#id",condition="#result.deleted == 0")
	public SkillMonster findByIdContainsDelete(int id) {
        return mapper.selectByPrimaryKey(id);
    }

    public void add(SkillMonster skillMonster) {
        skillMonster.setAddTime(LocalDateTime.now());
        skillMonster.setUpdateTime(LocalDateTime.now());
        mapper.insertSelective(skillMonster);
    }
    
    @CachePut(cacheNames="SkillMonster", key="#skillMonster.id")
	public int updateById(SkillMonster skillMonster) {
        skillMonster.setUpdateTime(LocalDateTime.now());
        return mapper.updateByPrimaryKeySelective(skillMonster);
    }
    
   	@CacheEvict(cacheNames="SkillMonster", key="#id")
	public void deleteById(int id) {
        mapper.logicalDeleteByPrimaryKey(id);
    }
    
    
    
    
    
 	public List<SkillMonster> findByName(String name) {
        SkillMonsterExample example = new SkillMonsterExample();
        SkillMonsterExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andNameEqualTo(name);
		return mapper.selectByExample(example);
	}

 	public List<SkillMonster> findBySkills(String skills) {
        SkillMonsterExample example = new SkillMonsterExample();
        SkillMonsterExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andSkillsEqualTo(skills);
		return mapper.selectByExample(example);
	}

 	public List<SkillMonster> findByType(Integer type) {
        SkillMonsterExample example = new SkillMonsterExample();
        SkillMonsterExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andTypeEqualTo(type);
		return mapper.selectByExample(example);
	}

 	public SkillMonster findOneByName(String name) {
        SkillMonsterExample example = new SkillMonsterExample();
        SkillMonsterExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andNameEqualTo(name);
		return mapper.selectOneByExample(example);
	}

 	public SkillMonster findOneBySkills(String skills) {
        SkillMonsterExample example = new SkillMonsterExample();
        SkillMonsterExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andSkillsEqualTo(skills);
		return mapper.selectOneByExample(example);
	}

 	public SkillMonster findOneByType(Integer type) {
        SkillMonsterExample example = new SkillMonsterExample();
        SkillMonsterExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andTypeEqualTo(type);
		return mapper.selectOneByExample(example);
	}

	
	public List<SkillMonster> findAll(int page, int size, String sort, String order) {
        SkillMonsterExample example = new SkillMonsterExample();
        SkillMonsterExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }
        PageHelper.startPage(page, size);
        return mapper.selectByExample(example);
    }
    
    public List<SkillMonster> findAll() {
        SkillMonsterExample example = new SkillMonsterExample();
        SkillMonsterExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        return mapper.selectByExample(example);
    }
}
