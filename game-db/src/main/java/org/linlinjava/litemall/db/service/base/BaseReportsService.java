package org.linlinjava.litemall.db.service.base;

import org.linlinjava.litemall.db.dao.ReportsMapper;
import org.linlinjava.litemall.db.domain.Reports;
import org.linlinjava.litemall.db.domain.example.ReportsExample;
import org.linlinjava.litemall.db.domain.example.ReportsExample.Criteria;
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
public class BaseReportsService{
    @Autowired
    protected ReportsMapper mapper;

    @Cacheable(cacheNames="Reports", key="#id")
	public Reports findById(int id) {
        return mapper.selectByPrimaryKeyWithLogicalDelete(id,false);
    }
    @Cacheable(cacheNames="Reports", key="#id",condition="#result.deleted == 0")
	public Reports findByIdContainsDelete(int id) {
        return mapper.selectByPrimaryKey(id);
    }

    public void add(Reports reports) {
        reports.setAddTime(LocalDateTime.now());
        reports.setUpdateTime(LocalDateTime.now());
        mapper.insertSelective(reports);
    }
    
    @CachePut(cacheNames="Reports", key="#reports.id")
	public int updateById(Reports reports) {
        reports.setUpdateTime(LocalDateTime.now());
        return mapper.updateByPrimaryKeySelective(reports);
    }
    
   	@CacheEvict(cacheNames="Reports", key="#id")
	public void deleteById(int id) {
        mapper.logicalDeleteByPrimaryKey(id);
    }
    
    
    
    
    
 	public List<Reports> findByZhanghao(String zhanghao) {
        ReportsExample example = new ReportsExample();
        ReportsExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andZhanghaoEqualTo(zhanghao);
		return mapper.selectByExample(example);
	}

 	public List<Reports> findByYuanbaoshu(Integer yuanbaoshu) {
        ReportsExample example = new ReportsExample();
        ReportsExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andYuanbaoshuEqualTo(yuanbaoshu);
		return mapper.selectByExample(example);
	}

 	public List<Reports> findByShifouchongzhi(String shifouchongzhi) {
        ReportsExample example = new ReportsExample();
        ReportsExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andShifouchongzhiEqualTo(shifouchongzhi);
		return mapper.selectByExample(example);
	}

 	public Reports findOneByZhanghao(String zhanghao) {
        ReportsExample example = new ReportsExample();
        ReportsExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andZhanghaoEqualTo(zhanghao);
		return mapper.selectOneByExample(example);
	}

 	public Reports findOneByYuanbaoshu(Integer yuanbaoshu) {
        ReportsExample example = new ReportsExample();
        ReportsExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andYuanbaoshuEqualTo(yuanbaoshu);
		return mapper.selectOneByExample(example);
	}

 	public Reports findOneByShifouchongzhi(String shifouchongzhi) {
        ReportsExample example = new ReportsExample();
        ReportsExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andShifouchongzhiEqualTo(shifouchongzhi);
		return mapper.selectOneByExample(example);
	}

	
	public List<Reports> findAll(int page, int size, String sort, String order) {
        ReportsExample example = new ReportsExample();
        ReportsExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }
        PageHelper.startPage(page, size);
        return mapper.selectByExample(example);
    }
    
    public List<Reports> findAll() {
        ReportsExample example = new ReportsExample();
        ReportsExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        return mapper.selectByExample(example);
    }
}
