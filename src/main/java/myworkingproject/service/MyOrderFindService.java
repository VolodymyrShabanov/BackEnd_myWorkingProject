package myworkingproject.service;

import lombok.AllArgsConstructor;
import myworkingproject.dto.orderDto.MyOrderByIdResponseDto;
import myworkingproject.dto.orderDto.MyOrderResponseDto;
import myworkingproject.entity.Auto;
import myworkingproject.entity.MyOrder;
import myworkingproject.entity.OrderStatus;
import myworkingproject.repository.MyOrderRepository;
import myworkingproject.service.converter.MyOrderConverter;
import myworkingproject.service.exeption.NotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
@AllArgsConstructor
public class MyOrderFindService {
    private final MyOrderRepository myOrderRepository;
    private AutoFindService autoFindService;
    private MyOrderConverter myOrderConverter;



    public List<MyOrderResponseDto> findAll(){
        return myOrderRepository.findAll().stream()
                .map(myOrderConverter::toResponse)
                .toList();
    }

    public MyOrderByIdResponseDto findById(Integer idMyOrder){
        MyOrder myOrder = myOrderRepository.findById(idMyOrder)
                .orElseThrow(() -> new NotFoundException("Order with id: " + idMyOrder + " not found"));

        return myOrderConverter.toByIdResponse(myOrder);
    }

    public List<MyOrderResponseDto> findByIdAuto(Integer idAuto){
        Auto foundAuto = autoFindService.findByIdReturnAuto(idAuto);

         return myOrderRepository.findByAuto(foundAuto).stream()
                 .map(myOrderConverter::toResponse)
                 .toList();
    }

    public List<MyOrderResponseDto> findByCreateDateBetween(String createDateFrom, String createDateTo){

        // Преобразование строки createDate в LocalDateTime С НАЧАЛОМ ДНЯ
        LocalDateTime startDateTime = LocalDateTime.parse(createDateFrom + "T00:00:00");

        // Преобразование строки createDate в LocalDateTime С КОНЦОМ ДНЯ
        LocalDateTime endDateTime = LocalDateTime.parse(createDateTo + "T23:59:59");

        System.out.println("Target date: " + startDateTime);

        return myOrderRepository.findByCreateDateBetween(startDateTime, endDateTime).stream()
                .map(myOrderConverter::toResponse)
                .toList();
    }


    public List<MyOrderResponseDto> findByStatus(String status){
        OrderStatus foundOrderStatus = OrderStatus.fromString(status);

        return myOrderRepository.findByStatus(foundOrderStatus).stream()
                .map(myOrder -> myOrderConverter.toResponse(myOrder))
                .toList();

    }



}
