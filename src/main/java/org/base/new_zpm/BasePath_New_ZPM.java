package org.base.new_zpm;

public class BasePath_New_ZPM {
    //浙品码IP
    public static final String ZPM_IP = "http://zpmtest.pzcode.cn";



    //-------------------------------接口路径-------------------------------------
    //获取用户信息
    public static final String GET_CURRENT_USE ="/zpmapi/sys/captcha/getCurrentUser";
    //企业信息管理
    public static final String COMPANY ="/api/zpm/company/update";
    //获取首页信息
    public static final String GET_COMPANY_INFO="/zpmapi/gm2d/company/findByUscc";
    //创建模板
    public static final String TEMPLATES_SAVE ="/api/zpm/zpm/codingtemplates/save";
    //模版列表页查询
    public static final String TEMPLATES_FIND ="/api/zpm/zpm/codingtemplates/findPageByQuery";
    //模板详情页查询
    public static final String TEMPLATES_DETAILS_FIND ="/zpmapi/zpm/codingtemplates/findById";
    //模板删除
    public static final String TEMPLATES_DELETE = "/api/zpm/zpm/codingtemplates/delete";




    //创建品类码
    public static final String SAMPLING_PRODUCT_SAVE="/api/zpm/zpm/samplingProduct/save";
    //品类码列表页查询
    public static final String SAMPLING_PRODUCT_DETAILS_FIND ="/zpmapi/zpm/samplingProduct/findById";
    //品类码详情页查询
    public static final String SAMPLING_PRODUCT_FIND ="/api/zpm/zpm/samplingProduct/findPageCompanyProduct";
    //品类码删除
    public static final String SAMPLING_PRODUCT_DELETE = "/api/zpm/zpm/samplingProduct/setProductQRCodeInvalid";



    //创建批次码
    public static final String BATCH_CODE_SAVE="/api/zpm/zpm/zpmCode/saveBatch";
    //批次码列表页查询
    public static final String BATCH_CODE_DETAILS_FIND ="/api/zpm/zpm/zpmCode/findPageByQuery";
    //批次码详情页查询
    public static final String BATCH_CODE_FIND ="/zpmapi/zpm/batchCode/findById";
    //批次码删除
    public static final String BATCH_CODE_DELETE = "/api/zpm/zpm/zpmCode/deleteBatchById";


    //创建单品码
    public static final String SINGLE_ITEM_SAVE="/api/zpm/zpm/zpmCode/saveBatchDpm";
    //单品码列表页查询
    public static final String SINGLE_ITEM_DETAILS_FIND ="/api/zpm/zpm/zpmCode/findPageDpm";
    //单品码详情页查询
    public static final String SINGLE_ITEM_FIND ="/zpmapi/zpm/zpmCode/findById";
    //单品码删除
    public static final String SINGLE_ITEM_DELETE = "/api/zpm/zpm/zpmCode/deleteDpmById";


    //供应商新增
    public static final String SUPPLIERS_SAVE ="/api/zpm/material/materialSuppliers/save";
    //供应商页查询
    public static final String SUPPLIERS_FIND ="/api/zpm/material/materialSuppliers/findPageByQuery";
    //供应商删除
    public static final String SUPPLIERS_DELETE ="/api/zpm/material/materialSuppliers/delete";


    //原辅料新增
    public static final String MATERIALS_SAVE ="/api/zpm/material/materialMaterials/save";
    //原辅料页查询
    public static final String MATERIALS_FIND ="/api/zpm/material/materialMaterials/findPageByQuery";
    //原辅料删除
    public static final String MATERIALS_DELETE ="/api/zpm/material/materialMaterials/delete";


    //经销商新增
    public static final String CUSTOMERS_SAVE ="/api/zpm/material/materialCustomers/save";
    //经销商查询
    public static final String CUSTOMERS_FIND ="/api/zpm/material/materialCustomers/findPageByQuery";
    //经销商删除
    public static final String CUSTOMERS_DELETE ="/api/zpm/material/materialCustomers/delete";


    //流向信息新增
    public static final String FLOW_DETAILS_SAVE ="/api/zpm/zpm/zpmCode/saveFlowDetails";
    //流向信息查询
    public static final String FLOW_DETAILS_FIND ="/api/zpm/zpm/flow/findPageByQuery";
    //流向信息删除
    public static final String FLOW_DETAILS_DELETE ="/api/zpm/zpm/flow/delete";


    //品牌新增
    public static final String COMPANY_BRAND_SAVE ="/api/zpm/companyBrand/save";
    //品牌查询
    public static final String COMPANY_BRAND_FIND ="/api/zpm/companyBrand/findPageByQuery";
    //品牌删除
    public static final String COMPANY_BRAND_DELETE ="/api/zpm/companyBrand/delete";


    //资质新增
    public static final String COMPANY_CREDENTIAL_SAVE ="/api/zpm/companyCredential/save";
    //资质查询
    public static final String COMPANY_CREDENTIAL_FIND ="/api/zpm/companyCredential/findPageByQuery";
    //资质删除
    public static final String COMPANY_CREDENTIAL_DELETE ="/api/zpm/companyCredential/delete";

    //进货信息新增
    public static final String MATERIAL_PURCHASE_SAVE ="/api/zpm/material/materialPurchase/save";
    //进货信息查询
    public static final String MATERIAL_PURCHASE_FIND ="/api/zpm/material/materialPurchase/findPageByQuery";
    //进货信息删除
    public static final String MATERIAL_PURCHASE_DELETE ="/api/zpm/material/materialPurchase/delete";


    //变更批次
    public static final String CHANGE_BATCH ="/api/zpm/zpm/zpmCode/associatedWithBatchAndBarSingle";
    //批量变更批次
    public static final String CHANGE_BATCH_MORE ="/api/zpm/zpm/zpmCode/associatedWithBatchAndBarBatch";


    //修改密码
    public static final String UPDATEPWD ="/api/zpm/sys/sysUser/updatePwd";


    //电动车上传
    public static final String DDC_INFO ="/api/zpm/electric/info/importExcel";

    //电池上传
    public static final String DC_INFO ="/api/zpm/battery/info/importExcel";

    //生产计量器具上传
    public static final String SC_MEASURE ="api/zpm/measure/instrument/productImport";

    //使用计量器具上传
    public static final String SY_MEASURE ="/api/zpm/measure/instrument/usingImport";
    //-------------------------------接口路径-------------------------------------

}
