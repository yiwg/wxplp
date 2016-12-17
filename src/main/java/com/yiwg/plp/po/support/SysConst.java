package com.yiwg.plp.po.support;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yiweiguo on 2016/12/9.
 */
public class SysConst {

    public static Integer scsCode=1;
    public static Integer failCode=2;
    public static Integer errorCode=3;
    public static Map<Integer,String> apiRet;

    static {
        apiRet=new HashMap<>();
        apiRet.put(scsCode,"成功");
        apiRet.put(failCode,"失败");
        apiRet.put(errorCode,"出错");
    }

}
