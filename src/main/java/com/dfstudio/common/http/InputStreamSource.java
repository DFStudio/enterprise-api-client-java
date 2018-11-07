package com.dfstudio.common.http;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author msgile
 * @author $LastChangedBy$
 * @version $Revision$  $LastChangedDate$
 * @since 10/2/18
 */
public abstract class InputStreamSource {
  private String charset = "utf-8";
  private String contentType = "text/plain";
  private long length = -1;

  public abstract InputStream openInputStream() throws IOException;

  public String getCharset() {
    return charset;
  }

  public InputStreamSource setCharset(String charset) {
    this.charset = charset;
    return this;
  }

  public String getContentType() {
    return contentType;
  }

  public InputStreamSource setContentType(String contentType) {
    this.contentType = contentType;
    return this;
  }

  public long getLength() { return length; }

  public InputStreamSource setLength(long length) {
    this.length = length;
    return this;
  }
}
