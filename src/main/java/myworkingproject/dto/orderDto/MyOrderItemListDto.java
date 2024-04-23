package myworkingproject.dto.orderDto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MyOrderItemListDto {
    private Integer idSparePart;
    private String nameSparePart;
    private Integer quantity;
}
