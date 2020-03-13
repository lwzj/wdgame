package org.linlinjava.litemall.gameserver.data.write;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.data.UtilObjMap;
import org.linlinjava.litemall.gameserver.data.UtilObjMapshuxing;
import org.linlinjava.litemall.gameserver.data.vo.Vo_4119_0;
import org.linlinjava.litemall.gameserver.domain.BuildFields;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.linlinjava.litemall.gameserver.process.GameUtil;
import org.springframework.stereotype.Service;
import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.vo.Vo_4121_0;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
public class M4121_0 extends BaseWrite {
    @Override
    protected void writeO(ByteBuf writeBuf, Object object) {

        List<Vo_4121_0> object1 = (List<Vo_4121_0>) object;
        GameWriteTool.writeShort(writeBuf, object1.size());

        for (Vo_4121_0 obj : object1) {
            GameWriteTool.writeInt(writeBuf, obj.id);

            GameWriteTool.writeString(writeBuf, obj.gid);

            GameWriteTool.writeInt(writeBuf, obj.suit_icon);

            GameWriteTool.writeShort(writeBuf, obj.weapon_icon);

            GameWriteTool.writeShort(writeBuf, obj.org_icon);


            Map<Object, Object> map = UtilObjMap.Vo_4121_0(obj);
            map.remove("id");
            map.remove("gid");

            map.remove("suit_icon");
            map.remove("weapon_icon");
            map.remove("org_icon");

            map.remove("memberpos_x");
            map.remove("memberpos_y");

            map.remove("membermap_id");
            map.remove("memberteam_status");
            map.remove("membercard_name");
            map.remove("membercomeback_flag");
            map.remove("memberlight_effect_count");

            Iterator<Map.Entry<Object, Object>> it = map.entrySet().iterator();

            while (it.hasNext()) {
                Map.Entry<Object, Object> entry = it.next();
                if (entry.getValue().equals(0) || entry.getKey().equals("")) {
                    it.remove();
                }
            }
            GameWriteTool.writeShort(writeBuf, map.size());
            for (Map.Entry<Object, Object> entry : map.entrySet()) {
                if (BuildFields.data.get((String) entry.getKey()) != null) {
                    BuildFields.get((String) entry.getKey()).write(writeBuf, entry.getValue());
                } else {
                    System.out.println(entry.getKey());
                }
            }
            GameWriteTool.writeShort(writeBuf, obj.memberpos_x);

            GameWriteTool.writeShort(writeBuf, obj.memberpos_y);

            GameWriteTool.writeInt(writeBuf, obj.membermap_id);

            GameWriteTool.writeByte(writeBuf, obj.memberteam_status);

            GameWriteTool.writeString(writeBuf, obj.membercard_name);

            GameWriteTool.writeByte(writeBuf, obj.membercomeback_flag);

            GameWriteTool.writeByte(writeBuf, obj.memberlight_effect_count);
        }

    }

    @Override
    public int cmd() {
        return 4121;
    }

}

























