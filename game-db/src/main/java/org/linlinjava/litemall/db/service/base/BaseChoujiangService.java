package org.linlinjava.litemall.db.service.base;

import org.linlinjava.litemall.db.dao.ChoujiangMapper;
import org.linlinjava.litemall.db.domain.Choujiang;
import org.linlinjava.litemall.db.domain.example.ChoujiangExample;
import org.linlinjava.litemall.db.domain.example.ChoujiangExample.Criteria;
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
public class BaseChoujiangService{
    @Autowired
    protected ChoujiangMapper mapper;

    @Cacheable(cacheNames="Choujiang", key="#id")
	public Choujiang findById(int id) {
        return mapper.selectByPrimaryKeyWithLogicalDelete(id,false);
    }
    @Cacheable(cacheNames="Choujiang", key="#id",condition="#result.deleted == 0")
	public Choujiang findByIdContainsDelete(int id) {
        return mapper.selectByPrimaryKey(id);
    }

    public void add(Choujiang choujiang) {
        choujiang.setAddTime(LocalDateTime.now());
        choujiang.setUpdateTime(LocalDateTime.now());
        mapper.insertSelective(choujiang);
    }
    
    @CachePut(cacheNames="Choujiang", key="#choujiang.id")
	public int updateById(Choujiang choujiang) {
        choujiang.setUpdateTime(LocalDateTime.now());
        return mapper.updateByPrimaryKeySelective(choujiang);
    }
    
   	@CacheEvict(cacheNames="Choujiang", key="#id")
	public void deleteById(int id) {
        mapper.logicalDeleteByPrimaryKey(id);
    }
    
    
    
    
    
 	public List<Choujiang> findByNo(Integer no) {
        ChoujiangExample example = new ChoujiangExample();
        ChoujiangExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andNoEqualTo(no);
		return mapper.selectByExample(example);
	}

 	public List<Choujiang> findByName(String name) {
        ChoujiangExample example = new ChoujiangExample();
        ChoujiangExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andNameEqualTo(name);
		return mapper.selectByExample(example);
	}

 	public List<Choujiang> findByDesc(String desc) {
        ChoujiangExample example = new ChoujiangExample();
        ChoujiangExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andDescEqualTo(desc);
		return mapper.selectByExample(example);
	}

 	public List<Choujiang> findByLevel(Integer level) {
        ChoujiangExample example = new ChoujiangExample();
        ChoujiangExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andLevelEqualTo(level);
		return mapper.selectByExample(example);
	}

 	public Choujiang findOneByNo(Integer no) {
        ChoujiangExample example = new ChoujiangExample();
        ChoujiangExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andNoEqualTo(no);
		return mapper.selectOneByExample(example);
	}

 	public Choujiang findOneByName(String name) {
        ChoujiangExample example = new ChoujiangExample();
        ChoujiangExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andNameEqualTo(name);
		return mapper.selectOneByExample(example);
	}

 	public Choujiang findOneByDesc(String desc) {
        ChoujiangExample example = new ChoujiangExample();
        ChoujiangExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andDescEqualTo(desc);
		return mapper.selectOneByExample(example);
	}

 	public Choujiang findOneByLevel(Integer level) {
        ChoujiangExample example = new ChoujiangExample();
        ChoujiangExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andLevelEqualTo(level);
		return mapper.selectOneByExample(example);
	}

	
	public List<Choujiang> findAll(int page, int size, String sort, String order) {
        ChoujiangExample example = new ChoujiangExample();
        ChoujiangExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }
        PageHelper.startPage(page, size);
        return mapper.selectByExample(example);
    }
    
    public List<Choujiang> findAll() {
        ChoujiangExample example = new ChoujiangExample();
        ChoujiangExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        return mapper.selectByExample(example);
    }
}
