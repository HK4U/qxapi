package com.mvaiwisdom.qxapi.service;



import com.mvaiwisdom.qxapi.domain.Qxsj;
import com.mvaiwisdom.qxapi.domain.QxsjRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author eider
 * @create 2018-06-03-下午5:50
 */

@Service
public class QxsjService {

    @Autowired
    private QxsjRepository qxsjRepository;

    public List<Qxsj> findAll(){
        return qxsjRepository.findAll();
    }


    public Qxsj save(Qxsj qxsj){
        return qxsjRepository.save(qxsj);
    }

//    public List<Qxsj> findByTime(){
    public List<Qxsj> findByTime(Date startTime, Date endTime){

//        String s = "2018-06-09";
//        String e = "2018-06-11";
        return qxsjRepository.findByTime(startTime, endTime);
    }

}
