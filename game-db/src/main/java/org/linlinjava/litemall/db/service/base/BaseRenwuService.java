package org.linlinjava.litemall.db.service.base;

import org.linlinjava.litemall.db.dao.RenwuMapper;
import org.linlinjava.litemall.db.domain.Renwu;
import org.linlinjava.litemall.db.domain.example.RenwuExample;
import org.linlinjava.litemall.db.domain.example.RenwuExample.Criteria;
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
public class BaseRenwuService{
    @Autowired
    protected RenwuMapper mapper;

    @Cacheable(cacheNames="Renwu", key="#id")
	public Renwu findById(int id) {
        return mapper.selectByPrimaryKeyWithLogicalDelete(id,false);
    }
    @Cacheable(cacheNames="Renwu", key="#id",condition="#result.deleted == 0")
	public Renwu findByIdContainsDelete(int id) {
        return mapper.selectByPrimaryKey(id);
    }

    public void add(Renwu renwu) {
        renwu.setAddTime(LocalDateTime.now());
        renwu.setUpdateTime(LocalDateTime.now());
        mapper.insertSelective(renwu);
    }
    
    @CachePut(cacheNames="Renwu", key="#renwu.id")
	public int updateById(Renwu renwu) {
        renwu.setUpdateTime(LocalDateTime.now());
        return mapper.updateByPrimaryKeySelective(renwu);
    }
    
   	@CacheEvict(cacheNames="Renwu", key="#id")
	public void deleteById(int id) {
        mapper.logicalDeleteByPrimaryKey(id);
    }
    
    
    
    
    
 	public List<Renwu> findByUncontent(String uncontent) {
        RenwuExample example = new RenwuExample();
        RenwuExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andUncontentEqualTo(uncontent);
		return mapper.selectByExample(example);
	}

 	public List<Renwu> findByNpcName(String npcName) {
        RenwuExample example = new RenwuExample();
        RenwuExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andNpcNameEqualTo(npcName);
		return mapper.selectByExample(example);
	}

 	public List<Renwu> findByCurrentTask(String currentTask) {
        RenwuExample example = new RenwuExample();
        RenwuExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andCurrentTaskEqualTo(currentTask);
		return mapper.selectByExample(example);
	}

 	public List<Renwu> findByShowName(String showName) {
        RenwuExample example = new RenwuExample();
        RenwuExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andShowNameEqualTo(showName);
		return mapper.selectByExample(example);
	}

 	public List<Renwu> findByTaskPrompt(String taskPrompt) {
        RenwuExample example = new RenwuExample();
        RenwuExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andTaskPromptEqualTo(taskPrompt);
		return mapper.selectByExample(example);
	}

 	public List<Renwu> findByReward(String reward) {
        RenwuExample example = new RenwuExample();
        RenwuExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andRewardEqualTo(reward);
		return mapper.selectByExample(example);
	}

 	public Renwu findOneByUncontent(String uncontent) {
        RenwuExample example = new RenwuExample();
        RenwuExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andUncontentEqualTo(uncontent);
		return mapper.selectOneByExample(example);
	}

 	public Renwu findOneByNpcName(String npcName) {
        RenwuExample example = new RenwuExample();
        RenwuExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andNpcNameEqualTo(npcName);
		return mapper.selectOneByExample(example);
	}

 	public Renwu findOneByCurrentTask(String currentTask) {
        RenwuExample example = new RenwuExample();
        RenwuExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andCurrentTaskEqualTo(currentTask);
		return mapper.selectOneByExample(example);
	}

 	public Renwu findOneByShowName(String showName) {
        RenwuExample example = new RenwuExample();
        RenwuExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andShowNameEqualTo(showName);
		return mapper.selectOneByExample(example);
	}

 	public Renwu findOneByTaskPrompt(String taskPrompt) {
        RenwuExample example = new RenwuExample();
        RenwuExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andTaskPromptEqualTo(taskPrompt);
		return mapper.selectOneByExample(example);
	}

 	public Renwu findOneByReward(String reward) {
        RenwuExample example = new RenwuExample();
        RenwuExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andRewardEqualTo(reward);
		return mapper.selectOneByExample(example);
	}

	
	public List<Renwu> findAll(int page, int size, String sort, String order) {
        RenwuExample example = new RenwuExample();
        RenwuExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }
        PageHelper.startPage(page, size);
        return mapper.selectByExample(example);
    }
    
    public List<Renwu> findAll() {
        RenwuExample example = new RenwuExample();
        RenwuExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        return mapper.selectByExample(example);
    }
}
