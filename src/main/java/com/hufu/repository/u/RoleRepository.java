package com.hufu.repository.u;

import com.hufu.entity.u.Resource;
import com.hufu.entity.u.Role;
import com.hufu.entity.u.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Resource,Integer> {

}
