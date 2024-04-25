package myworkingproject.service.myOrder;

import lombok.AllArgsConstructor;
import myworkingproject.dto.orderDto.MyOrderRequestDto;
import myworkingproject.dto.orderDto.MyOrderResponseDto;
import myworkingproject.entity.Auto;
import myworkingproject.entity.MyOrder;
import myworkingproject.repository.MyOrderRepository;
import myworkingproject.service.auto.AutoFindService;
import myworkingproject.service.converter.MyOrderConverter;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MyOrderCreateService {
    private final MyOrderRepository myOrderRepository;
    private MyOrderConverter myOrderConverter;
    private AutoFindService autoFindService;

    public MyOrderResponseDto createMyOrder(MyOrderRequestDto request){

        Integer idAutoFromRequest = request.getIdAuto();

        Auto foundAuto = autoFindService.findByIdReturnAuto(idAutoFromRequest);

        MyOrder newMyOrder = myOrderConverter.fromRequest(request, foundAuto);

        return myOrderConverter.toResponse(myOrderRepository.save(newMyOrder));
    }
}
