package myworkingproject.controllers.myOrder;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import myworkingproject.dto.myOrderItemDto.MyOrderItemRequestDto;
import myworkingproject.dto.orderDto.MyOrderByIdResponseDto;
import myworkingproject.dto.orderDto.MyOrderResponseDto;
import myworkingproject.service.myOrder.MyOrderUpdateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/myOrders")
public class MyOrderUpdateController {
    private final MyOrderUpdateService myOrderUpdateService;

    @PutMapping(value = "/updateOrder/{idOrder}")
    public ResponseEntity<MyOrderResponseDto> updateOrderById(@PathVariable Integer idOrder,
                                                              @RequestParam(required = false) String status,
                                                              @RequestParam(required = false) String description) {
        return ResponseEntity.ok(myOrderUpdateService.updateOrderById(idOrder, status, description));
    }

    @PutMapping("/addOrderItem")
    public ResponseEntity<MyOrderByIdResponseDto> addItemToOrder(@RequestBody MyOrderItemRequestDto request){
        return ResponseEntity.ok(myOrderUpdateService.addItemToOrder(request));
    }

    @PutMapping("/updateQuantityItem")
    // нужно доработать - нет понимания какой idOrderItem нужно поменять,
    // а так же если в одном и том же заказе есть несколько одинаковых запчастей как их учитывать при анализе доступного количества запчастей

    public ResponseEntity<MyOrderByIdResponseDto> updateQuantityItemToOrder(@RequestParam Integer idOrder,
                                                                            @RequestParam Integer idOrderItem,
                                                                            @RequestParam Integer quantity){
        return ResponseEntity.ok(myOrderUpdateService.updateQuantityItemToOrder(idOrder, idOrderItem, quantity));
    }
//
//    @DeleteMapping("/delete")
//    public ResponseEntity<MyOrderByIdResponseDto> updateQuantityItemToOrder(@RequestParam Integer idOrder,
//                                                                            @RequestParam Integer idOrderItem){
//        return ResponseEntity.ok(myOrderUpdateService.deleteItemToOrder(idOrder, idOrderItem));
//    }

    @DeleteMapping("/delete")
    @Transactional
    public ResponseEntity<MyOrderByIdResponseDto> deleteItemFormOrder(@RequestParam Integer idOrderItem){
        return ResponseEntity.ok(myOrderUpdateService.deleteItemToOrder(idOrderItem));
    }
}
