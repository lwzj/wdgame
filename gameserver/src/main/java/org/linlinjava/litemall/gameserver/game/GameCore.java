package org.linlinjava.litemall.gameserver.game;

import org.linlinjava.litemall.gameserver.domain.BuildFields;
import org.linlinjava.litemall.gameserver.fight.FightTianshuMap;
import org.linlinjava.litemall.gameserver.fight.BattleUtils;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.linlinjava.litemall.gameserver.netty.NettyServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GameCore {
    public static GameCore that;
    private static final Logger log = LoggerFactory.getLogger(GameCore.class);
    protected List<GameLine> gameLineList = new ArrayList<>();
    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private List<BaseWrite> baseWrites;
    private static final Map<Integer, BaseWrite> basewriteMap = new HashMap<>();
    public NettyServer server;
    public long currentTime = 0;

    public void init(NettyServer server) {
        log.error("game init begin!");

        this.server = server;
        for (int i = 0; i < 14; i++) {
            final GameLine gameLine = applicationContext.getBean("glllbawsdfawelllll", GameLine.class);
            gameLine.lineNum = i + 1;
            gameLine.lineName = "烟雨江南" + gameLine.lineNum;
            gameLineList.add(gameLine);
            gameLine.init();
        }

        BuildFields.init();
        BuildFields.add();
        BattleUtils.init();
        FightTianshuMap.init();
        log.error("game init over!");
    }

    @PostConstruct
    public void initAfter() {
        that = this;
        for (BaseWrite baseWrite : baseWrites) {
            basewriteMap.put(baseWrite.cmd(), baseWrite);
        }
    }

    public static <T> T getBean(String name, Class<T> cls) {
        return that.applicationContext.getBean(name, cls);
    }

    protected static BaseWrite getBaseWrite(int cmd) {
        return basewriteMap.get(cmd);
    }

    public static GameLine getGameLine(int line) {
        for (GameLine gameLine : GameCore.that.gameLineList) {
            if (gameLine.lineNum == line) {
                return gameLine;
            }
        }
        return null;
    }

    public List<GameLine> getGameLineAll() {
        return gameLineList;
    }
}
