package com.dfstudio.common.json;

/**
 * @author msgile
 * @author $LastChangedBy$
 * @version $Revision$  $LastChangedDate$
 * @since 10/3/18
 */
public interface JsonParser {
  Object deserialize(String json) throws JsonParserExcepton;
  String serialize(Object data) throws JsonParserExcepton;
}
