package org.linlinjava.litemall.gameserver.fight;

import org.linlinjava.litemall.gameserver.data.vo.*;
import org.linlinjava.litemall.gameserver.data.write.*;
import org.linlinjava.litemall.gameserver.domain.JiNeng;
import org.linlinjava.litemall.gameserver.domain.ZbAttribute;

import java.util.List;

public class FuzhuJin31Skill extends FightRoundSkill {
    @Override
    public List<FightResult> doSkill(FightContainer fightContainer, FightRequest fightRequest, JiNeng jiNeng) {
        final int victim_id = fightRequest.vid;
        final FightObject victObject = FightManager.getFightObject(fightContainer, victim_id);

        Vo_19959_0 vo_19959_0 = new Vo_19959_0();
        vo_19959_0.round = fightContainer.round;
        vo_19959_0.aid = fightRequest.id;
        vo_19959_0.action = fightRequest.action;
        vo_19959_0.vid = fightRequest.vid;
        vo_19959_0.para = fightRequest.para;
        FightManager.send(fightContainer, new M19959_0(), vo_19959_0);


        Vo_19945_0 vo_19945_0 = new Vo_19945_0();
        vo_19945_0.id = fightRequest.vid;
        vo_19945_0.hid = fightRequest.id;
        vo_19945_0.para_ex = 0;
        vo_19945_0.missed = 1;
        vo_19945_0.para = 0;
        vo_19945_0.damage_type = 2;
        FightManager.send(fightContainer, new M19945_0(), vo_19945_0);

        final Vo_64989_0 vo_64989_0 = new Vo_64989_0();
        vo_64989_0.hid = fightRequest.id;
        vo_64989_0.a = 2;

        final List<FightObject> targetList = FightManager.findTarget(fightContainer, fightRequest, 2, jiNeng.range);
        for (FightObject fightObject : targetList) {
            vo_64989_0.list.add(fightObject.fid);
        }
        FightManager.send(fightContainer, new M64989_0(), vo_64989_0);


        vo_19959_0 = new Vo_19959_0();
        vo_19959_0.round = fightContainer.round;
        vo_19959_0.aid = 0;
        vo_19959_0.action = 0;
        vo_19959_0.vid = 0;
        vo_19959_0.para = 0;
        FightManager.send(fightContainer, new M19959_0(), vo_19959_0);

        ZbAttribute zbAttribute = new ZbAttribute();
        zbAttribute.id = fightRequest.vid;
        zbAttribute.accurate = 2600;
        FightManager.send(fightContainer, new M64991_0(), zbAttribute);


        Vo_7655_0 vo_7655_0 = new Vo_7655_0();
        vo_7655_0.id = 0;
        FightManager.send(fightContainer, new M7655_0(), vo_7655_0);

        for (FightObject fightObject : targetList) {
            vo_19959_0 = new Vo_19959_0();
            vo_19959_0.round = fightContainer.round;
            vo_19959_0.aid = fightObject.fid;
            vo_19959_0.action = 43;
            vo_19959_0.vid = fightObject.fid;
            vo_19959_0.para = 0;
            FightManager.send(fightContainer, new M19959_0(), vo_19959_0);
            vo_7655_0 = new Vo_7655_0();
            vo_7655_0.id = fightObject.fid;
            FightManager.send(fightContainer, new M7655_0(), vo_7655_0);
            fightObject.addBuffState(fightContainer, getStateType());
            final FuzhuJin31Skill that = new FuzhuJin31Skill();
            fightObject.addSkill(that);
            that.buffObject = fightObject;
            that.removeRound = fightContainer.round + jiNeng.skillRound - 1;
            int gongjili = (int) BattleUtils.extAdd(jiNeng.skill_level, jiNeng.skill_no);
            that.buffObject.accurate_ext = that.buffObject.accurate * gongjili / 100;
            that.buffObject.fashang_ext = that.buffObject.fashang * gongjili / 100;
        }

        return null;
    }

    @Override
    protected void doRoundSkill() {

    }

    @Override
    protected void doDisappear() {
        buffObject.accurate_ext = 0;
        buffObject.fashang_ext = 0;
    }

    @Override
    public int getStateType() {
        return 20224;
    }

}
