package com.xebia.okr.repository;

import com.xebia.okr.domain.Plan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrudRepoPlan extends CrudRepository<Plan, Long> {
}
