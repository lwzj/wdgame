package org.linlinjava.litemall.gameserver.data.write;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;
import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.vo.Vo_9129_0;
@Service
public class M9129_0 extends BaseWrite {
    @Override
    protected void writeO(ByteBuf writeBuf,Object object) {
Vo_9129_0 object1 = (Vo_9129_0)object;
 GameWriteTool.writeShort(writeBuf,object1.notify);

 GameWriteTool.writeString(writeBuf,object1.para);
}@Override
    public int cmd() {
        return 9129;
    }
}



