package management.system.veterinary.core.exception.handler;

import management.system.veterinary.core.exception.CustomerAlreadyExistsException;
import management.system.veterinary.core.exception.NotAvailableException;
import management.system.veterinary.core.exception.NotFoundException;
import management.system.veterinary.core.result.Result;
import management.system.veterinary.core.result.ResultData;
import management.system.veterinary.core.utils.ResultHelper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Result> handleNotFoundException(NotFoundException e){
        return new ResponseEntity<>(ResultHelper.notFoundError(e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CustomerAlreadyExistsException.class)
    public ResponseEntity<Result> handleCustomerAlreadyExistsException(CustomerAlreadyExistsException e){
        return new ResponseEntity<>(ResultHelper.customerAlreadyExistsError(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(VaccineStillEffective.class)
    public ResponseEntity<Result> handleVaccineStillEffectiveException(VaccineStillEffective e){
        return new ResponseEntity<>(ResultHelper.customerAlreadyExistsError(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotAvailableException.class)
    public ResponseEntity<Result> notAvailableException(NotFoundException e){
        return new ResponseEntity<>(ResultHelper.notAvailableError(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResultData<List<String>>> handleValidationErrors(MethodArgumentNotValidException e){
        List<String> validationErrorList = e.getBindingResult().getFieldErrors()
                .stream()
                .map(FieldError::getDefaultMessage)
                .toList();
        return new ResponseEntity<>(ResultHelper.validateError(validationErrorList), HttpStatus.BAD_REQUEST);
    }
}
