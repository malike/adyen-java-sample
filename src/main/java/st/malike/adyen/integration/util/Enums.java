package st.malike.adyen.integration.util;

/**
 * @author malike_st
 */
public class Enums {

  public enum JSONResponseMessage {

    SERVER_ERROR,
    SUCCESS,
    MISSING_DATA_REQUIRED,
    PAYMENT_NOT_SUPPORTED
  }


  public enum PaymentChannel {
    MTN_MONEY,
    AIRTEL_MOBILE_MONEY,
    VODAFONE_CASH,
    VISA,
    DEFAULT_GATEWAY

  }

  public enum PaymentGateway {

    SLYDEPAY,
    EXPRESSPAY

  }

}
