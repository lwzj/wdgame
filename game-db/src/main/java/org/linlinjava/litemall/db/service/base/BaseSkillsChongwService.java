package org.linlinjava.litemall.db.service.base;

import org.linlinjava.litemall.db.dao.SkillsChongwMapper;
import org.linlinjava.litemall.db.domain.SkillsChongw;
import org.linlinjava.litemall.db.domain.example.SkillsChongwExample;
import org.linlinjava.litemall.db.domain.example.SkillsChongwExample.Criteria;
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
public class BaseSkillsChongwService{
    @Autowired
    protected SkillsChongwMapper mapper;

    @Cacheable(cacheNames="SkillsChongw", key="#id")
	public SkillsChongw findById(int id) {
        return mapper.selectByPrimaryKeyWithLogicalDelete(id,false);
    }
    @Cacheable(cacheNames="SkillsChongw", key="#id",condition="#result.deleted == 0")
	public SkillsChongw findByIdContainsDelete(int id) {
        return mapper.selectByPrimaryKey(id);
    }

    public void add(SkillsChongw skillsChongw) {
        skillsChongw.setAddTime(LocalDateTime.now());
        skillsChongw.setUpdateTime(LocalDateTime.now());
        mapper.insertSelective(skillsChongw);
    }
    
    @CachePut(cacheNames="SkillsChongw", key="#skillsChongw.id")
	public int updateById(SkillsChongw skillsChongw) {
        skillsChongw.setUpdateTime(LocalDateTime.now());
        return mapper.updateByPrimaryKeySelective(skillsChongw);
    }
    
   	@CacheEvict(cacheNames="SkillsChongw", key="#id")
	public void deleteById(int id) {
        mapper.logicalDeleteByPrimaryKey(id);
    }
    
    
    
    
    
 	public List<SkillsChongw> findByOwnerid(String ownerid) {
        SkillsChongwExample example = new SkillsChongwExample();
        SkillsChongwExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andOwneridEqualTo(ownerid);
		return mapper.selectByExample(example);
	}

 	public List<SkillsChongw> findBySkllCwid(String skllCwid) {
        SkillsChongwExample example = new SkillsChongwExample();
        SkillsChongwExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andSkllCwidEqualTo(skllCwid);
		return mapper.selectByExample(example);
	}

 	public List<SkillsChongw> findBySkillIdHex(String skillIdHex) {
        SkillsChongwExample example = new SkillsChongwExample();
        SkillsChongwExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andSkillIdHexEqualTo(skillIdHex);
		return mapper.selectByExample(example);
	}

 	public List<SkillsChongw> findBySkillName(String skillName) {
        SkillsChongwExample example = new SkillsChongwExample();
        SkillsChongwExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andSkillNameEqualTo(skillName);
		return mapper.selectByExample(example);
	}

 	public List<SkillsChongw> findBySkillReqMenpai(Integer skillReqMenpai) {
        SkillsChongwExample example = new SkillsChongwExample();
        SkillsChongwExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andSkillReqMenpaiEqualTo(skillReqMenpai);
		return mapper.selectByExample(example);
	}

 	public List<SkillsChongw> findBySkillLevel(Integer skillLevel) {
        SkillsChongwExample example = new SkillsChongwExample();
        SkillsChongwExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andSkillLevelEqualTo(skillLevel);
		return mapper.selectByExample(example);
	}

 	public List<SkillsChongw> findBySkillMubiao(Integer skillMubiao) {
        SkillsChongwExample example = new SkillsChongwExample();
        SkillsChongwExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andSkillMubiaoEqualTo(skillMubiao);
		return mapper.selectByExample(example);
	}

 	public List<SkillsChongw> findByTianshuId(String tianshuId) {
        SkillsChongwExample example = new SkillsChongwExample();
        SkillsChongwExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andTianshuIdEqualTo(tianshuId);
		return mapper.selectByExample(example);
	}

 	public List<SkillsChongw> findByTianshuName(String tianshuName) {
        SkillsChongwExample example = new SkillsChongwExample();
        SkillsChongwExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andTianshuNameEqualTo(tianshuName);
		return mapper.selectByExample(example);
	}

 	public SkillsChongw findOneByOwnerid(String ownerid) {
        SkillsChongwExample example = new SkillsChongwExample();
        SkillsChongwExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andOwneridEqualTo(ownerid);
		return mapper.selectOneByExample(example);
	}

 	public SkillsChongw findOneBySkllCwid(String skllCwid) {
        SkillsChongwExample example = new SkillsChongwExample();
        SkillsChongwExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andSkllCwidEqualTo(skllCwid);
		return mapper.selectOneByExample(example);
	}

 	public SkillsChongw findOneBySkillIdHex(String skillIdHex) {
        SkillsChongwExample example = new SkillsChongwExample();
        SkillsChongwExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andSkillIdHexEqualTo(skillIdHex);
		return mapper.selectOneByExample(example);
	}

 	public SkillsChongw findOneBySkillName(String skillName) {
        SkillsChongwExample example = new SkillsChongwExample();
        SkillsChongwExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andSkillNameEqualTo(skillName);
		return mapper.selectOneByExample(example);
	}

 	public SkillsChongw findOneBySkillReqMenpai(Integer skillReqMenpai) {
        SkillsChongwExample example = new SkillsChongwExample();
        SkillsChongwExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andSkillReqMenpaiEqualTo(skillReqMenpai);
		return mapper.selectOneByExample(example);
	}

 	public SkillsChongw findOneBySkillLevel(Integer skillLevel) {
        SkillsChongwExample example = new SkillsChongwExample();
        SkillsChongwExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andSkillLevelEqualTo(skillLevel);
		return mapper.selectOneByExample(example);
	}

 	public SkillsChongw findOneBySkillMubiao(Integer skillMubiao) {
        SkillsChongwExample example = new SkillsChongwExample();
        SkillsChongwExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andSkillMubiaoEqualTo(skillMubiao);
		return mapper.selectOneByExample(example);
	}

 	public SkillsChongw findOneByTianshuId(String tianshuId) {
        SkillsChongwExample example = new SkillsChongwExample();
        SkillsChongwExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andTianshuIdEqualTo(tianshuId);
		return mapper.selectOneByExample(example);
	}

 	public SkillsChongw findOneByTianshuName(String tianshuName) {
        SkillsChongwExample example = new SkillsChongwExample();
        SkillsChongwExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andTianshuNameEqualTo(tianshuName);
		return mapper.selectOneByExample(example);
	}

	
	public List<SkillsChongw> findAll(int page, int size, String sort, String order) {
        SkillsChongwExample example = new SkillsChongwExample();
        SkillsChongwExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }
        PageHelper.startPage(page, size);
        return mapper.selectByExample(example);
    }
    
    public List<SkillsChongw> findAll() {
        SkillsChongwExample example = new SkillsChongwExample();
        SkillsChongwExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        return mapper.selectByExample(example);
    }
}
