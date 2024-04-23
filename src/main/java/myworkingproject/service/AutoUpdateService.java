package myworkingproject.service;

import lombok.AllArgsConstructor;
import myworkingproject.dto.autoDto.AutoRequestDto;
import myworkingproject.dto.autoDto.AutoResponseDto;
import myworkingproject.entity.Auto;
import myworkingproject.repository.AutoRepository;
import myworkingproject.service.converter.AutoConverter;
import myworkingproject.service.exeption.NotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AutoUpdateService {
    private final AutoRepository autoRepository;
    private AutoConverter autoConverter;

//    public AutoResponseDto updateAutoByVinNumber(String vinNumber, AutoRequestDto request){
//
//        Auto updateAuto = autoRepository.findByVinNumber(vinNumber)
//                .orElseThrow( () -> new NotFoundException("Auto with VIN Number: " + vinNumber + " not found"));
//
//        if (request.getBrand() != null){
//        updateAuto.setBrand(request.getBrand());
//        }
//
//        if(request.getModel() != null){
//        updateAuto.setModel(request.getModel());
//        }
//
//        Auto saveAuto = autoRepository.save(updateAuto);
//
//        return autoConverter.toResponse(saveAuto);
//    }

    public AutoResponseDto updateAutoByVinNumber(AutoRequestDto request){

        Auto updateAuto = autoRepository.findByVinNumber(request.getVinNumber())
                .orElseThrow( () -> new NotFoundException("Auto with VIN Number: " + request.getVinNumber() + " not found"));

        if (request.getBrand() != null){
        updateAuto.setBrand(request.getBrand());
    }

        if(request.getModel() != null){
        updateAuto.setModel(request.getModel());
    }

        Auto saveAuto = autoRepository.save(updateAuto);

        return autoConverter.toResponse(saveAuto);
    }
}
