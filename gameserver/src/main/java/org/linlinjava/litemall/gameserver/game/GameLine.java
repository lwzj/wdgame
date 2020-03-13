package org.linlinjava.litemall.gameserver.game;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("glllbawsdfawelllll")
@Scope("prototype")
public class GameLine {
    public int lineNum;
    public String lineName;
    private List<GameMap> gameRoomList = new ArrayList<>();
    private Map<String, GameMap> gameRoomNameMap = new HashMap<>();

    public static GameShuaGuai gameShuaGuai = new GameShuaGuai();




    public void init() {
        final List<org.linlinjava.litemall.db.domain.Map> all = GameData.that.baseMapService.findAll();
        for (org.linlinjava.litemall.db.domain.Map map : all) {
            final GameMap gameMap = GameCore.getBean("gmmmasdfasdfmmmm", GameMap.class);
            gameMap.id = map.getMapId();
            gameMap.name = map.getName();
            gameMap.x = map.getX();
            gameMap.y = map.getY();
            gameRoomList.add(gameMap);
            gameRoomNameMap.put(gameMap.name, gameMap);
        }
    }

    public static GameMap getGameMapname(int line, String mapidname) {
        final GameLine gameLine = GameCore.getGameLine(line);
        for (GameMap gameMap : gameLine.gameRoomList) {
            if (gameMap.name.equals(mapidname)) {
                return gameMap;
            }
        }
        return null;
    }


    public static GameMap getGameMap(int line, int mapid) {
        final GameLine gameLine = GameCore.getGameLine(line);
        for (GameMap gameMap : gameLine.gameRoomList) {
            if (gameMap.id == mapid) {
                return gameMap;
            }
        }
        return null;
    }

    public static GameMap getGameMap(int line, String mapName) {
        final GameLine gameLine = GameCore.getGameLine(line);
        return gameLine.gameRoomNameMap.get(mapName);
    }
}
