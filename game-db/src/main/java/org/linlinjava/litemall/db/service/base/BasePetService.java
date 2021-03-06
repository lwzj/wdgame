package org.linlinjava.litemall.db.service.base;

import org.linlinjava.litemall.db.dao.PetMapper;
import org.linlinjava.litemall.db.domain.Pet;
import org.linlinjava.litemall.db.domain.example.PetExample;
import org.linlinjava.litemall.db.domain.example.PetExample.Criteria;
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
public class BasePetService{
    @Autowired
    protected PetMapper mapper;

    @Cacheable(cacheNames="Pet", key="#id")
	public Pet findById(int id) {
        return mapper.selectByPrimaryKeyWithLogicalDelete(id,false);
    }
    @Cacheable(cacheNames="Pet", key="#id",condition="#result.deleted == 0")
	public Pet findByIdContainsDelete(int id) {
        return mapper.selectByPrimaryKey(id);
    }

    public void add(Pet pet) {
        pet.setAddTime(LocalDateTime.now());
        pet.setUpdateTime(LocalDateTime.now());
        mapper.insertSelective(pet);
    }
    
    @CachePut(cacheNames="Pet", key="#pet.id")
	public int updateById(Pet pet) {
        pet.setUpdateTime(LocalDateTime.now());
        return mapper.updateByPrimaryKeySelective(pet);
    }
    
   	@CacheEvict(cacheNames="Pet", key="#id")
	public void deleteById(int id) {
        mapper.logicalDeleteByPrimaryKey(id);
    }
    
    
    
    
    
 	public List<Pet> findByIndex(Integer index) {
        PetExample example = new PetExample();
        PetExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andIndexEqualTo(index);
		return mapper.selectByExample(example);
	}

 	public List<Pet> findByLevelReq(Integer levelReq) {
        PetExample example = new PetExample();
        PetExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andLevelReqEqualTo(levelReq);
		return mapper.selectByExample(example);
	}

 	public List<Pet> findByLife(Integer life) {
        PetExample example = new PetExample();
        PetExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andLifeEqualTo(life);
		return mapper.selectByExample(example);
	}

 	public List<Pet> findByMana(Integer mana) {
        PetExample example = new PetExample();
        PetExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andManaEqualTo(mana);
		return mapper.selectByExample(example);
	}

 	public List<Pet> findBySpeed(Integer speed) {
        PetExample example = new PetExample();
        PetExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andSpeedEqualTo(speed);
		return mapper.selectByExample(example);
	}

 	public List<Pet> findByPhyAttack(Integer phyAttack) {
        PetExample example = new PetExample();
        PetExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andPhyAttackEqualTo(phyAttack);
		return mapper.selectByExample(example);
	}

 	public List<Pet> findByMagAttack(Integer magAttack) {
        PetExample example = new PetExample();
        PetExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andMagAttackEqualTo(magAttack);
		return mapper.selectByExample(example);
	}

 	public List<Pet> findByPolar(String polar) {
        PetExample example = new PetExample();
        PetExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andPolarEqualTo(polar);
		return mapper.selectByExample(example);
	}

 	public List<Pet> findBySkiils(String skiils) {
        PetExample example = new PetExample();
        PetExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andSkiilsEqualTo(skiils);
		return mapper.selectByExample(example);
	}

 	public List<Pet> findByZoon(String zoon) {
        PetExample example = new PetExample();
        PetExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andZoonEqualTo(zoon);
		return mapper.selectByExample(example);
	}

 	public List<Pet> findByIcon(Integer icon) {
        PetExample example = new PetExample();
        PetExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andIconEqualTo(icon);
		return mapper.selectByExample(example);
	}

 	public List<Pet> findByName(String name) {
        PetExample example = new PetExample();
        PetExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andNameEqualTo(name);
		return mapper.selectByExample(example);
	}

 	public Pet findOneByIndex(Integer index) {
        PetExample example = new PetExample();
        PetExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andIndexEqualTo(index);
		return mapper.selectOneByExample(example);
	}

 	public Pet findOneByLevelReq(Integer levelReq) {
        PetExample example = new PetExample();
        PetExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andLevelReqEqualTo(levelReq);
		return mapper.selectOneByExample(example);
	}

 	public Pet findOneByLife(Integer life) {
        PetExample example = new PetExample();
        PetExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andLifeEqualTo(life);
		return mapper.selectOneByExample(example);
	}

 	public Pet findOneByMana(Integer mana) {
        PetExample example = new PetExample();
        PetExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andManaEqualTo(mana);
		return mapper.selectOneByExample(example);
	}

 	public Pet findOneBySpeed(Integer speed) {
        PetExample example = new PetExample();
        PetExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andSpeedEqualTo(speed);
		return mapper.selectOneByExample(example);
	}

 	public Pet findOneByPhyAttack(Integer phyAttack) {
        PetExample example = new PetExample();
        PetExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andPhyAttackEqualTo(phyAttack);
		return mapper.selectOneByExample(example);
	}

 	public Pet findOneByMagAttack(Integer magAttack) {
        PetExample example = new PetExample();
        PetExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andMagAttackEqualTo(magAttack);
		return mapper.selectOneByExample(example);
	}

 	public Pet findOneByPolar(String polar) {
        PetExample example = new PetExample();
        PetExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andPolarEqualTo(polar);
		return mapper.selectOneByExample(example);
	}

 	public Pet findOneBySkiils(String skiils) {
        PetExample example = new PetExample();
        PetExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andSkiilsEqualTo(skiils);
		return mapper.selectOneByExample(example);
	}

 	public Pet findOneByZoon(String zoon) {
        PetExample example = new PetExample();
        PetExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andZoonEqualTo(zoon);
		return mapper.selectOneByExample(example);
	}

 	public Pet findOneByIcon(Integer icon) {
        PetExample example = new PetExample();
        PetExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andIconEqualTo(icon);
		return mapper.selectOneByExample(example);
	}

 	public Pet findOneByName(String name) {
        PetExample example = new PetExample();
        PetExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andNameEqualTo(name);
		return mapper.selectOneByExample(example);
	}

	
	public List<Pet> findAll(int page, int size, String sort, String order) {
        PetExample example = new PetExample();
        PetExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }
        PageHelper.startPage(page, size);
        return mapper.selectByExample(example);
    }
    
    public List<Pet> findAll() {
        PetExample example = new PetExample();
        PetExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        return mapper.selectByExample(example);
    }
}
