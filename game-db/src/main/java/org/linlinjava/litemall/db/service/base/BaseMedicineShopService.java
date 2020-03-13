package org.linlinjava.litemall.db.service.base;

import org.linlinjava.litemall.db.dao.MedicineShopMapper;
import org.linlinjava.litemall.db.domain.MedicineShop;
import org.linlinjava.litemall.db.domain.example.MedicineShopExample;
import org.linlinjava.litemall.db.domain.example.MedicineShopExample.Criteria;
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
public class BaseMedicineShopService{
    @Autowired
    protected MedicineShopMapper mapper;

    @Cacheable(cacheNames="MedicineShop", key="#id")
	public MedicineShop findById(int id) {
        return mapper.selectByPrimaryKeyWithLogicalDelete(id,false);
    }
    @Cacheable(cacheNames="MedicineShop", key="#id",condition="#result.deleted == 0")
	public MedicineShop findByIdContainsDelete(int id) {
        return mapper.selectByPrimaryKey(id);
    }

    public void add(MedicineShop medicineShop) {
        medicineShop.setAddTime(LocalDateTime.now());
        medicineShop.setUpdateTime(LocalDateTime.now());
        mapper.insertSelective(medicineShop);
    }
    
    @CachePut(cacheNames="MedicineShop", key="#medicineShop.id")
	public int updateById(MedicineShop medicineShop) {
        medicineShop.setUpdateTime(LocalDateTime.now());
        return mapper.updateByPrimaryKeySelective(medicineShop);
    }
    
   	@CacheEvict(cacheNames="MedicineShop", key="#id")
	public void deleteById(int id) {
        mapper.logicalDeleteByPrimaryKey(id);
    }
    
    
    
    
    
 	public List<MedicineShop> findByGoodsNo(Integer goodsNo) {
        MedicineShopExample example = new MedicineShopExample();
        MedicineShopExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andGoodsNoEqualTo(goodsNo);
		return mapper.selectByExample(example);
	}

 	public List<MedicineShop> findByPayType(Integer payType) {
        MedicineShopExample example = new MedicineShopExample();
        MedicineShopExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andPayTypeEqualTo(payType);
		return mapper.selectByExample(example);
	}

 	public List<MedicineShop> findByName(String name) {
        MedicineShopExample example = new MedicineShopExample();
        MedicineShopExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andNameEqualTo(name);
		return mapper.selectByExample(example);
	}

 	public List<MedicineShop> findByValue(Integer value) {
        MedicineShopExample example = new MedicineShopExample();
        MedicineShopExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andValueEqualTo(value);
		return mapper.selectByExample(example);
	}

 	public List<MedicineShop> findByLevel(Integer level) {
        MedicineShopExample example = new MedicineShopExample();
        MedicineShopExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andLevelEqualTo(level);
		return mapper.selectByExample(example);
	}

 	public List<MedicineShop> findByType(Integer type) {
        MedicineShopExample example = new MedicineShopExample();
        MedicineShopExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andTypeEqualTo(type);
		return mapper.selectByExample(example);
	}

 	public List<MedicineShop> findByItemcount(Integer itemcount) {
        MedicineShopExample example = new MedicineShopExample();
        MedicineShopExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andItemcountEqualTo(itemcount);
		return mapper.selectByExample(example);
	}

 	public MedicineShop findOneByGoodsNo(Integer goodsNo) {
        MedicineShopExample example = new MedicineShopExample();
        MedicineShopExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andGoodsNoEqualTo(goodsNo);
		return mapper.selectOneByExample(example);
	}

 	public MedicineShop findOneByPayType(Integer payType) {
        MedicineShopExample example = new MedicineShopExample();
        MedicineShopExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andPayTypeEqualTo(payType);
		return mapper.selectOneByExample(example);
	}

 	public MedicineShop findOneByName(String name) {
        MedicineShopExample example = new MedicineShopExample();
        MedicineShopExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andNameEqualTo(name);
		return mapper.selectOneByExample(example);
	}

 	public MedicineShop findOneByValue(Integer value) {
        MedicineShopExample example = new MedicineShopExample();
        MedicineShopExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andValueEqualTo(value);
		return mapper.selectOneByExample(example);
	}

 	public MedicineShop findOneByLevel(Integer level) {
        MedicineShopExample example = new MedicineShopExample();
        MedicineShopExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andLevelEqualTo(level);
		return mapper.selectOneByExample(example);
	}

 	public MedicineShop findOneByType(Integer type) {
        MedicineShopExample example = new MedicineShopExample();
        MedicineShopExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andTypeEqualTo(type);
		return mapper.selectOneByExample(example);
	}

 	public MedicineShop findOneByItemcount(Integer itemcount) {
        MedicineShopExample example = new MedicineShopExample();
        MedicineShopExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andItemcountEqualTo(itemcount);
		return mapper.selectOneByExample(example);
	}

	
	public List<MedicineShop> findAll(int page, int size, String sort, String order) {
        MedicineShopExample example = new MedicineShopExample();
        MedicineShopExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }
        PageHelper.startPage(page, size);
        return mapper.selectByExample(example);
    }
    
    public List<MedicineShop> findAll() {
        MedicineShopExample example = new MedicineShopExample();
        MedicineShopExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        return mapper.selectByExample(example);
    }
}
