package st.malike.adyen.integration.http;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import st.malike.adyen.integration.exception.APIErrorException;
import st.malike.adyen.integration.exception.MissingDataException;
import st.malike.adyen.integration.util.Enums;
import st.malike.adyen.integration.util.JSONResponse;

/**
 * @autor malike_st
 */
@Controller
@ControllerAdvice
public class ExceptionController {

  @ExceptionHandler(MissingDataException.class)
  @ResponseBody
  public JSONResponse missingParameterException(MissingDataException e) {
    JSONResponse jSONResponse = new JSONResponse();
    jSONResponse.setStatus(false);
    jSONResponse.setMessage(Enums.JSONResponseMessage.MISSING_DATA_REQUIRED.toString());
    jSONResponse.setResult(e.toString());
    return jSONResponse;
  }


  @ExceptionHandler(APIErrorException.class)
  @ResponseBody
  public JSONResponse apiException(Exception e) {
    JSONResponse jSONResponse = new JSONResponse();
    jSONResponse.setStatus(false);
    jSONResponse.setMessage(Enums.JSONResponseMessage.SERVER_ERROR.toString());
    jSONResponse.setResult(e.toString());
    return jSONResponse;
  }

  @ExceptionHandler(Exception.class)
  @ResponseBody
  public JSONResponse exception(Exception e) {
    JSONResponse jSONResponse = new JSONResponse();
    jSONResponse.setStatus(false);
    jSONResponse.setMessage(Enums.JSONResponseMessage.SERVER_ERROR.toString());
    jSONResponse.setResult(e.toString());
    return jSONResponse;
  }


}
