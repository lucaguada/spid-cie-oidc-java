package it.spid.cie.oidc.exception;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class TestPersistenceException {

  @Test
  public void testConstructor() {
    OIDCException e = new PersistenceException(new Exception());

    assertNotNull(e);
  }

}
