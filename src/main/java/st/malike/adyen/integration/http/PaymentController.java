package st.malike.adyen.integration.http;

import com.adyen.model.marketpay.Account;
import com.adyen.model.marketpay.AccountHolderBalanceResponse;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import st.malike.adyen.integration.exception.MissingDataException;
import st.malike.adyen.integration.service.AdyenPaymentGateway;
import st.malike.adyen.integration.util.Enums;
import st.malike.adyen.integration.util.JSONResponse;

/**
 * @autor malike_st
 */
@Controller
public class PaymentController extends ExceptionController {

  @Autowired
  private AdyenPaymentGateway adyenPaymentGateway;


  @RequestMapping(value = {
      "/api/balance"}, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public JSONResponse getBalance(@RequestBody Object data, HttpServletResponse response,
      HttpServletRequest request)
      throws Exception {
    JSONResponse jSONResponse = new JSONResponse();
    Map<String, Object> dataHash = (Map<String, Object>) data;
    String accountHolderCode = null;
    if (dataHash.containsKey("accountHolderCode")) {
      accountHolderCode = (String) dataHash.get("accountHolderCode");
    }
    if (accountHolderCode == null) {
      throw new MissingDataException("Order Code not specified");
    }
    if (accountHolderCode.isEmpty()) {
      throw new MissingDataException("Order Code not specified");
    }
    AccountHolderBalanceResponse responsePayment = adyenPaymentGateway
        .getAccountBalance(accountHolderCode);
    jSONResponse.setStatus(true);
    jSONResponse.setCount(1);
    jSONResponse.setResult(responsePayment);
    jSONResponse.setMessage(Enums.JSONResponseMessage.SUCCESS.toString());
    return jSONResponse;
  }

  @RequestMapping(value = {
      "/api/accounts"}, method = RequestMethod.POST, consumes = MediaType
      .APPLICATION_JSON_VALUE)
  @ResponseBody
  public JSONResponse getAccounts(@RequestBody Object data, HttpServletResponse response,
      HttpServletRequest request)
      throws Exception {
    JSONResponse jSONResponse = new JSONResponse();
    Map<String, Object> dataHash = (Map<String, Object>) data;
    String accountHolderCode = null;
    if (dataHash.containsKey("accountHolderCode")) {
      accountHolderCode = (String) dataHash.get("accountHolderCode");
    }
    if (accountHolderCode == null) {
      throw new MissingDataException("Order Code not specified");
    }
    if (accountHolderCode.isEmpty()) {
      throw new MissingDataException("Order Code not specified");
    }
    List<Account> accounts = adyenPaymentGateway
        .getAccounts(accountHolderCode);
    jSONResponse.setStatus(true);
    jSONResponse.setCount(accounts.size());
    jSONResponse.setResult(accounts);
    jSONResponse.setMessage(Enums.JSONResponseMessage.SUCCESS.toString());
    return jSONResponse;
  }


}
