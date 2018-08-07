package basePackage.model;

import javax.persistence.*;

/**
 * Created by ssikka on 8/1/18.
 */

@Entity
@SequenceGenerator(
        name = "USER_SEQ_GENERATOR",
        sequenceName = "USER_SEQ",
        initialValue = 1, allocationSize = 1)
public class Fees {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "USER_SEQ_GENERATOR")
    int txnId;

    String studentName;
    int fees;

    public Fees(){}
    public Fees(String studentName, int fees) {
        this.studentName = studentName;
        this.fees = fees;
    }

    public int getTxnId() {
        return txnId;
    }

    public void setTxnId(int txnId) {
        this.txnId = txnId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getFees() {
        return fees;
    }

    public void setFees(int fees) {
        this.fees = fees;
    }
}
