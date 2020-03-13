package org.linlinjava.litemall.db.service;

import org.linlinjava.litemall.db.domain.Characters;
import org.linlinjava.litemall.db.domain.example.CharactersExample;
import org.linlinjava.litemall.db.service.base.BaseCharactersService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CharacterService extends BaseCharactersService {
    public Characters findOneByName(String name) {
        CharactersExample example = new CharactersExample();
        CharactersExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andNameEqualTo(name);
        return mapper.selectOneByExampleWithBLOBs(example);
    }

    public List<Characters> findByAccountId(Integer accountId) {
        CharactersExample example = new CharactersExample();
        CharactersExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andAccountIdEqualTo(accountId);
        return mapper.selectByExampleWithBLOBs(example);
    }
    public Characters findOneByID(int id) {
        CharactersExample example = new CharactersExample();
        CharactersExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andIdEqualTo(id);
        return mapper.selectOneByExampleWithBLOBs(example);
    }

    public Characters finOnByGiD(String gid) {
        CharactersExample example = new CharactersExample();
        CharactersExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andGidEqualTo(gid);
        return mapper.selectOneByExampleWithBLOBs(example);
    }

}
