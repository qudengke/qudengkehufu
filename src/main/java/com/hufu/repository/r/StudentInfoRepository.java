package com.hufu.repository.r;

import com.hufu.entity.r.StudentInfo;
import com.hufu.entity.r.Tag;
import com.hufu.entity.s.Advise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentInfoRepository extends JpaRepository<StudentInfo,Integer> {

}
