package org.linlinjava.litemall.db.service.base;

import org.linlinjava.litemall.db.dao.MapsMapper;
import org.linlinjava.litemall.db.domain.Maps;
import org.linlinjava.litemall.db.domain.example.MapsExample;
import org.linlinjava.litemall.db.domain.example.MapsExample.Criteria;
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
public class BaseMapsService{
    @Autowired
    protected MapsMapper mapper;

    @Cacheable(cacheNames="Maps", key="#id")
	public Maps findById(int id) {
        return mapper.selectByPrimaryKeyWithLogicalDelete(id,false);
    }
    @Cacheable(cacheNames="Maps", key="#id",condition="#result.deleted == 0")
	public Maps findByIdContainsDelete(int id) {
        return mapper.selectByPrimaryKey(id);
    }

    public void add(Maps maps) {
        maps.setAddTime(LocalDateTime.now());
        maps.setUpdateTime(LocalDateTime.now());
        mapper.insertSelective(maps);
    }
    
    @CachePut(cacheNames="Maps", key="#maps.id")
	public int updateById(Maps maps) {
        maps.setUpdateTime(LocalDateTime.now());
        return mapper.updateByPrimaryKeySelective(maps);
    }
    
   	@CacheEvict(cacheNames="Maps", key="#id")
	public void deleteById(int id) {
        mapper.logicalDeleteByPrimaryKey(id);
    }
    
    
    
    
    
 	public List<Maps> findByName(String name) {
        MapsExample example = new MapsExample();
        MapsExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andNameEqualTo(name);
		return mapper.selectByExample(example);
	}

 	public List<Maps> findByType(Integer type) {
        MapsExample example = new MapsExample();
        MapsExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andTypeEqualTo(type);
		return mapper.selectByExample(example);
	}

 	public List<Maps> findByMap(Integer map) {
        MapsExample example = new MapsExample();
        MapsExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andMapEqualTo(map);
		return mapper.selectByExample(example);
	}

 	public List<Maps> findByDir(Float dir) {
        MapsExample example = new MapsExample();
        MapsExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andDirEqualTo(dir);
		return mapper.selectByExample(example);
	}

 	public List<Maps> findByX(Float x) {
        MapsExample example = new MapsExample();
        MapsExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andXEqualTo(x);
		return mapper.selectByExample(example);
	}

 	public List<Maps> findByY(Float y) {
        MapsExample example = new MapsExample();
        MapsExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andYEqualTo(y);
		return mapper.selectByExample(example);
	}

 	public Maps findOneByName(String name) {
        MapsExample example = new MapsExample();
        MapsExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andNameEqualTo(name);
		return mapper.selectOneByExample(example);
	}

 	public Maps findOneByType(Integer type) {
        MapsExample example = new MapsExample();
        MapsExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andTypeEqualTo(type);
		return mapper.selectOneByExample(example);
	}

 	public Maps findOneByMap(Integer map) {
        MapsExample example = new MapsExample();
        MapsExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andMapEqualTo(map);
		return mapper.selectOneByExample(example);
	}

 	public Maps findOneByDir(Float dir) {
        MapsExample example = new MapsExample();
        MapsExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andDirEqualTo(dir);
		return mapper.selectOneByExample(example);
	}

 	public Maps findOneByX(Float x) {
        MapsExample example = new MapsExample();
        MapsExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andXEqualTo(x);
		return mapper.selectOneByExample(example);
	}

 	public Maps findOneByY(Float y) {
        MapsExample example = new MapsExample();
        MapsExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andYEqualTo(y);
		return mapper.selectOneByExample(example);
	}

	
	public List<Maps> findAll(int page, int size, String sort, String order) {
        MapsExample example = new MapsExample();
        MapsExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }
        PageHelper.startPage(page, size);
        return mapper.selectByExample(example);
    }
    
    public List<Maps> findAll() {
        MapsExample example = new MapsExample();
        MapsExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        return mapper.selectByExample(example);
    }
}
