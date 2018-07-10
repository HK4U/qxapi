package com.mvaiwisdom.qxapi.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface QxsjRepository extends JpaRepository <Qxsj, Long> {

//    @Query(value = "select pre_1h, prs, rhu, station_id_c, tem, vis, wep_now, win_d_avg_2mi, win_d_inst_max, win_d_s_max, win_s_avg_2mi, win_s_inst_max, win_s_max, windpower, date_time from qxsj where record_date between ?1 and ?2", nativeQuery = true)
    @Query(value = "select * from qxsj where record_date between ?1 and ?2", nativeQuery = true)

    List<Qxsj> findByTime(Date startTime, Date endTime);

}
