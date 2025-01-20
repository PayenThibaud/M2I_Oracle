package org.example.exo3.Service;


import org.example.exo3.Dto.ClientDtoReceive;
import org.example.exo3.Dto.ClientDtoSend;
import org.example.exo3.Entity.Client;
import org.example.exo3.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService extends GeneriqueServiceImpl<ClientDtoReceive, ClientDtoSend, Client> {

    @Autowired
    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        super(clientRepository);
        this.clientRepository = clientRepository;
    }

    @Override
    protected ClientDtoSend mapToResponse(Client client) {
        return ClientDtoSend.builder()
                .id_client(client.getId_client())
                .nom(client.getNom())
                .build();
    }

    @Override
    protected Client mapToEntity(ClientDtoReceive dto) {
        return Client.builder()
                .nom(dto.getNom())
                .build();
    }

    @Override
    public String getEntityName() {
        return "Client";
    }
}
