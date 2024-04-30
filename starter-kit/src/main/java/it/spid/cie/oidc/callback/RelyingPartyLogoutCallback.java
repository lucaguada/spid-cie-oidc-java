package it.spid.cie.oidc.callback;

import it.spid.cie.oidc.model.AuthnRequest;
import it.spid.cie.oidc.model.AuthnToken;

@FunctionalInterface
public interface RelyingPartyLogoutCallback {
  void logout(String userKey, AuthnRequest authnRequest, AuthnToken authnToken);
}
