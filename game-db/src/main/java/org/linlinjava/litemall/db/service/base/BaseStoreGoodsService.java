package org.linlinjava.litemall.db.service.base;

import org.linlinjava.litemall.db.dao.StoreGoodsMapper;
import org.linlinjava.litemall.db.domain.StoreGoods;
import org.linlinjava.litemall.db.domain.example.StoreGoodsExample;
import org.linlinjava.litemall.db.domain.example.StoreGoodsExample.Criteria;
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
public class BaseStoreGoodsService{
    @Autowired
    protected StoreGoodsMapper mapper;

    @Cacheable(cacheNames="StoreGoods", key="#id")
	public StoreGoods findById(int id) {
        return mapper.selectByPrimaryKeyWithLogicalDelete(id,false);
    }
    @Cacheable(cacheNames="StoreGoods", key="#id",condition="#result.deleted == 0")
	public StoreGoods findByIdContainsDelete(int id) {
        return mapper.selectByPrimaryKey(id);
    }

    public void add(StoreGoods storeGoods) {
        storeGoods.setAddTime(LocalDateTime.now());
        storeGoods.setUpdateTime(LocalDateTime.now());
        mapper.insertSelective(storeGoods);
    }
    
    @CachePut(cacheNames="StoreGoods", key="#storeGoods.id")
	public int updateById(StoreGoods storeGoods) {
        storeGoods.setUpdateTime(LocalDateTime.now());
        return mapper.updateByPrimaryKeySelective(storeGoods);
    }
    
   	@CacheEvict(cacheNames="StoreGoods", key="#id")
	public void deleteById(int id) {
        mapper.logicalDeleteByPrimaryKey(id);
    }
    
    
    
    
    
 	public List<StoreGoods> findByName(String name) {
        StoreGoodsExample example = new StoreGoodsExample();
        StoreGoodsExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andNameEqualTo(name);
		return mapper.selectByExample(example);
	}

 	public List<StoreGoods> findByBarcode(String barcode) {
        StoreGoodsExample example = new StoreGoodsExample();
        StoreGoodsExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andBarcodeEqualTo(barcode);
		return mapper.selectByExample(example);
	}

 	public List<StoreGoods> findByForSale(Integer forSale) {
        StoreGoodsExample example = new StoreGoodsExample();
        StoreGoodsExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andForSaleEqualTo(forSale);
		return mapper.selectByExample(example);
	}

 	public List<StoreGoods> findByShowPos(Integer showPos) {
        StoreGoodsExample example = new StoreGoodsExample();
        StoreGoodsExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andShowPosEqualTo(showPos);
		return mapper.selectByExample(example);
	}

 	public List<StoreGoods> findByRpos(Integer rpos) {
        StoreGoodsExample example = new StoreGoodsExample();
        StoreGoodsExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andRposEqualTo(rpos);
		return mapper.selectByExample(example);
	}

 	public List<StoreGoods> findBySaleQuota(Integer saleQuota) {
        StoreGoodsExample example = new StoreGoodsExample();
        StoreGoodsExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andSaleQuotaEqualTo(saleQuota);
		return mapper.selectByExample(example);
	}

 	public List<StoreGoods> findByRecommend(Integer recommend) {
        StoreGoodsExample example = new StoreGoodsExample();
        StoreGoodsExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andRecommendEqualTo(recommend);
		return mapper.selectByExample(example);
	}

 	public List<StoreGoods> findByCoin(Integer coin) {
        StoreGoodsExample example = new StoreGoodsExample();
        StoreGoodsExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andCoinEqualTo(coin);
		return mapper.selectByExample(example);
	}

 	public List<StoreGoods> findByDiscount(Integer discount) {
        StoreGoodsExample example = new StoreGoodsExample();
        StoreGoodsExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andDiscountEqualTo(discount);
		return mapper.selectByExample(example);
	}

 	public List<StoreGoods> findByType(Integer type) {
        StoreGoodsExample example = new StoreGoodsExample();
        StoreGoodsExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andTypeEqualTo(type);
		return mapper.selectByExample(example);
	}

 	public List<StoreGoods> findByQuotaLimit(Integer quotaLimit) {
        StoreGoodsExample example = new StoreGoodsExample();
        StoreGoodsExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andQuotaLimitEqualTo(quotaLimit);
		return mapper.selectByExample(example);
	}

 	public List<StoreGoods> findByMustVip(Integer mustVip) {
        StoreGoodsExample example = new StoreGoodsExample();
        StoreGoodsExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andMustVipEqualTo(mustVip);
		return mapper.selectByExample(example);
	}

