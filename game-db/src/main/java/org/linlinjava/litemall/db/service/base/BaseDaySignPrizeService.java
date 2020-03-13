package org.linlinjava.litemall.db.service.base;

import org.linlinjava.litemall.db.dao.DaySignPrizeMapper;
import org.linlinjava.litemall.db.domain.DaySignPrize;
import org.linlinjava.litemall.db.domain.example.DaySignPrizeExample;
import org.linlinjava.litemall.db.domain.example.DaySignPrizeExample.Criteria;
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
public class BaseDaySignPrizeService{
    @Autowired
    protected DaySignPrizeMapper mapper;

    @Cacheable(cacheNames="DaySignPrize", key="#id")
	public DaySignPrize findById(int id) {
        return mapper.selectByPrimaryKeyWithLogicalDelete(id,false);
    }
    @Cacheable(cacheNames="DaySignPrize", key="#id",condition="#result.deleted == 0")
	public DaySignPrize findByIdContainsDelete(int id) {
        return mapper.selectByPrimaryKey(id);
    }

    public void add(DaySignPrize daySignPrize) {
        daySignPrize.setAddTime(LocalDateTime.now());
        daySignPrize.setUpdateTime(LocalDateTime.now());
        mapper.insertSelective(daySignPrize);
    }
    
    @CachePut(cacheNames="DaySignPrize", key="#daySignPrize.id")
	public int updateById(DaySignPrize daySignPrize) {
        daySignPrize.setUpdateTime(LocalDateTime.now());
        return mapper.updateByPrimaryKeySelective(daySignPrize);
    }
    
   	@CacheEvict(cacheNames="DaySignPrize", key="#id")
	public void deleteById(int id) {
        mapper.logicalDeleteByPrimaryKey(id);
    }
    
    
    
    
    
 	public List<DaySignPrize> findByName(String name) {
        DaySignPrizeExample example = new DaySignPrizeExample();
        DaySignPrizeExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andNameEqualTo(name);
		return mapper.selectByExample(example);
	}

 	public List<DaySignPrize> findByIndex(Integer index) {
        DaySignPrizeExample example = new DaySignPrizeExample();
        DaySignPrizeExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andIndexEqualTo(index);
		return mapper.selectByExample(example);
	}

 	public DaySignPrize findOneByName(String name) {
        DaySignPrizeExample example = new DaySignPrizeExample();
        DaySignPrizeExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andNameEqualTo(name);
		return mapper.selectOneByExample(example);
	}

 	public DaySignPrize findOneByIndex(Integer index) {
        DaySignPrizeExample example = new DaySignPrizeExample();
        DaySignPrizeExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andIndexEqualTo(index);
		return mapper.selectOneByExample(example);
	}

	
	public List<DaySignPrize> findAll(int page, int size, String sort, String order) {
        DaySignPrizeExample example = new DaySignPrizeExample();
        DaySignPrizeExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }
        PageHelper.startPage(page, size);
        return mapper.selectByExample(example);
    }
    
    public List<DaySignPrize> findAll() {
        DaySignPrizeExample example = new DaySignPrizeExample();
        DaySignPrizeExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        return mapper.selectByExample(example);
    }
}
