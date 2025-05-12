package com.kimberly.alumnos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kimberly.alumnos.model.Alumno;
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {

}
