package guldilin.reposervice;

import guldilin.dto.CoordinatesDTO;
import guldilin.exceptions.EntryNotFound;
import guldilin.exceptions.ErrorMessage;
import guldilin.exceptions.StorageServiceRequestException;
import guldilin.util.ClientFactoryBuilder;
import lombok.SneakyThrows;

import javax.ws.rs.client.Client;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class CoordinatesRepoServiceImpl implements CoordinatesRepoService {
    private final Client client;
    private final String storageServiceUrl;

    public CoordinatesRepoServiceImpl() {
        this.client = ClientFactoryBuilder.getClient();
        this.storageServiceUrl = ClientFactoryBuilder.getStorageServiceUrl();
    }

    @SneakyThrows
    public CoordinatesDTO getById(Long id) {
        Response response = client.target(storageServiceUrl + "/api/coordinates/" + id)
                .request(MediaType.APPLICATION_JSON)
                .get();
        if (response.getStatus() == Response.Status.NOT_FOUND.getStatusCode()) {
            throw new EntryNotFound(id, ErrorMessage.COORDINATES_NOT_FOUND);
        }
        if (response.getStatus() > 300) throw new StorageServiceRequestException();
        return response.readEntity(CoordinatesDTO.class);
    }

    public Double getDistanceBetween(CoordinatesDTO from, CoordinatesDTO to) {
        return Math.sqrt(Math.pow(from.getX() - to.getX(), 2) + Math.pow(from.getY() - to.getY(), 2));
    }
}
