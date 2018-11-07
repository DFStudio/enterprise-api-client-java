package com.dfstudio.api.enterprise;

import java.io.IOException;

import com.dfstudio.common.http.HttpResponse;
import com.dfstudio.common.http.InputStreamSource;

/**
 * @author msgile
 * @author $LastChangedBy$
 * @version $Revision$  $LastChangedDate$
 * @since 10/2/18
 */
public class EnterpriseSession {
  private ApiContext context;
  private String sessionUrl;

  public EnterpriseSession(ApiContext context, String sessionUrl) {
    this.context = context;
    this.sessionUrl = sessionUrl;
  }

  public void lookupSetGlobalValues(String field, InputStreamSource data) throws IOException {
    HttpResponse response = context.http.doPost(sessionUrl+"/domain/"+field+"/path/root.js",data);
    if ( response.getStatusCode() >= 300 ) {
      throw new IOException(String.format("Status:%s, %s",response.getStatusCode(),response.getMessageAsString()));
    }
  }
}

