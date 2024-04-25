package myworkingproject.dto.orderDto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MyOrderItemListDto {
    private Integer isOrderItem;
    private Integer idSparePart;
    private String nameSparePart;
    private Integer quantity;
}
