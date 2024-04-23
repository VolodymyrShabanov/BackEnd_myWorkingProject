package myworkingproject.controller.Auto;

import lombok.AllArgsConstructor;
import myworkingproject.dto.autoDto.AutoRequestDto;
import myworkingproject.dto.autoDto.AutoResponseDto;
import myworkingproject.service.AutoUpdateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/autos")
@AllArgsConstructor
public class AutoUpdateController {
    private AutoUpdateService autoUpdateService;

//    @PutMapping("/update/{vinNumber}")
//    public ResponseEntity<AutoResponseDto> updateAutoByVinNumber(@PathVariable String vinNumber, @RequestBody AutoRequestDto request){
//        return new ResponseEntity<>(autoUpdateService.updateAutoByVinNumber(vinNumber, request), HttpStatus.OK);
//    }

    @PutMapping("/update")
    public ResponseEntity<AutoResponseDto> updateAutoByVinNumber(@RequestBody AutoRequestDto request){
        return new ResponseEntity<>(autoUpdateService.updateAutoByVinNumber(request), HttpStatus.OK);
    }
}
