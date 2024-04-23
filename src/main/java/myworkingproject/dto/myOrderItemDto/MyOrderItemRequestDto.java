package myworkingproject.dto.myOrderItemDto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MyOrderItemRequestDto {
    private Integer idSparePart;
    private Integer idMyOrder;
    private Integer quantity;

}


