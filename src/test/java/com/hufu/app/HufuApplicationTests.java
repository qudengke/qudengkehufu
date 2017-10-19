package com.hufu.app;

import com.hufu.entity.r.Question;
import com.hufu.entity.r.Record;
import com.hufu.entity.r.StudentInfo;
import com.hufu.entity.r.Tag;
import com.hufu.entity.s.Strategy;
import com.hufu.entity.u.Role;
import com.hufu.entity.u.User;
import com.hufu.repository.r.QuestionRepository;
import com.hufu.repository.r.RecordRepository;
import com.hufu.repository.r.TagRepository;
import com.hufu.repository.s.StrategyRepository;
import com.hufu.repository.u.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class HufuApplicationTests {

	@Autowired
	private TagRepository tagRepository;

	@Autowired
	private QuestionRepository questionRepository;
	@Test
	public void contextLoads() {
//		Strategy  strategy=new Strategy();
//		strategy.setName("第一个虎符策略");
//		User user =new User();
//		user.setName("zhangsan");
////		strategy.setUser(user);
//		strategy.setUser(user);
//		strategyRepository.save(strategy);
//		Strategy  strategy1=strategyRepository.findOne(4);
//		System.out.println(strategy1.getUser().getName());

//		User user=new User();
//		user.setName("lisi");
//		Role role=new Role();
//		role.setName("经理");
//		user.addRole(role);
//		userRepository.save(user);
//		User user1=userRepository.findOne(user.getId());
//		System.out.println("##########");


//		Tag tag=new Tag();
//		Record record=new Record();
//
//		tag.setTagName("目标明确");
//		record.setUrl("hajajsffjaskfhjaf");
//		User user =new User();
//		user.setName("zhangsan");
//		record.addTag(tag);
//		record.setUser(user);
//		StudentInfo studentInfo=new StudentInfo();
//		studentInfo.setFee("12345");
//		record.setStudentInfo(studentInfo);
//		recordRepository.save(record);
//		Tag tag=tagRepository.findOne(4);
//		System.out.println("####");

		Question question1=new Question();
		Question question2=new Question();
		question1.setName("问题1");
		question2.setName("问题2");
		question2.setQid(question1);
		questionRepository.save(question2);
	}

}
