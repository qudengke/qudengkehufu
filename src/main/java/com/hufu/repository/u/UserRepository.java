package com.hufu.repository.u;

import com.hufu.entity.u.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

}
