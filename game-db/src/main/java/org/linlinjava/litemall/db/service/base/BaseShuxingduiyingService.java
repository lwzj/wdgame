package org.linlinjava.litemall.db.service.base;

import org.linlinjava.litemall.db.dao.ShuxingduiyingMapper;
import org.linlinjava.litemall.db.domain.Shuxingduiying;
import org.linlinjava.litemall.db.domain.example.ShuxingduiyingExample;
import org.linlinjava.litemall.db.domain.example.ShuxingduiyingExample.Criteria;
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
public class BaseShuxingduiyingService{
    @Autowired
    protected ShuxingduiyingMapper mapper;

    @Cacheable(cacheNames="Shuxingduiying", key="#id")
	public Shuxingduiying findById(int id) {
        return mapper.selectByPrimaryKeyWithLogicalDelete(id,false);
    }
    @Cacheable(cacheNames="Shuxingduiying", key="#id",condition="#result.deleted == 0")
	public Shuxingduiying findByIdContainsDelete(int id) {
        return mapper.selectByPrimaryKey(id);
    }

    public void add(Shuxingduiying shuxingduiying) {
        shuxingduiying.setAddTime(LocalDateTime.now());
        shuxingduiying.setUpdateTime(LocalDateTime.now());
        mapper.insertSelective(shuxingduiying);
    }
    
    @CachePut(cacheNames="Shuxingduiying", key="#shuxingduiying.id")
	public int updateById(Shuxingduiying shuxingduiying) {
        shuxingduiying.setUpdateTime(LocalDateTime.now());
        return mapper.updateByPrimaryKeySelective(shuxingduiying);
    }
    
   	@CacheEvict(cacheNames="Shuxingduiying", key="#id")
	public void deleteById(int id) {
        mapper.logicalDeleteByPrimaryKey(id);
    }
    
    
    
    
    
 	public List<Shuxingduiying> findByName(String name) {
        ShuxingduiyingExample example = new ShuxingduiyingExample();
        ShuxingduiyingExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andNameEqualTo(name);
		return mapper.selectByExample(example);
	}

 	public List<Shuxingduiying> findByYingwen(String yingwen) {
        ShuxingduiyingExample example = new ShuxingduiyingExample();
        ShuxingduiyingExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andYingwenEqualTo(yingwen);
		return mapper.selectByExample(example);
	}

 	public Shuxingduiying findOneByName(String name) {
        ShuxingduiyingExample example = new ShuxingduiyingExample();
        ShuxingduiyingExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andNameEqualTo(name);
		return mapper.selectOneByExample(example);
	}

 	public Shuxingduiying findOneByYingwen(String yingwen) {
        ShuxingduiyingExample example = new ShuxingduiyingExample();
        ShuxingduiyingExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andYingwenEqualTo(yingwen);
		return mapper.selectOneByExample(example);
	}

	
	public List<Shuxingduiying> findAll(int page, int size, String sort, String order) {
        ShuxingduiyingExample example = new ShuxingduiyingExample();
        ShuxingduiyingExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }
        PageHelper.startPage(page, size);
        return mapper.selectByExample(example);
    }
    
    public List<Shuxingduiying> findAll() {
        ShuxingduiyingExample example = new ShuxingduiyingExample();
        ShuxingduiyingExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        return mapper.selectByExample(example);
    }
}
