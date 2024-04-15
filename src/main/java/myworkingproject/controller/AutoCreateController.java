package myworkingproject.controller;

import lombok.AllArgsConstructor;
import myworkingproject.dto.autoDto.AutoCreateRequestDto;
import myworkingproject.dto.autoDto.AutoCreateResponseDto;
import myworkingproject.service.AutoCreateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/autos")
public class AutoCreateController {
    private final AutoCreateService autoCreateService;

    @PostMapping("/createAuto")
    public ResponseEntity<AutoCreateResponseDto> createAuto(@RequestBody AutoCreateRequestDto request){
        return new ResponseEntity<>(autoCreateService.createAuto(request), HttpStatus.CREATED);
    }
}
