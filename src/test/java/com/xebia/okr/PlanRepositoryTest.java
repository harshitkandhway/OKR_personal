package com.xebia.okr;
import com.xebia.okr.domain.Plan;
import com.xebia.okr.repository.PlanRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.Date;
@RunWith(SpringRunner.class)
@DataJpaTest
public class PlanRepositoryTest {

    @Autowired
    private PlanRepository planRepository;

    //Unit test for create
    @Test
    public void should_save_plan_when_i_pass_plan_with_title() {
        Plan planObject = new Plan("This is first plan", new Date(), new Date());
        Plan returnedPlanObject = planRepository.save(planObject);
        Assertions.assertThat(returnedPlanObject.getId()).isNotNull();
    }

    //Unit test for Update
    @Test
    public void should_update_plan_when_i_change_title() {
        Plan planObject = new Plan("Before Updation", new Date(), new Date());
        Plan returnedPlanObject = planRepository.save(planObject);
        returnedPlanObject.setTitle("After Updation");
        returnedPlanObject = planRepository.save(planObject);
        Assertions.assertThat(returnedPlanObject.getId()).isNotNull();
    }

    //Unit test for Read
    @Test
    public void should_read_plan_title_when_i_pass_plan_id() {
        Plan planObject = new Plan("plan title", new Date(), new Date());
        Plan returnedPlanObject = planRepository.save(planObject);
        Assertions.assertThat(returnedPlanObject.getId()).isNotNull();
    }

    //unit test for delete
    @Test
    public void should_delete_plan_when_plan_id_is_passed() {
        Plan planObject = new Plan("plan to be deleted", new Date(), new Date());
        Plan returnedPlanObject = planRepository.save(planObject);
        planRepository.deleteById(returnedPlanObject.getId());
        Assertions.assertThat(planRepository.findById(returnedPlanObject.getId()).isPresent()).isFalse();
    }
}
