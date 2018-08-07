package basePackage.service;

import basePackage.model.Courses;
import basePackage.model.Student;
import basePackage.repository.FeesRepository;
import basePackage.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Created by ssikka on 7/27/18.
 */
@Component
public class StudentService {

    @Autowired
    StudentRepository repository;
    @Autowired
    FeesService fee;
    @Autowired
    CourseService courseService;
    @Autowired
    StudentRepository stud;



    public List<Student> retrieveAllStudents(){
        return stud.findAll();

    }

    public Set<Courses> retrieveCourses( Student student){

        return student.getCourses();
    }



    public Courses addCourse(String studentId,Courses course){
        Student s=new Student(studentId,"sahil","desc",new HashSet<>());
        s.getCourses().add(course);
        //course.setId("c1");
        course.getStudents().add(s);

        //courseService.addCourse(course);
        stud.save(s);
      //  courseService.addCourse(course);

        //s.getCourses().add(course);

        return course;

    }

    public Student retrieveStudent(String studentId) {
        List<Student>students=retrieveAllStudents();
        for(Student s:students){
            if(s.getId().equals(studentId)){
                return s;
            }
        }
        return null;
    }

    public Courses retrieveCourse(Student s, String courseId) {

        for(Courses course: s.getCourses()){
            if(course.getId().equals(courseId))
                return course;
        }

        return null;
    }

    public Student deleteStudent(String studentId) {
        List<Student>students=retrieveAllStudents();
        for(Student s:students){
            if(s.getId().equals(studentId)){
                students.remove(s);
                return s;
            }
        }
        return null;
    }

    public Student addStudentWithoutFees(String studentId){
        Student student=new Student(studentId,"struts","10 lessons",new HashSet<>());
        List<Student>students=retrieveAllStudents();
        for(Student s:students){
            if(s.getId().equals(studentId))
                return null;
        }

        students.add(new Student(studentId,"struts","10 lessons",new HashSet<>()));
        stud.save(student);
        return student;

    }

    public Student addStudentWithFees(String studentId, int fees){
        Student student=addStudentWithoutFees(studentId);
        fee.addFeesByStudent(student.getName(),fees);
        return student;
    }

}
