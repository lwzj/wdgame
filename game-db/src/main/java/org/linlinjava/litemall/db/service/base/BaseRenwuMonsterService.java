package org.linlinjava.litemall.db.service.base;

import org.linlinjava.litemall.db.dao.RenwuMonsterMapper;
import org.linlinjava.litemall.db.domain.RenwuMonster;
import org.linlinjava.litemall.db.domain.example.RenwuMonsterExample;
import org.linlinjava.litemall.db.domain.example.RenwuMonsterExample.Criteria;
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
public class BaseRenwuMonsterService{
    @Autowired
    protected RenwuMonsterMapper mapper;

    @Cacheable(cacheNames="RenwuMonster", key="#id")
	public RenwuMonster findById(int id) {
        return mapper.selectByPrimaryKeyWithLogicalDelete(id,false);
    }
    @Cacheable(cacheNames="RenwuMonster", key="#id",condition="#result.deleted == 0")
	public RenwuMonster findByIdContainsDelete(int id) {
        return mapper.selectByPrimaryKey(id);
    }

    public void add(RenwuMonster renwuMonster) {
        renwuMonster.setAddTime(LocalDateTime.now());
        renwuMonster.setUpdateTime(LocalDateTime.now());
        mapper.insertSelective(renwuMonster);
    }
    
    @CachePut(cacheNames="RenwuMonster", key="#renwuMonster.id")
	public int updateById(RenwuMonster renwuMonster) {
        renwuMonster.setUpdateTime(LocalDateTime.now());
        return mapper.updateByPrimaryKeySelective(renwuMonster);
    }
    
   	@CacheEvict(cacheNames="RenwuMonster", key="#id")
	public void deleteById(int id) {
        mapper.logicalDeleteByPrimaryKey(id);
    }
    
    
    
    
    
 	public List<RenwuMonster> findByMapName(String mapName) {
        RenwuMonsterExample example = new RenwuMonsterExample();
        RenwuMonsterExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andMapNameEqualTo(mapName);
		return mapper.selectByExample(example);
	}

 	public List<RenwuMonster> findByX(Integer x) {
        RenwuMonsterExample example = new RenwuMonsterExample();
        RenwuMonsterExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andXEqualTo(x);
		return mapper.selectByExample(example);
	}

 	public List<RenwuMonster> findByY(Integer y) {
        RenwuMonsterExample example = new RenwuMonsterExample();
        RenwuMonsterExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andYEqualTo(y);
		return mapper.selectByExample(example);
	}

 	public List<RenwuMonster> findByName(String name) {
        RenwuMonsterExample example = new RenwuMonsterExample();
        RenwuMonsterExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andNameEqualTo(name);
		return mapper.selectByExample(example);
	}

 	public List<RenwuMonster> findByIcon(Integer icon) {
        RenwuMonsterExample example = new RenwuMonsterExample();
        RenwuMonsterExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andIconEqualTo(icon);
		return mapper.selectByExample(example);
	}

 	public List<RenwuMonster> findBySkills(String skills) {
        RenwuMonsterExample example = new RenwuMonsterExample();
        RenwuMonsterExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andSkillsEqualTo(skills);
		return mapper.selectByExample(example);
	}

 	public List<RenwuMonster> findByType(Integer type) {
        RenwuMonsterExample example = new RenwuMonsterExample();
        RenwuMonsterExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andTypeEqualTo(type);
		return mapper.selectByExample(example);
	}

 	public RenwuMonster findOneByMapName(String mapName) {
        RenwuMonsterExample example = new RenwuMonsterExample();
        RenwuMonsterExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andMapNameEqualTo(mapName);
		return mapper.selectOneByExample(example);
	}

 	public RenwuMonster findOneByX(Integer x) {
        RenwuMonsterExample example = new RenwuMonsterExample();
        RenwuMonsterExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andXEqualTo(x);
		return mapper.selectOneByExample(example);
	}

 	public RenwuMonster findOneByY(Integer y) {
        RenwuMonsterExample example = new RenwuMonsterExample();
        RenwuMonsterExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andYEqualTo(y);
		return mapper.selectOneByExample(example);
	}

 	public RenwuMonster findOneByName(String name) {
        RenwuMonsterExample example = new RenwuMonsterExample();
        RenwuMonsterExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andNameEqualTo(name);
		return mapper.selectOneByExample(example);
	}

 	public RenwuMonster findOneByIcon(Integer icon) {
        RenwuMonsterExample example = new RenwuMonsterExample();
        RenwuMonsterExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andIconEqualTo(icon);
		return mapper.selectOneByExample(example);
	}

 	public RenwuMonster findOneBySkills(String skills) {
        RenwuMonsterExample example = new RenwuMonsterExample();
        RenwuMonsterExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andSkillsEqualTo(skills);
		return mapper.selectOneByExample(example);
	}

 	public RenwuMonster findOneByType(Integer type) {
        RenwuMonsterExample example = new RenwuMonsterExample();
        RenwuMonsterExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andTypeEqualTo(type);
		return mapper.selectOneByExample(example);
	}

	
	public List<RenwuMonster> findAll(int page, int size, String sort, String order) {
        RenwuMonsterExample example = new RenwuMonsterExample();
        RenwuMonsterExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }
        PageHelper.startPage(page, size);
        return mapper.selectByExample(example);
    }
    
    public List<RenwuMonster> findAll() {
        RenwuMonsterExample example = new RenwuMonsterExample();
        RenwuMonsterExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        return mapper.selectByExample(example);
    }
}
