package myworkingproject.dto.autoDto;

import lombok.Data;

@Data
public class AutoCreateRequestDto {
    private String vinNumber;
    private String brand;
    private String model;
}
