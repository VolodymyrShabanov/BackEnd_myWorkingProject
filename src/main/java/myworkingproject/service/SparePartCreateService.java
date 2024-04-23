package myworkingproject.service;

import lombok.AllArgsConstructor;
import myworkingproject.dto.sparePartDto.SparePartRequestDto;
import myworkingproject.dto.sparePartDto.SparePartResponseDto;
import myworkingproject.entity.SparePart;
import myworkingproject.repository.SparePartRepository;
import myworkingproject.service.converter.SparePartConverter;
import myworkingproject.service.exeption.AlreadyExistException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SparePartCreateService {
    private final SparePartRepository sparePartRepository;
    private SparePartConverter sparePartConverter;

    public SparePartResponseDto createSparePart(SparePartRequestDto request) {
        if (sparePartRepository.findByName(request.getName()).isEmpty()) {

            SparePart newSparePart = sparePartConverter.fromRequest(request);
            return sparePartConverter.toResponse(sparePartRepository.save(newSparePart));
        }

        throw new AlreadyExistException("Spare part with name: " + request.getName() + " already exist!");
    }


}
