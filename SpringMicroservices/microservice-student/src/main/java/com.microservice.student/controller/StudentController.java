package com.microservice.student.controller;

import com.microservice.student.entities.Student;
import com.microservice.student.service.IStudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/student")
public class StudentController {

    private final IStudentService studentService;

    public StudentController(IStudentService studentService) {
        this.studentService = studentService;
    }


    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveStudent(@RequestBody Student student){
        studentService.save(student);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllStudents(){
        return ResponseEntity.ok(studentService.findAll());
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(studentService.findById(id)) ;

    }

    //Se devuelven todos los estudiantes que pertenecen a ese curso, este metodo va a hacer consumido desde el microservicio course.
    @GetMapping("/search-by-idCourse/{idCourse}")
    public ResponseEntity<?> findStudentsByIdCourse(@PathVariable Long idCourse){
        return ResponseEntity.ok(studentService.findByIdCourse(idCourse));
    }


}
