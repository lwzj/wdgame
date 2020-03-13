package org.linlinjava.litemall.gameserver.game;

import org.linlinjava.litemall.db.service.CharacterService;
import org.linlinjava.litemall.db.service.SaleGoodService;
import org.linlinjava.litemall.db.service.base.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class GameData {
    public static GameData that;
    @Qualifier("baseCharactersService")
    @Autowired
    public BaseCharactersService baseCharactersService;
    @Qualifier("characterService")
    @Autowired
    public CharacterService characterService;
    @Autowired
    public BasePetService basePetService;

    @Autowired
    public BaseExperienceService baseExperienceService;
    @Autowired
    public BaseStoreInfoService baseStoreInfoService;
    @Autowired
    public BaseZhuangbeiInfoService baseZhuangbeiInfoService;

    @Autowired
    public BaseChoujiangService baseChoujiangService;
    @Autowired
    public BaseShowTasksService baseShowTasksService;

    @Autowired
    public BasePetHelpTypeService basePetHelpTypeService;
    @Autowired
    public BaseDaySignPrizeService baseDaySignPrizeService;
    @Qualifier("baseSaleGoodService")
    @Autowired
    public BaseSaleGoodService baseSaleGoodService;
    @Qualifier("saleGoodService")
    @Autowired
    public SaleGoodService saleGoodService;
    @Autowired
    public BaseNpcService baseNpcService;

    @Autowired
    public BaseMapService baseMapService;

    @Autowired
    public BaseAccountsService baseAccountsService;

    @Autowired
    public BaseNpcPointService baseNpcPointService;
    @Autowired
    public BaseNpcDialogueService baseNpcDialogueService;
    @Autowired
    public BaseNpcDialogueFrameService baseNpcDialogueFrameService;
    @Autowired
    public BaseCreepsStoreService baseCreepsStoreService;
    @Autowired
    public BaseGroceriesShopService baseGroceriesShopService;
    @Autowired
    public BaseMedicineShopService baseMedicineShopService;
    @Autowired
    public BaseSaleClassifyGoodService baseSaleClassifyGoodService;

    @Autowired
    public BaseStoreGoodsService baseStoreGoodsService;
    @Autowired
    public BaseShuxingduiyingService baseShuxingduiyingService;
    @Autowired
    public BasePackModificationService basePackModificationService;
    @Autowired
    public BaseSkillMonsterService baseSkillMonsterService;
    @Autowired
    public BaseRenwuService baseRenwuService;
    @Autowired
    public BaseRenwuMonsterService baseRenwuMonsterService;
    @Autowired
    public  BaseExperienceTreasureService baseExperienceTreasureService;
    @Autowired
    public BaseNoticeService baseNoticeService;
    @Autowired
    public BaseChargeService baseChargeService;


    @PostConstruct
    public void initAfter() {
        that = this;

    }

}
