package com.codigo.spring.controller;

import com.codigo.spring.request.EstudianteRequest;
import com.codigo.spring.response.EstudianteResponse;
import com.codigo.spring.response.ResponseBase;
import com.codigo.spring.service.EstudianteService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/estudiante")
@Tag(name = "Estudiante", description = "Endpoints para crear y consultar estudiantes")
public class EstudianteController {

    private final EstudianteService estudianteService;

    public EstudianteController(EstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    @PostMapping("/save")
    public ResponseBase<EstudianteResponse> save(@Valid @RequestBody EstudianteRequest request) {
        EstudianteResponse saved = estudianteService.save(request);
        return new ResponseBase<>(200, "Estudiante guardado correctamente", saved);
    }

    @GetMapping("/get/{dni}")
    public ResponseBase<EstudianteResponse> getById(@PathVariable String dni) {
        Optional<EstudianteResponse> optional = estudianteService.getById(dni);
        if (optional.isPresent()) {
            return new ResponseBase<>(200, "Estudiante encontrado", optional.get());
        } else {
            return new ResponseBase<>(404, "Estudiante no encontrado", null);
        }
    }
}
