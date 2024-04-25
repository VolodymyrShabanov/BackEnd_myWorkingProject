package myworkingproject.controllers.myOrderItem;

import lombok.AllArgsConstructor;
import myworkingproject.dto.myOrderItemDto.MyOrderItemRequestDto;
import myworkingproject.dto.myOrderItemDto.MyOrderItemResponseDto;
import myworkingproject.service.myOrderItem.MyOrderItemCreateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/orderItems")
public class MyOrderItemCreateController {

    private final MyOrderItemCreateService myOrderItemCreateService;

//    @PostMapping("/createOrderItem")
//    public ResponseEntity<MyOrderItemResponseDto> createOrderItem(@RequestBody MyOrderItemRequestDto request) {
//        return new ResponseEntity<>(myOrderItemCreateService.createOrderItem(request), HttpStatus.OK);
//    }

}
