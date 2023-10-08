package guldilin.reposervice;

import guldilin.dto.CoordinatesDTO;

public interface CoordinatesRepoService {
    CoordinatesDTO getById(Long id);

    Double getDistanceBetween(CoordinatesDTO from, CoordinatesDTO to);
}
