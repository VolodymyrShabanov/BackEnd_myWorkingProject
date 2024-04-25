package myworkingproject.controllers.sparePart;

import lombok.AllArgsConstructor;
import myworkingproject.dto.sparePartDto.SparePartRequestDto;
import myworkingproject.dto.sparePartDto.SparePartResponseDto;
import myworkingproject.service.sparePart.SparePartCreateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/spareParts")
@AllArgsConstructor
public class SparePartCreateController {

    private final SparePartCreateService sparePartCreateService;

    @PostMapping("/createSparePart")
    public ResponseEntity<SparePartResponseDto> createSparePart(@RequestBody SparePartRequestDto request) {
        return new ResponseEntity<>(sparePartCreateService.createSparePart(request), HttpStatus.OK);
    }
}
