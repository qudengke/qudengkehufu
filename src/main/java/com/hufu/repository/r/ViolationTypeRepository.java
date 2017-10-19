package com.hufu.repository.r;

import com.hufu.entity.r.ViolationType;
import com.hufu.entity.s.Advise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ViolationTypeRepository extends JpaRepository<ViolationType,Integer> {

}
