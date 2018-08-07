package basePackage.studentController;

import basePackage.exception.MissingStudentException;
import basePackage.exception.StudentNotExists;
import basePackage.exception.cannotAddStudentException;
import basePackage.model.Courses;
import basePackage.model.Student;
import basePackage.repository.StudentRepository;
import basePackage.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import basePackage.service.StudentService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.*;

/**
 * Created by ssikka on 7/27/18.
 */

@RestController
public class StudentController {

    @Autowired
    StudentRepository repository;
    @Autowired
    StudentService service;

    @Autowired
    CourseService courseService;

    @GetMapping("students")
    public List<Student> retrieveAllStudents(){

        List<Student>a= service.retrieveAllStudents();
        for(Student s:a)
            System.out.println(s.getId());
        return a;
    }

    @GetMapping(value=  "/students/{studentId}")
    public Set<Courses> retrieveCoursesForStudent(@PathVariable String studentId) throws Exception {

        Student student=service.retrieveStudent(studentId);
        if(student==null){
            throw new StudentNotExists();
        }
        Set<Courses> courseList=service.retrieveCourses(student);
        return courseList;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    Map<String, String> handleException(StudentNotExists e){     //error handler -- if no student is found
        Map<String, String>map=new HashMap<>();
        map.put("errorCode","student does not exist ");
        return map;
    }

    @PostMapping("/students/{studentId}/courses/{courseId}")           // add courses to student with particular studentId
    public Student registerStudentForCourse (
            @PathVariable String studentId, @PathVariable String courseId) {

       Student s=new Student(studentId,"sahil","description",new HashSet<>());
       Courses course=courseService.getCourse(courseId);
       course.getStudents().add(s);
       s.getCourses().add(course);
       s=repository.save(s);
       return s;
    }

    @PostMapping("/courses/")
    public Courses addCourse(@RequestBody Courses newCourse){
        newCourse= courseService.addCourse(newCourse);
        return newCourse;
    }

    @DeleteMapping(value="/students/{studentId}")                 // delete student
    public Student deleteStudent(@PathVariable String studentId) throws MissingStudentException{

        Student id= service.deleteStudent(studentId);

        if(id==null){
            MissingStudentException exception=new MissingStudentException();
            exception.setId(studentId);
            throw exception;
        }
        return id;
    }

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    Map<String, String> handleException(MissingStudentException e){     //error handler -- if no student is found
        Map<String, String>map=new HashMap<>();
        map.put("errorCode","student does not exist " + e.getId());
        return map;
    }

    @RequestMapping(method = RequestMethod.GET ,value = "/students/{studentId}/courses/{courseId}")     // get method to receive particular course of particular studentId
    public Courses getCourse(@PathVariable String studentId, @PathVariable String courseId){

        Student student= service.retrieveStudent(studentId);
        Courses course=null;
        if(student!=null)
             course= service.retrieveCourse(student,courseId);

        return course;
    }

    @PostMapping(value="/students/{studentId}")
    public Student addStudent(@PathVariable String studentId,@RequestBody Student stud) throws Exception{

        Student s= service.addStudentWithoutFees(studentId);
        if(s==null){
            throw new cannotAddStudentException();
        }else{
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/studentId").buildAndExpand(studentId).toUri();
        }
        return s;
    }

    @PostMapping(value="/students/{studentId}/fees/{amount}")
    public Student addStudent(@PathVariable String studentId,@PathVariable int amount) throws Exception{

        Student s= service.addStudentWithFees(studentId,amount);
        if(s==null){
            throw new cannotAddStudentException();
        }else{
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/studentId").buildAndExpand(studentId).toUri();
        }
        return s;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    Map<String, String> handleException(cannotAddStudentException e){     //error handler -- if no student is found
        Map<String, String>map=new HashMap<>();
        map.put("errorCode","student already exists");
        return map;
    }

}
