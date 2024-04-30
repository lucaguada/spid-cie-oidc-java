package it.spid.cie.oidc.model;

import java.time.LocalDateTime;

public class AuthnToken extends BaseModel {

  private String code;
  private String accessToken;
  private String idToken;
  private String scope;
  private String tokenType;
  private int expiresIn;
  private String authnRequestId;
  private String userKey;
  private LocalDateTime revoked;
  private String refreshToken;

  public String getAccessToken() {
    return accessToken;
  }

  public AuthnToken setAccessToken(String accessToken) {
    this.accessToken = accessToken;

    return this;
  }

  public String getAuthnRequestId() {
    return authnRequestId;
  }

  public AuthnToken setAuthnRequestId(String authnRequestId) {
    this.authnRequestId = authnRequestId;

    return this;
  }

  public String getCode() {
    return code;
  }

  public AuthnToken setCode(String code) {
    this.code = code;

    return this;
  }

  public int getExpiresIn() {
    return expiresIn;
  }

  public AuthnToken setExpiresIn(int expiresIn) {
    this.expiresIn = expiresIn;

    return this;
  }

  public String getIdToken() {
    return idToken;
  }

  public AuthnToken setIdToken(String idToken) {
    this.idToken = idToken;

    return this;
  }

  public String getRefreshToken() {
    return refreshToken;
  }

  public AuthnToken setRefreshToken(String refreshToken) {
    this.refreshToken = refreshToken;

    return this;
  }

  public LocalDateTime getRevoked() {
    return revoked;
  }

  public AuthnToken setRevoked(LocalDateTime revoked) {
    this.revoked = revoked;

    return this;
  }

  public String getScope() {
    return scope;
  }

  public AuthnToken setScope(String scope) {
    this.scope = scope;

    return this;
  }

  public String getTokenType() {
    return tokenType;
  }

  public AuthnToken setTokenType(String tokenType) {
    this.tokenType = tokenType;

    return this;
  }

  public String getUserKey() {
    return userKey;
  }

  public AuthnToken setUserKey(String userKey) {
    this.userKey = userKey;

    return this;
  }

}
