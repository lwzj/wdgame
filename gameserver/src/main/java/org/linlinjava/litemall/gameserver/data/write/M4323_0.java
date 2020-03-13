package org.linlinjava.litemall.gameserver.data.write;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;
import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.vo.Vo_4323_0;

@Service
public class M4323_0 extends BaseWrite {
    @Override
    protected void writeO(ByteBuf writeBuf, Object object) {
        Vo_4323_0 object1 = (Vo_4323_0) object;
        GameWriteTool.writeInt(writeBuf, object1.id);

        GameWriteTool.writeShort(writeBuf, object1.level);
    }

    @Override
    public int cmd() {
        return 4323;
    }
}



