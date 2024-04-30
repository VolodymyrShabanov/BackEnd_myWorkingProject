package myworkingproject.controllers.spare_parts;

import lombok.AllArgsConstructor;
import myworkingproject.dto.spare_parts.SparePartRequestDto;
import myworkingproject.dto.spare_parts.SparePartResponseDto;
import myworkingproject.services.spare_parts.SparePartCreateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
