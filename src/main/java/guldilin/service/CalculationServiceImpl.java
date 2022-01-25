package guldilin.service;

import guldilin.dto.CoordinatesDTO;
import guldilin.dto.LengthDTO;
import guldilin.reposervice.CityRepoService;
import guldilin.reposervice.CoordinatesRepoService;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(endpointInterface = "guldilin.service.CalculationService")
public class CalculationServiceImpl implements CalculationService {
    @Inject
    private CoordinatesRepoService coordinatesRepoService;

    @Inject
    private CityRepoService cityRepoService;

    @WebMethod
    public LengthDTO calculateDistanceBetweenCities(Long id1, Long id2) {
//        long lid1, lid2;
//        try {
//            lid1 = Long.parseLong(id1);
//        } catch (NumberFormatException e) {
//            throw new ArgumentFormatException("id1", ErrorMessage.IS_INTEGER);
//        }
//        try {
//            lid2 = Long.parseLong(id2);
//        } catch (NumberFormatException e) {
//            throw new ArgumentFormatException("id2", ErrorMessage.IS_INTEGER);
//        }
        CoordinatesDTO c1 = this.coordinatesRepoService.getById(this.cityRepoService.getById(id1).getCoordinates());
        CoordinatesDTO c2 = this.coordinatesRepoService.getById(this.cityRepoService.getById(id2).getCoordinates());
        return new LengthDTO(this.coordinatesRepoService.getDistanceBetween(c1, c2));
    }

    @WebMethod
    public LengthDTO calculateDistanceToMaxPopulated() {
        CoordinatesDTO c = this.coordinatesRepoService.getById(this.cityRepoService.getCityWithMaxPopulation().getCoordinates());
        return new LengthDTO(this.coordinatesRepoService.getDistanceBetween(c,
                CoordinatesDTO.builder().x(0L).y(0).build()));
    }
}
