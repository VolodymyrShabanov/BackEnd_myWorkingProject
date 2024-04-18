package myworkingproject.dto.autoDto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AutoResponseDto {
    private Integer id;
    private String vinNumber;
    private String brand;
    private String model;
}
