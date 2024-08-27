package express.object;

public class NewInstanceCreationException extends Exception {

    public NewInstanceCreationException(Class<?> clazz) {
        super("Error creating new instance of " + clazz.getName());
    }

    public NewInstanceCreationException(Class<?> clazz, Throwable cause) {
        super("Error creating new instance of " + clazz.getName(), cause);
    }

    // Constructor that accepts a custom message
    public NewInstanceCreationException(String message) {
        super(message);
    }

    // Constructor that accepts a custom message and a cause
    public NewInstanceCreationException(String message, Throwable cause) {
        super(message, cause);
    }

    // Constructor that accepts a cause
    public NewInstanceCreationException(Throwable cause) {
        super(cause);
    }
}
