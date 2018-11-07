package com.dfstudio.api.enterprise;

import com.dfstudio.common.http.HttpClient;
import com.dfstudio.common.http.JavaHttpClient;
import com.dfstudio.common.json.JsonParser;
import com.dfstudio.common.json.SimpleJsonParser;

/**
 * @author msgile
 * @author $LastChangedBy$
 * @version $Revision$  $LastChangedDate$
 * @since 10/4/18
 */
public class ApiContext {
  HttpClient http = new JavaHttpClient();
  JsonParser parser = new SimpleJsonParser();

  public HttpClient getHttp() {
    return http;
  }

  public ApiContext setHttp(HttpClient http) {
    this.http = http;
    return this;
  }

  public JsonParser getParser() {
    return parser;
  }

  public ApiContext setParser(JsonParser parser) {
    this.parser = parser;
    return this;
  }
}
