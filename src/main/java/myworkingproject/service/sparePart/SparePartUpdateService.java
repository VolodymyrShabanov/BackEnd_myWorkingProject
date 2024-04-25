package myworkingproject.service.sparePart;

import lombok.AllArgsConstructor;
import myworkingproject.dto.sparePartDto.SparePartRequestDto;
import myworkingproject.dto.sparePartDto.SparePartResponseDto;
import myworkingproject.entity.SparePart;
import myworkingproject.repository.SparePartRepository;
import myworkingproject.service.converter.SparePartConverter;
import myworkingproject.service.exeption.NotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SparePartUpdateService {
    private final SparePartRepository sparePartRepository;
    private SparePartConverter sparePartConverter;

//    public SparePart take(SparePart sparePart, Integer quantity) {
//        Integer balance = sparePart.getQuantity();
//
//        if (balance < quantity) {
//            throw new CalculateException("Not enough spare parts, the balance: " + balance);
//        }
//
//        sparePart.setQuantity(balance - quantity);
//        return sparePart;
//    }

    public SparePartResponseDto updateSparePartById(Integer idSparePart, String description){

        SparePart updateSparePart = sparePartRepository.findByIdSparePart(idSparePart)
                .orElseThrow(() -> new NotFoundException("Spare part with id: " + idSparePart + " not found"));

        if (description != null) {
            updateSparePart.setDescription(description);
        }

        return sparePartConverter.toResponse(sparePartRepository.save(updateSparePart));
    }


}
