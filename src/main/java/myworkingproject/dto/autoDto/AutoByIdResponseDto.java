package myworkingproject.dto.autoDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AutoByIdResponseDto {
    private Integer id;
    private String vinNumber;
    private String brand;
    private String model;
    private List<AutoListMyOrderDto> myOrdersList;


}
