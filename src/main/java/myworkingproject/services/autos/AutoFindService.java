package myworkingproject.services.autos;

import lombok.AllArgsConstructor;
import myworkingproject.dto.autos.AutoByIdResponseDto;
import myworkingproject.dto.autos.AutoResponseDto;
import myworkingproject.entitys.Auto;
import myworkingproject.repositories.AutoRepository;
import myworkingproject.services.converters.AutoConverter;
import myworkingproject.services.exeptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AutoFindService {
    private final AutoRepository autoRepository;
    private final AutoConverter autoConverter;

    public List<AutoResponseDto> findAll() {
        return autoRepository.findAll().stream()
                .map(autoConverter::toResponse)
                .toList();
    }

    public AutoByIdResponseDto findById(Integer idAuto) {
        Auto auto = autoRepository.findById(idAuto)
                .orElseThrow(() -> new NotFoundException("Auto with id: " + idAuto + " not found!"));

        return autoConverter.toByIdResponseDto(auto);
    }


    public Auto findByIdReturnAuto(Integer idAuto) {
        return autoRepository.findById(idAuto)
                .orElseThrow(() -> new NotFoundException("Auto with id: " + idAuto + " not found!"));
    }

    public AutoResponseDto findByVinNumber(String vinNumber) {
        Auto auto = autoRepository.findByVinNumber(vinNumber)
                .orElseThrow(() -> new NotFoundException("Auto with vin number: " + vinNumber + " not found!"));
        return autoConverter.toResponse(auto);
    }

    public List<AutoResponseDto> findByBrand(String brand) {
        List<Auto> autos = autoRepository.findByBrand(brand);

        if (autos.isEmpty()) {
            throw new NotFoundException("Auto with brand: " + brand + " not found!");
        }

        return autos.stream()
                .map(autoConverter::toResponse)
                .toList();
    }

    public List<AutoResponseDto> findByModel(String model) {
        List<Auto> autos = autoRepository.findByModel(model);

        if (autos.isEmpty()) {
            throw new NotFoundException("Auto with model: " + model + " not found!");
        }

        return autos.stream()
                .map(autoConverter::toResponse)
                .toList();
    }

}
