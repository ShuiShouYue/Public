package org.base;

public class BasePathitsp {
    //子平台IP
    public static final String ITSP_IP = "http://192.168.82.164:10023";



    //-------------------------------接口路径-------------------------------------
    //获取用户信息
    public static final String GET_USER ="/superapi/user/getUser";
    //获取标准信息
    public static final String GET_Plat_std_Catalog="/superapi/PlatstdCatalog";
    //创建模板
    public static final String TEMPLATES_SAVE="/api/zpm/codingtemplates/save";
    //模版列表页查询
    public static final String TEMPLATES_FIND ="/api/zpm/codingtemplates/findPageByQuery";
    //模板详情页查询
    public static final String TEMPLATES_DETAILS_FIND ="/api/zpm/codingtemplates/findById";
    //模板删除
    public static final String TEMPLATES_DELETE = "/api/zpm/codingtemplates/delete";




    //创建品类码
    public static final String SAMPLING_PRODUCT_SAVE="/api/zpm/samplingProduct/save";
    //品类码列表页查询
    public static final String SAMPLING_PRODUCT_DETAILS_FIND ="/api/zpm/samplingProduct/findById";
    //品类码详情页查询
    public static final String SAMPLING_PRODUCT_FIND ="/api/zpm/samplingProduct/findPageCompanyProduct";
    //品类码删除
    public static final String SAMPLING_PRODUCT_DELETE = "/api/zpm/samplingProduct/setProductQRCodeInvalid";



    //创建批次码
    public static final String BATCH_CODE_SAVE="/api/zpm/zpmCode/saveBatch";
    //批次码列表页查询
    public static final String BATCH_CODE_DETAILS_FIND ="/api/zpm/batchCode/findPageByQuery";
    //批次码详情页查询
    public static final String BATCH_CODE_FIND ="/api/zpm/batchCode/findById";
    //批次码删除
    public static final String BATCH_CODE_DELETE = "/api/zpm/batchCode/delete";


    //创建单品码
    public static final String SINGLE_ITEM_SAVE="/api/zpm/zpmCode/saveDpm";
    //单品码列表页查询
    public static final String SINGLE_ITEM_DETAILS_FIND ="/api/gm2d/serialCode/findPageByQuery";
    //单品码详情页查询
    public static final String SINGLE_ITEM_FIND ="/api/zpm/zpmCode/findById";
    //单品码删除
    public static final String SINGLE_ITEM_DELETE = "/api/gm2d/serialCode/delete";

}
