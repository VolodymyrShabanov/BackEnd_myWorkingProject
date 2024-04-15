package myworkingproject.service.exeption;

public class AlreadyExistException extends RuntimeException{
    public AlreadyExistException (String message) {
        super(message);
    }
}
