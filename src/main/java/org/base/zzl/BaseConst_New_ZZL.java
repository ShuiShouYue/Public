package org.base.zzl;

public class BaseConst_New_ZZL {
    //生产企业token
    public static  String Token_zzl_sc = "Bearer 25fb9f83-e9d4-4ed0-a02c-1606386c81a8";
    //销售企业token
    public static  String Token_zzl_xs = "Bearer 3f91b65d-ebbf-4d80-95a3-3a61e7904d62";

    public BaseConst_New_ZZL() {
    }

    public static String getToken_zzl_sc() {
        return Token_zzl_sc;
    }

    public static void setToken_zzl_sc(String token_zzl_sc) {
        Token_zzl_sc = token_zzl_sc;
    }

    public static String getToken_zzl_xs() {
        return Token_zzl_xs;
    }

    public static void setToken_zzl_xs(String token_zzl_xs) {
        Token_zzl_xs = token_zzl_xs;
    }
}
