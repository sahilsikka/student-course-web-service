package basePackage.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by ssikka on 7/27/18.
 */

@Entity
public class Courses {
    @Id
    private String id;

    private String name;
    private String description;

    @ManyToMany(cascade = {
            CascadeType.MERGE
    },mappedBy = "courses")

    Set<Student>students=new HashSet<>();

    public Set<Student> getStudents() {
       return students;
   }

    public Courses(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;

    }

    public Courses(String name, String description, Set<Student> students) {
        this.name = name;
        this.description = description;
        this.students = students;
    }

    public Courses() {

    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
