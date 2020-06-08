package Exceptions;

/**
 * Klasa RegisterException obsługująca wyjątek przy rejestracji
 */

public class RegisterException extends Exception {
    public RegisterException(Exception e) {
        super(e);
    }
}
