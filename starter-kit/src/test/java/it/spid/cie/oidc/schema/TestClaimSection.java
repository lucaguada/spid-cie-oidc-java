package it.spid.cie.oidc.schema;

import it.spid.cie.oidc.schemas.ClaimSection;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestClaimSection {

  @Test
  public void testParse1() {
    ClaimSection res = ClaimSection.parse(ClaimSection.ID_TOKEN.name());

    assertNull(res);
  }

  @Test
  public void testParse2() {
    ClaimSection res = ClaimSection.parse(ClaimSection.ID_TOKEN.value());

    assertTrue(ClaimSection.ID_TOKEN.equals(res));
  }

  @Test
  public void testParse3() {
    ClaimSection res = ClaimSection.parse("ko");

    assertNull(res);
  }

  @Test
  public void testParse4a() {
    boolean catched = false;

    try {
      ClaimSection.parse("ko", true);
    } catch (Exception e) {
      catched = true;
    }

    assertTrue(catched);
  }

  @Test
  public void testParse4b() {
    boolean catched = false;
    ClaimSection res = null;

    try {
      res = ClaimSection.parse("ko", false);
    } catch (Exception e) {
      catched = true;
    }

    assertFalse(catched);
    assertNull(res);
  }

  @Test
  public void testParse5() {
    ClaimSection res = ClaimSection.parse(null);

    assertNull(res);
  }

  @Test
  public void testParse6a() {
    boolean catched = false;
    ClaimSection res = null;

    try {
      res = ClaimSection.parse(ClaimSection.ID_TOKEN.value(), true);
    } catch (Exception e) {
      catched = true;
    }

    assertFalse(catched);
    assertNotNull(res);
  }

  @Test
  public void testParse6b() {
    boolean catched = false;
    ClaimSection res = null;

    try {
      res = ClaimSection.parse(ClaimSection.ID_TOKEN.value(), false);
    } catch (Exception e) {
      catched = true;
    }

    assertFalse(catched);
    assertNotNull(res);
  }

  @Test
  public void testParse7() {
    assertEquals(ClaimSection.ID_TOKEN.toString(), ClaimSection.ID_TOKEN.value());
  }

}
