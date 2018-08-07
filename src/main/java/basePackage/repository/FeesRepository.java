package basePackage.repository;

import basePackage.model.Fees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ssikka on 8/1/18.
 */
public interface FeesRepository extends JpaRepository<Fees,Integer> {

    Fees findByTxnId(int id);

}
