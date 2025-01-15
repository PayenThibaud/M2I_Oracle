package org.example.clientservice.Controller;

import org.example.clientservice.Dto.ClientDtoReceive;
import org.example.clientservice.Dto.ClientDtoSend;
import org.example.clientservice.Entity.Client;
import org.example.clientservice.Service.ClientService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("client")
public class ClientController extends GeneriqueController<ClientDtoReceive, ClientDtoSend, ClientService> {

    public ClientController(ClientService service) {
        super(service);
    }
}
