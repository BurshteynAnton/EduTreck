package antonburshteyn.contacts.dto.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serializable;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CommentNotFoundException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 3513689438276083713L;
}
