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
public class Student {
    @Id
    String id;
    String name;
    private String description;

    @JsonBackReference

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name="student_courses", joinColumns = @JoinColumn(name="student_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name="course_id",referencedColumnName = "id"))
    Set<Courses> courses=new HashSet<>();

    public Set<Courses> getCourses() {
        return courses;
    }

    public Student(){}

    public Student(String id, String name, String description, Set<Courses> courses) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.courses = courses;
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

    public void setCourses(Set<Courses> courses) {
        this.courses = courses;
    }
}
