package myworkingproject.controllers.spare_parts;

import lombok.AllArgsConstructor;
import myworkingproject.dto.spare_parts.SparePartResponseDto;
import myworkingproject.services.spare_parts.SparePartUpdateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/spareParts")
@AllArgsConstructor
public class SparePartUpdateController {
    private final SparePartUpdateService sparePartUpdateService;


    @PutMapping(value = "updateSparePart/{idSparePart}")
    public ResponseEntity<SparePartResponseDto> updateSparePartById(@PathVariable Integer idSparePart, @RequestParam String description) {
        return ResponseEntity.ok(sparePartUpdateService.updateSparePartById(idSparePart, description));
    }
}
