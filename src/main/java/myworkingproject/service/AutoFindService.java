package myworkingproject.service;

import lombok.AllArgsConstructor;
import myworkingproject.dto.autoDto.AutoCreateRequestDto;
import myworkingproject.dto.autoDto.AutoCreateResponseDto;
import myworkingproject.entity.Auto;
import myworkingproject.repository.AutoRepository;
import myworkingproject.service.converter.AutoConverter;
import myworkingproject.service.exeption.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AutoFindService {
    private final AutoRepository repository;
    private AutoConverter converter;

    public List<AutoCreateResponseDto> findAll(){
        return repository.findAll().stream()
                .map(converter::toCreateResponse)
                .toList();
    }

    public AutoCreateResponseDto findById(Integer idAuto) {
        Auto auto = repository.findById(idAuto)
                .orElseThrow(() -> new NotFoundException("Auto with id: " + idAuto + " not found"));
        return converter.toCreateResponse(auto);
    }

    public AutoCreateResponseDto findByVinNumber(String vinNumber) {
        Auto auto = repository.findByVinNumber(vinNumber)
                .orElseThrow(() -> new NotFoundException("Auto with vin number: " + vinNumber + " not found!"));
        return converter.toCreateResponse(auto);
    }

    public List<AutoCreateResponseDto> findByBrand(String brand){
        return repository.findByBrand(brand).stream()
                .map(converter::toCreateResponse)
                .toList();
    }

    public List<AutoCreateResponseDto> findByModel(String model){
        return repository.findByModel(model).stream()
                .map(converter::toCreateResponse)
                .toList();
    }


}
