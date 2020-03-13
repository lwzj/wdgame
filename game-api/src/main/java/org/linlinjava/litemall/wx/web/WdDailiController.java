package org.linlinjava.litemall.wx.web;

import org.linlinjava.litemall.core.util.JacksonUtil;
import org.linlinjava.litemall.core.util.ResponseUtil;
import org.linlinjava.litemall.db.dao.custom.CustomDailiMapper;
import org.linlinjava.litemall.db.domain.Daili;
import org.linlinjava.litemall.db.domain.Notice;
import org.linlinjava.litemall.db.service.base.BaseAccountsService;
import org.linlinjava.litemall.db.service.base.BaseDailiService;
import org.linlinjava.litemall.db.service.base.BaseNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
@RequestMapping
@Validated
public class WdDailiController {
    @Autowired
    private BaseAccountsService baseAccountsService;
    @Autowired
    private BaseNoticeService baseNoticeService;

    private static final String ADMIN_TOKEN = "tasdjbaqwuibzxcvnbibasouwerka";
    @Autowired
    private BaseDailiService baseDailiService;

    @Autowired
    private CustomDailiMapper customDailiMapper;

    public static final List<String> zimu = new CopyOnWriteArrayList<>();

    static {
        zimu.add("A");
        zimu.add("B");
        zimu.add("C");
        zimu.add("D");
        zimu.add("E");
        zimu.add("F");
        zimu.add("G");
        zimu.add("H");
        zimu.add("I");
        zimu.add("J");
        zimu.add("K");
        zimu.add("L");
        zimu.add("M");
        zimu.add("N");
        zimu.add("O");
        zimu.add("P");
        zimu.add("Q");
        zimu.add("R");
        zimu.add("S");
        zimu.add("T");
        zimu.add("U");
        zimu.add("V");
        zimu.add("W");
        zimu.add("X");
        zimu.add("Y");
        zimu.add("Z");
    }

    @PostMapping("login")
    public Object login(@RequestBody String body, HttpServletRequest request) {
        String username = JacksonUtil.parseString(body, "account");
        String password = JacksonUtil.parseString(body, "password");
        if (username == null || password == null) {
            return ResponseUtil.badArgument();
        }
        final HashMap<Object, Object> data = new HashMap<>();
        final ArrayList<Map> list = new ArrayList<>();
        if (username.equals("QWERASDF1234") && password.equals("123QWEASD")) {
            HashMap hashMap = new HashMap();
            for (String zm : zimu) {
                final List<Map> maps = customDailiMapper.selectAccount(zm);
                for (Map map : maps) {
                    final Object numobj = map.get("num");
                    int num = Integer.valueOf(numobj.toString());

                    hashMap = new HashMap();
                    hashMap.put("code", map.get("code"));
                    hashMap.put("number", num);
                    list.add(hashMap);
                }
            }
            data.put("name", username);

            data.put("list", list);
            data.put("token", ADMIN_TOKEN);
            data.put("isAdmin", true);
            data.put("number", 0);
            data.put("canGiveCount", 0);
        } else {
//            if (username.length() > 1) {
////                 return ResponseUtil.fail();
////            }
            final Daili daili = baseDailiService.findOneByAccount(username);
            if (daili == null || !daili.getPasswd().equals(password)) {
                return ResponseUtil.fail();
            }
            final String uuid = UUID.randomUUID().toString();
            daili.setToken(uuid);
            baseDailiService.updateById(daili);

            HashMap hashMap = new HashMap();
            final List<Map> maps = customDailiMapper.selectAccount(username);
            for (Map map : maps) {
                hashMap.put("code", map.get("code"));
                hashMap.put("number", map.get("num"));
                list.add(hashMap);
            }

            data.put("name", username);
            data.put("list", list);
            data.put("token", uuid);
            data.put("isAdmin", false);
            data.put("code", username);
            data.put("canGiveCount", 0);
        }
        return ResponseUtil.ok(data);
    }

    @PostMapping("message")
    public Object message(@RequestBody String body, HttpServletRequest request) {
        String message = JacksonUtil.parseString(body, "message");
        String token = JacksonUtil.parseString(body, "token");
        if (!token.equals(ADMIN_TOKEN)) {
            return ResponseUtil.fail();
        }
        int time = JacksonUtil.parseInteger(body, "time");
        final Notice notice = baseNoticeService.findById(1);
        notice.setTime(time);
        notice.setMessage(message);
        baseNoticeService.updateById(notice);
        return ResponseUtil.ok();
    }

