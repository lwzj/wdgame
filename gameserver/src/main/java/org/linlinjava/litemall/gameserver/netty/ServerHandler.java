package org.linlinjava.litemall.gameserver.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;
import org.linlinjava.litemall.db.domain.Accounts;
import org.linlinjava.litemall.db.domain.Charge;
import org.linlinjava.litemall.db.util.JSONUtils;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.GameReadTool;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.game.GameData;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.linlinjava.litemall.gameserver.game.GameObjectCharMng;
import org.linlinjava.litemall.gameserver.util.DuiLie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Qualifier("serverHandler")
@ChannelHandler.Sharable
@Component
public class ServerHandler extends ChannelInboundHandlerAdapter {
    private static final Logger log = LoggerFactory.getLogger(ServerHandler.class);
    public static final AttributeKey<GameObjectChar> akey = AttributeKey.newInstance("session");
    private static Map map = new HashMap();

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);

    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
        final Attribute<GameObjectChar> attr = ctx.channel().attr(akey);
        if (attr == null) {
            return;
        }
        final GameObjectChar session = attr.get();
        if (session == null || session.chara == null) {
            return;
        }
        GameObjectCharMng.remove(session);

    }

    @Autowired
    private List<GameHandler> gameHandlers;

    /**
     * 解析客户端请求数据
     *
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        final Attribute<GameObjectChar> attr = ctx.channel().attr(akey);
        GameObjectChar session = null;
        if (attr != null && attr.get() != null) {
            session = attr.get();
            GameObjectChar.GAMEOBJECTCHAR_THREAD_LOCAL.set(session);
        }
        ByteBuf buff = (ByteBuf) msg;
        GameReadTool.readInt(buff);
        GameReadTool.readShort(buff);
        int cmd = GameReadTool.readShort(buff);
        System.out.println("cmd====" + cmd);
        for (GameHandler waitLine : gameHandlers) {
            if (cmd == waitLine.cmd()) {
                if (session != null) {
                    if (session.lock()) {
                        try {//这里是处理数据的逻辑
                            //判断刷金币
                            Accounts accounts = GameData.that.baseAccountsService.findById(session.accountid);
                            final List<Charge> list = GameData.that.baseChargeService.findByAccountname(accounts.getName());                          // 如果金币大于冲值元宝则退出
                            int totalYuanbao = 0;
                            if (list != null) {
                                for (int i = 0; i < list.size(); i++) {
                                    totalYuanbao = totalYuanbao + list.get(i).getCoin();
                                }
                            }

                            //1.
                            if (session.chara != null && session.chara.extra_life > totalYuanbao + 8888888) {
                                // exit; fenghao
                                Accounts account = new Accounts();
                                account.setId(session.accountid);
                                account.setBlock(1);
                                GameData.that.baseAccountsService.updateById(account);
                                GameObjectChar.getGameObjectChar().offline();
                            }
                            //2.
                            if (session.chara != null && session.chara.extra_life < 0) {
                                // exit;
                                Accounts account = new Accounts();
                                account.setId(session.accountid);
                                account.setBlock(1);
                                GameData.that.baseAccountsService.updateById(account);
                                GameObjectChar.getGameObjectChar().offline();
                            }
                            if (session.chara != null && session.chara.balance < 0) {
                                // exit;
                                Accounts account = new Accounts();
                                account.setId(session.accountid);
                                account.setBlock(1);
                                GameData.that.baseAccountsService.updateById(account);
                                GameObjectChar.getGameObjectChar().offline();
                            }

                            //判断刷属性
                            DuiLie duilie = (DuiLie) map.get(session.accountid);
                            if (duilie == null) {

                                DuiLie duilie1 = new DuiLie();
                                duilie1.add(cmd);
                                map.put(session.accountid, duilie1);
                            } else {
                                duilie.add(cmd);
                                map.put(session.accountid, duilie);
                            }
                            if (session.characters != null) {

                                String data = session.characters.getData();
                                Chara chara = JSONUtils.parseObject(data, Chara.class);
                                System.out.println("剩余点数:::" + chara.polar_point);
                                System.out.println("体质:::" + chara.life);
                                System.out.println("灵力:::" + chara.mag_power);
                                System.out.println("力量:::" + chara.phy_power);
                                System.out.println("敏捷:::" + chara.speed);

                                System.out.println("气血:::" + chara.def);
                                System.out.println("法力:::" + chara.dex);
                                System.out.println("物伤:::" + chara.accurate);
                                System.out.println("法伤:::" + chara.mana);
                                System.out.println("速度:::" + chara.parry);
                                System.out.println("防御:::" + chara.wiz);
                                duilie.setChara(chara);
                                if (duilie.getChara() != null) {
                                    //校验总数
                                    boolean zsflag = ((chara.polar_point + chara.life + chara.mag_power + chara.phy_power + chara.speed)
                                            == (duilie.getChara().polar_point + duilie.getChara().life + duilie.getChara().mag_power + duilie.getChara().phy_power + duilie.getChara().speed));
                                    System.out.println("校验总数:" + zsflag);
                                    boolean flag222 = false;
                                    if (chara.polar_point >= 0) {
                                        flag222 = true;
                                    }
                                    //level
                                    int levle = chara.level;
                                    int sysxd = (levle - 1) * 4 + (levle * 4);

                                    boolean flag111 = true;
                                    if (levle != 1) {
                                        if (sysxd != (chara.polar_point + chara.life + chara.mag_power + chara.phy_power + chara.speed)
                                                || chara.speed < levle
                                                || chara.life < levle
                                                || chara.mag_power < levle
                                                || chara.phy_power < levle
                                                || chara.speed > sysxd
                                                || chara.life > sysxd
                                                || chara.mag_power > sysxd
                                                || chara.phy_power > sysxd
                                                || chara.polar_point < 0
                                        ) {
                                            System.out.println("======================判断是刷包WPE==========================");
                                            flag111 = false;
                                            Accounts account = new Accounts();
                                            account.setId(session.accountid);
                                            account.setBlock(1);
                                            GameData.that.baseAccountsService.updateById(account);
                                            GameObjectChar.getGameObjectChar().offline();
                                        }
                                    }

                                    //if (zsflag && flag1 && flag2 && flag3 && flag4 && flag5&&flag222) {
                                    if (flag222 && flag111) {
                                        map.put(session.accountid, duilie);
                                        waitLine.process(ctx, buff);
                                    }
                                    duilie.setChara(chara);
                                } else {
                                    waitLine.process(ctx, buff);
                                }
                                // waitLine.process(ctx, buff);
                                break;
                            } else {
                                waitLine.process(ctx, buff);
                            }
                        } finally {
                            session.unlock();
                        }
                    }
                } else {
                    waitLine.process(ctx, buff);
                    break;
                }
            }
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        if (!cause.toString().contains("java.io.IOException")) {
            log.error("exceptionCaught", cause);
        }
        ctx.close();
    }
}
