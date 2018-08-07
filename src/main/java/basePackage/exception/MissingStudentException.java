package basePackage.exception;

/**
 * Created by ssikka on 7/30/18.
 */
public class MissingStudentException extends Exception {


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String id;


}
