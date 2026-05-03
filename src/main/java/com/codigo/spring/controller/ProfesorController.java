package com.codigo.spring.controller;

import com.codigo.spring.request.ProfesorRequest;
import com.codigo.spring.response.ProfesorResponse;
import com.codigo.spring.response.ResponseBase;
import com.codigo.spring.service.ProfesorService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/profesor")
@Tag(name = "Profesor", description = "Endpoints para crear y consultar profesores")
public class ProfesorController {

    private final ProfesorService profesorService;

    public ProfesorController(ProfesorService profesorService) {
        this.profesorService = profesorService;
    }

    @PostMapping("/save")
    public ResponseBase<ProfesorResponse> save(@Valid @RequestBody ProfesorRequest request) {
        ProfesorResponse saved = profesorService.save(request);
        return new ResponseBase<>(200, "Profesor guardado correctamente", saved);
    }

    @GetMapping("/get/{dni}")
    public ResponseBase<ProfesorResponse> getByDni(@PathVariable String dni) {

        Optional<ProfesorResponse> optional = profesorService.getById(dni);

        if (optional.isPresent()) {
            return new ResponseBase<>(200, "Profesor encontrado", optional.get());
        } else {
            return new ResponseBase<>(404, "Profesor no encontrado", null);
        }
    }
}
