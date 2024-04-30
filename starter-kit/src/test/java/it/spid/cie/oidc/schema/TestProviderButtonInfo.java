package it.spid.cie.oidc.schema;

import it.spid.cie.oidc.schemas.ProviderButtonInfo;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestProviderButtonInfo {

  @Test
  public void testClass1() {
    ProviderButtonInfo model = new ProviderButtonInfo("subject", "orgName", "url");

    assertEquals("subject", model.getSubject());
    assertEquals("orgName", model.getOrganizationName());
    assertEquals("url", model.getLogoUrl());
    assertEquals("orgName", model.getTitle());
  }

  @Test
  public void testClass2() {
    ProviderButtonInfo model = new ProviderButtonInfo("subject", null, "url");

    assertEquals("subject", model.getTitle());
  }

}
