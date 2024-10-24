package antonburshteyn.contacts.dto.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serializable;

@ResponseStatus(HttpStatus.CONFLICT)
public class ContactExistException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 1848473570339700788L;

}
