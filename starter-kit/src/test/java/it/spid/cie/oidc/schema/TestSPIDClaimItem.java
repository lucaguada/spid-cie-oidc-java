package it.spid.cie.oidc.schema;

import it.spid.cie.oidc.schemas.SPIDClaimItem;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class TestSPIDClaimItem {

  @Test
  public void testClass1a() {
    assertNotNull(SPIDClaimItem.get("family_name"));
  }

  @Test
  public void testClass1b() {
    assertNull(SPIDClaimItem.get("familyname"));
  }

  @Test
  public void testClass2a() {
    assertNotNull(SPIDClaimItem.getByAlias(SPIDClaimItem.FAMILY_NAME.getAlias()));
  }

  @Test
  public void testClass2b() {
    assertNull(SPIDClaimItem.getByAlias("familyname"));
  }

  @Test
  public void testClass2c() {
    assertNotNull(SPIDClaimItem.SPID_CODE);
  }

  @Test
  public void testClass3() {
    assertNotNull(SPIDClaimItem.registerItem("test_name", "testAlias"));
  }


}
