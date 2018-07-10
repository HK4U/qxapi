package com.mvaiwisdom.qxapi.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mvaiwisdom.qxapi.domain.Qxsj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author eider
 * @create 2018-06-03-下午6:13
 */

@Component
public class QxTask {




//        public final static long ONE_Minute =  60 * 1000;
//
//        @Scheduled(fixedDelay=ONE_Minute)
//        public void fixedDelayJob(){
//            System.out.println(Dates.format_yyyyMMddHHmmss(new Date())+" >>fixedDelay执行....");
//        }


    /**
     * 实例化RestTemplate类，用于外部接口的调用
     */
    private RestTemplate restTemplate;




//    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    private LocalDate d1;
//    System.out.println(d1);


    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        restTemplate = builder.build();
        return restTemplate;
    }





    /**
     * 使用ObjectMapper用来实现json数据与java对象的序列化与反序列化，使用.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)规定
     * 在反序列化json数据为Java对象的过程中，忽略Java对象中不存在的字段属性；
     */
    ObjectMapper mapper = new ObjectMapper().disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);




    @Autowired
    private QxsjService qxsjService;


    /**
     * 自定义字符串格式化方法，由于原始数据转换为字符串后均含有""双引号
     * 使用replace()方法去除字符串中的双引号
     * @param s
     * @return
     */
    public String QxFormat(String s){

        return s.replace("\"", "");


    }


    /**
     * 自定义整形数字格式化方法，需要先将整形数字转换为字符串
     * 只有转换为string类型才可以对数值型数据进行格式化；
     * @param s
     * @return
     */
    public String IntFormat(String s){

        int s1 = Integer.parseInt(s);

        String s2 = (new DecimalFormat("00")).format(s1);

        return s2;

    }


    /**
     * 设置字符串转换为整形数据的方法；
     * @param s
     * @return
     */
    public int StoI(String s){

        return Integer.parseInt(s);

    }


    /**
     * 设置整型数据转换为字符串类型的方法；
     * @param i
     * @return
     */
    public String ItoS(int i){
        return Integer.toString(i);
    }





    /**
     * 实例化SimpleDateFormat类，用来执行字符串到日期类型数据的转换
     */
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");





    /**
     * 外部气象数据接口的形式为url= a+b+c+d+e，此处将url进行拆分；
     */

    private String a = "http://api.data.cma.cn:8090/api?userId=5257674279816Z9XH&pwd=jQsl1Qd&dataFormat=json&interfaceId=getSurfEleByTimeRangeAndStaID&timeRange=[";

    //获取系统当前时间并转换为字符串
//    private String day1 = dateFormat.format(new Date()).replaceAll("-","");

    private String day1 = "20180608";

    private String b;

    private String c = "3000,";

//    private String day2 = Integer.toString(Integer.parseInt(day1)+1);

