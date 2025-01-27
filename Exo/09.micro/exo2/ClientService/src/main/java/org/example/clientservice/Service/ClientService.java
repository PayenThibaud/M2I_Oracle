package org.example.clientservice.Service;

import org.example.clientservice.Dto.ClientDtoReceive;
import org.example.clientservice.Dto.ClientDtoSend;
import org.example.clientservice.Entity.Client;
import org.example.clientservice.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService extends GeneriqueServiceImpl<ClientDtoReceive, ClientDtoSend, Client> {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        super(clientRepository);
        this.clientRepository = clientRepository;
    }
    @Override
    public String getEntityName() {
        return "Client";
    }

    @Override
    protected ClientDtoSend mapToResponse(Client client) {
        return ClientDtoSend.builder()
                .id_client(client.getId_client())
                .nom(client.getNom())
                .age(client.getAge())
                .email(client.getEmail())
                .telephone(client.getTelephone())
                .build();
    }

    @Override
    protected Client mapToEntity(ClientDtoReceive clientDtoReceive) {
        return Client.builder()
                .nom(clientDtoReceive.getNom())
                .age(clientDtoReceive.getAge())
                .email(clientDtoReceive.getEmail())
                .telephone(clientDtoReceive.getTelephone())
                .build();
    }


    @Override
    public List<ClientDtoSend> getAllEntities() {
        return super.getAllEntities();
    }

    @Override
    public ClientDtoSend getEntityById(int id) {
        return super.getEntityById(id);
    }

    @Override
    public ClientDtoSend createEntity(ClientDtoReceive clientDtoReceive) {
        return super.createEntity(clientDtoReceive);
    }

    @Override
    public ClientDtoSend updateEntity(int id, ClientDtoReceive clientDtoReceive) {
        return super.updateEntity(id, clientDtoReceive);
    }

    @Override
    public void deleteEntity(int id) {
        super.deleteEntity(id);
    }
}