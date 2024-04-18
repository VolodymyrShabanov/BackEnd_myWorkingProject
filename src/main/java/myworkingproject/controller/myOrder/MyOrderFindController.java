package myworkingproject.controller.myOrder;

import lombok.AllArgsConstructor;
import myworkingproject.dto.autoDto.AutoResponseDto;
import myworkingproject.dto.orderDto.MyOrderByIdResponseDto;
import myworkingproject.dto.orderDto.MyOrderResponseDto;
import myworkingproject.service.MyOrderFindService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/myOrders")
public class MyOrderFindController {
    private MyOrderFindService myOrderFindService;

    @GetMapping
    public ResponseEntity<List<MyOrderResponseDto>> findAll(){
        return new ResponseEntity<>(myOrderFindService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{idMyOrder}")
    public ResponseEntity<MyOrderByIdResponseDto> findById (@PathVariable("idMyOrder") Integer idMyOrder){
        return new ResponseEntity<>(myOrderFindService.findById(idMyOrder), HttpStatus.OK);
    }

    @GetMapping("/autos/{idAuto}")
    public ResponseEntity<List<MyOrderResponseDto>> findByIdAuto(@PathVariable("idAuto") Integer idAuto){
        return new ResponseEntity<>(myOrderFindService.findByIdAuto(idAuto), HttpStatus.OK);
    }


    @GetMapping(params = "createDate")
    public ResponseEntity<List<MyOrderResponseDto>> findByCreateDate(@RequestParam String createDate){
        System.out.println(createDate);
        return new ResponseEntity<>(myOrderFindService.findByCreateDateBetween(createDate, createDate), HttpStatus.OK);
    }

    @GetMapping(params = {"createDateFrom", "createDateTo"})
    public ResponseEntity<List<MyOrderResponseDto>> findByCreateDateFromPeriod(@RequestParam String createDateFrom,
                                                                               @RequestParam String createDateTo){
    return new ResponseEntity<>(myOrderFindService.findByCreateDateBetween(createDateFrom, createDateTo), HttpStatus.OK);
    }

    @GetMapping(params = "status")
    public ResponseEntity<List<MyOrderResponseDto>> findByStatus(@RequestParam String status){
        return new ResponseEntity<>(myOrderFindService.findByStatus(status), HttpStatus.OK);
    }


}