    @PostMapping("append1")
    public Object append(@RequestBody String body, HttpServletRequest request) {
        String count = JacksonUtil.parseString(body, "count");
        String appendName = JacksonUtil.parseString(body, "appendName");
        String token = JacksonUtil.parseString(body, "token");
        if (!token.equals(ADMIN_TOKEN)) {
            return ResponseUtil.fail();
        }



        final HashMap<Object, Object> data = new HashMap<>();
        data.put("canGiveCount", 0);
        return ResponseUtil.ok(data);
    }

    @PostMapping("select")
    public Object select(@RequestBody String body, HttpServletRequest request) {

        String count = JacksonUtil.parseString(body, "count");
        int day = JacksonUtil.parseInteger(body, "day");
        if (day == 3) {
            day = 2;
        }
        String token = JacksonUtil.parseString(body, "token");
        final ArrayList<Map> list = new ArrayList<>();

        if (token.equals(ADMIN_TOKEN)) {
            HashMap hashMap = new HashMap();
            hashMap.put("countTotal", 1);
            hashMap.put("code", "管理员");
            final ArrayList<Map> listin = new ArrayList<>();
            hashMap.put("list", listin);
            list.add(hashMap);
            int alltotal = 0;
            for (String zm : zimu) {
                final List<Map> maps = customDailiMapper.selectMoney(zm, day - 1);
                int total = 0;
                for (Map map : maps) {
                    final Object numobj = map.get("num");
                    int num = Integer.valueOf(numobj.toString());
                    total += num;
                    alltotal += num;
                }
                HashMap zidaihashMap = new HashMap();
                listin.add(zidaihashMap);
                zidaihashMap.put("code", zm);
                zidaihashMap.put("count", total);

            }
            hashMap.put("countTotal", alltotal);

        } else {
            final Daili daili = baseDailiService.findOneByToken(token);
            HashMap hashMap = new HashMap();
            hashMap.put("code", daili.getAccount());
            final ArrayList<Map> listin = new ArrayList<>();
            hashMap.put("list", listin);
            list.add(hashMap);


            final List<Map> maps = customDailiMapper.selectMoney(daili.getAccount(), day-1);
            int total = 0;
            for (Map map : maps) {
                HashMap zidaihashMap = new HashMap();
                listin.add(zidaihashMap);
                zidaihashMap.put("code", map.get("code"));
                final Object numobj = map.get("num");
                int num = Integer.valueOf(numobj.toString());
                total += num;
                zidaihashMap.put("count", num);
            }

            hashMap.put("countTotal", total);

        }
//        final HashMap<Object, Object> data = new HashMap<>();
//        data.put("data", list);


        return ResponseUtil.ok(list);
    }
    private static boolean charge;
    @PostMapping("search")
    public Object search(@RequestBody String body, HttpServletRequest request) {
        String token = JacksonUtil.parseString(body, "token");
        final HashMap<Object, Object> data = new HashMap<>();
        data.put("popen", charge ? 1 : 0);
        return ResponseUtil.ok(data);
    }

    @PostMapping("/popen")
    public Object popen(@RequestBody String body, HttpServletRequest request) {
        String token = JacksonUtil.parseString(body, "token");
        if (!token.equals(ADMIN_TOKEN)) {
            return ResponseUtil.ok();
        }
        String popen = JacksonUtil.parseString(body, "popen");
        if (popen.equals("0")) {
            charge = false;
        } else {
            charge = true;
        }
        final HashMap<Object, Object> data = new HashMap<>();
        data.put("popen", popen);
        return ResponseUtil.ok();
    }

    @PostMapping("appendCount")
    public Object appendCount(@RequestBody String body, HttpServletRequest request) {
        String token = JacksonUtil.parseString(body, "token");
        String count = JacksonUtil.parseString(body, "count");
        String code = JacksonUtil.parseString(body, "code");

//        final HashMap<Object, Object> data = new HashMap<>();
//        data.put("popen",1);
        return ResponseUtil.ok();
    }

    public static String getUUID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    public static String md5(String plainText) {
        //定义一个字节数组
        byte[] secretBytes = null;
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            //对字符串进行加密
            md.update(plainText.getBytes());
            //获得加密后的数据
            secretBytes = md.digest();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("没有md5这个算法！");
        }
        //将加密后的数据转换为16进制数字
        String md5code = new BigInteger(1, secretBytes).toString(16);// 16进制数字
        // 如果生成数字未满32位，需要前面补0
        for (int i = 0; i < 32 - md5code.length(); i++) {
            md5code = "0" + md5code;
        }
        return md5code;
    }

}
