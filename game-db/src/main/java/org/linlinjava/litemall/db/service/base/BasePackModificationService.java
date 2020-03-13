package org.linlinjava.litemall.db.service.base;

import org.linlinjava.litemall.db.dao.PackModificationMapper;
import org.linlinjava.litemall.db.domain.PackModification;
import org.linlinjava.litemall.db.domain.example.PackModificationExample;
import org.linlinjava.litemall.db.domain.example.PackModificationExample.Criteria;
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
public class BasePackModificationService{
    @Autowired
    protected PackModificationMapper mapper;

    @Cacheable(cacheNames="PackModification", key="#id")
	public PackModification findById(int id) {
        return mapper.selectByPrimaryKeyWithLogicalDelete(id,false);
    }
    @Cacheable(cacheNames="PackModification", key="#id",condition="#result.deleted == 0")
	public PackModification findByIdContainsDelete(int id) {
        return mapper.selectByPrimaryKey(id);
    }

    public void add(PackModification packModification) {
        packModification.setAddTime(LocalDateTime.now());
        packModification.setUpdateTime(LocalDateTime.now());
        mapper.insertSelective(packModification);
    }
    
    @CachePut(cacheNames="PackModification", key="#packModification.id")
	public int updateById(PackModification packModification) {
        packModification.setUpdateTime(LocalDateTime.now());
        return mapper.updateByPrimaryKeySelective(packModification);
    }
    
   	@CacheEvict(cacheNames="PackModification", key="#id")
	public void deleteById(int id) {
        mapper.logicalDeleteByPrimaryKey(id);
    }
    
    
    
    
    
 	public List<PackModification> findByAlias(String alias) {
        PackModificationExample example = new PackModificationExample();
        PackModificationExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andAliasEqualTo(alias);
		return mapper.selectByExample(example);
	}

 	public List<PackModification> findByFasionType(String fasionType) {
        PackModificationExample example = new PackModificationExample();
        PackModificationExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andFasionTypeEqualTo(fasionType);
		return mapper.selectByExample(example);
	}

 	public List<PackModification> findByStr(String str) {
        PackModificationExample example = new PackModificationExample();
        PackModificationExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andStrEqualTo(str);
		return mapper.selectByExample(example);
	}

 	public List<PackModification> findByType(String type) {
        PackModificationExample example = new PackModificationExample();
        PackModificationExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andTypeEqualTo(type);
		return mapper.selectByExample(example);
	}

 	public List<PackModification> findByFoodNum(Integer foodNum) {
        PackModificationExample example = new PackModificationExample();
        PackModificationExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andFoodNumEqualTo(foodNum);
		return mapper.selectByExample(example);
	}

 	public List<PackModification> findByGoodsPrice(Integer goodsPrice) {
        PackModificationExample example = new PackModificationExample();
        PackModificationExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andGoodsPriceEqualTo(goodsPrice);
		return mapper.selectByExample(example);
	}

 	public List<PackModification> findBySex(Integer sex) {
        PackModificationExample example = new PackModificationExample();
        PackModificationExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andSexEqualTo(sex);
		return mapper.selectByExample(example);
	}

 	public List<PackModification> findByPosition(Integer position) {
        PackModificationExample example = new PackModificationExample();
        PackModificationExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andPositionEqualTo(position);
		return mapper.selectByExample(example);
	}

 	public List<PackModification> findByCategory(Integer category) {
        PackModificationExample example = new PackModificationExample();
        PackModificationExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andCategoryEqualTo(category);
		return mapper.selectByExample(example);
	}

 	public PackModification findOneByAlias(String alias) {
        PackModificationExample example = new PackModificationExample();
        PackModificationExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andAliasEqualTo(alias);
		return mapper.selectOneByExample(example);
	}

 	public PackModification findOneByFasionType(String fasionType) {
        PackModificationExample example = new PackModificationExample();
        PackModificationExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andFasionTypeEqualTo(fasionType);
		return mapper.selectOneByExample(example);
	}

 	public PackModification findOneByStr(String str) {
        PackModificationExample example = new PackModificationExample();
        PackModificationExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andStrEqualTo(str);
		return mapper.selectOneByExample(example);
	}

 	public PackModification findOneByType(String type) {
        PackModificationExample example = new PackModificationExample();
        PackModificationExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andTypeEqualTo(type);
		return mapper.selectOneByExample(example);
	}

 	public PackModification findOneByFoodNum(Integer foodNum) {
        PackModificationExample example = new PackModificationExample();
        PackModificationExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andFoodNumEqualTo(foodNum);
		return mapper.selectOneByExample(example);
	}

 	public PackModification findOneByGoodsPrice(Integer goodsPrice) {
        PackModificationExample example = new PackModificationExample();
        PackModificationExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andGoodsPriceEqualTo(goodsPrice);
		return mapper.selectOneByExample(example);
	}

 	public PackModification findOneBySex(Integer sex) {
        PackModificationExample example = new PackModificationExample();
        PackModificationExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andSexEqualTo(sex);
		return mapper.selectOneByExample(example);
	}

 	public PackModification findOneByPosition(Integer position) {
        PackModificationExample example = new PackModificationExample();
        PackModificationExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andPositionEqualTo(position);
		return mapper.selectOneByExample(example);
	}

 	public PackModification findOneByCategory(Integer category) {
        PackModificationExample example = new PackModificationExample();
        PackModificationExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andCategoryEqualTo(category);
		return mapper.selectOneByExample(example);
	}

	
	public List<PackModification> findAll(int page, int size, String sort, String order) {
        PackModificationExample example = new PackModificationExample();
        PackModificationExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }
        PageHelper.startPage(page, size);
        return mapper.selectByExample(example);
    }
    
    public List<PackModification> findAll() {
        PackModificationExample example = new PackModificationExample();
        PackModificationExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        return mapper.selectByExample(example);
    }
}
