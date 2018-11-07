package com.dfstudio.common.http;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Map;

import com.dfstudio.common.io.IoUtil;

public class JavaHttpClient implements HttpClient {

  @Override
  public HttpResponse doGet(String url) throws IOException {
    return doGet(url,null);
  }

  @Override
  public HttpResponse doGet(String url, Map<String,Object> params) throws IOException {
    String paramStr = HttpUtil.toParamString(params);
    try {
      HttpURLConnection connection = (HttpURLConnection) (new URL(url+"?"+paramStr)).openConnection();
      connection.setDoOutput(true);
      connection.setRequestMethod("GET");
      connection.setReadTimeout(Integer.MAX_VALUE);
      connection.setRequestProperty("Content-Type", "text/json");
      connection.setRequestProperty("charset", "utf-8");
      connection.connect();
      return new JavaHttpResponse(connection);
    } catch (ProtocolException e) {
      throw new IllegalStateException(e);
    }
  }

  @Override
  public HttpResponse doPost(String url, InputStreamSource body) throws IOException {
    try {
      HttpURLConnection connection = (HttpURLConnection) (new URL(url)).openConnection();
      connection.setDoOutput(true);
      connection.setDoInput(true);
      connection.setConnectTimeout(Integer.MAX_VALUE-10);
      connection.setReadTimeout(Integer.MAX_VALUE-10);
      connection.setRequestMethod("POST");
      connection.setRequestProperty("charset", body.getCharset());
      connection.setRequestProperty("Content-Type", body.getContentType());
      connection.setRequestProperty("Content-Length", String.valueOf(body.getLength()));
      IoUtil.copy(body.openInputStream(),connection.getOutputStream());
      connection.connect();
      return new JavaHttpResponse(connection);
    } catch (ProtocolException e) {
      throw new IllegalStateException(e);
    }
  }

  public static class JavaHttpResponse implements HttpResponse {
    private int statusCode;
    private String message;

    public JavaHttpResponse(HttpURLConnection connection) throws IOException {
      this.statusCode = connection.getResponseCode();
      try {
        this.message = IoUtil.read(connection.getInputStream());
      } catch( IOException ex ) {
        this.message = "";
      }
    }

    @Override
    public int getStatusCode() {
      return statusCode;
    }

    @Override
    public String getMessageAsString() {
      return message;
    }

    public String toString() {
      return "HttpStatus("+statusCode+")";
    }
  }
}
