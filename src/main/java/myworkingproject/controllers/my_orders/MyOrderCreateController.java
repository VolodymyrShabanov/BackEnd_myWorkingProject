package myworkingproject.controllers.my_orders;

import lombok.AllArgsConstructor;
import myworkingproject.dto.my_orders.MyOrderRequestDto;
import myworkingproject.dto.my_orders.MyOrderResponseDto;
import myworkingproject.services.my_orders.MyOrderCreateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/myOrders")
public class MyOrderCreateController {
    private final MyOrderCreateService myOrderCreateService;

    @RequestMapping("/createMyOrders")
    public ResponseEntity<MyOrderResponseDto> createMyOrder(@RequestBody MyOrderRequestDto request) {
        return new ResponseEntity<>(myOrderCreateService.createMyOrder(request), HttpStatus.OK);
    }
}
