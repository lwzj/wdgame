package org.linlinjava.litemall.db.service.base;

import org.linlinjava.litemall.db.dao.SrenwuMapper;
import org.linlinjava.litemall.db.domain.Srenwu;
import org.linlinjava.litemall.db.domain.example.SrenwuExample;
import org.linlinjava.litemall.db.domain.example.SrenwuExample.Criteria;
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
public class BaseSrenwuService{
    @Autowired
    protected SrenwuMapper mapper;

    @Cacheable(cacheNames="Srenwu", key="#id")
	public Srenwu findById(int id) {
        return mapper.selectByPrimaryKeyWithLogicalDelete(id,false);
    }
    @Cacheable(cacheNames="Srenwu", key="#id",condition="#result.deleted == 0")
	public Srenwu findByIdContainsDelete(int id) {
        return mapper.selectByPrimaryKey(id);
    }

    public void add(Srenwu srenwu) {
        srenwu.setAddTime(LocalDateTime.now());
        srenwu.setUpdateTime(LocalDateTime.now());
        mapper.insertSelective(srenwu);
    }
    
    @CachePut(cacheNames="Srenwu", key="#srenwu.id")
	public int updateById(Srenwu srenwu) {
        srenwu.setUpdateTime(LocalDateTime.now());
        return mapper.updateByPrimaryKeySelective(srenwu);
    }
    
   	@CacheEvict(cacheNames="Srenwu", key="#id")
	public void deleteById(int id) {
        mapper.logicalDeleteByPrimaryKey(id);
    }
    
    
    
    
    
 	public List<Srenwu> findByPid(String pid) {
        SrenwuExample example = new SrenwuExample();
        SrenwuExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andPidEqualTo(pid);
		return mapper.selectByExample(example);
	}

 	public List<Srenwu> findByRid(Integer rid) {
        SrenwuExample example = new SrenwuExample();
        SrenwuExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andRidEqualTo(rid);
		return mapper.selectByExample(example);
	}

 	public List<Srenwu> findBySkillName(String skillName) {
        SrenwuExample example = new SrenwuExample();
        SrenwuExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andSkillNameEqualTo(skillName);
		return mapper.selectByExample(example);
	}

 	public List<Srenwu> findBySkillJieshao(String skillJieshao) {
        SrenwuExample example = new SrenwuExample();
        SrenwuExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andSkillJieshaoEqualTo(skillJieshao);
		return mapper.selectByExample(example);
	}

 	public List<Srenwu> findBySkillDqti(String skillDqti) {
        SrenwuExample example = new SrenwuExample();
        SrenwuExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andSkillDqtiEqualTo(skillDqti);
		return mapper.selectByExample(example);
	}

 	public List<Srenwu> findBySkillXck(String skillXck) {
        SrenwuExample example = new SrenwuExample();
        SrenwuExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andSkillXckEqualTo(skillXck);
		return mapper.selectByExample(example);
	}

 	public Srenwu findOneByPid(String pid) {
        SrenwuExample example = new SrenwuExample();
        SrenwuExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andPidEqualTo(pid);
		return mapper.selectOneByExample(example);
	}

 	public Srenwu findOneByRid(Integer rid) {
        SrenwuExample example = new SrenwuExample();
        SrenwuExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andRidEqualTo(rid);
		return mapper.selectOneByExample(example);
	}

 	public Srenwu findOneBySkillName(String skillName) {
        SrenwuExample example = new SrenwuExample();
        SrenwuExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andSkillNameEqualTo(skillName);
		return mapper.selectOneByExample(example);
	}

 	public Srenwu findOneBySkillJieshao(String skillJieshao) {
        SrenwuExample example = new SrenwuExample();
        SrenwuExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andSkillJieshaoEqualTo(skillJieshao);
		return mapper.selectOneByExample(example);
	}

 	public Srenwu findOneBySkillDqti(String skillDqti) {
        SrenwuExample example = new SrenwuExample();
        SrenwuExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andSkillDqtiEqualTo(skillDqti);
		return mapper.selectOneByExample(example);
	}

 	public Srenwu findOneBySkillXck(String skillXck) {
        SrenwuExample example = new SrenwuExample();
        SrenwuExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andSkillXckEqualTo(skillXck);
		return mapper.selectOneByExample(example);
	}

	
	public List<Srenwu> findAll(int page, int size, String sort, String order) {
        SrenwuExample example = new SrenwuExample();
        SrenwuExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }
        PageHelper.startPage(page, size);
        return mapper.selectByExample(example);
    }
    
    public List<Srenwu> findAll() {
        SrenwuExample example = new SrenwuExample();
        SrenwuExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        return mapper.selectByExample(example);
    }
}
