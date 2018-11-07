package com.dfstudio.common.json;

/**
 * @author msgile
 * @author $LastChangedBy$
 * @version $Revision$  $LastChangedDate$
 * @since 10/3/18
 */
public class JsonParserExcepton extends Exception {
  public JsonParserExcepton() {
  }

  public JsonParserExcepton(String message) {
    super(message);
  }

  public JsonParserExcepton(String message, Throwable cause) {
    super(message, cause);
  }

  public JsonParserExcepton(Throwable cause) {
    super(cause);
  }

  public JsonParserExcepton(String message, Throwable cause, boolean enableSuppression,
                            boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
