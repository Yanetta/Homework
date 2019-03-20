package workSpringData.exeption;

public class DeleteException extends  RuntimeException {
    private static final long serialVersion = 1L;
    public DeleteException(String message){
        super(message);
    }
}