//    private String day2 = "20180609"

    private String d;

    private String e = "3000]&staIDs=53512&elements=TEM,PRS,RHU,windpower,WIN_D_Avg_2mi,WIN_D_S_Max,WIN_S_Max,WIN_D_INST_Max,WIN_S_Inst_Max,WIN_S_Avg_2mi,PRE_1h,VIS,WEP_Now,Station_Id_C,Year,Mon,Day,Hour&dataCode=SURF_CHN_MUL_HOR";


    // QxUrl = a + day1 + b + c + day2 + d + e;
    private String QxUrl;






    /**
     * 设置定时任务，暂定以24h为周期即（fixRate = 24*60*60*1000），执行当日数据记录获取；
     */
    @Scheduled(fixedRate=20000)
    public void fixedRateJob(){




        day1 = ItoS(StoI(day1) + 1);
//        String day_2 = ItoS(StoI(day_1) + 1;




        /**
         * 利用此处循环，遍历一天当中24条数据记录；
         */
        for (int i = 0; i < 24; i = i+1) {


//            if(i+1 = 24)


            /**
             * 格式化Hour显示，显示为00格式
             */
            b = (new DecimalFormat("00")).format(i);
            d = (new DecimalFormat("00")).format(i+1);


            /**
             * 组合气象数据接口URL；
             */
            QxUrl = a + day1 + b + c + day1 + d + e;



            /**
             * 调用restTemplate的getForObject方法调用外部数据接口并返回json格式数据；
             */
            String data = restTemplate.getForObject(QxUrl, String.class);



            /**
             * 使用jackson将气象数据接口返回的json格式数据反序列化为java对象
             */
            try {

                /**
                 * 使用readValue方法将json数据格式化为Java对象
                 */
//                ApiData apiData = mapper.readValue(data, ApiData.class);


                /**
                 * 使用readTree方法将json数据格式化为JsonNode类型
                 * JsonNode类型使得json数据可以按照键值对的形式进行索引查询
                 * 例如node.get("DS")语句表示按照"DS"查询该键名称下对应的值
                 */

                JsonNode node = mapper.readTree(data);

                /**
                 * 这里因为"DS"对应的值为"[{}]"类型，为List类型
                 * 将List中的元素使用get()方法取出为对象{}
                 * 使用toString()方法将该对象转化为纯文本形式，纯文本的键值对即为json格式
                 * 在使用readTree方法将该气象数据json转化为JsonNode形式供索引查询；
                 */
                String qxJson = node.get("DS").get(0).toString();
                JsonNode nodeQx = mapper.readTree(qxJson);

                /**
                 * 字符串均含有双引号，在将json格式转换为字符串后需要去除双引号,使用自定义的QxFormat()方法；
                 */
                String year = QxFormat(nodeQx.get("Year").toString());
                String mon = QxFormat(nodeQx.get("Mon").toString());
                String day = QxFormat(nodeQx.get("Day").toString());


                /**
                 * 拼接yyyymmdd格式的日期数据，在字符串状态下调用自定义的IntFormat()方法将数据格式化为00显示模式；
                 */
                String rDate = year + "-" +  IntFormat(mon) + "-" + IntFormat(day);


                /**
                 * 将"yyyy-MM-dd"类型的字符串转换为date类型数据；
                 * 注意在数据库中调整recordDate字段类型为"date"而不是"datetime"，后者包含时分秒数据；
                 */
                Date recordDate = null;
                try {
                    recordDate = dateFormat.parse(rDate);

                } catch (ParseException e1) {
                    e1.printStackTrace();
                }


                /**
                 * 此处示例话Qxsj对象后，将调用气象数据api返回的数据保存并调用service保存至数据库
                 * 此处代码可以使用for循环简化，此处未简化，在保证性能的同时让维护人员更直接的理解代码含义；
                 */
                Qxsj qxsj = new Qxsj();
                qxsj.setTEM(QxFormat(nodeQx.get("TEM").toString()));
                qxsj.setPRS(QxFormat(nodeQx.get("PRS").toString()));
                qxsj.setRHU(QxFormat(nodeQx.get("RHU").toString()));
                qxsj.setWindpower(QxFormat(nodeQx.get("windpower").toString()));
                qxsj.setWIN_D_Avg_2mi(QxFormat(nodeQx.get("WIN_D_Avg_2mi").toString()));
                qxsj.setWIN_D_S_Max(QxFormat(nodeQx.get("WIN_D_S_Max").toString()));
                qxsj.setWIN_S_Max(QxFormat(nodeQx.get("WIN_S_Max").toString()));
                qxsj.setWIN_D_INST_Max(QxFormat(nodeQx.get("WIN_D_INST_Max").toString()));
                qxsj.setWIN_S_Inst_Max(QxFormat(nodeQx.get("WIN_S_Inst_Max").toString()));
                qxsj.setWIN_S_Avg_2mi(QxFormat(nodeQx.get("WIN_S_Avg_2mi").toString()));
                qxsj.setPRE_1h(QxFormat(nodeQx.get("PRE_1h").toString()));
                qxsj.setVIS(QxFormat(nodeQx.get("VIS").toString()));
                qxsj.setWEP_Now(QxFormat(nodeQx.get("WEP_Now").toString()));
                qxsj.setStation_Id_C(QxFormat(nodeQx.get("Station_Id_C").toString()));
                qxsj.setYear(QxFormat(nodeQx.get("Year").toString()));
                qxsj.setMon(QxFormat(nodeQx.get("Mon").toString()));
                qxsj.setDay(QxFormat(nodeQx.get("Day").toString()));
                qxsj.setHour(QxFormat(nodeQx.get("Hour").toString()));
                qxsj.setDateTime(rDate);
                qxsj.setRecordDate(recordDate);


                /**
                 * 调用服务，将数据存储至数据库；
                 */
                qxsjService.save(qxsj);





            } catch (IOException e1) {
                e1.printStackTrace();
            }




            /**
             * 利用线程设置延时，避免短时间内方位气象数据接口次数过多导致访问请求被禁止；
             */
            try
            {
                Thread.sleep(5000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }



        }





    }



}
