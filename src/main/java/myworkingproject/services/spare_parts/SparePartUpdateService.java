package myworkingproject.services.spare_parts;

import lombok.AllArgsConstructor;
import myworkingproject.dto.spare_parts.SparePartResponseDto;
import myworkingproject.entitys.SparePart;
import myworkingproject.repositories.SparePartRepository;
import myworkingproject.services.converters.SparePartConverter;
import myworkingproject.services.exeptions.NotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SparePartUpdateService {
    private final SparePartRepository sparePartRepository;
    private SparePartConverter sparePartConverter;

    public SparePartResponseDto updateSparePartById(Integer idSparePart, String description) {

        SparePart updateSparePart = sparePartRepository.findByIdSparePart(idSparePart)
                .orElseThrow(() -> new NotFoundException("Spare part with id: " + idSparePart + " not found"));

        if (description != null) {
            updateSparePart.setDescription(description);
        }

        return sparePartConverter.toResponse(sparePartRepository.save(updateSparePart));
    }


}
