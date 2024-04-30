package it.spid.cie.oidc.exception;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class TestConfigException {

  @Test
  public void testConstructor1() {
    OIDCException e = new ConfigException("test %s", "test");

    assertNotNull(e);
  }

  @Test
  public void testConstructor2() {
    OIDCException e = new ConfigException("test", new Exception());

    assertNotNull(e);
  }

  @Test
  public void testConstructor3() {
    OIDCException e = new ConfigException(new Exception());

    assertNotNull(e);
  }

}
