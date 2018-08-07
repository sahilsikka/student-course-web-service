package basePackage.service;

import basePackage.model.Courses;
import basePackage.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by ssikka on 8/2/18.
 */
@Component
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    public Courses addCourse(Courses course){
        courseRepository.save(course);
        return course;
    }

    public Courses getCourse(String id){
        return courseRepository.findByIdContains(id);
    }
}
