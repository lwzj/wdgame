package org.linlinjava.litemall.gameserver.data.write;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;
import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.vo.Vo_11757_0;

import java.util.List;

@Service
public class M11757_0 extends BaseWrite {
    @Override
    protected void writeO(ByteBuf writeBuf, Object object) {
        Vo_11757_0 object1 = (Vo_11757_0) object;
        GameWriteTool.writeInt(writeBuf, object1.id);

        GameWriteTool.writeShort(writeBuf, object1.list.size());
        for (Integer integer : object1.list) {
            GameWriteTool.writeInt(writeBuf, integer);
        }

    }

    @Override
    public int cmd() {
        return 11757;
    }
}





