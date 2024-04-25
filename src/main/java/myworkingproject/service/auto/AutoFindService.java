package myworkingproject.service.auto;

import lombok.AllArgsConstructor;
import myworkingproject.dto.autoDto.AutoByIdResponseDto;
import myworkingproject.dto.autoDto.AutoResponseDto;
import myworkingproject.entity.Auto;
import myworkingproject.repository.AutoRepository;
import myworkingproject.service.converter.AutoConverter;
import myworkingproject.service.exeption.NotFoundException;
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
        Auto auto = autoRepository.findById(idAuto)
                .orElseThrow(() -> new NotFoundException("Auto with id: " + idAuto + " not found!"));
        return auto;
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
