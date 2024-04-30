package it.spid.cie.oidc.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestValidator {

  @Test
  public void testConstructor() {
    Validator obj = new Validator();

    assertNotNull(obj);
  }

  @Test
  public void testIsNullOrEmpty1() {
    assertTrue(Validator.isNullOrEmpty(null));
  }

  @Test
  public void testIsNullOrEmpty2() {
    assertTrue(Validator.isNullOrEmpty(""));
  }

  @Test
  public void testIsNullOrEmpty3() {
    assertTrue(Validator.isNullOrEmpty("  	 "));
  }

  @Test
  public void testIsNullOrEmpty4() {
    assertFalse(Validator.isNullOrEmpty("  1	 "));
  }

}
