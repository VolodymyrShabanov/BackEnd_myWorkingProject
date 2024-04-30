package myworkingproject.services.autos;

import lombok.AllArgsConstructor;
import myworkingproject.dto.autos.AutoRequestDto;
import myworkingproject.dto.autos.AutoResponseDto;
import myworkingproject.entitys.Auto;
import myworkingproject.repositories.AutoRepository;
import myworkingproject.services.converters.AutoConverter;
import myworkingproject.services.exeptions.AlreadyExistException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
//@RequiredArgsConstructor
public class AutoCreateService {
    private final AutoRepository autoRepository;
    private AutoConverter autoConverter;

    public AutoResponseDto createAuto(AutoRequestDto request) {
        if (autoRepository.findByVinNumber(request.getVinNumber()).isEmpty()) {

            Auto newAuto = autoConverter.fromRequest(request);
            return autoConverter.toResponse(autoRepository.save(newAuto));

        } else {
            throw new AlreadyExistException("Auto with VIN Number: " + request.getVinNumber() + " all ready exist!");
        }

    }
}
