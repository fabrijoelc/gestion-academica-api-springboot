package com.codigo.spring.controller;

import com.codigo.spring.request.CursoRequest;
import com.codigo.spring.request.CursoUpdateRequest;
import com.codigo.spring.response.CursoResponse;
import com.codigo.spring.response.ResponseBase;
import com.codigo.spring.service.CursoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/curso")
@Tag(name = "Curso", description = "Endpoints para crear, consultar y actualizar cursos")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @PostMapping("/save")
    public ResponseBase<CursoResponse> saveCurso(@Valid @RequestBody CursoRequest request) {
        return cursoService.save(request);
    }

    @GetMapping("/get/{id}")
    public ResponseBase<CursoResponse> getById(@PathVariable int id) {
        return cursoService.getById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseBase<CursoResponse> updateCurso(
            @PathVariable int id,
            @Valid @RequestBody CursoUpdateRequest request) {
        return cursoService.update(id, request);
    }
}
