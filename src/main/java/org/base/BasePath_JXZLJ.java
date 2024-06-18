package org.base;

//-------------------------------山西质量奖质量官-------------------------------------
public class BasePath_JXZLJ {

    //质量奖IP
    public static final String ZLJ_IP = "http://192.168.82.164:10063";



    //-------------------------------接口路径-------------------------------------
    public static final String LOGIN = "/api/jxqb/sys/login";

    //获取用户信息
    public static final String SUBMIT_ZLGSQ ="/api/jxqb/qo/apply/addQoApply";
    //审核接口
    public static final String AUDIT= "/api/jxqb/qo/apply/audit";
    //分配专家接口
    public static final String ASSIGN_EXPERTS ="/api/jxqb/qo/apply/applyGroup";
    //专家审核接口
    public static final String AUDIT_ZJ ="/api/jxqb/qo/apply/saveExpertFile";
    //汇总查询
    public static final String FIND_BY_ID ="/api/jxqb/qo/apply/findById";
    //多条件查询
    public static final String FIND_PAGE_BY_QUERY ="/api/jxqb/qo/apply/findPageByQuery";
    //上传
    public static final String UPLOAD ="/api/jxqb/sys/file/rest/upload";
}
