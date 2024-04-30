package myworkingproject.dto.my_orders;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MyOrderRequestDto {
 private Integer idAuto;
 private String description;

}
