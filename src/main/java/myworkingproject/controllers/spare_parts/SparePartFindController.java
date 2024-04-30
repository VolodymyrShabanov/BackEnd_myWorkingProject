package myworkingproject.controllers.spare_parts;

import lombok.AllArgsConstructor;
import myworkingproject.dto.spare_parts.SparePartResponseDto;
import myworkingproject.services.spare_parts.SparePartFindService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/spareParts")
public class SparePartFindController {
    private final SparePartFindService sparePartFindService;

    @GetMapping
    public ResponseEntity<List<SparePartResponseDto>> findAll() {
        return new ResponseEntity<>(sparePartFindService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{idSparePart}")
    public ResponseEntity<SparePartResponseDto> findById(@PathVariable Integer idSparePart) {
        return new ResponseEntity<>(sparePartFindService.findById(idSparePart), HttpStatus.OK);
    }

    @GetMapping(params = "name")
    public ResponseEntity<SparePartResponseDto> findByName(@RequestParam String name) {
        return new ResponseEntity<>(sparePartFindService.findByName(name), HttpStatus.OK);
    }

}
