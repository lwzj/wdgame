package org.linlinjava.litemall.db.service.base;

import org.linlinjava.litemall.db.dao.AccountsMapper;
import org.linlinjava.litemall.db.domain.Accounts;
import org.linlinjava.litemall.db.domain.example.AccountsExample;
import org.linlinjava.litemall.db.domain.example.AccountsExample.Criteria;
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
public class BaseAccountsService{
    @Autowired
    protected AccountsMapper mapper;

    @Cacheable(cacheNames="Accounts", key="#id")
	public Accounts findById(int id) {
        return mapper.selectByPrimaryKeyWithLogicalDelete(id,false);
    }
    @Cacheable(cacheNames="Accounts", key="#id",condition="#result.deleted == 0")
	public Accounts findByIdContainsDelete(int id) {
        return mapper.selectByPrimaryKey(id);
    }

    public void add(Accounts accounts) {
        accounts.setAddTime(LocalDateTime.now());
        accounts.setUpdateTime(LocalDateTime.now());
        mapper.insertSelective(accounts);
    }
    
    @CachePut(cacheNames="Accounts", key="#accounts.id")
	public int updateById(Accounts accounts) {
        accounts.setUpdateTime(LocalDateTime.now());
        return mapper.updateByPrimaryKeySelective(accounts);
    }
    
   	@CacheEvict(cacheNames="Accounts", key="#id")
	public void deleteById(int id) {
        mapper.logicalDeleteByPrimaryKey(id);
    }
    
    
    
    
    
 	public List<Accounts> findByName(String name) {
        AccountsExample example = new AccountsExample();
        AccountsExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andNameEqualTo(name);
		return mapper.selectByExample(example);
	}

 	public List<Accounts> findByKeyword(String keyword) {
        AccountsExample example = new AccountsExample();
        AccountsExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andKeywordEqualTo(keyword);
		return mapper.selectByExample(example);
	}

 	public List<Accounts> findByPassword(String password) {
        AccountsExample example = new AccountsExample();
        AccountsExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andPasswordEqualTo(password);
		return mapper.selectByExample(example);
	}

 	public List<Accounts> findByToken(String token) {
        AccountsExample example = new AccountsExample();
        AccountsExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andTokenEqualTo(token);
		return mapper.selectByExample(example);
	}

 	public List<Accounts> findByChongzhijifen(Integer chongzhijifen) {
        AccountsExample example = new AccountsExample();
        AccountsExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andChongzhijifenEqualTo(chongzhijifen);
		return mapper.selectByExample(example);
	}

 	public List<Accounts> findByChongzhiyuanbao(Integer chongzhiyuanbao) {
        AccountsExample example = new AccountsExample();
        AccountsExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andChongzhiyuanbaoEqualTo(chongzhiyuanbao);
		return mapper.selectByExample(example);
	}

 	public List<Accounts> findByYaoqingma(String yaoqingma) {
        AccountsExample example = new AccountsExample();
        AccountsExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andYaoqingmaEqualTo(yaoqingma);
		return mapper.selectByExample(example);
	}

 	public List<Accounts> findByBlock(Integer block) {
        AccountsExample example = new AccountsExample();
        AccountsExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andBlockEqualTo(block);
		return mapper.selectByExample(example);
	}

 	public List<Accounts> findByCode(String code) {
        AccountsExample example = new AccountsExample();
        AccountsExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andCodeEqualTo(code);
		return mapper.selectByExample(example);
	}

 	public Accounts findOneByName(String name) {
        AccountsExample example = new AccountsExample();
        AccountsExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andNameEqualTo(name);
		return mapper.selectOneByExample(example);
	}

 	public Accounts findOneByKeyword(String keyword) {
        AccountsExample example = new AccountsExample();
        AccountsExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andKeywordEqualTo(keyword);
		return mapper.selectOneByExample(example);
	}

 	public Accounts findOneByPassword(String password) {
        AccountsExample example = new AccountsExample();
        AccountsExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andPasswordEqualTo(password);
		return mapper.selectOneByExample(example);
	}

 	public Accounts findOneByToken(String token) {
        AccountsExample example = new AccountsExample();
        AccountsExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andTokenEqualTo(token);
		return mapper.selectOneByExample(example);
	}

 	public Accounts findOneByChongzhijifen(Integer chongzhijifen) {
        AccountsExample example = new AccountsExample();
        AccountsExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andChongzhijifenEqualTo(chongzhijifen);
		return mapper.selectOneByExample(example);
	}

 	public Accounts findOneByChongzhiyuanbao(Integer chongzhiyuanbao) {
        AccountsExample example = new AccountsExample();
        AccountsExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andChongzhiyuanbaoEqualTo(chongzhiyuanbao);
		return mapper.selectOneByExample(example);
	}

 	public Accounts findOneByYaoqingma(String yaoqingma) {
        AccountsExample example = new AccountsExample();
        AccountsExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andYaoqingmaEqualTo(yaoqingma);
		return mapper.selectOneByExample(example);
	}

 	public Accounts findOneByBlock(Integer block) {
        AccountsExample example = new AccountsExample();
        AccountsExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andBlockEqualTo(block);
		return mapper.selectOneByExample(example);
	}

 	public Accounts findOneByCode(String code) {
        AccountsExample example = new AccountsExample();
        AccountsExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andCodeEqualTo(code);
		return mapper.selectOneByExample(example);
	}

	
	public List<Accounts> findAll(int page, int size, String sort, String order) {
        AccountsExample example = new AccountsExample();
        AccountsExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }
        PageHelper.startPage(page, size);
        return mapper.selectByExample(example);
    }
    
    public List<Accounts> findAll() {
        AccountsExample example = new AccountsExample();
        AccountsExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        return mapper.selectByExample(example);
    }
}
