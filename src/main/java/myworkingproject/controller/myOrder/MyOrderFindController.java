package myworkingproject.controller.myOrder;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import lombok.AllArgsConstructor;
import myworkingproject.dto.orderDto.MyOrderByIdResponseDto;
import myworkingproject.dto.orderDto.MyOrderResponseDto;
import myworkingproject.entity.MyOrder;
import myworkingproject.service.MyOrderFindService;
import myworkingproject.service.exeption.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tags(
        @Tag(name = "Orders")
)

@RestController
@AllArgsConstructor
@RequestMapping("api/myOrders")
public class MyOrderFindController {
    private MyOrderFindService myOrderFindService;

    @GetMapping("/all")
    public ResponseEntity<List<MyOrderResponseDto>> findAll(){
        return new ResponseEntity<>(myOrderFindService.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Find order by Id", description = "available to everyone")
    @ApiResponses(value = {
            @ApiResponse (responseCode = "200",
                    description = "we get order",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = MyOrderByIdResponseDto.class))),

            @ApiResponse (responseCode = "400",
                    description = "Bad REQUEST",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(
                                    type = "string",  // Указываем, что возвращаемый тип - String
                                    description = "not valid ....."))),  // Описание возвращаемой строки)), // -> ?????????

            @ApiResponse (responseCode = "404",
                    description = "Order with id - not exist!!",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(
                                    type = "string",  // Указываем, что возвращаемый тип - String
                                    description = "not valid ....."))),  // Описание возвращаемой строки)), // -> ?????????
    })

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
