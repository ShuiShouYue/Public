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
    //下载
    public static final String EXPORTARCHIVED ="/api/jxqb/qo/archived/exportArchived";
    //删除
    public static final String DELETE ="/api/jxqb/qo/apply/delete";
    //注销
    public static final String CANCELAPPLY ="/api/jxqb/qo/changeApply/cancelApply";
    //注销审核接口
    public static final String CANCEAUDIT ="/api/jxqb/qo/changeApply/audit";
    //质量官证书查询接口
    public static final String FIND_PAGE_BY_QUERY_ZS ="/api/jxqb/qo/archived/findPageByQuery";
    //质量官字段查询接口
    public static final String FIND_PAGE_BY_QUERY_ZD ="/api/jxqb/qo/changeApply/findPageByQuery";
    //质量官详情查询接口
    public static final String FIND_PAGE_BY_QUERY_XQ ="/api/jxqb/qo/changeApply/findById";
    //质量官变更申请
    public static final String SUBMIT_ZLGBG ="/api/jxqb/qo/changeApply/addApply";

    //质量官变更详情（data为变更输入）
    public static final String FIND_BY_ID_ZLGBG ="/api/jxqb/qo/archived/findById";
}
