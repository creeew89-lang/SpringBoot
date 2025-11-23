package gov.om.tra.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
class HelloController {

    private final List<Student> studentList = new ArrayList<>();
    private int idCounter = 1;

    @PostMapping("/create")
    public String createStudent(@RequestBody Student s) {
        s.id = idCounter;
        s.createdDate = new Date();
        s.isActive = true;
        studentList.add(s);
        return "Student created with ID: " + idCounter++;
    }

    @GetMapping("/getAll")
    public List<Student> getAllStudents() {
        return studentList.stream().filter(s -> s.isActive).toList();
    }

    @GetMapping("/getById")
    public Student getStudent(@RequestParam int id) {
        return studentList.stream()
                .filter(s -> s.id == id && s.isActive)
                .findFirst()
                .orElseGet(Student::new);
    }

    @PutMapping("/update")
    public String updateStudent(@RequestBody Student u) {
        if (u.id == null) return "ID missing";
        for (Student s : studentList) {
            if (s.id.equals(u.id) && s.isActive) {
                s.name = u.name;
                s.address = u.address;
                s.age = u.age;
                s.updatedDate = new Date();
                return "Student updated successfully";
            }
        }
        return "Student not found";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable int id) {
        for (Student s : studentList) {
            if (s.id == id && s.isActive) {
                s.isActive = false;
                s.updatedDate = new Date();
                return "Student deleted successfully";
            }
        }
        return "Invalid id";
    }
}

class Student {
    public Integer id;
    public String name;
    public String address;
    public Integer age;
    public Date createdDate;
    public Date updatedDate;
    public Boolean isActive;
}