package com.dfstudio.common.http;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * @author msgile
 * @author $LastChangedBy$
 * @version $Revision$  $LastChangedDate$
 * @since 10/2/18
 */
public class HttpUtil {
  public static String toParamString(Object... params) {
    Map<String,Object> map = new HashMap<>(10);
    for(int i=0; i<params.length-2; i=i+2) {
      map.put(params[i].toString(),params[i+1]);
    }
    return toParamString(map);
  }

  public static String toParamString(Map<String, Object> params) {
    if ( params == null ) return "";
    try {
      StringBuilder paramStr = new StringBuilder();
      for (Map.Entry<String,Object> param : params.entrySet()) {
        if (paramStr.length() != 0) paramStr.append('&');
        paramStr.append(URLEncoder.encode(param.getKey(), "UTF-8"));
        paramStr.append('=');
        paramStr.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
      }
      return paramStr.toString();
    } catch (UnsupportedEncodingException e) {
      throw new IllegalStateException(e);
    }
  }

  public static void assertOk(HttpResponse response) throws IOException {
    if ( response.getStatusCode() >= 300 ) {
      throw new IOException("Status:"+response.getStatusCode());
    }
  }

}
