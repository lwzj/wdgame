package org.linlinjava.litemall.db.service.base;

import org.linlinjava.litemall.db.dao.CharactersMapper;
import org.linlinjava.litemall.db.domain.Characters;
import org.linlinjava.litemall.db.domain.example.CharactersExample;
import org.linlinjava.litemall.db.domain.example.CharactersExample.Criteria;
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
public class BaseCharactersService{
    @Autowired
    protected CharactersMapper mapper;

    @Cacheable(cacheNames="Characters", key="#id")
	public Characters findById(int id) {
        return mapper.selectByPrimaryKeyWithLogicalDelete(id,false);
    }
    @Cacheable(cacheNames="Characters", key="#id",condition="#result.deleted == 0")
	public Characters findByIdContainsDelete(int id) {
        return mapper.selectByPrimaryKey(id);
    }

    public void add(Characters characters) {
        characters.setAddTime(LocalDateTime.now());
        characters.setUpdateTime(LocalDateTime.now());
        mapper.insertSelective(characters);
    }
    
    @CachePut(cacheNames="Characters", key="#characters.id")
	public int updateById(Characters characters) {
        characters.setUpdateTime(LocalDateTime.now());
        return mapper.updateByPrimaryKeySelective(characters);
    }
    
   	@CacheEvict(cacheNames="Characters", key="#id")
	public void deleteById(int id) {
        mapper.logicalDeleteByPrimaryKey(id);
    }
    
    
    
    
    
 	public List<Characters> findByMenpai(Integer menpai) {
        CharactersExample example = new CharactersExample();
        CharactersExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andMenpaiEqualTo(menpai);
		return mapper.selectByExample(example);
	}

 	public List<Characters> findByName(String name) {
        CharactersExample example = new CharactersExample();
        CharactersExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andNameEqualTo(name);
		return mapper.selectByExample(example);
	}

 	public List<Characters> findByAccountId(Integer accountId) {
        CharactersExample example = new CharactersExample();
        CharactersExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andAccountIdEqualTo(accountId);
		return mapper.selectByExample(example);
	}

 	public List<Characters> findByGid(String gid) {
        CharactersExample example = new CharactersExample();
        CharactersExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andGidEqualTo(gid);
		return mapper.selectByExample(example);
	}

 	public Characters findOneByMenpai(Integer menpai) {
        CharactersExample example = new CharactersExample();
        CharactersExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andMenpaiEqualTo(menpai);
		return mapper.selectOneByExample(example);
	}

 	public Characters findOneByName(String name) {
        CharactersExample example = new CharactersExample();
        CharactersExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andNameEqualTo(name);
		return mapper.selectOneByExample(example);
	}

 	public Characters findOneByAccountId(Integer accountId) {
        CharactersExample example = new CharactersExample();
        CharactersExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andAccountIdEqualTo(accountId);
		return mapper.selectOneByExample(example);
	}

 	public Characters findOneByGid(String gid) {
        CharactersExample example = new CharactersExample();
        CharactersExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andGidEqualTo(gid);
		return mapper.selectOneByExample(example);
	}

	
	public List<Characters> findAll(int page, int size, String sort, String order) {
        CharactersExample example = new CharactersExample();
        CharactersExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }
        PageHelper.startPage(page, size);
        return mapper.selectByExample(example);
    }
    
    public List<Characters> findAll() {
        CharactersExample example = new CharactersExample();
        CharactersExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        return mapper.selectByExample(example);
    }
}
