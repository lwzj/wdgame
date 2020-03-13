package org.linlinjava.litemall.db.service.base;

import org.linlinjava.litemall.db.dao.NpcPointMapper;
import org.linlinjava.litemall.db.domain.NpcPoint;
import org.linlinjava.litemall.db.domain.example.NpcPointExample;
import org.linlinjava.litemall.db.domain.example.NpcPointExample.Criteria;
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
public class BaseNpcPointService{
    @Autowired
    protected NpcPointMapper mapper;

    @Cacheable(cacheNames="NpcPoint", key="#id")
	public NpcPoint findById(int id) {
        return mapper.selectByPrimaryKeyWithLogicalDelete(id,false);
    }
    @Cacheable(cacheNames="NpcPoint", key="#id",condition="#result.deleted == 0")
	public NpcPoint findByIdContainsDelete(int id) {
        return mapper.selectByPrimaryKey(id);
    }

    public void add(NpcPoint npcPoint) {
        npcPoint.setAddTime(LocalDateTime.now());
        npcPoint.setUpdateTime(LocalDateTime.now());
        mapper.insertSelective(npcPoint);
    }
    
    @CachePut(cacheNames="NpcPoint", key="#npcPoint.id")
	public int updateById(NpcPoint npcPoint) {
        npcPoint.setUpdateTime(LocalDateTime.now());
        return mapper.updateByPrimaryKeySelective(npcPoint);
    }
    
   	@CacheEvict(cacheNames="NpcPoint", key="#id")
	public void deleteById(int id) {
        mapper.logicalDeleteByPrimaryKey(id);
    }
    
    
    
    
    
 	public List<NpcPoint> findByMapname(String mapname) {
        NpcPointExample example = new NpcPointExample();
        NpcPointExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andMapnameEqualTo(mapname);
		return mapper.selectByExample(example);
	}

 	public List<NpcPoint> findByDoorname(String doorname) {
        NpcPointExample example = new NpcPointExample();
        NpcPointExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andDoornameEqualTo(doorname);
		return mapper.selectByExample(example);
	}

 	public List<NpcPoint> findByX(Integer x) {
        NpcPointExample example = new NpcPointExample();
        NpcPointExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andXEqualTo(x);
		return mapper.selectByExample(example);
	}

 	public List<NpcPoint> findByY(Integer y) {
        NpcPointExample example = new NpcPointExample();
        NpcPointExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andYEqualTo(y);
		return mapper.selectByExample(example);
	}

 	public List<NpcPoint> findByZ(Integer z) {
        NpcPointExample example = new NpcPointExample();
        NpcPointExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andZEqualTo(z);
		return mapper.selectByExample(example);
	}

 	public List<NpcPoint> findByInx(Integer inx) {
        NpcPointExample example = new NpcPointExample();
        NpcPointExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andInxEqualTo(inx);
		return mapper.selectByExample(example);
	}

 	public List<NpcPoint> findByIny(Integer iny) {
        NpcPointExample example = new NpcPointExample();
        NpcPointExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andInyEqualTo(iny);
		return mapper.selectByExample(example);
	}

 	public NpcPoint findOneByMapname(String mapname) {
        NpcPointExample example = new NpcPointExample();
        NpcPointExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andMapnameEqualTo(mapname);
		return mapper.selectOneByExample(example);
	}

 	public NpcPoint findOneByDoorname(String doorname) {
        NpcPointExample example = new NpcPointExample();
        NpcPointExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andDoornameEqualTo(doorname);
		return mapper.selectOneByExample(example);
	}

 	public NpcPoint findOneByX(Integer x) {
        NpcPointExample example = new NpcPointExample();
        NpcPointExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andXEqualTo(x);
		return mapper.selectOneByExample(example);
	}

 	public NpcPoint findOneByY(Integer y) {
        NpcPointExample example = new NpcPointExample();
        NpcPointExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andYEqualTo(y);
		return mapper.selectOneByExample(example);
	}

 	public NpcPoint findOneByZ(Integer z) {
        NpcPointExample example = new NpcPointExample();
        NpcPointExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andZEqualTo(z);
		return mapper.selectOneByExample(example);
	}

 	public NpcPoint findOneByInx(Integer inx) {
        NpcPointExample example = new NpcPointExample();
        NpcPointExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andInxEqualTo(inx);
		return mapper.selectOneByExample(example);
	}

 	public NpcPoint findOneByIny(Integer iny) {
        NpcPointExample example = new NpcPointExample();
        NpcPointExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andInyEqualTo(iny);
		return mapper.selectOneByExample(example);
	}

	
	public List<NpcPoint> findAll(int page, int size, String sort, String order) {
        NpcPointExample example = new NpcPointExample();
        NpcPointExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }
        PageHelper.startPage(page, size);
        return mapper.selectByExample(example);
    }
    
    public List<NpcPoint> findAll() {
        NpcPointExample example = new NpcPointExample();
        NpcPointExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        return mapper.selectByExample(example);
    }
}
