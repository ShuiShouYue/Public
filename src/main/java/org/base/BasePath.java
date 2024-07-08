package org.base;

public class BasePath {
    //浙品码IP
    public static final String ZPM_IP = "http://192.168.82.164:10061";



    //-------------------------------接口路径-------------------------------------
    //获取用户信息
    public static final String GET_CURRENT_USE ="/zpmapi/sys/captcha/getCurrentUser";
    //获取首页信息
    public static final String GET_COMPANY_INFO="/zpmapi/gm2d/company/findByUscc";
    //创建模板
    public static final String TEMPLATES_SAVE="/zpmapi/zpm/codingtemplates/save";
    //模版列表页查询
    public static final String TEMPLATES_FIND ="/zpmapi/zpm/codingtemplates/findPageByQuery";
    //模板详情页查询
    public static final String TEMPLATES_DETAILS_FIND ="/zpmapi/zpm/codingtemplates/findById";
    //模板删除
    public static final String TEMPLATES_DELETE = "/zpmapi/zpm/codingtemplates/delete";




    //创建品类码
    public static final String SAMPLING_PRODUCT_SAVE="/zpmapi/zpm/samplingProduct/save";
    //品类码列表页查询
    public static final String SAMPLING_PRODUCT_DETAILS_FIND ="/zpmapi/zpm/samplingProduct/findById";
    //品类码详情页查询
    public static final String SAMPLING_PRODUCT_FIND ="/zpmapi/zpm/samplingProduct/findPageCompanyProduct";
    //品类码删除
    public static final String SAMPLING_PRODUCT_DELETE = "/zpmapi/zpm/samplingProduct/setProductQRCodeInvalid";



    //创建批次码
    public static final String BATCH_CODE_SAVE="/zpmapi/zpm/zpmCode/saveBatch";
    //批次码列表页查询
    public static final String BATCH_CODE_DETAILS_FIND ="/zpmapi/zpm/batchCode/findPageByQuery";
    //批次码详情页查询
    public static final String BATCH_CODE_FIND ="/zpmapi/zpm/batchCode/findById";
    //批次码删除
    public static final String BATCH_CODE_DELETE = "/zpmapi/zpm/batchCode/delete";


    //创建单品码
    public static final String SINGLE_ITEM_SAVE="/zpmapi/zpm/zpmCode/saveDpm";
    //单品码列表页查询
    public static final String SINGLE_ITEM_DETAILS_FIND ="/zpmapi/gm2d/serialCode/findPageByQuery";
    //单品码详情页查询
    public static final String SINGLE_ITEM_FIND ="/zpmapi/zpm/zpmCode/findById";
    //单品码删除
    public static final String SINGLE_ITEM_DELETE = "/zpmapi/gm2d/serialCode/delete";

    //-------------------------------接口路径-------------------------------------

}
