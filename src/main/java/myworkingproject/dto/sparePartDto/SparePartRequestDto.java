package myworkingproject.dto.sparePartDto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SparePartRequestDto {
    private String name;
    private Integer quantity;
    private String description;
}
