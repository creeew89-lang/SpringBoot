package gov.om.tra.rest.demo;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private Map<Integer, String> courses = new HashMap<>();
    private int idCounter = 1;

    @PostMapping
    public String createCourse(@RequestParam String name) {
        courses.put(idCounter, name);
        return "Course created with ID: " + idCounter++;
    }

    @GetMapping
    public Map<Integer, String> getAllCourses() {
        return courses;
    }

    @GetMapping("/{id}")
    public String getCourseById(@PathVariable int id) {
        return courses.getOrDefault(id, "Course not found");
    }

    @PutMapping("/{id}")
    public String updateCourse(@PathVariable int id, @RequestParam String name) {
        if (courses.containsKey(id)) {
            courses.put(id, name);
            return "Course updated successfully";
        }
        return "Course not found";
    }

    @DeleteMapping("/{id}")
    public String deleteCourse(@PathVariable int id) {
        if (courses.remove(id) != null) {
            return "Course deleted successfully";
        }
        return "Course not found";
    }
}