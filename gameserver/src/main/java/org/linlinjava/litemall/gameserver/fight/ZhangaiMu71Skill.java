package org.linlinjava.litemall.gameserver.fight;

import org.linlinjava.litemall.gameserver.data.vo.*;
import org.linlinjava.litemall.gameserver.data.write.*;
import org.linlinjava.litemall.gameserver.domain.JiNeng;

import java.util.ArrayList;
import java.util.List;

public class ZhangaiMu71Skill extends FightRoundSkill {
    @Override
    public List<FightResult> doSkill(FightContainer fightContainer, FightRequest fightRequest, JiNeng jiNeng) {
        List<FightResult> resultList = new ArrayList<>();
        final FightObject attFightObject = FightManager.getFightObject(fightContainer, fightRequest.id);

        Vo_19959_0 vo_19959_0 = new Vo_19959_0();
        vo_19959_0.round = fightContainer.round;
        vo_19959_0.aid = fightRequest.id;
        vo_19959_0.action = fightRequest.action;
        vo_19959_0.vid = fightRequest.vid;
        vo_19959_0.para = fightRequest.para;
        FightManager.send(fightContainer, new M19959_0(), vo_19959_0);

        boolean fabao = true;
        final FightFabaoSkill fabaoSkill = attFightObject.getFabaoSkill();
        if (fabaoSkill != null) {
            if (fabaoSkill.getStateType() == 8398 && fabaoSkill.isActive()) {
                fabao = false;
            }
        }

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

        final List<FightObject> targetList = FightManager.findTarget(fightContainer, fightRequest, 1, jiNeng.range);
        for (FightObject fightObject : targetList) {
            vo_64989_0.list.add(fightObject.fid);
        }
        FightManager.send(fightContainer, new M64989_0(), vo_64989_0);



        for (FightObject fightObject : targetList) {
            vo_19959_0 = new Vo_19959_0();
            vo_19959_0.round = fightContainer.round;
            vo_19959_0.aid = fightObject.fid;
            vo_19959_0.action = 43;
            vo_19959_0.vid = fightObject.fid;
            vo_19959_0.para = 0;
            FightManager.send(fightContainer, new M19959_0(), vo_19959_0);
            Vo_7655_0 vo_7655_0 = new Vo_7655_0();
            vo_7655_0.id = fightObject.fid;
            FightManager.send(fightContainer, new M7655_0(), vo_7655_0);
            fightObject.addBuffState(fightContainer, getStateType());
            final ZhangaiMu71Skill that = new ZhangaiMu71Skill();
            fightObject.addSkill(that);
            that.buffObject = fightObject;
            that.removeRound = fightContainer.round + jiNeng.skillRound;
            that.fightContainer = fightContainer;
            int hurt = 0;
            if (hurt == 0) {
                final int addHurt = BattleUtils.skillAttack(attFightObject.fashang + attFightObject.fashang_ext, jiNeng.skill_level, "FS", jiNeng.skill_no);
                final int thurt = BattleUtils.battle(attFightObject.fashang + attFightObject.fashang_ext, addHurt, fightObject.fangyu + fightObject.fangyu_ext);
                hurt = thurt;
            } else {
                hurt = (int) (hurt * 0.9);
            }
            int showhurt = fightObject.reduceShengming(hurt, fabao);

            that.xueliang = hurt;
            final FightResult fightResult = new FightResult();
            fightResult.id = fightRequest.id;
            fightResult.vid = fightObject.fid;
            fightResult.point = -showhurt;
            fightResult.effect_no = 0;
            fightResult.damage_type = 4;
            resultList.add(fightResult);
        }

        return resultList;
    }

    private int xueliang;

    @Override
    protected void doRoundSkill() {
        xueliang = xueliang / 2;
        Vo_19959_0 vo_19959_0 = new Vo_19959_0();
        vo_19959_0.round = fightContainer.round;
        vo_19959_0.aid = buffObject.fid;
        vo_19959_0.action = 0;
        vo_19959_0.vid = buffObject.fid;
        vo_19959_0.para = 0;
        FightManager.send(fightContainer, new M19959_0(), vo_19959_0);
        vo_19959_0 = new Vo_19959_0();
        vo_19959_0.round = fightContainer.round;
        vo_19959_0.aid = buffObject.fid;
        vo_19959_0.action = 0;
        vo_19959_0.vid = buffObject.fid;
        vo_19959_0.para = 0;
        FightManager.send(fightContainer, new M19959_0(), vo_19959_0);
        xueliang = buffObject.reduceShengming(xueliang, false);
        if (buffObject.type == 1 || buffObject.type == 2) {
            buffObject.update(fightContainer);
        }
        vo_19959_0 = new Vo_19959_0();
        vo_19959_0.round = fightContainer.round;
        vo_19959_0.aid = 0;
        vo_19959_0.action = 0;
        vo_19959_0.vid = 0;
        vo_19959_0.para = 0;
        FightManager.send(fightContainer, new M19959_0(), vo_19959_0);
        Vo_7655_0 vo_7655_0 = new Vo_7655_0();
        vo_7655_0.id = 0;
        FightManager.send(fightContainer, new M7655_0(), vo_7655_0);
        final FightResult fightResult = new FightResult();
        fightResult.id = buffObject.fid;
        fightResult.vid = buffObject.fid;
        fightResult.point = -xueliang;
        fightResult.effect_no = 0;
        fightResult.damage_type = 4;
        FightManager.send_LIFE_DELTA(fightContainer, fightResult);
        vo_7655_0 = new Vo_7655_0();
        vo_7655_0.id = buffObject.fid;
        FightManager.send(fightContainer, new M7655_0(), vo_7655_0);
        vo_7655_0 = new Vo_7655_0();
        vo_7655_0.id = buffObject.fid;
        FightManager.send(fightContainer, new M7655_0(), vo_7655_0);
    }

    @Override
    protected void doDisappear() {

    }

    @Override
    public int getStateType() {
        return 3842;
    }
}
