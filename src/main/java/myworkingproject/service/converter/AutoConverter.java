package myworkingproject.service.converter;

import myworkingproject.dto.autoDto.AutoCreateRequestDto;
import myworkingproject.dto.autoDto.AutoCreateResponseDto;
import myworkingproject.entity.Auto;
import org.springframework.stereotype.Service;

@Service
public class AutoConverter {

    public Auto fromCreateRequest(AutoCreateRequestDto requestDto) {
        Auto newAuto = new Auto();
        newAuto.setVinNumber(requestDto.getVinNumber());
        newAuto.setBrand(requestDto.getBrand());
        newAuto.setModel(requestDto.getModel());

        return newAuto;
    }

    public AutoCreateResponseDto toCreateResponse(Auto auto) {
        return new AutoCreateResponseDto(auto.getIdAuto(), auto.getVinNumber(), auto.getBrand(), auto.getModel());
    }
}
