package myworkingproject.controller.myOrderItem;

import lombok.AllArgsConstructor;
import myworkingproject.dto.myOrderItemDto.MyOrderItemResponseDto;
import myworkingproject.service.MyOrderItemFindService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/orderItems")
public class myOrderItemFindController {
    private MyOrderItemFindService myOrderItemFindService;

    @GetMapping
    public ResponseEntity<List<MyOrderItemResponseDto>> findAll(){
        return new ResponseEntity<>(myOrderItemFindService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{idMyOrderItem}")
    public ResponseEntity<MyOrderItemResponseDto> findById(@PathVariable Integer idMyOrderItem){
        return new ResponseEntity<>(myOrderItemFindService.findById(idMyOrderItem), HttpStatus.OK);
    }

    @GetMapping("/idSparePart:{idSparePart}")
    public ResponseEntity<List<MyOrderItemResponseDto>> findByIdSparePart(@PathVariable Integer idSparePart){
        return new ResponseEntity<>(myOrderItemFindService.findByIdSparePart(idSparePart), HttpStatus.OK);
    }

    @GetMapping("/idOrder:{idOrder}")
    public ResponseEntity<List<MyOrderItemResponseDto>> findByIdOrder(@PathVariable Integer idOrder){
        return new ResponseEntity<>(myOrderItemFindService.findByIdMyOrder(idOrder), HttpStatus.OK);
    }

}
