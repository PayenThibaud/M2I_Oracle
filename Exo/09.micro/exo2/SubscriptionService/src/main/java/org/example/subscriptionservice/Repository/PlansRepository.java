package org.example.subscriptionservice.Repository;

import org.example.subscriptionservice.Entity.Plans;
import org.springframework.data.repository.CrudRepository;

public interface PlansRepository extends CrudRepository<Plans, Integer> {
}
