package com.mvaiwisdom.qxapi.domain;

import java.lang.reflect.Array;
import java.util.List;

/**
 * @author eider
 * @create 2018-06-03-下午8:53
 */
public class ApiData {

    private String returnCode;

    private String returnMessage;

    private String rowCount;

    private String colCount;

    private String requestParams;

    private String requestTime;

    private String responseTime;

    private String takeTime;

    private String fieldNames;

    private String fieldUnits;


    /**
     * 针对气象数据接口返回的json嵌套格式数据，最后一个键值对为："DS":[{"1":"A", "2":"B"}]
     * DS属性所需需要被定义为数组或列表，内部元素为气象数据对象；
     */

    private ApiDs[] ds;

//    private List<ApiDs> ds;

//    private ApiDs[] ds;

    public ApiDs[] getDs() {
        return ds;
    }

    public void setDs(ApiDs[] ds) {
        this.ds = ds;
    }

    public ApiData() {
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMessage() {
        return returnMessage;
    }

    public void setReturnMessage(String returnMessage) {
        this.returnMessage = returnMessage;
    }

    public String getRowCount() {
        return rowCount;
    }

    public void setRowCount(String rowCount) {
        this.rowCount = rowCount;
    }

    public String getColCount() {
        return colCount;
    }

    public void setColCount(String colCount) {
        this.colCount = colCount;
    }

    public String getRequestParams() {
        return requestParams;
    }

    public void setRequestParams(String requestParams) {
        this.requestParams = requestParams;
    }

    public String getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(String requestTime) {
        this.requestTime = requestTime;
    }

    public String getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(String responseTime) {
        this.responseTime = responseTime;
    }

    public String getTakeTime() {
        return takeTime;
    }

    public void setTakeTime(String takeTime) {
        this.takeTime = takeTime;
    }

    public String getFieldNames() {
        return fieldNames;
    }

    public void setFieldNames(String fieldNames) {
        this.fieldNames = fieldNames;
    }

    public String getFieldUnits() {
        return fieldUnits;
    }

    public void setFieldUnits(String fieldUnits) {
        this.fieldUnits = fieldUnits;
    }





}
