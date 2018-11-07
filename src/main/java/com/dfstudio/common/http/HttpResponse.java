package com.dfstudio.common.http;

public interface HttpResponse {
  int getStatusCode();
  String getMessageAsString();
}
