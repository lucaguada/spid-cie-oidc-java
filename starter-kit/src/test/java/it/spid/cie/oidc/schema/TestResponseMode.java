package it.spid.cie.oidc.schema;

import it.spid.cie.oidc.schemas.ResponseMode;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestResponseMode {

  @Test
  public void testParse1() {
    ResponseMode res = ResponseMode.parse(ResponseMode.QUERY.name());

    assertNull(res);
  }

  @Test
  public void testParse2() {
    ResponseMode res = ResponseMode.parse(ResponseMode.QUERY.value());

    assertTrue(ResponseMode.QUERY.equals(res));
  }

  @Test
  public void testParse3() {
    ResponseMode res = ResponseMode.parse("ko");

    assertNull(res);
  }

  @Test
  public void testParse4() {
    boolean catched = false;

    try {
      ResponseMode.parse("ko", true);
    } catch (Exception e) {
      catched = true;
    }

    assertTrue(catched);
  }

  @Test
  public void testParse4b() {
    boolean catched = false;
    ResponseMode res = null;

    try {
      res = ResponseMode.parse("ko", false);
    } catch (Exception e) {
      catched = true;
    }

    assertFalse(catched);
    assertNull(res);
  }

  @Test
  public void testParse5() {
    ResponseMode res = ResponseMode.parse(null);

    assertNull(res);
  }

  @Test
  public void testParse6a() {
    boolean catched = false;
    ResponseMode res = null;

    try {
      res = ResponseMode.parse(ResponseMode.QUERY.value(), true);
    } catch (Exception e) {
      catched = true;
    }

    assertFalse(catched);
    assertNotNull(res);
  }

  @Test
  public void testParse6b() {
    boolean catched = false;
    ResponseMode res = null;

    try {
      res = ResponseMode.parse(ResponseMode.QUERY.value(), false);
    } catch (Exception e) {
      catched = true;
    }

    assertFalse(catched);
    assertNotNull(res);
  }

  @Test
  public void testParse7() {
    assertEquals(ResponseMode.FORM_POST.toString(), ResponseMode.FORM_POST.value());
  }

}
