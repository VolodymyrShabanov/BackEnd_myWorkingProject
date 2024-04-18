package myworkingproject.service;

import lombok.AllArgsConstructor;
import myworkingproject.dto.autoDto.AutoRequestDto;
import myworkingproject.dto.autoDto.AutoResponseDto;
import myworkingproject.entity.Auto;
import myworkingproject.repository.AutoRepository;
import myworkingproject.service.converter.AutoConverter;
import myworkingproject.service.exeption.AlreadyExistException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
//@RequiredArgsConstructor
public class AutoCreateService {
     private final AutoRepository autoRepository;
     private AutoConverter autoConverter;

     public AutoResponseDto createAuto(AutoRequestDto request){
         if (autoRepository.findByVinNumber(request.getVinNumber()).isEmpty()){

             Auto newAuto = autoConverter.fromRequest(request);
             return autoConverter.toResponse(autoRepository.save(newAuto));
         } else {
             throw new AlreadyExistException("Auto with VIN Number: " + request.getVinNumber() + " all ready exist!");
         }

     }
}
