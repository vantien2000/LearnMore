package LearnMore.example.LearnMore.Exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String Message) {
        super(Message);
    }
}
