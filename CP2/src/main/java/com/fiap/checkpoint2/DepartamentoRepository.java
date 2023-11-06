package com.fiap.checkpoint2;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public interface DepartamentoRepository extends JpaRepository<Department, Long> {
    Department findByName(String name);

    Department save(Department department);

}

