package myworkingproject.dto.orderDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import myworkingproject.entity.OrderStatus;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class MyOrderResponseDto {
    private Integer idOrder;
    private Integer idAuto;
    private LocalDateTime createDate;
    private LocalDateTime lastUpdate;
    private OrderStatus status;
    private String description;
}
