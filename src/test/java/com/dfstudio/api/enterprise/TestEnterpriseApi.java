package com.dfstudio.api.enterprise;

import java.io.File;

import com.dfstudio.common.http.InputStreamSource;
import com.dfstudio.common.http.InputStreamSources;
import org.junit.Test;

/**
 * @author msgile
 * @author $LastChangedBy$
 * @version $Revision$  $LastChangedDate$
 * @since 10/4/18
 */
public class TestEnterpriseApi {
  @Test
  public void testAuthenticate() throws Exception {
    EnterpriseSession session = new EnterpriseApi("https://demo.dfstudio.com").authenticate("USERNAME","ACCOUNT","PASSWORD");
    InputStreamSource file = InputStreamSources.fromFile(new File("PATH TO FILE")).setContentType("text/json");
    session.lookupSetGlobalValues("custom.selectedTitleId",file);
  }

}