package myworkingproject.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import myworkingproject.dto.autoDto.AutoCreateRequestDto;
import myworkingproject.dto.autoDto.AutoCreateResponseDto;
import myworkingproject.entity.Auto;
import myworkingproject.repository.AutoRepository;
import myworkingproject.service.converter.AutoConverter;
import myworkingproject.service.exeption.AlreadyExistException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
//@RequiredArgsConstructor
public class AutoCreateService {
     private final AutoRepository repository;
     private AutoConverter converter;

     public AutoCreateResponseDto createAuto(AutoCreateRequestDto request){
         if (repository.findByVinNumber(request.getVinNumber()).isEmpty()){

             Auto newAuto = converter.fromCreateRequest(request);
             return converter.toCreateResponse(repository.save(newAuto));
         } else {
             throw new AlreadyExistException("Auto with VIN Number: " + request.getVinNumber() + " all ready exist!");
         }

     }
}
