package org.linlinjava.litemall.db.service.base;

import org.linlinjava.litemall.db.dao.NpcDialogueFrameMapper;
import org.linlinjava.litemall.db.domain.NpcDialogueFrame;
import org.linlinjava.litemall.db.domain.example.NpcDialogueFrameExample;
import org.linlinjava.litemall.db.domain.example.NpcDialogueFrameExample.Criteria;
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
public class BaseNpcDialogueFrameService{
    @Autowired
    protected NpcDialogueFrameMapper mapper;

    @Cacheable(cacheNames="NpcDialogueFrame", key="#id")
	public NpcDialogueFrame findById(int id) {
        return mapper.selectByPrimaryKeyWithLogicalDelete(id,false);
    }
    @Cacheable(cacheNames="NpcDialogueFrame", key="#id",condition="#result.deleted == 0")
	public NpcDialogueFrame findByIdContainsDelete(int id) {
        return mapper.selectByPrimaryKey(id);
    }

    public void add(NpcDialogueFrame npcDialogueFrame) {
        npcDialogueFrame.setAddTime(LocalDateTime.now());
        npcDialogueFrame.setUpdateTime(LocalDateTime.now());
        mapper.insertSelective(npcDialogueFrame);
    }
    
    @CachePut(cacheNames="NpcDialogueFrame", key="#npcDialogueFrame.id")
	public int updateById(NpcDialogueFrame npcDialogueFrame) {
        npcDialogueFrame.setUpdateTime(LocalDateTime.now());
        return mapper.updateByPrimaryKeySelective(npcDialogueFrame);
    }
    
   	@CacheEvict(cacheNames="NpcDialogueFrame", key="#id")
	public void deleteById(int id) {
        mapper.logicalDeleteByPrimaryKey(id);
    }
    
    
    
    
    
 	public List<NpcDialogueFrame> findByPortrait(Integer portrait) {
        NpcDialogueFrameExample example = new NpcDialogueFrameExample();
        NpcDialogueFrameExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andPortraitEqualTo(portrait);
		return mapper.selectByExample(example);
	}

 	public List<NpcDialogueFrame> findByPicNo(Integer picNo) {
        NpcDialogueFrameExample example = new NpcDialogueFrameExample();
        NpcDialogueFrameExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andPicNoEqualTo(picNo);
		return mapper.selectByExample(example);
	}

 	public List<NpcDialogueFrame> findByContent(String content) {
        NpcDialogueFrameExample example = new NpcDialogueFrameExample();
        NpcDialogueFrameExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andContentEqualTo(content);
		return mapper.selectByExample(example);
	}

 	public List<NpcDialogueFrame> findBySecretKey(String secretKey) {
        NpcDialogueFrameExample example = new NpcDialogueFrameExample();
        NpcDialogueFrameExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andSecretKeyEqualTo(secretKey);
		return mapper.selectByExample(example);
	}

 	public List<NpcDialogueFrame> findByName(String name) {
        NpcDialogueFrameExample example = new NpcDialogueFrameExample();
        NpcDialogueFrameExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andNameEqualTo(name);
		return mapper.selectByExample(example);
	}

 	public List<NpcDialogueFrame> findByAttrib(Integer attrib) {
        NpcDialogueFrameExample example = new NpcDialogueFrameExample();
        NpcDialogueFrameExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andAttribEqualTo(attrib);
		return mapper.selectByExample(example);
	}

 	public List<NpcDialogueFrame> findByUpdateTimes(LocalDateTime updateTimes) {
        NpcDialogueFrameExample example = new NpcDialogueFrameExample();
        NpcDialogueFrameExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andUpdateTimesEqualTo(updateTimes);
		return mapper.selectByExample(example);
	}

 	public List<NpcDialogueFrame> findByIdname(Integer idname) {
        NpcDialogueFrameExample example = new NpcDialogueFrameExample();
        NpcDialogueFrameExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andIdnameEqualTo(idname);
		return mapper.selectByExample(example);
	}

 	public List<NpcDialogueFrame> findByNext(String next) {
        NpcDialogueFrameExample example = new NpcDialogueFrameExample();
        NpcDialogueFrameExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andNextEqualTo(next);
		return mapper.selectByExample(example);
	}

 	public List<NpcDialogueFrame> findByCurrentTask(String currentTask) {
        NpcDialogueFrameExample example = new NpcDialogueFrameExample();
        NpcDialogueFrameExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andCurrentTaskEqualTo(currentTask);
		return mapper.selectByExample(example);
	}

 	public List<NpcDialogueFrame> findByUncontent(String uncontent) {
        NpcDialogueFrameExample example = new NpcDialogueFrameExample();
        NpcDialogueFrameExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andUncontentEqualTo(uncontent);
		return mapper.selectByExample(example);
	}

 	public List<NpcDialogueFrame> findByZhuangbei(String zhuangbei) {
        NpcDialogueFrameExample example = new NpcDialogueFrameExample();
        NpcDialogueFrameExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andZhuangbeiEqualTo(zhuangbei);
		return mapper.selectByExample(example);
	}

