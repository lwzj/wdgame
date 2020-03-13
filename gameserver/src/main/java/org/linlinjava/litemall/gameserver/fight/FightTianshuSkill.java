package org.linlinjava.litemall.gameserver.fight;

import org.linlinjava.litemall.gameserver.data.vo.Vo_12028_0;
import org.linlinjava.litemall.gameserver.data.write.M12028_0;
import org.linlinjava.litemall.gameserver.domain.JiNeng;

import java.util.List;

public abstract class FightTianshuSkill implements FightSkill {
    protected FightObject buffObject = null;
    protected FightContainer fightContainer;

    public boolean isActive() {
        return FightManager.RANDOM.nextBoolean();
    }


    @Override
    public List<FightResult> doSkill(FightContainer fightContainer, FightRequest fightRequest, JiNeng jiNeng) {
        return null;
    }

    public void sendEffect(FightContainer fightContainer) {
        final Vo_12028_0 vo_12028_0 = new Vo_12028_0();
        vo_12028_0.id = buffObject.fid;
        vo_12028_0.effect_no = 0;
        vo_12028_0.type = 4;
        vo_12028_0.name = getName();
        FightManager.send(fightContainer, new M12028_0(), vo_12028_0);
    }
    public abstract String getName();
}
