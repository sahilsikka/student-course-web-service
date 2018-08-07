package basePackage.repository;

import basePackage.model.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ssikka on 8/2/18.
 */
public interface CourseRepository  extends JpaRepository<Courses, String>{

    Courses findByIdContains(String id);
}
