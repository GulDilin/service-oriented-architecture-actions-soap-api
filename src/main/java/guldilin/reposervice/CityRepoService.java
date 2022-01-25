package guldilin.reposervice;

import guldilin.dto.CityDTO;

public interface CityRepoService {
    CityDTO getById(Long id);

    CityDTO getCityWithMaxPopulation();
}
