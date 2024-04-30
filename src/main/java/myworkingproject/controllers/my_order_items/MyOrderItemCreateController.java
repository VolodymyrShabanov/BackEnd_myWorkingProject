package myworkingproject.controllers.my_order_items;

import lombok.AllArgsConstructor;
import myworkingproject.services.my_order_items.MyOrderItemCreateService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/orderItems")
public class MyOrderItemCreateController {

    private final MyOrderItemCreateService myOrderItemCreateService;

}
