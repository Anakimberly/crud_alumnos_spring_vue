package com.kimberly.alumnos.controllers;
import java.util.List;

import org.hibernate.sql.Alias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
//metodo para editar un alumno hacia la base de datos
@PutMapping("/editar-alumnos/{id}")
public ResponseEntity<Alumno> actualizarAlumno(@PathVariable Long id, @RequestBody Alumno alumno){
    return alumnoRepository.findById(id).map(alumnoExistente -> {
alumnoExistente.setNombre(alumno.getNombre());
alumnoExistente.setApellidos(alumno.getApellidos());
alumnoExistente.setEmail(alumno.getEmail());
alumnoExistente.setNumeroControl(alumno.getNumeroControl());
alumnoExistente.setTelefono(alumno.getTelefono());
alumnoExistente.setCarrera(alumno.getCarrera());
alumnoExistente.setImagenURL(alumno.getImagenURL());
Alumno actualizado = alumnoRepository.save(alumnoExistente);
return ResponseEntity.ok(actualizado);
    }).orElse(ResponseEntity.notFound().build());
}

//metodo para eliminar un alumno de la base de datos
@DeleteMapping("/eliminar-alumnos/{id}")
public void eliminarAlumno(@PathVariable Long id){
    alumnoRepository.deleteById(id);

}
}