 	public List<StoreGoods> findByIsGift(Integer isGift) {
        StoreGoodsExample example = new StoreGoodsExample();
        StoreGoodsExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andIsGiftEqualTo(isGift);
		return mapper.selectByExample(example);
	}

 	public List<StoreGoods> findByFollowPetType(Integer followPetType) {
        StoreGoodsExample example = new StoreGoodsExample();
        StoreGoodsExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andFollowPetTypeEqualTo(followPetType);
		return mapper.selectByExample(example);
	}

 	public StoreGoods findOneByName(String name) {
        StoreGoodsExample example = new StoreGoodsExample();
        StoreGoodsExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andNameEqualTo(name);
		return mapper.selectOneByExample(example);
	}

 	public StoreGoods findOneByBarcode(String barcode) {
        StoreGoodsExample example = new StoreGoodsExample();
        StoreGoodsExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andBarcodeEqualTo(barcode);
		return mapper.selectOneByExample(example);
	}

 	public StoreGoods findOneByForSale(Integer forSale) {
        StoreGoodsExample example = new StoreGoodsExample();
        StoreGoodsExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andForSaleEqualTo(forSale);
		return mapper.selectOneByExample(example);
	}

 	public StoreGoods findOneByShowPos(Integer showPos) {
        StoreGoodsExample example = new StoreGoodsExample();
        StoreGoodsExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andShowPosEqualTo(showPos);
		return mapper.selectOneByExample(example);
	}

 	public StoreGoods findOneByRpos(Integer rpos) {
        StoreGoodsExample example = new StoreGoodsExample();
        StoreGoodsExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andRposEqualTo(rpos);
		return mapper.selectOneByExample(example);
	}

 	public StoreGoods findOneBySaleQuota(Integer saleQuota) {
        StoreGoodsExample example = new StoreGoodsExample();
        StoreGoodsExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andSaleQuotaEqualTo(saleQuota);
		return mapper.selectOneByExample(example);
	}

 	public StoreGoods findOneByRecommend(Integer recommend) {
        StoreGoodsExample example = new StoreGoodsExample();
        StoreGoodsExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andRecommendEqualTo(recommend);
		return mapper.selectOneByExample(example);
	}

 	public StoreGoods findOneByCoin(Integer coin) {
        StoreGoodsExample example = new StoreGoodsExample();
        StoreGoodsExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andCoinEqualTo(coin);
		return mapper.selectOneByExample(example);
	}

 	public StoreGoods findOneByDiscount(Integer discount) {
        StoreGoodsExample example = new StoreGoodsExample();
        StoreGoodsExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andDiscountEqualTo(discount);
		return mapper.selectOneByExample(example);
	}

 	public StoreGoods findOneByType(Integer type) {
        StoreGoodsExample example = new StoreGoodsExample();
        StoreGoodsExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andTypeEqualTo(type);
		return mapper.selectOneByExample(example);
	}

 	public StoreGoods findOneByQuotaLimit(Integer quotaLimit) {
        StoreGoodsExample example = new StoreGoodsExample();
        StoreGoodsExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andQuotaLimitEqualTo(quotaLimit);
		return mapper.selectOneByExample(example);
	}

 	public StoreGoods findOneByMustVip(Integer mustVip) {
        StoreGoodsExample example = new StoreGoodsExample();
        StoreGoodsExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andMustVipEqualTo(mustVip);
		return mapper.selectOneByExample(example);
	}

 	public StoreGoods findOneByIsGift(Integer isGift) {
        StoreGoodsExample example = new StoreGoodsExample();
        StoreGoodsExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andIsGiftEqualTo(isGift);
		return mapper.selectOneByExample(example);
	}

 	public StoreGoods findOneByFollowPetType(Integer followPetType) {
        StoreGoodsExample example = new StoreGoodsExample();
        StoreGoodsExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andFollowPetTypeEqualTo(followPetType);
		return mapper.selectOneByExample(example);
	}

	
	public List<StoreGoods> findAll(int page, int size, String sort, String order) {
        StoreGoodsExample example = new StoreGoodsExample();
        StoreGoodsExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }
        PageHelper.startPage(page, size);
        return mapper.selectByExample(example);
    }
    
    public List<StoreGoods> findAll() {
        StoreGoodsExample example = new StoreGoodsExample();
        StoreGoodsExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        return mapper.selectByExample(example);
    }
}
