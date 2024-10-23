package antonburshteyn.authentication.dto.exceptions;

import jakarta.servlet.annotation.HttpConstraint;

@HttpConstraint()
public class InvalidCredentialsException extends RuntimeException {

    private static final long serialVersionUID = 3692591317106622779L;

    public InvalidCredentialsException() {
        super("Invalid username or password");
    }

}
