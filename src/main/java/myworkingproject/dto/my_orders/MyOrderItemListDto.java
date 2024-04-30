package myworkingproject.dto.my_orders;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MyOrderItemListDto {
    private Integer idMyOrderItem;
    private Integer idSparePart;
    private String nameSparePart;
    private Integer quantity;
}
