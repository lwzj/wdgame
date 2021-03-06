package org.linlinjava.litemall.gameserver.data.write;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;
import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.vo.Vo_41041_0;

@Service
public class M41041_0 extends BaseWrite {
    @Override
    protected void writeO(ByteBuf writeBuf, Object object) {
        Vo_41041_0 object1 = (Vo_41041_0) object;
        GameWriteTool.writeByte(writeBuf, object1.type);

        GameWriteTool.writeByte(writeBuf, object1.limitNum);

        GameWriteTool.writeByte(writeBuf, object1.count);
    }

    @Override
    public int cmd() {
        return 41041;
    }
}




