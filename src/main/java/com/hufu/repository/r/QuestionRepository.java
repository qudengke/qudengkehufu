package com.hufu.repository.r;

import com.hufu.entity.r.Question;
import com.hufu.entity.s.Advise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question,Integer> {

}
