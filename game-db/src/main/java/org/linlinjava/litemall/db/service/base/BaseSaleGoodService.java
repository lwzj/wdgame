package org.linlinjava.litemall.db.service.base;

import org.linlinjava.litemall.db.dao.SaleGoodMapper;
import org.linlinjava.litemall.db.domain.SaleGood;
import org.linlinjava.litemall.db.domain.example.SaleGoodExample;
import org.linlinjava.litemall.db.domain.example.SaleGoodExample.Criteria;
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
public class BaseSaleGoodService{
    @Autowired
    protected SaleGoodMapper mapper;

    @Cacheable(cacheNames="SaleGood", key="#id")
	public SaleGood findById(int id) {
        return mapper.selectByPrimaryKeyWithLogicalDelete(id,false);
    }
    @Cacheable(cacheNames="SaleGood", key="#id",condition="#result.deleted == 0")
	public SaleGood findByIdContainsDelete(int id) {
        return mapper.selectByPrimaryKey(id);
    }

    public void add(SaleGood saleGood) {
        saleGood.setAddTime(LocalDateTime.now());
        saleGood.setUpdateTime(LocalDateTime.now());
        mapper.insertSelective(saleGood);
    }
    
    @CachePut(cacheNames="SaleGood", key="#saleGood.id")
	public int updateById(SaleGood saleGood) {
        saleGood.setUpdateTime(LocalDateTime.now());
        return mapper.updateByPrimaryKeySelective(saleGood);
    }
    
   	@CacheEvict(cacheNames="SaleGood", key="#id")
	public void deleteById(int id) {
        mapper.logicalDeleteByPrimaryKey(id);
    }
    
    
    
    
    
 	public List<SaleGood> findByGoodsId(String goodsId) {
        SaleGoodExample example = new SaleGoodExample();
        SaleGoodExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andGoodsIdEqualTo(goodsId);
		return mapper.selectByExample(example);
	}

 	public List<SaleGood> findByName(String name) {
        SaleGoodExample example = new SaleGoodExample();
        SaleGoodExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andNameEqualTo(name);
		return mapper.selectByExample(example);
	}

 	public List<SaleGood> findByStartTime(Integer startTime) {
        SaleGoodExample example = new SaleGoodExample();
        SaleGoodExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andStartTimeEqualTo(startTime);
		return mapper.selectByExample(example);
	}

 	public List<SaleGood> findByEndTime(Integer endTime) {
        SaleGoodExample example = new SaleGoodExample();
        SaleGoodExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andEndTimeEqualTo(endTime);
		return mapper.selectByExample(example);
	}

 	public List<SaleGood> findByPrice(Integer price) {
        SaleGoodExample example = new SaleGoodExample();
        SaleGoodExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andPriceEqualTo(price);
		return mapper.selectByExample(example);
	}

 	public List<SaleGood> findByReqLevel(Integer reqLevel) {
        SaleGoodExample example = new SaleGoodExample();
        SaleGoodExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andReqLevelEqualTo(reqLevel);
		return mapper.selectByExample(example);
	}

 	public List<SaleGood> findByOwnerUuid(String ownerUuid) {
        SaleGoodExample example = new SaleGoodExample();
        SaleGoodExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andOwnerUuidEqualTo(ownerUuid);
		return mapper.selectByExample(example);
	}

 	public List<SaleGood> findByStr(String str) {
        SaleGoodExample example = new SaleGoodExample();
        SaleGoodExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andStrEqualTo(str);
		return mapper.selectByExample(example);
	}

 	public List<SaleGood> findByPet(String pet) {
        SaleGoodExample example = new SaleGoodExample();
        SaleGoodExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andPetEqualTo(pet);
		return mapper.selectByExample(example);
	}

 	public List<SaleGood> findByPos(Integer pos) {
        SaleGoodExample example = new SaleGoodExample();
        SaleGoodExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andPosEqualTo(pos);
		return mapper.selectByExample(example);
	}

 	public List<SaleGood> findByIspet(Integer ispet) {
        SaleGoodExample example = new SaleGoodExample();
        SaleGoodExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andIspetEqualTo(ispet);
		return mapper.selectByExample(example);
	}

 	public List<SaleGood> findByLevel(Integer level) {
        SaleGoodExample example = new SaleGoodExample();
        SaleGoodExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andLevelEqualTo(level);
		return mapper.selectByExample(example);
	}

 	public SaleGood findOneByGoodsId(String goodsId) {
        SaleGoodExample example = new SaleGoodExample();
        SaleGoodExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andGoodsIdEqualTo(goodsId);
		return mapper.selectOneByExample(example);
	}

 	public SaleGood findOneByName(String name) {
        SaleGoodExample example = new SaleGoodExample();
        SaleGoodExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andNameEqualTo(name);
		return mapper.selectOneByExample(example);
	}

 	public SaleGood findOneByStartTime(Integer startTime) {
        SaleGoodExample example = new SaleGoodExample();
        SaleGoodExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andStartTimeEqualTo(startTime);
		return mapper.selectOneByExample(example);
	}

 	public SaleGood findOneByEndTime(Integer endTime) {
        SaleGoodExample example = new SaleGoodExample();
        SaleGoodExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andEndTimeEqualTo(endTime);
		return mapper.selectOneByExample(example);
	}

 	public SaleGood findOneByPrice(Integer price) {
        SaleGoodExample example = new SaleGoodExample();
        SaleGoodExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andPriceEqualTo(price);
		return mapper.selectOneByExample(example);
	}

 	public SaleGood findOneByReqLevel(Integer reqLevel) {
        SaleGoodExample example = new SaleGoodExample();
        SaleGoodExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andReqLevelEqualTo(reqLevel);
		return mapper.selectOneByExample(example);
	}

 	public SaleGood findOneByOwnerUuid(String ownerUuid) {
        SaleGoodExample example = new SaleGoodExample();
        SaleGoodExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andOwnerUuidEqualTo(ownerUuid);
		return mapper.selectOneByExample(example);
	}

 	public SaleGood findOneByStr(String str) {
        SaleGoodExample example = new SaleGoodExample();
        SaleGoodExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andStrEqualTo(str);
		return mapper.selectOneByExample(example);
	}

 	public SaleGood findOneByPet(String pet) {
        SaleGoodExample example = new SaleGoodExample();
        SaleGoodExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andPetEqualTo(pet);
		return mapper.selectOneByExample(example);
	}

 	public SaleGood findOneByPos(Integer pos) {
        SaleGoodExample example = new SaleGoodExample();
        SaleGoodExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andPosEqualTo(pos);
		return mapper.selectOneByExample(example);
	}

 	public SaleGood findOneByIspet(Integer ispet) {
        SaleGoodExample example = new SaleGoodExample();
        SaleGoodExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andIspetEqualTo(ispet);
		return mapper.selectOneByExample(example);
	}

 	public SaleGood findOneByLevel(Integer level) {
        SaleGoodExample example = new SaleGoodExample();
        SaleGoodExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andLevelEqualTo(level);
		return mapper.selectOneByExample(example);
	}

	
	public List<SaleGood> findAll(int page, int size, String sort, String order) {
        SaleGoodExample example = new SaleGoodExample();
        SaleGoodExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }
        PageHelper.startPage(page, size);
        return mapper.selectByExample(example);
    }
    
    public List<SaleGood> findAll() {
        SaleGoodExample example = new SaleGoodExample();
        SaleGoodExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        return mapper.selectByExample(example);
    }
}
