package com.dfstudio.common.io;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author msgile
 * @author $LastChangedBy$
 * @version $Revision$  $LastChangedDate$
 * @since 10/3/18
 */
public class IoUtil {
  public static String read(InputStream input) throws IOException {
    ByteArrayOutputStream buffer = new ByteArrayOutputStream(1024);
    copy(input,buffer);
    return new String(buffer.toByteArray());
  }

  public static long copy(InputStream input, OutputStream output) throws IOException {
    long size = 0;
    try {
      byte[] buffer = new byte[1024];
      int bytesRead = 0;
      while((bytesRead = input.read(buffer)) != -1) {
        size += bytesRead;
        output.write(buffer,0,bytesRead);
      }
      output.flush();
    } finally {
      close(input);
      close(output);
    }
    return size;
  }

  public static void close(Closeable closeable) {
    try {
      if ( closeable != null ) {
        closeable.close();
      }
    } catch (IOException ignore) {
      ;
    }
  }
}
