package st.malike.adyen.integration.exception;

/**
 * @autor malike_st
 */
public class APIErrorException extends Exception {

  public APIErrorException() {
  }

  public APIErrorException(String message) {
    super(message);
  }

  public APIErrorException(String message, Throwable cause) {
    super(message, cause);
  }

  public APIErrorException(Throwable cause) {
    super(cause);
  }

  public APIErrorException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
