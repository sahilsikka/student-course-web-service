package basePackage.studentController;

import basePackage.model.Fees;
import basePackage.repository.FeesRepository;
import basePackage.service.FeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ssikka on 8/2/18.
 */
@RestController
public class FeeController {

    @Autowired
    FeesService fee;

    @GetMapping(value = "/fees/{id}")
    public Fees getFeesByStudentId(@PathVariable int id){
        return fee.getFeesOfStudentByStudentName(id);
    }

}
