package myworkingproject.dto.my_orders;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import myworkingproject.entitys.OrderStatus;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class MyOrderResponseDto {
    private Integer idMyOrder;
    private Integer idAuto;
    private LocalDateTime createDate;
    private LocalDateTime lastUpdate;
    private OrderStatus status;
    private String description;
}
