package myworkingproject.services.converters;

import myworkingproject.dto.spare_parts.SparePartRequestDto;
import myworkingproject.dto.spare_parts.SparePartResponseDto;
import myworkingproject.entitys.SparePart;
import org.springframework.stereotype.Service;

@Service
public class SparePartConverter {

    public SparePart fromRequest(SparePartRequestDto responseDto) {
        return SparePart.builder()
                .name(responseDto.getName())
                .quantity(responseDto.getQuantity())
                .description(responseDto.getDescription())
                .build();
    }

    public SparePartResponseDto toResponse(SparePart sparePart) {
        return new SparePartResponseDto(
                sparePart.getIdSparePart(),
                sparePart.getName(),
                sparePart.getQuantity(),
                sparePart.getDescription());
    }
}
