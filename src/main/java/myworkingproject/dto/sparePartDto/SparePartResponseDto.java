package myworkingproject.dto.sparePartDto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SparePartResponseDto {
    private Integer idSparePart;
    private String name;
    private Integer quantity;
    private String description;

}
