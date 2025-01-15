package org.example.subscriptionservice.Repository;

import org.example.subscriptionservice.Entity.Subscription;
import org.springframework.data.repository.CrudRepository;

public interface SubscriptionRepository extends CrudRepository<Subscription, Integer> {
}
