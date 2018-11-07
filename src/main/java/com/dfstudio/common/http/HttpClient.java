package com.dfstudio.common.http;

import java.io.IOException;
import java.util.Map;

/**
 * @author msgile
 * @author $LastChangedBy$
 * @version $Revision$  $LastChangedDate$
 * @since 10/2/18
 */
public interface HttpClient {
  HttpResponse doGet(String url) throws IOException;
  HttpResponse doGet(String url, Map<String,Object> urlParams) throws IOException;
  HttpResponse doPost(String url, InputStreamSource body) throws IOException;
}

