package myworkingproject.controller.myOrder;

import lombok.AllArgsConstructor;
import myworkingproject.dto.orderDto.MyOrderRequestDto;
import myworkingproject.dto.orderDto.MyOrderResponseDto;
import myworkingproject.service.MyOrderCreateService;
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
    public ResponseEntity<MyOrderResponseDto> createMyOrder(@RequestBody MyOrderRequestDto request){
        return new ResponseEntity<>(myOrderCreateService.createMyOrder(request), HttpStatus.OK);
    }


}
