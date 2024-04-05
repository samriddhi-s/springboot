// package com.example.srikrishna.demo.controller;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.example.srikrishna.demo.model.Student;
// import com.example.srikrishna.demo.service.StudentService;

// @RestController
// @RequestMapping("/student")
// @CrossOrigin
// public class StudentController {
//    @Autowired

//    private StudentService studentService;

//    @PostMapping("/add")
//    public String add(@RequestBody Student student)
//    {
//      studentService.saveStudent(student);
//      return "New student is added";
//    }

//    @GetMapping("/getAll")
//    public List<Student> getAllStudents()
//    {
//       return studentService.getAllStudents();
//    }
// }


// StudentController.java

package com.example.srikrishna.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.srikrishna.demo.model.Student;
import com.example.srikrishna.demo.service.StudentService;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {

   @Autowired
   private StudentService studentService;

   @PostMapping("/add")
   public String add(@RequestBody Student student) {
     studentService.saveStudent(student);
     return "New student is added";
   }

   @GetMapping("/getAll")
   public List<Student> getAllStudents() {
      return studentService.getAllStudents();
   }

   @PutMapping("/update/{id}")
   public String updateStudent(@PathVariable int id, @RequestBody Student student) {
     student.setId(id);
     studentService.saveStudent(student);
     return "Student with ID " + id + " is updated";
   }

   @DeleteMapping("/delete/{id}")
   public String deleteStudent(@PathVariable int id) {
     studentService.deleteStudent(id);
     return "Student with ID " + id + " is deleted";
   }
}
