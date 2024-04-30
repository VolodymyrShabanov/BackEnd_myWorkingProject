package myworkingproject.services.autos;

import lombok.AllArgsConstructor;
import myworkingproject.dto.autos.AutoRequestDto;
import myworkingproject.dto.autos.AutoResponseDto;
import myworkingproject.entitys.Auto;
import myworkingproject.repositories.AutoRepository;
import myworkingproject.services.converters.AutoConverter;
import myworkingproject.services.exeptions.NotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AutoUpdateService {
    private final AutoRepository autoRepository;
    private AutoConverter autoConverter;

    public AutoResponseDto updateAutoByVinNumber(AutoRequestDto request) {

        Auto updateAuto = autoRepository.findByVinNumber(request.getVinNumber())
                .orElseThrow(() -> new NotFoundException("Auto with VIN Number: " + request.getVinNumber() + " not found"));

        if (request.getBrand() != null) {
            updateAuto.setBrand(request.getBrand());
        }

        if (request.getModel() != null) {
            updateAuto.setModel(request.getModel());
        }

        Auto saveAuto = autoRepository.save(updateAuto);

        return autoConverter.toResponse(saveAuto);
    }
}
