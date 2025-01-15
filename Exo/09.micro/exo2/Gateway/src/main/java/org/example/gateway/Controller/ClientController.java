package org.example.gateway.Controller;

import org.example.gateway.Dto.ClientDtoRequest;
import org.example.gateway.Dto.ClientDtoResponse;
import org.example.gateway.Dto.ClientDtoResponseGet;
import org.example.gateway.utils.PortApi;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
Content-Type: application/json

{
    "nom": "Dupont",
        "age": 30,
        "email": "dupont@example.com",
        "telephone": "0123456789"
}
 */

@RestController
@RequestMapping("client")
public class ClientController extends GeneriqueController<ClientDtoRequest, ClientDtoResponse, ClientDtoResponseGet> {


    public ClientController() {
        super(ClientDtoRequest.class);
    }

    @Override
    protected String getBaseUrl() {
        return "http://localhost:" + PortApi.portClient + "/client";
    }

    @Override
    protected String getEntityName() {
        return "Client";
    }

    @Override
    protected Class<ClientDtoResponseGet[]> getArrayResponseType() {
        return ClientDtoResponseGet[].class;
    }

    @Override
    protected Class<ClientDtoResponseGet> getSingleResponseTypeGet() {
        return ClientDtoResponseGet.class;
    }

    @Override
    protected Class<ClientDtoResponse> getSingleResponseType() {
        return ClientDtoResponse.class;
    }
}
