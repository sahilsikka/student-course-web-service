package basePackage.repository;

import basePackage.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by ssikka on 8/1/18.
 */
public interface StudentRepository extends JpaRepository<Student,Integer>{

   /* @Autowired
    JdbcTemplate jdbcTemplate;

    class StudentrowMapper  implements RowMapper<Student>{
        @Override
        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
            Student student = new Student();
            student.setId(rs.getString("Id"));
            student.setName(rs.getString("name"));
            return student;
        }
    }

    public List<Student> getAllStudents(){
        return jdbcTemplate.query("select * from student", new StudentrowMapper());
    }

    public List<Student> findStudentById(String id){
        return jdbcTemplate.query("select * from student where id = ?",new Object[]{id}, new BeanPropertyRowMapper<Student>(Student.class));

    }
    */


}
