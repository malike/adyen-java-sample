/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package st.malike.adyen.integration.util;

/**
 * @author malike_st
 */
public class JSONResponse {

  private boolean status;
  private long count;
  private Object result;
  private String message;

  public JSONResponse() {
  }

  public boolean isStatus() {
    return status;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }

  public long getCount() {
    return count;
  }

  public void setCount(long count) {
    this.count = count;
  }

  public Object getResult() {
    return result;
  }

  public void setResult(Object result) {
    this.result = result;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
