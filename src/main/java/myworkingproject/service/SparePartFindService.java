package myworkingproject.service;

import lombok.AllArgsConstructor;
import myworkingproject.dto.sparePartDto.SparePartResponseDto;
import myworkingproject.entity.SparePart;
import myworkingproject.repository.SparePartRepository;
import myworkingproject.service.converter.SparePartConverter;
import myworkingproject.service.exeption.NotFoundException;
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
                .orElseThrow(() -> new NotFoundException("Spare part with id " + idSparePart + " not found"));

        return sparePartConverter.toResponse(foundSparePart);
    }

    public SparePart findByIdReturnSparePart(Integer idSparePart) {
        SparePart foundSparePart = sparePartRepository.findByIdSparePart(idSparePart)
                .orElseThrow(() -> new NotFoundException("Spare part with id " + idSparePart + " not found"));

        return foundSparePart;
    }


    public SparePartResponseDto findByName(String name) {
        SparePart foundSparePart = sparePartRepository.findByName(name)
                .orElseThrow(() -> new NotFoundException("Spare part with name " + name + " not found"));

        return sparePartConverter.toResponse(foundSparePart);
    }


}
