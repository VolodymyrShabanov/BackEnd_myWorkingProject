package myworkingproject.controllers.autos;

import lombok.AllArgsConstructor;
import myworkingproject.dto.autos.AutoRequestDto;
import myworkingproject.dto.autos.AutoResponseDto;
import myworkingproject.services.autos.AutoCreateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/autos")
public class AutoCreateController {
    private final AutoCreateService autoCreateService;

    @PostMapping("/createAuto")
    public ResponseEntity<AutoResponseDto> createAuto(@RequestBody AutoRequestDto request) {
        return new ResponseEntity<>(autoCreateService.createAuto(request), HttpStatus.CREATED);
    }
}
