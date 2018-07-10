package com.mvaiwisdom.qxapi.web;

import com.mvaiwisdom.qxapi.domain.Qxsj;
import com.mvaiwisdom.qxapi.service.QxsjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static jdk.internal.org.objectweb.asm.Type.getType;

/**
 * @author eider
 * @create 2018-06-03-下午5:59
 */

@RestController
public class QxsjController {


    @Autowired
    private QxsjService qxsjService;

    /**
     * 实例化RestTemplate类，用来读取外部数据接口
     */


    @GetMapping("/qxsj")
    public List<Qxsj> getAll(){
        return qxsjService.findAll();
    }





    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date sTime = null;
    Date eTime = null;


    /**
     * post请求解析
     * @param startTime
     * @param endTime
     * @return
     */
    @PostMapping("/qxsj")
    public List<Qxsj> getByTime(@RequestParam String startTime, @RequestParam String endTime){

        try {
            sTime =  dateFormat.parse(startTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        try {
            eTime = dateFormat.parse(endTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }

//        System.out.println(startTime.getClass().toString());



        return qxsjService.findByTime(sTime, eTime);
    }




}
