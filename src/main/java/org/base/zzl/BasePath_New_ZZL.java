package org.base.zzl;

public class BasePath_New_ZZL {
    public static final String ZZL_IP = "http://192.168.82.164:10060";



    //-------------------------------接口路径-------------------------------------
    //登录接口
    public static final String LOGIN ="/zzlapi/sys/login";

    //模版新增
    public static final String CODINGTEMPLATES_SAVE ="/zzlapi/zpm/codingtemplates/save";

    //模版查询
    public static final String CODINGTEMPLATES_FIND ="/zzlapi/zpm/codingtemplates/findPageByQuery";

    //模版删除
    public static final String CODINGTEMPLATES_DELETE ="/zzlapi/zpm/codingtemplates/delete";

    //-------------------------------------------------------------------------

    //企业信息
    public static final String COMPANYINFOS_UPDATE ="/zzlapi/zpm/companyinfos/update";
    //-------------------------------------------------------------------------

    //客户创建
    public static final String CUSTOM_SAVE ="/zzlapi/psi/custom/save";
    //客户查询
    public static final String CUSTOM_FIND ="/zzlapi/psi/custom/findPageByQuery";
    //客户删除
    public static final String CUSTOM_DELETE ="/zzlapi/psi/custom/delete";

    //-------------------------------------------------------------------------

    //品类码创建
    public static final String SAMPLING_PRODUCT_SAVE ="/zzlapi/zpm/samplingProduct/save";
    //品类码查询
    public static final String SAMPLING_PRODUCT_FIND ="/zzlapi/zpm/samplingProduct/findPageCompanyProduct";
    //品类码删除
    public static final String SAMPLING_PRODUCT_DELETE ="/zzlapi/zpm/samplingProduct/setProductQRCodeInvalid";
    //-------------------------------------------------------------------------
    //批次码创建
    public static final String BATCH_SAVE ="/zzlapi/zpm/zpmCode/saveBatch";
    //批次码查询
    public static final String BATCH_FIND ="/zzlapi/zpm/zpmCode/findPageByQuery";
    //批次码删除
    public static final String BATCH_DELETE ="/zzlapi/zpm/zpmCode/deleteBatchById";

    //单品码创建
    public static final String DPM_SAVE ="/zzlapi/zpm/zpmCode/saveBatchDpm";
    //单品码查询
    public static final String DPM_FIND ="/zzlapi/zpm/zpmCode/findPageDpm";
    //单品码入库前报废
    public static final String DPM_DELETE ="/zzlapi/zpm/zpmCode/deleteDpmById";

    //-------------------------------------------------------------------------
    //单个入库
    public static final String PSI ="/zzlapi/psi/inv/save";
    //批量入库
    public static final String DP ="/zzlapi/zpm/zpmCode/saveBatchDpm";

    //-------------------------------------------------------------------------
    //订单新增
    public static final String ORDER_SAVE ="/zzlapi/psi/order/save";
    //订单查询
    public static final String ORDER_FIND ="/zzlapi/psi/order/findPageByQuery";
    //订单删除
    public static final String ORDER_DELETE ="/zzlapi/psi/order/delete";
}
