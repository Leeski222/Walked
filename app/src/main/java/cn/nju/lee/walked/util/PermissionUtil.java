package cn.nju.lee.walked.util;

/**
 * Created by 果宝 on 2018/1/13.
 * 专门负责动态权限管理的类
 */

public class PermissionUtil {
    private PermissionUtil mPermissionUtil;

    private PermissionUtil() {
    }

    public PermissionUtil getInstance() {
        if(mPermissionUtil == null) {
            synchronized (PermissionUtil.class) {
                mPermissionUtil = new PermissionUtil();
            }
        }
        return mPermissionUtil;
    }
    
}
