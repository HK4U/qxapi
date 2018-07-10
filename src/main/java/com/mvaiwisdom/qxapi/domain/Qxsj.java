package com.mvaiwisdom.qxapi.domain;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.web.ResourceProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author eider
 * @create 2018-06-03-下午4:10
 */

@Entity
public class Qxsj {




    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String TEM;

    private String PRS;

    private String RHU;

    private String windpower;

    private String WIN_D_Avg_2mi;

    private String WIN_D_S_Max;

    private String WIN_S_Max;

    private String WIN_D_INST_Max;

    private String WIN_S_Inst_Max;

    private String WIN_S_Avg_2mi;

    private String PRE_1h;

    private String VIS;

    private String WEP_Now;

    private String Station_Id_C;

    /**
     * date类型用来满足数据库根据时间段查询数据记录
     */
    private Date recordDate;


    private String Year;

    private String Mon;

    private String Day;

    private String Hour;


    /**
     * 该类型的日期数据用来进行前端显示，类型为字符串；
     */
    private String DateTime;



    public Qxsj() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTEM() {
        return TEM;
    }

    public void setTEM(String TEM) {
        this.TEM = TEM;
    }

    public String getPRS() {
        return PRS;
    }

    public void setPRS(String PRS) {
        this.PRS = PRS;
    }

    public String getRHU() {
        return RHU;
    }

    public void setRHU(String RHU) {
        this.RHU = RHU;
    }

    public String getWindpower() {
        return windpower;
    }

    public void setWindpower(String windpower) {
        this.windpower = windpower;
    }

    public String getWIN_D_Avg_2mi() {
        return WIN_D_Avg_2mi;
    }

    public void setWIN_D_Avg_2mi(String WIN_D_Avg_2mi) {
        this.WIN_D_Avg_2mi = WIN_D_Avg_2mi;
    }

    public String getWIN_D_S_Max() {
        return WIN_D_S_Max;
    }

    public void setWIN_D_S_Max(String WIN_D_S_Max) {
        this.WIN_D_S_Max = WIN_D_S_Max;
    }

    public String getWIN_S_Max() {
        return WIN_S_Max;
    }

    public void setWIN_S_Max(String WIN_S_Max) {
        this.WIN_S_Max = WIN_S_Max;
    }

    public String getWIN_D_INST_Max() {
        return WIN_D_INST_Max;
    }

    public void setWIN_D_INST_Max(String WIN_D_INST_Max) {
        this.WIN_D_INST_Max = WIN_D_INST_Max;
    }

    public String getWIN_S_Inst_Max() {
        return WIN_S_Inst_Max;
    }

    public void setWIN_S_Inst_Max(String WIN_S_Inst_Max) {
        this.WIN_S_Inst_Max = WIN_S_Inst_Max;
    }

    public String getWIN_S_Avg_2mi() {
        return WIN_S_Avg_2mi;
    }

    public void setWIN_S_Avg_2mi(String WIN_S_Avg_2mi) {
        this.WIN_S_Avg_2mi = WIN_S_Avg_2mi;
    }

    public String getPRE_1h() {
        return PRE_1h;
    }

    public void setPRE_1h(String PRE_1h) {
        this.PRE_1h = PRE_1h;
    }

    public String getVIS() {
        return VIS;
    }

    public void setVIS(String VIS) {
        this.VIS = VIS;
    }

    public String getWEP_Now() {
        return WEP_Now;
    }

    public void setWEP_Now(String WEP_Now) {
        this.WEP_Now = WEP_Now;
    }

    public String getStation_Id_C() {
        return Station_Id_C;
    }

    public void setStation_Id_C(String station_Id_C) {
        Station_Id_C = station_Id_C;
    }

    public java.util.Date getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(java.util.Date recordDate) {
        this.recordDate = recordDate;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    public String getMon() {
        return Mon;
    }

    public void setMon(String mon) {
        Mon = mon;
    }

    public String getDay() {
        return Day;
    }

    public void setDay(String day) {
        Day = day;
    }

    public String getHour() {
        return Hour;
    }

    public void setHour(String hour) {
        Hour = hour;
    }

    public String getDateTime() {
        return DateTime;
    }

    public void setDateTime(String dateTime) {
        DateTime = dateTime;
    }


    //    public Integer getRecordTime() {
//        return recordTime;
//    }
//
//    public void setRecordTime(Integer recordTime) {
//        this.recordTime = recordTime;
//    }
}
