package it.spid.cie.oidc.exception;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class TestSchemaException {

  @Test
  public void testValidation1() {
    OIDCException e = new SchemaException.Validation(new Exception());

    assertNotNull(e);
  }

  @Test
  public void testValidation2() {
    OIDCException e = new SchemaException.Validation("test");

    assertNotNull(e);
  }

}
