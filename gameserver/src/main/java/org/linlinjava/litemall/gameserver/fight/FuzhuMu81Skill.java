package org.linlinjava.litemall.gameserver.fight;

import org.linlinjava.litemall.gameserver.data.vo.*;
import org.linlinjava.litemall.gameserver.data.write.*;
import org.linlinjava.litemall.gameserver.domain.JiNeng;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FuzhuMu81Skill extends FightRoundSkill {
    @Override
    public List<FightResult> doSkill(FightContainer fightContainer, FightRequest fightRequest, JiNeng jiNeng) {



        List<FightResult> resultList = new ArrayList<>();
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

        final List<FightObject> targetList = findTarget(fightContainer, fightRequest, 2, jiNeng.range);
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
            final FuzhuMu81Skill that = new FuzhuMu81Skill();
            fightObject.addSkill(that);
            that.buffObject = fightObject;
            that.removeRound = fightContainer.round + jiNeng.skillRound;
            that.fightContainer = fightContainer;
            if (fightObject.isDead()) {
                that.doRoundSkill();
                fightObject.removeSkill(that);
                fightObject.removeBuffState(fightContainer, getStateType());
            } else {
                int jiaxue = (int) BattleUtils.extAdd(jiNeng.skill_level, jiNeng.skill_no);
                int xueliang = fightObject.max_shengming * jiaxue / 100;
                xueliang = fightObject.addShengming(xueliang);
                fightObject.update(fightContainer);

                final FightResult fightResult = new FightResult();
                fightResult.id = fightRequest.id;
                fightResult.vid = fightObject.fid;
                fightResult.point = xueliang;
                fightResult.effect_no = 10005;
                fightResult.damage_type = 0;
                resultList.add(fightResult);
            }
        }


        return resultList;
    }

    boolean use = false;

    @Override
    protected void doRoundSkill() {
        if (!use && buffObject.state == 2) {
            Vo_19959_0 vo_19959_0 = new Vo_19959_0();
            vo_19959_0.round = fightContainer.round;
            vo_19959_0.aid = buffObject.fid;
            vo_19959_0.action = 0;
            vo_19959_0.vid = buffObject.fid;
            vo_19959_0.para = 0;
            FightManager.send(fightContainer, new M19959_0(), vo_19959_0);
            buffObject.state = 1;
            final int blood = buffObject.max_shengming / 5;
            buffObject.shengming = blood;
            buffObject.revive(fightContainer);
            Vo_7655_0 vo_7655_0 = new Vo_7655_0();
            vo_7655_0.id = buffObject.fid;
            FightManager.send(fightContainer, new M7655_0(), vo_7655_0);
            use = true;
            buffObject.removeBuffState(fightContainer, getStateType());
        }
    }

    @Override
    protected void doDisappear() {

    }

    @Override
    public int getStateType() {
        return 528128;
    }

    public static List<FightObject> findTarget(FightContainer fightContainer, FightRequest fightRequest, int type, int num) {
        List<FightObject> fightObjects = new ArrayList<>();
        final List<FightTeam> teamList = fightContainer.teamList;
        List<FightObject> friendsFightTeam = null;
        for (FightTeam fightTeam : teamList) {
            final List<FightObject> fightObjectList = fightTeam.fightObjectList;
            for (FightObject fightObject : fightObjectList) {
                if (fightObject.fid == fightRequest.id) {
                    friendsFightTeam = new ArrayList<>(fightTeam.fightObjectList);
                }
            }
        }
        for (Iterator<FightObject> iterator = friendsFightTeam.iterator(); iterator.hasNext(); ) {
            FightObject next = iterator.next();
            if (next.fid == fightRequest.vid) {
                num--;
                fightObjects.add(next);
                iterator.remove();
            }
        }
        for (int i = 0; i < num && friendsFightTeam.size() != 0; i++) {
            final FightObject newTarget = friendsFightTeam.remove(FightManager.RANDOM.nextInt(friendsFightTeam.size()));
            fightObjects.add(newTarget);
        }
//混乱
        return fightObjects;
    }
}
