package org.linlinjava.litemall.gameserver.data.write;

import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class M8405 extends BaseWrite {
    @Value("${netty.ip}")
    private String ip;

    @Override
    protected void writeO(ByteBuf writeBuf, Object object) {
        String charaName = (String) object;
        GameWriteTool.writeString(writeBuf, ip + ",8300,8300,8300," + charaName);
    }

    @Override
    public int cmd() {
        return 8405;
    }
}



