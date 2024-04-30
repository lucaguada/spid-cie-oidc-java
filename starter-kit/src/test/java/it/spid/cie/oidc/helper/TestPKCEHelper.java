package it.spid.cie.oidc.helper;

import org.json.JSONObject;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class TestPKCEHelper {

  @Test
  public void testClass() {
    JSONObject json = PKCEHelper.getPKCE();

    assertFalse(json.isEmpty());
  }

}
