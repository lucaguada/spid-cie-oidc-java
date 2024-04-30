package it.spid.cie.oidc.model;

public class AuthnRequest extends BaseModel {

  private String clientId;
  private String state;
  private String endpoint;
  private String data;
  private boolean successful;
  private String providerConfiguration;
  private String provider;
  private String providerId;
  private String providerJwks;

  public String getClientId() {
    return clientId;
  }

  public AuthnRequest setClientId(String clientId) {
    this.clientId = clientId;

    return this;
  }

  public String getEndpoint() {
    return endpoint;
  }

  public AuthnRequest setEndpoint(String endpoint) {
    this.endpoint = endpoint;

    return this;
  }

  public String getData() {
    return data;
  }

  public AuthnRequest setData(String data) {
    this.data = data;

    return this;
  }

  public String getProvider() {
    return provider;
  }

  public AuthnRequest setProvider(String provider) {
    this.provider = provider;

    return this;
  }

  public String getProviderConfiguration() {
    return providerConfiguration;
  }

  public AuthnRequest setProviderConfiguration(String providerConfiguration) {
    this.providerConfiguration = providerConfiguration;

    return this;
  }

  public String getProviderId() {
    return providerId;
  }

  public AuthnRequest setProviderId(String providerId) {
    this.providerId = providerId;

    return this;
  }

  public String getProviderJwks() {
    return providerJwks;
  }

  public AuthnRequest setProviderJwks(String providerJwks) {
    this.providerJwks = providerJwks;

    return this;
  }

  public String getState() {
    return state;
  }

  public AuthnRequest setState(String state) {
    this.state = state;

    return this;
  }

  public boolean isSuccessful() {
    return successful;
  }

  public AuthnRequest setSuccessful(boolean successful) {
    this.successful = successful;

    return this;
  }

}
