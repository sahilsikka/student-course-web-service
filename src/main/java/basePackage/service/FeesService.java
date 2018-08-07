package basePackage.service;

import basePackage.model.Fees;
import basePackage.repository.FeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ssikka on 8/1/18.
 */
@Service
public class FeesService {

    @Autowired
    FeesRepository feeRepo;

    public Fees getFeesOfStudentByStudentName(int id){
        return feeRepo.findByTxnId(id);
    }

    public Fees addFeesByStudent(String name, int fees){
        return feeRepo.save(new Fees(name, fees));
    }


}
