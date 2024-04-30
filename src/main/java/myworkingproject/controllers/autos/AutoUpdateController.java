package myworkingproject.controllers.autos;

import lombok.AllArgsConstructor;
import myworkingproject.dto.autos.AutoRequestDto;
import myworkingproject.dto.autos.AutoResponseDto;
import myworkingproject.services.autos.AutoUpdateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/autos")
@AllArgsConstructor
public class AutoUpdateController {
    private AutoUpdateService autoUpdateService;

    @PutMapping("/update")
    public ResponseEntity<AutoResponseDto> updateAutoByVinNumber(@RequestBody AutoRequestDto request) {
        return new ResponseEntity<>(autoUpdateService.updateAutoByVinNumber(request), HttpStatus.OK);
    }
}
