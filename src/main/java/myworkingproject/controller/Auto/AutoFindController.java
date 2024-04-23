package myworkingproject.controller.Auto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;


import lombok.extern.slf4j.Slf4j;
import myworkingproject.dto.autoDto.AutoByIdResponseDto;
import myworkingproject.dto.autoDto.AutoResponseDto;
import myworkingproject.entity.Auto;
import myworkingproject.service.AutoFindService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/api/autos")
@AllArgsConstructor

public class AutoFindController {

    private final AutoFindService autoFindService;

    @GetMapping
    @Operation(summary = "Get all AUTO")
    @ApiResponse(responseCode = "200",
            description = "Successfully!!!",
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Auto.class)),})
    public ResponseEntity<List<AutoResponseDto>> findAll(){
        return new ResponseEntity<>(autoFindService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{idAuto}")
    @Operation(summary = "Get AUTO by ID")
    @ApiResponse(responseCode = "200",
            description = "Successfully!!!",
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Auto.class)),})

    public ResponseEntity<AutoByIdResponseDto> findById(@PathVariable("idAuto") Integer idAuto){
        return new ResponseEntity<>(autoFindService.findById(idAuto), HttpStatus.OK);
    }

    @GetMapping("/") // тут вопрос как правильно организзовать запрос по параметрам
    public ResponseEntity<AutoResponseDto> findByVinNumber(@RequestParam String vinNumber){
        return new ResponseEntity<>(autoFindService.findByVinNumber(vinNumber), HttpStatus.OK);
    }
    @GetMapping(params = "brand")
    public ResponseEntity<List<AutoResponseDto>> findByBrand(@RequestParam String brand){
        return new ResponseEntity<>(autoFindService.findByBrand(brand), HttpStatus.OK);
    }

    @GetMapping(params = "model")
    public ResponseEntity<List<AutoResponseDto>> findByModel(@RequestParam String model){
        return new ResponseEntity<>(autoFindService.findByModel(model), HttpStatus.OK);
    }

}
