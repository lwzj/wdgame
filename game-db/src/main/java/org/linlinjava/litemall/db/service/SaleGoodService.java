package org.linlinjava.litemall.db.service;


import org.linlinjava.litemall.db.domain.SaleGood;
import org.linlinjava.litemall.db.domain.example.SaleGoodExample;
import org.linlinjava.litemall.db.service.base.BaseSaleGoodService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SaleGoodService extends BaseSaleGoodService {


    public SaleGood findOneByGoodsId(String goodsId) {
        SaleGoodExample example = new SaleGoodExample();
        SaleGoodExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andGoodsIdEqualTo(goodsId);
        return mapper.selectOneByExampleWithBLOBs(example);
    }

    public List<SaleGood> findByStr(String str) {
        SaleGoodExample example = new SaleGoodExample();
        SaleGoodExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andStrEqualTo(str);
        return mapper.selectByExampleWithBLOBs(example);
    }

    public List<SaleGood> findByOwnerUuid(String ownerUuid) {
        SaleGoodExample example = new SaleGoodExample();
        SaleGoodExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andOwnerUuidEqualTo(ownerUuid);
        return mapper.selectByExampleWithBLOBs(example);
    }
//
//    public List<Characters> findByAccountId(Integer accountId) {
//        SaleGoodExample example = new SaleGoodExample();
//        SaleGoodExample.Criteria criteria = example.createCriteria();
//        criteria.andDeletedEqualTo(false).andAccountIdEqualTo(accountId);
//        return mapper.selectByExampleWithBLOBs(example);
//    }
//    public Characters findOneByID(int id) {
//        CharactersExample example = new CharactersExample();
//        CharactersExample.Criteria criteria = example.createCriteria();
//        criteria.andDeletedEqualTo(false).andIdEqualTo(id);
//        return mapper.selectOneByExampleWithBLOBs(example);
//    }
//
//    public Characters finOnByGiD(String gid) {
//        CharactersExample example = new CharactersExample();
//        CharactersExample.Criteria criteria = example.createCriteria();
//        criteria.andDeletedEqualTo(false).andGidEqualTo(gid);
//        return mapper.selectOneByExampleWithBLOBs(example);
//    }
}
