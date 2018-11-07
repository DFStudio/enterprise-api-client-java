package com.dfstudio.common.json;

/**
 * @author msgile
 * @author $LastChangedBy$
 * @version $Revision$  $LastChangedDate$
 * @since 10/3/18
 */
public class SimpleJsonParser implements JsonParser {
  @Override
  public Object deserialize(String json) throws JsonParserExcepton {
    if ( json.startsWith("\"") ) {
      String temp = json.substring(1);
      int pos = temp.indexOf("\"");
      return temp.substring(0,pos);
    }
    return null;
  }

  @Override
  public String serialize(Object data) throws JsonParserExcepton {
    return null;
  }
}
