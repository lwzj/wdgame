package org.linlinjava.litemall.db.service.base;

import org.linlinjava.litemall.db.dao.CreepsStoreMapper;
import org.linlinjava.litemall.db.domain.CreepsStore;
import org.linlinjava.litemall.db.domain.example.CreepsStoreExample;
import org.linlinjava.litemall.db.domain.example.CreepsStoreExample.Criteria;
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
public class BaseCreepsStoreService{
    @Autowired
    protected CreepsStoreMapper mapper;

    @Cacheable(cacheNames="CreepsStore", key="#id")
	public CreepsStore findById(int id) {
        return mapper.selectByPrimaryKeyWithLogicalDelete(id,false);
    }
    @Cacheable(cacheNames="CreepsStore", key="#id",condition="#result.deleted == 0")
	public CreepsStore findByIdContainsDelete(int id) {
        return mapper.selectByPrimaryKey(id);
    }

    public void add(CreepsStore creepsStore) {
        creepsStore.setAddTime(LocalDateTime.now());
        creepsStore.setUpdateTime(LocalDateTime.now());
        mapper.insertSelective(creepsStore);
    }
    
    @CachePut(cacheNames="CreepsStore", key="#creepsStore.id")
	public int updateById(CreepsStore creepsStore) {
        creepsStore.setUpdateTime(LocalDateTime.now());
        return mapper.updateByPrimaryKeySelective(creepsStore);
    }
    
   	@CacheEvict(cacheNames="CreepsStore", key="#id")
	public void deleteById(int id) {
        mapper.logicalDeleteByPrimaryKey(id);
    }
    
    
    
    
    
 	public List<CreepsStore> findByName(String name) {
        CreepsStoreExample example = new CreepsStoreExample();
        CreepsStoreExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andNameEqualTo(name);
		return mapper.selectByExample(example);
	}

 	public List<CreepsStore> findByPrice(Integer price) {
        CreepsStoreExample example = new CreepsStoreExample();
        CreepsStoreExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andPriceEqualTo(price);
		return mapper.selectByExample(example);
	}

 	public CreepsStore findOneByName(String name) {
        CreepsStoreExample example = new CreepsStoreExample();
        CreepsStoreExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andNameEqualTo(name);
		return mapper.selectOneByExample(example);
	}

 	public CreepsStore findOneByPrice(Integer price) {
        CreepsStoreExample example = new CreepsStoreExample();
        CreepsStoreExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andPriceEqualTo(price);
		return mapper.selectOneByExample(example);
	}

	
	public List<CreepsStore> findAll(int page, int size, String sort, String order) {
        CreepsStoreExample example = new CreepsStoreExample();
        CreepsStoreExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }
        PageHelper.startPage(page, size);
        return mapper.selectByExample(example);
    }
    
    public List<CreepsStore> findAll() {
        CreepsStoreExample example = new CreepsStoreExample();
        CreepsStoreExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        return mapper.selectByExample(example);
    }
}
