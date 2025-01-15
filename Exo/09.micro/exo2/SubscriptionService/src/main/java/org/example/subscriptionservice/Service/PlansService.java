package org.example.subscriptionservice.Service;

import org.example.subscriptionservice.Dto.Plans.PlansDtoReceive;
import org.example.subscriptionservice.Dto.Plans.PlansDtoSend;
import org.example.subscriptionservice.Entity.Plans;
import org.example.subscriptionservice.Repository.PlansRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlansService extends GeneriqueServiceImpl<PlansDtoReceive, PlansDtoSend, Plans>{

    @Autowired
    private final PlansRepository plansRepository;

    public PlansService(PlansRepository plansRepository) {
        super(plansRepository);
        this.plansRepository = plansRepository;
    }

    @Override
    protected PlansDtoSend mapToResponse(Plans plans) {
        return PlansDtoSend.builder()
                .id_plans(plans.getId_plans())
                .name(plans.getName())
                .price(plans.getPrice())
                .billingCycle(plans.getBillingCycle())
                .build();
    }

    @Override
    protected Plans mapToEntity(PlansDtoReceive dto) {
        return Plans.builder()
                .billingCycle(dto.getBillingCycle())
                .name(dto.getName())
                .price(dto.getPrice())
                .build();
    }

    @Override
    public String getEntityName() {
        return "Plans";
    }
}
