package com.dfstudio.common.http;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @author msgile
 * @author $LastChangedBy$
 * @version $Revision$  $LastChangedDate$
 * @since 10/2/18
 */
public class InputStreamSources {
  public static InputStreamSource fromParams(Object... params) {
    Map<String,Object> map = new HashMap<>(10);
    for(int i=0; i<params.length-1; i=i+2) {
      map.put(params[i].toString(),params[i+1]);
    }
    return fromParams(map);
  }
  public static InputStreamSource fromParams(Map<String,Object> params) {
    String paramString = HttpUtil.toParamString(params);
    return fromString(paramString)
        .setContentType("application/x-www-form-urlencoded");
  }

  public static InputStreamSource fromString(String str) {
    byte[] byteArray = str.getBytes();
    return new InputStreamSource() {
      @Override
      public InputStream openInputStream() {
        ByteArrayInputStream bytes = new ByteArrayInputStream(byteArray);
        return bytes;
      }
    }.setLength(byteArray.length);

  }

  public static InputStreamSource fromFile(File file) {
    return new InputStreamSource() {
      @Override
      public InputStream openInputStream() throws IOException {
        try {
          return new FileInputStream(file);
        } catch (FileNotFoundException e) {
          throw new IOException(e);
        }
      }
    }.setLength(file.length());
  }
}
