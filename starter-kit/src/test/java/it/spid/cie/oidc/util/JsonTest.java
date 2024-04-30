package it.spid.cie.oidc.util;

import org.json.JSONArray;
import org.junit.Test;

import static org.junit.Assert.*;

public class JsonTest {

  @Test
  public void shouldMarshalToJsonArray() {
    JSONArray res = Json.array("one", "two");

    assertEquals(2, res.length());
  }

  @Test
  public void asJSONArray2() {
    JSONArray res = Json.array();

    assertTrue(res.isEmpty());
  }

  @Test
  public void contains1() {
    JSONArray array = Json.array("0", "1");

    assertTrue(Json.contains(array, "0"));
  }

  @Test
  public void contains2() {
    JSONArray array = Json.array("0", "1");

    assertFalse(Json.contains(array, "00"));
  }

  @Test
  public void contains3() {
    JSONArray array = new JSONArray();

    assertFalse(Json.contains(array, "00"));
  }
}
