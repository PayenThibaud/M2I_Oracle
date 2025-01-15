package org.example.subscriptionservice.Service;

import org.example.subscriptionservice.Dto.Client.ClientDtoSend;
import org.example.subscriptionservice.Dto.Subscription.SubscriptionDtoReceive;
import org.example.subscriptionservice.Dto.Subscription.SubscriptionDtoSend;
import org.example.subscriptionservice.Entity.Plans;
import org.example.subscriptionservice.Entity.Subscription;
import org.example.subscriptionservice.Repository.PlansRepository;
import org.example.subscriptionservice.Repository.SubscriptionRepository;
import org.example.subscriptionservice.Tools.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionService extends GeneriqueServiceImpl<SubscriptionDtoReceive, SubscriptionDtoSend, Subscription>{

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Autowired
    private PlansRepository planRepository;

    public SubscriptionService(SubscriptionRepository subscriptionRepository, PlansRepository planRepository) {
        super(subscriptionRepository);
        this.subscriptionRepository = subscriptionRepository;
        this.planRepository = planRepository;
    }

    private void rechercherNomClient(SubscriptionDtoSend subscriptionDtoSend) {
        RestClient<ClientDtoSend> clientRestClient = new RestClient<>("http://localhost:8081/client/" + subscriptionDtoSend.getId_Client());

        try {
            ClientDtoSend clientDtoResponse = clientRestClient.getRequest(ClientDtoSend.class);
            subscriptionDtoSend.setNomClient(clientDtoResponse.getNom());
        } catch (Exception e) {
            System.err.println("Erreur, du service client pour la subscription avec l'ID " + subscriptionDtoSend.getId_Client());
            e.printStackTrace();
            subscriptionDtoSend.setNomClient("Nom indisponible");
        }
    }


    @Override
    protected SubscriptionDtoSend mapToResponse(Subscription subscription) {

        Plans plans = planRepository.findById(subscription.getIdPlans())
                .orElseThrow(() -> new RuntimeException("Plans non trouvé pour l'abonnement " + subscription.getId_subscription()));

        SubscriptionDtoSend subscriptionDtoSend = SubscriptionDtoSend.builder()
                .id_subscription(subscription.getId_subscription())
                .end_date(subscription.getEnd_date())
                .start_date(subscription.getStart_date())
                .id_Client(subscription.getIdClient())
                .id_Plans(subscription.getIdPlans())
                .status(subscription.getStatus())
                .nomPlans(plans.getName())
                .build();

        rechercherNomClient(subscriptionDtoSend);

        return subscriptionDtoSend;
    }

    @Override
    protected Subscription mapToEntity(SubscriptionDtoReceive dto) {
        return Subscription.builder()
                .idPlans(dto.getId_Plans())
                .idClient(dto.getId_Client())
                .end_date(dto.getEnd_date())
                .start_date(dto.getStart_date())
                .status(dto.getStatus())
                .build();
    }

    @Override
    public String getEntityName() {
        return "Subscription";
    }
}
