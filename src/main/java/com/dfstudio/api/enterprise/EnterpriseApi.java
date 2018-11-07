package com.dfstudio.api.enterprise;

import java.io.IOException;

import com.dfstudio.common.http.HttpResponse;
import com.dfstudio.common.http.InputStreamSource;
import com.dfstudio.common.http.InputStreamSources;
import com.dfstudio.common.json.JsonParserExcepton;

/**
 * @author msgile
 * @author $LastChangedBy$
 * @version $Revision$  $LastChangedDate$
 * @since 10/2/18
 */
public class EnterpriseApi {
  private ApiContext context = new ApiContext();

  private String baseUrl;

  public EnterpriseApi(String baseUrl) {
    this.baseUrl = baseUrl;
  }

  public EnterpriseSession authenticate(String username, String accountShortName, String password)
      throws IOException, JsonParserExcepton {
    InputStreamSource body = InputStreamSources.fromParams(
        "username",username,
        "account",accountShortName,
        "password",password
    );
    HttpResponse response = context.http.doPost(baseUrl+"/api/v1/session.js",body);
    if ( response.getStatusCode() >= 300 ) {
      throw new IOException(String.format("Status:%s, %s",response.getStatusCode(),response.getMessageAsString()));
    }
    String sessionUrl = (String) context.parser.deserialize(response.getMessageAsString());
    String sessionBaseUrl = sessionUrl.substring(0,sessionUrl.lastIndexOf("."));
    return new EnterpriseSession(context,sessionBaseUrl);
  }
}
