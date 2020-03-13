package org.linlinjava.litemall.db.service.base;

import org.linlinjava.litemall.db.dao.NpcMapper;
import org.linlinjava.litemall.db.domain.Npc;
import org.linlinjava.litemall.db.domain.example.NpcExample;
import org.linlinjava.litemall.db.domain.example.NpcExample.Criteria;
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
public class BaseNpcService{
    @Autowired
    protected NpcMapper mapper;

    @Cacheable(cacheNames="Npc", key="#id")
	public Npc findById(int id) {
        return mapper.selectByPrimaryKeyWithLogicalDelete(id,false);
    }
    @Cacheable(cacheNames="Npc", key="#id",condition="#result.deleted == 0")
	public Npc findByIdContainsDelete(int id) {
        return mapper.selectByPrimaryKey(id);
    }

    public void add(Npc npc) {
        npc.setAddTime(LocalDateTime.now());
        npc.setUpdateTime(LocalDateTime.now());
        mapper.insertSelective(npc);
    }
    
    @CachePut(cacheNames="Npc", key="#npc.id")
	public int updateById(Npc npc) {
        npc.setUpdateTime(LocalDateTime.now());
        return mapper.updateByPrimaryKeySelective(npc);
    }
    
   	@CacheEvict(cacheNames="Npc", key="#id")
	public void deleteById(int id) {
        mapper.logicalDeleteByPrimaryKey(id);
    }
    
    
    
    
    
 	public List<Npc> findByIcon(Integer icon) {
        NpcExample example = new NpcExample();
        NpcExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andIconEqualTo(icon);
		return mapper.selectByExample(example);
	}

 	public List<Npc> findByX(Integer x) {
        NpcExample example = new NpcExample();
        NpcExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andXEqualTo(x);
		return mapper.selectByExample(example);
	}

 	public List<Npc> findByY(Integer y) {
        NpcExample example = new NpcExample();
        NpcExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andYEqualTo(y);
		return mapper.selectByExample(example);
	}

 	public List<Npc> findByName(String name) {
        NpcExample example = new NpcExample();
        NpcExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andNameEqualTo(name);
		return mapper.selectByExample(example);
	}

 	public List<Npc> findByMapId(Integer mapId) {
        NpcExample example = new NpcExample();
        NpcExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andMapIdEqualTo(mapId);
		return mapper.selectByExample(example);
	}

 	public Npc findOneByIcon(Integer icon) {
        NpcExample example = new NpcExample();
        NpcExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andIconEqualTo(icon);
		return mapper.selectOneByExample(example);
	}

 	public Npc findOneByX(Integer x) {
        NpcExample example = new NpcExample();
        NpcExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andXEqualTo(x);
		return mapper.selectOneByExample(example);
	}

 	public Npc findOneByY(Integer y) {
        NpcExample example = new NpcExample();
        NpcExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andYEqualTo(y);
		return mapper.selectOneByExample(example);
	}

 	public Npc findOneByName(String name) {
        NpcExample example = new NpcExample();
        NpcExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andNameEqualTo(name);
		return mapper.selectOneByExample(example);
	}

 	public Npc findOneByMapId(Integer mapId) {
        NpcExample example = new NpcExample();
        NpcExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andMapIdEqualTo(mapId);
		return mapper.selectOneByExample(example);
	}

	
	public List<Npc> findAll(int page, int size, String sort, String order) {
        NpcExample example = new NpcExample();
        NpcExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }
        PageHelper.startPage(page, size);
        return mapper.selectByExample(example);
    }
    
    public List<Npc> findAll() {
        NpcExample example = new NpcExample();
        NpcExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        return mapper.selectByExample(example);
    }
}
