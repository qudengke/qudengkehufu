package com.hufu.repository.u;

import com.hufu.entity.u.Student;
import com.hufu.entity.u.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {

}
