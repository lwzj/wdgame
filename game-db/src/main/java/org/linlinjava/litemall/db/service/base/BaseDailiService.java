package org.linlinjava.litemall.db.service.base;

import org.linlinjava.litemall.db.dao.DailiMapper;
import org.linlinjava.litemall.db.domain.Daili;
import org.linlinjava.litemall.db.domain.example.DailiExample;
import org.linlinjava.litemall.db.domain.example.DailiExample.Criteria;
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
public class BaseDailiService{
    @Autowired
    protected DailiMapper mapper;

    @Cacheable(cacheNames="Daili", key="#id")
	public Daili findById(int id) {
        return mapper.selectByPrimaryKeyWithLogicalDelete(id,false);
    }
    @Cacheable(cacheNames="Daili", key="#id",condition="#result.deleted == 0")
	public Daili findByIdContainsDelete(int id) {
        return mapper.selectByPrimaryKey(id);
    }

    public void add(Daili daili) {
        daili.setAddTime(LocalDateTime.now());
        daili.setUpdateTime(LocalDateTime.now());
        mapper.insertSelective(daili);
    }
    
    @CachePut(cacheNames="Daili", key="#daili.id")
	public int updateById(Daili daili) {
        daili.setUpdateTime(LocalDateTime.now());
        return mapper.updateByPrimaryKeySelective(daili);
    }
    
   	@CacheEvict(cacheNames="Daili", key="#id")
	public void deleteById(int id) {
        mapper.logicalDeleteByPrimaryKey(id);
    }
    
    
    
    
    
 	public List<Daili> findByAccount(String account) {
        DailiExample example = new DailiExample();
        DailiExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andAccountEqualTo(account);
		return mapper.selectByExample(example);
	}

 	public List<Daili> findByPasswd(String passwd) {
        DailiExample example = new DailiExample();
        DailiExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andPasswdEqualTo(passwd);
		return mapper.selectByExample(example);
	}

 	public List<Daili> findByCode(String code) {
        DailiExample example = new DailiExample();
        DailiExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andCodeEqualTo(code);
		return mapper.selectByExample(example);
	}

 	public List<Daili> findByToken(String token) {
        DailiExample example = new DailiExample();
        DailiExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andTokenEqualTo(token);
		return mapper.selectByExample(example);
	}

 	public Daili findOneByAccount(String account) {
        DailiExample example = new DailiExample();
        DailiExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andAccountEqualTo(account);
		return mapper.selectOneByExample(example);
	}

 	public Daili findOneByPasswd(String passwd) {
        DailiExample example = new DailiExample();
        DailiExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andPasswdEqualTo(passwd);
		return mapper.selectOneByExample(example);
	}

 	public Daili findOneByCode(String code) {
        DailiExample example = new DailiExample();
        DailiExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andCodeEqualTo(code);
		return mapper.selectOneByExample(example);
	}

 	public Daili findOneByToken(String token) {
        DailiExample example = new DailiExample();
        DailiExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andTokenEqualTo(token);
		return mapper.selectOneByExample(example);
	}

	
	public List<Daili> findAll(int page, int size, String sort, String order) {
        DailiExample example = new DailiExample();
        DailiExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }
        PageHelper.startPage(page, size);
        return mapper.selectByExample(example);
    }
    
    public List<Daili> findAll() {
        DailiExample example = new DailiExample();
        DailiExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        return mapper.selectByExample(example);
    }
}
