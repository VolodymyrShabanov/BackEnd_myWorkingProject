package myworkingproject.dto.autoDto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AutoCreateResponseDto {
    private Integer id;
    private String vinNumber;
    private String brand;
    private String model;
}
