package com.fiap.checkpoint2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departament")
public class DepartamentoController {
    @Autowired
    private DepartamentoRepository departmentRepository;

    @PostMapping
    public Departamento createDepartamento(@RequestBody Departamento departamento) {
        return departmentoRepository.save(department);
    }

    @GetMapping("/{id}")
    public Departamento getDepartamento(@PathVariable Long id) {
        return departamentoRepository.findById(id).orElse(null);
    }

    @GetMapping
    public List<Departamento> getAllDepartamentos() {
        return departamentoRepository.findAll();
    }

    @PutMapping("/{id}")
    public Departamento updateDepartamento(@PathVariable Long id, @RequestBody Departamento updatedDepartamento) {
        Departamento departamento = departamentoRepository.findById(id).orElse(null);
        if (departamento != null) {
            departamento.setName(updatedDepartament.getName());
            return departmentoRepository.save(departamento);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteDepartamento(@PathVariable Long id) {
        departamentoRepository.deleteById(id);
    }
}
