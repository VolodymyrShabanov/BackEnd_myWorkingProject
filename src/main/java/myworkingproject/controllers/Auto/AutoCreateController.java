package myworkingproject.controllers.Auto;

import lombok.AllArgsConstructor;
import myworkingproject.dto.autoDto.AutoRequestDto;
import myworkingproject.dto.autoDto.AutoResponseDto;
import myworkingproject.service.auto.AutoCreateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/autos")
public class AutoCreateController {
    private final AutoCreateService autoCreateService;

    @PostMapping("/createAuto")
    public ResponseEntity<AutoResponseDto> createAuto(@RequestBody AutoRequestDto request){
        return new ResponseEntity<>(autoCreateService.createAuto(request), HttpStatus.CREATED);
    }
}
