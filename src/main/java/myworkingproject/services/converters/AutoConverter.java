package myworkingproject.services.converters;

import myworkingproject.dto.autos.AutoByIdResponseDto;
import myworkingproject.dto.autos.AutoListMyOrderDto;
import myworkingproject.dto.autos.AutoRequestDto;
import myworkingproject.dto.autos.AutoResponseDto;
import myworkingproject.entitys.Auto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutoConverter {

    public Auto fromRequest(AutoRequestDto requestDto) {
        Auto newAuto = new Auto();
        newAuto.setVinNumber(requestDto.getVinNumber());
        newAuto.setBrand(requestDto.getBrand());
        newAuto.setModel(requestDto.getModel());

        return newAuto;
    }

    public AutoResponseDto toResponse(Auto auto) {
        return new AutoResponseDto(auto.getIdAuto(),
                auto.getVinNumber(),
                auto.getBrand(),
                auto.getModel());
    }

    public AutoByIdResponseDto toByIdResponseDto(Auto auto) {
        List<AutoListMyOrderDto> autoMyOrders = auto.getMyOrders().stream()
                .map(myOrder ->
                        new AutoListMyOrderDto(
                                myOrder.getIdMyOrder(),
                                myOrder.getLastUpdate(),
                                myOrder.getStatus(),
                                myOrder.getDescription()
                        )
                )
                .toList();

        return new AutoByIdResponseDto(auto.getIdAuto(),
                auto.getVinNumber(),
                auto.getBrand(),
                auto.getModel(),
                autoMyOrders);
    }

}
