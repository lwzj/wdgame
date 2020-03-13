package org.linlinjava.litemall.db.service.base;

import org.linlinjava.litemall.db.dao.ShowTasksMapper;
import org.linlinjava.litemall.db.domain.ShowTasks;
import org.linlinjava.litemall.db.domain.example.ShowTasksExample;
import org.linlinjava.litemall.db.domain.example.ShowTasksExample.Criteria;
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
public class BaseShowTasksService{
    @Autowired
    protected ShowTasksMapper mapper;

    @Cacheable(cacheNames="ShowTasks", key="#id")
	public ShowTasks findById(int id) {
        return mapper.selectByPrimaryKeyWithLogicalDelete(id,false);
    }
    @Cacheable(cacheNames="ShowTasks", key="#id",condition="#result.deleted == 0")
	public ShowTasks findByIdContainsDelete(int id) {
        return mapper.selectByPrimaryKey(id);
    }

    public void add(ShowTasks showTasks) {
        showTasks.setAddTime(LocalDateTime.now());
        showTasks.setUpdateTime(LocalDateTime.now());
        mapper.insertSelective(showTasks);
    }
    
    @CachePut(cacheNames="ShowTasks", key="#showTasks.id")
	public int updateById(ShowTasks showTasks) {
        showTasks.setUpdateTime(LocalDateTime.now());
        return mapper.updateByPrimaryKeySelective(showTasks);
    }
    
   	@CacheEvict(cacheNames="ShowTasks", key="#id")
	public void deleteById(int id) {
        mapper.logicalDeleteByPrimaryKey(id);
    }
    
    
    
    
    
 	public List<ShowTasks> findByTaskType(String taskType) {
        ShowTasksExample example = new ShowTasksExample();
        ShowTasksExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andTaskTypeEqualTo(taskType);
		return mapper.selectByExample(example);
	}

 	public List<ShowTasks> findByTaskDesc(String taskDesc) {
        ShowTasksExample example = new ShowTasksExample();
        ShowTasksExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andTaskDescEqualTo(taskDesc);
		return mapper.selectByExample(example);
	}

 	public List<ShowTasks> findByTaskPrompt(String taskPrompt) {
        ShowTasksExample example = new ShowTasksExample();
        ShowTasksExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andTaskPromptEqualTo(taskPrompt);
		return mapper.selectByExample(example);
	}

 	public List<ShowTasks> findByRefresh(Integer refresh) {
        ShowTasksExample example = new ShowTasksExample();
        ShowTasksExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andRefreshEqualTo(refresh);
		return mapper.selectByExample(example);
	}

 	public List<ShowTasks> findByTaskEndTime(Integer taskEndTime) {
        ShowTasksExample example = new ShowTasksExample();
        ShowTasksExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andTaskEndTimeEqualTo(taskEndTime);
		return mapper.selectByExample(example);
	}

 	public List<ShowTasks> findByAttrib(Integer attrib) {
        ShowTasksExample example = new ShowTasksExample();
        ShowTasksExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andAttribEqualTo(attrib);
		return mapper.selectByExample(example);
	}

 	public List<ShowTasks> findByReward(String reward) {
        ShowTasksExample example = new ShowTasksExample();
        ShowTasksExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andRewardEqualTo(reward);
		return mapper.selectByExample(example);
	}

 	public List<ShowTasks> findByShowName(String showName) {
        ShowTasksExample example = new ShowTasksExample();
        ShowTasksExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andShowNameEqualTo(showName);
		return mapper.selectByExample(example);
	}

 	public List<ShowTasks> findByTasktaskExtraPara(String tasktaskExtraPara) {
        ShowTasksExample example = new ShowTasksExample();
        ShowTasksExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andTasktaskExtraParaEqualTo(tasktaskExtraPara);
		return mapper.selectByExample(example);
	}

 	public List<ShowTasks> findByTasktaskState(Integer tasktaskState) {
        ShowTasksExample example = new ShowTasksExample();
        ShowTasksExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andTasktaskStateEqualTo(tasktaskState);
		return mapper.selectByExample(example);
	}

 	public ShowTasks findOneByTaskType(String taskType) {
        ShowTasksExample example = new ShowTasksExample();
        ShowTasksExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andTaskTypeEqualTo(taskType);
		return mapper.selectOneByExample(example);
	}

 	public ShowTasks findOneByTaskDesc(String taskDesc) {
        ShowTasksExample example = new ShowTasksExample();
        ShowTasksExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andTaskDescEqualTo(taskDesc);
		return mapper.selectOneByExample(example);
	}

 	public ShowTasks findOneByTaskPrompt(String taskPrompt) {
        ShowTasksExample example = new ShowTasksExample();
        ShowTasksExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andTaskPromptEqualTo(taskPrompt);
		return mapper.selectOneByExample(example);
	}

 	public ShowTasks findOneByRefresh(Integer refresh) {
        ShowTasksExample example = new ShowTasksExample();
        ShowTasksExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andRefreshEqualTo(refresh);
		return mapper.selectOneByExample(example);
	}

 	public ShowTasks findOneByTaskEndTime(Integer taskEndTime) {
        ShowTasksExample example = new ShowTasksExample();
        ShowTasksExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andTaskEndTimeEqualTo(taskEndTime);
		return mapper.selectOneByExample(example);
	}

 	public ShowTasks findOneByAttrib(Integer attrib) {
        ShowTasksExample example = new ShowTasksExample();
        ShowTasksExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andAttribEqualTo(attrib);
		return mapper.selectOneByExample(example);
	}

 	public ShowTasks findOneByReward(String reward) {
        ShowTasksExample example = new ShowTasksExample();
        ShowTasksExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andRewardEqualTo(reward);
		return mapper.selectOneByExample(example);
	}

 	public ShowTasks findOneByShowName(String showName) {
        ShowTasksExample example = new ShowTasksExample();
        ShowTasksExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andShowNameEqualTo(showName);
		return mapper.selectOneByExample(example);
	}

 	public ShowTasks findOneByTasktaskExtraPara(String tasktaskExtraPara) {
        ShowTasksExample example = new ShowTasksExample();
        ShowTasksExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andTasktaskExtraParaEqualTo(tasktaskExtraPara);
		return mapper.selectOneByExample(example);
	}

 	public ShowTasks findOneByTasktaskState(Integer tasktaskState) {
        ShowTasksExample example = new ShowTasksExample();
        ShowTasksExample.Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(false).andTasktaskStateEqualTo(tasktaskState);
		return mapper.selectOneByExample(example);
	}

	
	public List<ShowTasks> findAll(int page, int size, String sort, String order) {
        ShowTasksExample example = new ShowTasksExample();
        ShowTasksExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }
        PageHelper.startPage(page, size);
        return mapper.selectByExample(example);
    }
    
    public List<ShowTasks> findAll() {
        ShowTasksExample example = new ShowTasksExample();
        ShowTasksExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        return mapper.selectByExample(example);
    }
}
