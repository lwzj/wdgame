package org.linlinjava.litemall.db.service.base;

import org.linlinjava.litemall.db.dao.SaleClassifyGoodMapper;
import org.linlinjava.litemall.db.domain.SaleClassifyGood;
import org.linlinjava.litemall.db.domain.example.SaleClassifyGoodExample;
import org.linlinjava.litemall.db.domain.example.SaleClassifyGoodExample.Criteria;
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
public class BaseSaleClassifyGoodService{
    @Autowired
    protected SaleClassifyGoodMapper mapper;

    @Cacheable(cacheNames="SaleClassifyGood", key="#id")
	public SaleClassifyGood findById(int id) {
        return mapper.selectByPrimaryKeyWithLogicalDelete(id,false);
    }
    @Cacheable(cacheNames="SaleClassifyGood", key="#id",condition="#result.deleted == 0")
	public SaleClassifyGood findByIdContainsDelete(int id) {
        return mapper.selectByPrimaryKey(id);
    }

    public void add(SaleClassifyGood saleClassifyGood) {
        saleClassifyGood.setAddTime(LocalDateTime.now());
        saleClassifyGood.setUpdateTime(LocalDateTime.now());
        mapper.insertSelective(saleClassifyGood);
    }
    
    @CachePut(cacheNames="SaleClassifyGood", key="#saleClassifyGood.id")
	public int updateById(SaleClassifyGood saleClassifyGood) {
        saleClassifyGood.setUpdateTime(LocalDateTime.now());
        return mapper.updateByPrimaryKeySelective(saleClassifyGood);
    }
    
   	@CacheEvict(cacheNames="SaleClassifyGood", key="#id")
	public void deleteById(int id) {
        mapper.logicalDeleteByPrimaryKey(id);
    }
    
    
    
    
    
 	public List<SaleClassifyGood> findByPname(String pname) {
        SaleClassifyGoodExample example = new SaleClassifyGoodExample();
        SaleClassifyGoodExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andPnameEqualTo(pname);
		return mapper.selectByExample(example);
	}

 	public List<SaleClassifyGood> findByCname(String cname) {
        SaleClassifyGoodExample example = new SaleClassifyGoodExample();
        SaleClassifyGoodExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andCnameEqualTo(cname);
		return mapper.selectByExample(example);
	}

 	public List<SaleClassifyGood> findByAttrib(String attrib) {
        SaleClassifyGoodExample example = new SaleClassifyGoodExample();
        SaleClassifyGoodExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andAttribEqualTo(attrib);
		return mapper.selectByExample(example);
	}

 	public List<SaleClassifyGood> findByIcon(Integer icon) {
        SaleClassifyGoodExample example = new SaleClassifyGoodExample();
        SaleClassifyGoodExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andIconEqualTo(icon);
		return mapper.selectByExample(example);
	}

 	public List<SaleClassifyGood> findByStr(String str) {
        SaleClassifyGoodExample example = new SaleClassifyGoodExample();
        SaleClassifyGoodExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andStrEqualTo(str);
		return mapper.selectByExample(example);
	}

 	public List<SaleClassifyGood> findByPrice(Integer price) {
        SaleClassifyGoodExample example = new SaleClassifyGoodExample();
        SaleClassifyGoodExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andPriceEqualTo(price);
		return mapper.selectByExample(example);
	}

 	public List<SaleClassifyGood> findByCompose(String compose) {
        SaleClassifyGoodExample example = new SaleClassifyGoodExample();
        SaleClassifyGoodExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andComposeEqualTo(compose);
		return mapper.selectByExample(example);
	}

 	public SaleClassifyGood findOneByPname(String pname) {
        SaleClassifyGoodExample example = new SaleClassifyGoodExample();
        SaleClassifyGoodExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andPnameEqualTo(pname);
		return mapper.selectOneByExample(example);
	}

 	public SaleClassifyGood findOneByCname(String cname) {
        SaleClassifyGoodExample example = new SaleClassifyGoodExample();
        SaleClassifyGoodExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andCnameEqualTo(cname);
		return mapper.selectOneByExample(example);
	}

 	public SaleClassifyGood findOneByAttrib(String attrib) {
        SaleClassifyGoodExample example = new SaleClassifyGoodExample();
        SaleClassifyGoodExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andAttribEqualTo(attrib);
		return mapper.selectOneByExample(example);
	}

 	public SaleClassifyGood findOneByIcon(Integer icon) {
        SaleClassifyGoodExample example = new SaleClassifyGoodExample();
        SaleClassifyGoodExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andIconEqualTo(icon);
		return mapper.selectOneByExample(example);
	}

 	public SaleClassifyGood findOneByStr(String str) {
        SaleClassifyGoodExample example = new SaleClassifyGoodExample();
        SaleClassifyGoodExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andStrEqualTo(str);
		return mapper.selectOneByExample(example);
	}

 	public SaleClassifyGood findOneByPrice(Integer price) {
        SaleClassifyGoodExample example = new SaleClassifyGoodExample();
        SaleClassifyGoodExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andPriceEqualTo(price);
		return mapper.selectOneByExample(example);
	}

 	public SaleClassifyGood findOneByCompose(String compose) {
        SaleClassifyGoodExample example = new SaleClassifyGoodExample();
        SaleClassifyGoodExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andComposeEqualTo(compose);
		return mapper.selectOneByExample(example);
	}

	
	public List<SaleClassifyGood> findAll(int page, int size, String sort, String order) {
        SaleClassifyGoodExample example = new SaleClassifyGoodExample();
        SaleClassifyGoodExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }
        PageHelper.startPage(page, size);
        return mapper.selectByExample(example);
    }
    
    public List<SaleClassifyGood> findAll() {
        SaleClassifyGoodExample example = new SaleClassifyGoodExample();
        SaleClassifyGoodExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        return mapper.selectByExample(example);
    }
}
