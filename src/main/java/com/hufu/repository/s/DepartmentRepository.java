package com.hufu.repository.s;

import com.hufu.entity.s.Advise;
import com.hufu.entity.s.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Integer> {

}
