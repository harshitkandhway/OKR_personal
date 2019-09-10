package com.xebia.okr;

import com.xebia.okr.domain.KeyResult;
import com.xebia.okr.domain.Objective;
import com.xebia.okr.domain.Plan;
import com.xebia.okr.repository.CrudRepoPlan;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
//@SpringBootTest
@DataJpaTest
public class OkrApplicationTests {

	@Autowired
	private CrudRepoPlan crudRepository;
	//ApplicationContext context;

	@Test
	public void contextLoads() {
	}

	@Test
	public void unitTest()
	{
		KeyResult keyResult1 = new KeyResult("Oracle Certified for Backend");
		KeyResult keyResult2 = new KeyResult("Write 3 blogs for learning Frontend");

		Objective objective1 = new Objective("Become a full stack Developer in 3 months");
		List<KeyResult> keyResultList = new ArrayList<>();
		keyResultList.add(keyResult1);
		keyResultList.add(keyResult2);
		objective1.setKeyResults(keyResultList);

		Objective objective2 = new Objective("Start writing to do note in 1 week");
		List<Objective> objectiveList = new ArrayList<>();
		objectiveList.add(objective1);
		objectiveList.add(objective2);


		Plan plan1 = new Plan("first plan",new Date("30/08/2019"),new Date("10/09/2019"),objectiveList);
		Plan plan = crudRepository.save(plan1);


		System.out.println("data-->"+crudRepository.findById(plan.getId()));


// 1st id will be generated auto by generator... so it will be 1







	Assertions.assertThat(crudRepository.findById(1L).get().getTitle()).isEqualTo("first plan");

		//CrudRepoPlan repo = context.getBean(CrudRepoPlan.class);
		//repo.save(plan1);


	}

}
