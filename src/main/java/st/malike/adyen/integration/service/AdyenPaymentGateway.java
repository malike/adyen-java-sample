package st.malike.adyen.integration.service;

import com.adyen.Client;
import com.adyen.Config;
import com.adyen.enums.Environment;
import com.adyen.model.checkout.PaymentMethodsRequest;
import com.adyen.model.checkout.PaymentMethodsResponse;
import com.adyen.model.marketpay.AccountHolderBalanceRequest;
import com.adyen.model.marketpay.AccountHolderBalanceResponse;
import com.adyen.model.marketpay.GetAccountHolderRequest;
import com.adyen.model.marketpay.GetAccountHolderResponse;
import com.adyen.service.Account;
import com.adyen.service.Checkout;
import com.adyen.service.Fund;
import com.adyen.service.exception.ApiException;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.List;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @autor malike_st
 */
@Service
public class AdyenPaymentGateway {

  private static final org.slf4j.Logger logger = LoggerFactory.getLogger(AdyenPaymentGateway.class);
  Gson gson = new Gson();

  @Value("${payment.username}")
  private static String username;
  @Value("${payment.password}")
  private static String password;
  private static String environment = "TEST";
  private final Client client;

  public AdyenPaymentGateway() {
    Config config = new Config();
    config.setUsername(username);
    config.setPassword(password);
    config.setEnvironment(Environment.valueOf(environment));
    this.client = new Client(config);
    client.setEnvironment(config.getEnvironment(), null);
  }


  public AccountHolderBalanceResponse getAccountBalance(String accountHolderCode) throws Exception {
    Fund fund = new Fund(client);
    AccountHolderBalanceRequest accountHolderBalanceRequest = new AccountHolderBalanceRequest();
    accountHolderBalanceRequest.setAccountHolderCode(accountHolderCode);
    return fund.accountHolderBalance(accountHolderBalanceRequest);
  }

  public List<com.adyen.model.marketpay.Account> getAccounts(String accountHolderCode)
      throws Exception {
    Account account = new Account(client);
    GetAccountHolderRequest accountHolderRequest = new GetAccountHolderRequest();
    accountHolderRequest.setAccountHolderCode(accountHolderCode);
    accountHolderRequest.setShowDetails(true);
    GetAccountHolderResponse accountHolder = account.getAccountHolder(accountHolderRequest);
    return accountHolder.getAccounts();
  }

  public PaymentMethodsResponse checkout(String merchantAccount) throws IOException, ApiException {
    Checkout checkout = new Checkout(client);
    PaymentMethodsRequest paymentMethodsRequest = new PaymentMethodsRequest();
    paymentMethodsRequest.setMerchantAccount(merchantAccount);
    return checkout.paymentMethods(paymentMethodsRequest);
  }

}
