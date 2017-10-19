package com.hufu.repository.u;

import com.hufu.entity.u.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepository extends JpaRepository<Role,Integer> {

}
