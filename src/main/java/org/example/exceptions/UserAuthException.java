package org.example.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserAuthException extends RuntimeException {
    public UserAuthException(String message) {
        super(message);
    }
}
