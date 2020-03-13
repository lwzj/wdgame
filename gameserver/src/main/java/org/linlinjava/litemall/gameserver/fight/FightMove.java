package org.linlinjava.litemall.gameserver.fight;

import org.linlinjava.litemall.gameserver.domain.Chara;

import java.util.HashMap;
import java.util.Map;

public class FightMove {
    public int id;
    public int curMove;
    public int nextMove;

    public static final Map<Integer,FightMove> MOVE_MAP = new HashMap<>();
    public static boolean move(int id){
        FightMove fightMove = MOVE_MAP.get(id);
        if(fightMove == null){
            fightMove = new FightMove();
            fightMove.curMove = 0;
            fightMove.nextMove = 5+FightManager.RANDOM.nextInt(10);
            MOVE_MAP.put(id,fightMove);
            return false;
        }
        fightMove.curMove++;
        if(fightMove.curMove >= fightMove.nextMove){
            fightMove.curMove = 0;
            fightMove.nextMove = 5+FightManager.RANDOM.nextInt(10);
            return true;
        }
        return false;
    }
}
