package com.kimberly.alumnos.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kimberly.alumnos.model.Alumno;
import com.kimberly.alumnos.repository.AlumnoRepository;
@RestController
@RequestMapping("/alumnos")
public class AlumnoController {
    @Autowired
    private AlumnoRepository alumnoRepository;
//metodo get para traer todos los alumnos de la base de datos
    @GetMapping("/traer-alumnos")
    public List<Alumno> TraerAlumnos(){
        return alumnoRepository.findAll();

    }
    //metodo para insertar alumno en la base de datos
    @PostMapping("/insertar-alumnos")
    public Alumno insertarAlumno(@RequestBody Alumno alumno){
        return alumnoRepository.save(alumno);
    }


}
