package myworkingproject.controllers.my_orders;

import lombok.AllArgsConstructor;
import myworkingproject.dto.my_order_items.MyOrderItemRequestDto;
import myworkingproject.dto.my_orders.MyOrderByIdResponseDto;
import myworkingproject.dto.my_orders.MyOrderResponseDto;
import myworkingproject.services.my_orders.MyOrderUpdateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/myOrders")
public class MyOrderUpdateController {
    private final MyOrderUpdateService myOrderUpdateService;

    @PutMapping(value = "/updateOrder/{idMyOrder}")
    public ResponseEntity<MyOrderResponseDto> updateOrderById(@PathVariable Integer idMyOrder,
                                                              @RequestParam(required = false) String status,
                                                              @RequestParam(required = false) String description) {
        return ResponseEntity.ok(myOrderUpdateService.updateOrderById(idMyOrder, status, description));
    }

    @PutMapping("/addOrderItem")
    public ResponseEntity<MyOrderByIdResponseDto> addItemToOrder(@RequestBody MyOrderItemRequestDto request){
        return ResponseEntity.ok(myOrderUpdateService.addItemToOrder(request));
    }

    @PutMapping("/updateQuantityItem")
    public ResponseEntity<MyOrderByIdResponseDto> updateQuantityItemToOrder(@RequestParam Integer idMyOrder,
                                                                            @RequestParam Integer idMyOrderItem,
                                                                            @RequestParam Integer quantity){
        return ResponseEntity.ok(myOrderUpdateService.updateQuantityItemToOrder(idMyOrder, idMyOrderItem, quantity));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<MyOrderByIdResponseDto> deleteMyOrderItemFromMyOrder(@RequestParam Integer idMyOrder,
                                                                            @RequestParam Integer idMyOrderItem){
        return ResponseEntity.ok(myOrderUpdateService.deleteMyOrderItemFromMyOrder(idMyOrder, idMyOrderItem));
    }

}
