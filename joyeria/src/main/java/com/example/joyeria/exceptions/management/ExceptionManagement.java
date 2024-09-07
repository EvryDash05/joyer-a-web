package com.example.joyeria.exceptions.management;

import com.example.joyeria.commons.constants.ErrorConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import com.example.joyeria.exceptions.custom.ErrorResponse;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.example.joyeria.exceptions.custom.BusinessException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.context.request.WebRequest;
import com.example.joyeria.exceptions.custom.NotDataFoundException;

import java.util.*;

@Slf4j
@RestControllerAdvice
public class ExceptionManagement {

    public enum ErrorType{
        ERROR,
        WARNING,
        INVALID,
        FATAL
    }

    /**
    * Method to handle generic exception {@link Exception}
    * */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse generalException(Exception ex, WebRequest request){
        ErrorResponse apiError =
                ErrorResponse.builder()
                        .type(ErrorType.FATAL.name())
                        .code(ErrorConstant.GENERIC_ERROR_CODE)
                        .message(ErrorConstant.GENERIC_ERROR_MESSAGE)
                        .moreInfo(ex.getMessage())
                        .build();
        log.debug(apiError.toString());
        return apiError;
    }

    /**
     * To handle an exception of type {@link NotDataFoundException}
    * */
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotDataFoundException.class)
    public ErrorResponse notFoundException(NotDataFoundException ex, WebRequest request){
        ErrorResponse apiError =
                ErrorResponse.builder()
                        .type(ErrorType.WARNING.name())
                        .code(ErrorConstant.NOT_FOUND_CODE)
                        .message(ErrorConstant.RECORD_NOT_FOUND_MESSAGE)
                        .moreInfo(ex.getMessage())
                        .build();
        log.debug(apiError.toString());
        return apiError;
    }

    /**
     * To handle exception of type {@link HttpRequestMethodNotSupportedException}
    * */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(value = HttpStatus.METHOD_NOT_ALLOWED)
    public ErrorResponse methodNotSupportedException(HttpRequestMethodNotSupportedException ex, WebRequest request){
        ErrorResponse apiError =
                ErrorResponse.builder()
                        .type(ErrorType.ERROR.name())
                        .code(ErrorConstant.BAD_REQUEST_CODE)
                        .message(ex.getMessage())
                        .build();
        log.debug(apiError.toString());
        return apiError;
    }

    /**
     * To handle an exception of type {@link HttpMediaTypeNotSupportedException}
    * */
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    @ResponseStatus(value = HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    public ErrorResponse resolveMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException ex, WebRequest request){
        ErrorResponse apiError =
                ErrorResponse.builder()
                        .type(ErrorType.ERROR.name())
                        .code(ErrorConstant.BAD_REQUEST_CODE)
                        .message(ex.getMessage())
                        .build();
        log.debug(apiError.toString());
        return apiError;
    }

    /**
     * To handle an exception of type {@link HttpMediaTypeNotAcceptableException}
     * */
    @ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
    @ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
    public ErrorResponse resolveMediaTypeNotAcceptableException(HttpMediaTypeNotAcceptableException ex, WebRequest request){
        ErrorResponse apiError =
                ErrorResponse.builder()
                        .type(ErrorType.INVALID.name())
                        .code(ErrorConstant.BAD_REQUEST_CODE)
                        .message(ex.getMessage())
                        .build();
        log.debug(apiError.toString());
        return apiError;
    }

    /**
     * To handle an exception of type {@link MethodArgumentNotValidException}
     * */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorResponse methodArgumentNotValidException(MethodArgumentNotValidException ex, WebRequest request){
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();

        List<String> fields = new ArrayList<>();
        Map<String, List<String>> groupErrors = new HashMap<>();

        for(FieldError fieldError : fieldErrors){
            String field = fieldError.getField();
            groupErrors.computeIfAbsent(
                    fieldError.getDefaultMessage(), key -> Collections.singletonList(field));
            fields.add(field);
        }

        ErrorResponse apiError =
                ErrorResponse.builder()
                        .type(ErrorType.INVALID.name())
                        .code(ErrorConstant.BAD_REQUEST_CODE)
                        .message(groupErrors.toString())
                        .moreInfo(fields.toString())
                        .build();
        log.debug(apiError.toString());
        return apiError;
    }

    /**
     * Method to handle an exception of type {@link BusinessException}
     * */
    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(value = HttpStatus.OK)
    public ErrorResponse businessException(BusinessException ex, WebRequest request){
        ErrorResponse apiError =
            ErrorResponse.builder()
                    .type(ErrorType.ERROR.name())
                    .code(ErrorConstant.GENERIC_ERROR_CODE)
                    .message(ex.getMessage())
                    .build();
        log.debug(apiError.toString());
        return apiError;
    }

}
