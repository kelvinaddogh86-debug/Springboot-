package shops.shops.globaleexcption;

import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import shops.shops.customexception.Productnotfoundexception;
import shops.shops.errorresponds.ErrorResponds;


@RestControllerAdvice
public class GlobleExcption {

    @ExceptionHandler(Productnotfoundexception.class)
    public ResponseEntity <ErrorResponds> productnotfound(Productnotfoundexception ex , WebRequest request){
        String message = ("resurce not found");
        ErrorResponds errormessage = new ErrorResponds(
            message
            ,request.getDescription(false)
            ,HttpStatus.NOT_FOUND.value()
            ,request.getContextPath()
            ,System.currentTimeMillis());
    
       return new ResponseEntity<>(errormessage,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
   public ResponseEntity< ErrorResponds> validation(MethodArgumentNotValidException ex ,WebRequest request){
     String message = ex.getBindingResult()
            .getFieldErrors()
            .stream()
            .map(error-> error.getField() + ": " + error.getDefaultMessage())
            .collect(Collectors.joining(", "));
            
            ErrorResponds errorResponds = new ErrorResponds(message, request.getDescription(false), HttpStatus.BAD_REQUEST.value(), request.getContextPath(), System.currentTimeMillis());
            return new ResponseEntity<>(errorResponds,HttpStatus.BAD_REQUEST);
   }
        
}