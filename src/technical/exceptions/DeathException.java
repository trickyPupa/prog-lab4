package technical.exceptions;

public class DeathException extends RuntimeException{
    public DeathException(String message){
        super(message);
    }

    public DeathException() {
        super();
    }
}
