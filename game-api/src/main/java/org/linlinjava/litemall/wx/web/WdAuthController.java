package org.linlinjava.litemall.wx.web;

import org.linlinjava.litemall.core.util.JSONUtils;
import org.linlinjava.litemall.db.domain.Accounts;
import org.linlinjava.litemall.db.service.base.BaseAccountsService;
import org.linlinjava.litemall.core.util.DesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

@RestController
@RequestMapping
@Validated
public class WdAuthController {
    @Autowired
    private BaseAccountsService baseAccountsService;
    @Value("${netty.ip}")
    private String ip;

    @GetMapping("/vip4/192111/d")
    public Object d() {
        Map<String, Object> data = new HashMap<String, Object>();
        List list = new ArrayList<>();
        list.add("106.53.89.138");
        list.add("106.53.89.138");
        list.add("106.53.89.138");
        data.put("host", "106.53.89.138");
        data.put("ips", list);
        data.put("ttl", 17);
        data.put("origin_ttl", 100);
        return data;
    }

    @GetMapping("/vip4/atm/g-bits//version.php")
    public Object android() {
        String s = "20290209.38";
        return s;
    }

    @GetMapping("/vip4/atm/g-bits/get_patch.php")
    public Object get_patch() {
        ModelAndView modelAndView = new ModelAndView("redirect:/vip4/atm/g-bits/patch.zip");
        return modelAndView;
    }


    @GetMapping("/vip4/mobile/sdk/register.php")
    public Object bindPhone(String account, String pwd, String safe,String check) {

        Map<String, Object> data = new HashMap<String, Object>();
        Accounts accounts = baseAccountsService.findOneByName(account);
//        if (!safe.equals("aabb1122")) {
//            data.put("IsSuccess", false);
//            data.put("Msg", "邀请码错误！");
//            return data;
//        }
        if (accounts != null) {
            data.put("IsSuccess", false);
            data.put("Msg", "账号已经存在！");
        } else {
            data.put("IsSuccess", true);
            data.put("Msg", "账号注册成功，请返回界面登录。！");
            accounts = new Accounts();
            accounts.setName(account);
            accounts.setPassword(pwd);
            accounts.setKeyword(safe);
            accounts.setCode(check.toUpperCase());
            String uuid = utest();
            accounts.setToken(uuid);
            baseAccountsService.add(accounts);
        }
        return data;
    }


    public static String json(String body, String arr) {
        String[] strs = body.split("&");
        Map<String, String> map = new HashMap();
        for (int i = 0; i < strs.length; i++) {
            String[] strss = strs[i].split("=");
            map.put(strss[0], strss[1]);
        }
        return map.get(arr);
    }

    @PostMapping("/vip4/login/login.php")
    public Object login(@RequestBody String body) {

        String account = json(body, "username");
        String pwd = json(body, "userpwd");
        pwd = DesUtil.decrypt(pwd, "leiting");
        Map<String, Object> data = new HashMap<String, Object>();
        Accounts accounts = baseAccountsService.findOneByName(account);
        if (accounts == null) {
            data.put("message", "账号不存在!");
            data.put("status", "fail");
            data.put("type", "10001");
        } else if (!accounts.getPassword().equals(pwd)) {
            data.put("message", "密码错误!!");
            data.put("status", "fail");
            data.put("type", "10001");
        } else {
            Map<String, Object> message = new HashMap<String, Object>();
//        String cookie = md5(pwd);
            message.put("token", accounts.getToken());
            message.put("realNameAuth", "1");
            message.put("sid", accounts.getToken());
            message.put("adult", "1");
            message.put("age", 32);
            message.put("bind", "1");
            message.put("registTime", "1558317799000");
            message.put("timestamp", System.currentTimeMillis() + "");
            data.put("message", JSONUtils.toJSONString(message));
            data.put("status", "success");
            data.put("type", "1");
        }
        return data;
    }

    @PostMapping("/vip4/login/mobile!mobileCheckLoginV3.php")
    public Object motionLogin(@RequestBody String body) {

        String account = json(body, "username");
        String pwd = json(body, "token");
        Map<String, Object> data = new HashMap<String, Object>();
        Accounts accounts = baseAccountsService.findOneByName(account);
        if (accounts == null) {
            data.put("message", "账号不存在!");
            data.put("status", "fail");
            data.put("type", "10001");
        } else if (!accounts.getToken().equals(pwd)) {
            data.put("message", "密码错误!!");
            data.put("status", "fail");
            data.put("type", "10001");
        } else {
            Map<String, Object> message = new HashMap<String, Object>();
//        String cookie = md5(pwd);
            message.put("token", accounts.getToken());
            message.put("realNameAuth", "1");
            message.put("sid", accounts.getToken());
            message.put("adult", "1");
            message.put("age", 32);
            message.put("bind", "1");
            message.put("registTime", "1558317799000");
            message.put("timestamp", System.currentTimeMillis() + "");
            data.put("message", JSONUtils.toJSONString(message));
            data.put("status", "success");
            data.put("type", "1");
        }
        return data;
    }

    public static String utest() {
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
