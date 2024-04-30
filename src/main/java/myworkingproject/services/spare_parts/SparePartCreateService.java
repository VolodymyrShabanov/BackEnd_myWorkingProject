package myworkingproject.services.spare_parts;

import lombok.AllArgsConstructor;
import myworkingproject.dto.spare_parts.SparePartRequestDto;
import myworkingproject.dto.spare_parts.SparePartResponseDto;
import myworkingproject.entitys.SparePart;
import myworkingproject.repositories.SparePartRepository;
import myworkingproject.services.converters.SparePartConverter;
import myworkingproject.services.exeptions.AlreadyExistException;
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
