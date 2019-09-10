package com.xebia.okr;

import com.xebia.okr.domain.KeyResult;
import com.xebia.okr.domain.Objective;
import com.xebia.okr.domain.Plan;
import com.xebia.okr.repository.CrudRepoPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class OkrApplication implements CommandLineRunner {
    @Autowired
    private CrudRepoPlan crudRepoPlan;

    public static void main(String[] args) {
        SpringApplication.run(OkrApplication.class, args);


    }


    @Override
    public void run(String... args) throws Exception {

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

		Plan plan1 = new Plan("first plan", new Date("30/08/2019"), new Date("10/09/2019"), objectiveList);
		crudRepoPlan.save(plan1);

		//should_create_objective_when_i_proide_valid_data()
		// search on internet -> spring boot properties
		// h2 file based url}
	}
}
