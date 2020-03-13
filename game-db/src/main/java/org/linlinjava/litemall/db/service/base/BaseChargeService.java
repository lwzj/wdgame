package org.linlinjava.litemall.db.service.base;

import org.linlinjava.litemall.db.dao.ChargeMapper;
import org.linlinjava.litemall.db.domain.Charge;
import org.linlinjava.litemall.db.domain.example.ChargeExample;
import org.linlinjava.litemall.db.domain.example.ChargeExample.Criteria;
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
public class BaseChargeService{
    @Autowired
    protected ChargeMapper mapper;

    @Cacheable(cacheNames="Charge", key="#id")
	public Charge findById(int id) {
        return mapper.selectByPrimaryKeyWithLogicalDelete(id,false);
    }
    @Cacheable(cacheNames="Charge", key="#id",condition="#result.deleted == 0")
	public Charge findByIdContainsDelete(int id) {
        return mapper.selectByPrimaryKey(id);
    }

    public void add(Charge charge) {
        charge.setAddTime(LocalDateTime.now());
        charge.setUpdateTime(LocalDateTime.now());
        mapper.insertSelective(charge);
    }
    
    @CachePut(cacheNames="Charge", key="#charge.id")
	public int updateById(Charge charge) {
        charge.setUpdateTime(LocalDateTime.now());
        return mapper.updateByPrimaryKeySelective(charge);
    }
    
   	@CacheEvict(cacheNames="Charge", key="#id")
	public void deleteById(int id) {
        mapper.logicalDeleteByPrimaryKey(id);
    }
    
    
    
    
    
 	public List<Charge> findByAccountname(String accountname) {
        ChargeExample example = new ChargeExample();
        ChargeExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andAccountnameEqualTo(accountname);
		return mapper.selectByExample(example);
	}

 	public List<Charge> findByCoin(Integer coin) {
        ChargeExample example = new ChargeExample();
        ChargeExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andCoinEqualTo(coin);
		return mapper.selectByExample(example);
	}

 	public List<Charge> findByState(Integer state) {
        ChargeExample example = new ChargeExample();
        ChargeExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andStateEqualTo(state);
		return mapper.selectByExample(example);
	}

 	public List<Charge> findByMoney(Integer money) {
        ChargeExample example = new ChargeExample();
        ChargeExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andMoneyEqualTo(money);
		return mapper.selectByExample(example);
	}

 	public List<Charge> findByCode(String code) {
        ChargeExample example = new ChargeExample();
        ChargeExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andCodeEqualTo(code);
		return mapper.selectByExample(example);
	}

 	public Charge findOneByAccountname(String accountname) {
        ChargeExample example = new ChargeExample();
        ChargeExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andAccountnameEqualTo(accountname);
		return mapper.selectOneByExample(example);
	}
    public Charge findOneById(int id) {
        ChargeExample example = new ChargeExample();
        ChargeExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andIdEqualTo(id);
        return mapper.selectOneByExample(example);
    }
 	public Charge findOneByCoin(Integer coin) {
        ChargeExample example = new ChargeExample();
        ChargeExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andCoinEqualTo(coin);
		return mapper.selectOneByExample(example);
	}

 	public Charge findOneByState(Integer state) {
        ChargeExample example = new ChargeExample();
        ChargeExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andStateEqualTo(state);
		return mapper.selectOneByExample(example);
	}

 	public Charge findOneByMoney(Integer money) {
        ChargeExample example = new ChargeExample();
        ChargeExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andMoneyEqualTo(money);
		return mapper.selectOneByExample(example);
	}

 	public Charge findOneByCode(String code) {
        ChargeExample example = new ChargeExample();
        ChargeExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andCodeEqualTo(code);
		return mapper.selectOneByExample(example);
	}

	
	public List<Charge> findAll(int page, int size, String sort, String order) {
        ChargeExample example = new ChargeExample();
        ChargeExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }
        PageHelper.startPage(page, size);
        return mapper.selectByExample(example);
    }
    
    public List<Charge> findAll() {
        ChargeExample example = new ChargeExample();
        ChargeExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        return mapper.selectByExample(example);
    }
}
