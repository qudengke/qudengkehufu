package com.hufu.repository.r;

import com.hufu.entity.r.ViolationInfo;
import com.hufu.entity.s.Advise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ViolationInfoRepository extends JpaRepository<ViolationInfo,Integer> {

}