 	public List<NpcDialogueFrame> findByJingyan(Integer jingyan) {
        NpcDialogueFrameExample example = new NpcDialogueFrameExample();
        NpcDialogueFrameExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andJingyanEqualTo(jingyan);
		return mapper.selectByExample(example);
	}

 	public List<NpcDialogueFrame> findByMoney(Integer money) {
        NpcDialogueFrameExample example = new NpcDialogueFrameExample();
        NpcDialogueFrameExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andMoneyEqualTo(money);
		return mapper.selectByExample(example);
	}

 	public NpcDialogueFrame findOneByPortrait(Integer portrait) {
        NpcDialogueFrameExample example = new NpcDialogueFrameExample();
        NpcDialogueFrameExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andPortraitEqualTo(portrait);
		return mapper.selectOneByExample(example);
	}

 	public NpcDialogueFrame findOneByPicNo(Integer picNo) {
        NpcDialogueFrameExample example = new NpcDialogueFrameExample();
        NpcDialogueFrameExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andPicNoEqualTo(picNo);
		return mapper.selectOneByExample(example);
	}

 	public NpcDialogueFrame findOneByContent(String content) {
        NpcDialogueFrameExample example = new NpcDialogueFrameExample();
        NpcDialogueFrameExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andContentEqualTo(content);
		return mapper.selectOneByExample(example);
	}

 	public NpcDialogueFrame findOneBySecretKey(String secretKey) {
        NpcDialogueFrameExample example = new NpcDialogueFrameExample();
        NpcDialogueFrameExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andSecretKeyEqualTo(secretKey);
		return mapper.selectOneByExample(example);
	}

 	public NpcDialogueFrame findOneByName(String name) {
        NpcDialogueFrameExample example = new NpcDialogueFrameExample();
        NpcDialogueFrameExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andNameEqualTo(name);
		return mapper.selectOneByExample(example);
	}

 	public NpcDialogueFrame findOneByAttrib(Integer attrib) {
        NpcDialogueFrameExample example = new NpcDialogueFrameExample();
        NpcDialogueFrameExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andAttribEqualTo(attrib);
		return mapper.selectOneByExample(example);
	}

 	public NpcDialogueFrame findOneByUpdateTimes(LocalDateTime updateTimes) {
        NpcDialogueFrameExample example = new NpcDialogueFrameExample();
        NpcDialogueFrameExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andUpdateTimesEqualTo(updateTimes);
		return mapper.selectOneByExample(example);
	}

 	public NpcDialogueFrame findOneByIdname(Integer idname) {
        NpcDialogueFrameExample example = new NpcDialogueFrameExample();
        NpcDialogueFrameExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andIdnameEqualTo(idname);
		return mapper.selectOneByExample(example);
	}

 	public NpcDialogueFrame findOneByNext(String next) {
        NpcDialogueFrameExample example = new NpcDialogueFrameExample();
        NpcDialogueFrameExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andNextEqualTo(next);
		return mapper.selectOneByExample(example);
	}

 	public NpcDialogueFrame findOneByCurrentTask(String currentTask) {
        NpcDialogueFrameExample example = new NpcDialogueFrameExample();
        NpcDialogueFrameExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andCurrentTaskEqualTo(currentTask);
		return mapper.selectOneByExample(example);
	}

 	public NpcDialogueFrame findOneByUncontent(String uncontent) {
        NpcDialogueFrameExample example = new NpcDialogueFrameExample();
        NpcDialogueFrameExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andUncontentEqualTo(uncontent);
		return mapper.selectOneByExample(example);
	}

 	public NpcDialogueFrame findOneByZhuangbei(String zhuangbei) {
        NpcDialogueFrameExample example = new NpcDialogueFrameExample();
        NpcDialogueFrameExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andZhuangbeiEqualTo(zhuangbei);
		return mapper.selectOneByExample(example);
	}

 	public NpcDialogueFrame findOneByJingyan(Integer jingyan) {
        NpcDialogueFrameExample example = new NpcDialogueFrameExample();
        NpcDialogueFrameExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andJingyanEqualTo(jingyan);
		return mapper.selectOneByExample(example);
	}

 	public NpcDialogueFrame findOneByMoney(Integer money) {
        NpcDialogueFrameExample example = new NpcDialogueFrameExample();
        NpcDialogueFrameExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andMoneyEqualTo(money);
		return mapper.selectOneByExample(example);
	}

	
	public List<NpcDialogueFrame> findAll(int page, int size, String sort, String order) {
        NpcDialogueFrameExample example = new NpcDialogueFrameExample();
        NpcDialogueFrameExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }
        PageHelper.startPage(page, size);
        return mapper.selectByExample(example);
    }
    
    public List<NpcDialogueFrame> findAll() {
        NpcDialogueFrameExample example = new NpcDialogueFrameExample();
        NpcDialogueFrameExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        return mapper.selectByExample(example);
    }
}
