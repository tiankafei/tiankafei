package org.tiankafei.springmvcdemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(reason = "名字不是admin",value = HttpStatus.NOT_ACCEPTABLE)
public class UserNameException extends RuntimeException {
}