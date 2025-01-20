package org.example.exo3.Controller;

import org.example.exo3.Dto.ClientDtoReceive;
import org.example.exo3.Dto.ClientDtoSend;
import org.example.exo3.Service.ClientService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Client")
public class ClientController extends GeneriqueController<ClientDtoReceive, ClientDtoSend, ClientService> {
    public ClientController(ClientService service) {
        super(service);
    }
}
