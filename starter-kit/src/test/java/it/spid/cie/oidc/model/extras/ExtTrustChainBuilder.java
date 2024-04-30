package it.spid.cie.oidc.model.extras;

import it.spid.cie.oidc.exception.OIDCException;
import it.spid.cie.oidc.helper.JWTHelper;
import it.spid.cie.oidc.model.TrustChainBuilder;
import org.json.JSONObject;

public class ExtTrustChainBuilder extends TrustChainBuilder {

  public ExtTrustChainBuilder(
    String subject, String metadataType, JWTHelper jwtHelper) {

    super(subject, metadataType, jwtHelper);
  }

  public JSONObject tastableApplyPolicy(JSONObject metadata, JSONObject policy)
    throws OIDCException {

    return applyPolicy(metadata, policy);
  }

  public void testableProcessSubjectConfiguration() throws OIDCException {
    processSubjectConfiguration();
  }

  public void testableProcessTrustAnchorConfiguration() throws OIDCException {
    processTrustAnchorConfiguration();
  }

}
