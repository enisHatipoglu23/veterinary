package management.system.veterinary.core.utils;

import management.system.veterinary.core.result.Result;
import management.system.veterinary.core.result.ResultData;
import org.springframework.http.HttpStatus;

public class ResultHelper {

    public static <T> ResultData<T> created(T data){

        return new ResultData<>(true, Msg.CREATED, HttpStatus.CREATED.toString(), data);
    }
    public static <T>ResultData<T> validateError(T data){

        return new ResultData<>(false, Msg.VALIDATION_ERROR, HttpStatus.BAD_REQUEST.toString(), data);
    }

    public static <T>ResultData<T> success(T data){

        return new ResultData<>(true, Msg.OK, HttpStatus.OK.toString(), data);
    }

    public static Result deletionSuccess(){
        return new Result(true, Msg.OK, HttpStatus.OK .toString());
    }

    public static Result notFoundError(String message){

        return new Result(false, Msg.NOT_FOUND, HttpStatus.NOT_FOUND.toString());
    }

    public static Result customerAlreadyExistsError(String message){

        return new Result(false, Msg.CUSTOMER_ALREADY_EXISTS, HttpStatus.BAD_REQUEST.toString());
    }

    public static Result vaccineStillEffectiveError(String message){

        return new Result(false, Msg.CUSTOMER_ALREADY_EXISTS, HttpStatus.BAD_REQUEST.toString());
    }

    public static Result notAvailableError(String message){

        return new Result(false, Msg.NOT_AVAILABLE, HttpStatus.LOCKED.toString());
    }
}
