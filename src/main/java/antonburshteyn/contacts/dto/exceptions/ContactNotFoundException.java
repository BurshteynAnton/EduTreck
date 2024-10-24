package antonburshteyn.contacts.dto.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serializable;
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ContactNotFoundException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = -9088548450962015369L;

}
