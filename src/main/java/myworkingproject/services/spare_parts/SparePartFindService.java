package myworkingproject.services.spare_parts;

import lombok.AllArgsConstructor;
import myworkingproject.dto.spare_parts.SparePartResponseDto;
import myworkingproject.entitys.SparePart;
import myworkingproject.repositories.SparePartRepository;
import myworkingproject.services.converters.SparePartConverter;
import myworkingproject.services.exeptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SparePartFindService {
    private final SparePartRepository sparePartRepository;
    private SparePartConverter sparePartConverter;

    public List<SparePartResponseDto> findAll() {
        return sparePartRepository.findAll().stream()
                .map(sparePartConverter::toResponse)
                .toList();
    }

    public SparePartResponseDto findById(Integer idSparePart) {
        SparePart foundSparePart = sparePartRepository.findByIdSparePart(idSparePart)
                .orElseThrow(() -> new NotFoundException("Spare part with id: " + idSparePart + " not found"));

        return sparePartConverter.toResponse(foundSparePart);
    }

    public SparePart findByIdReturnSparePart(Integer idSparePart) {
        return sparePartRepository.findByIdSparePart(idSparePart)
                .orElseThrow(() -> new NotFoundException("Spare part with id: " + idSparePart + " not found"));
    }


    public SparePartResponseDto findByName(String name) {
        SparePart foundSparePart = sparePartRepository.findByName(name)
                .orElseThrow(() -> new NotFoundException("Spare part with name " + name + " not found"));

        return sparePartConverter.toResponse(foundSparePart);
    }


}
