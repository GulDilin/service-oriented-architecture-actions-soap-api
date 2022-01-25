package guldilin.service;

import guldilin.dto.LengthDTO;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface CalculationService {
    @WebMethod
    LengthDTO calculateDistanceBetweenCities(Long id1, Long id2);

    @WebMethod
    LengthDTO calculateDistanceToMaxPopulated();
}
