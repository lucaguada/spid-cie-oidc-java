package it.spid.cie.oidc.config;

import it.spid.cie.oidc.exception.ConfigException;
import it.spid.cie.oidc.exception.OIDCException;
import it.spid.cie.oidc.util.ArrayUtil;
import it.spid.cie.oidc.util.Validator;

import java.util.Collections;
import java.util.Set;

public class GlobalOptions<GLOBAL_OPTIONS extends GlobalOptions<GLOBAL_OPTIONS>> {

  public static final int DEFAULT_EXPIRING_MINUTES = 30;

  public static final String DEFAULT_SIGNING_ALG = "RS256";

  public static final String[] SUPPORTED_ENCRYPTION_ENCODINGS = { "A128CBC-HS256", "A192CBC-HS384", "A256CBC-HS512", "A128GCM", "A192GCM", "A256GCM" };

  public static final String[] SUPPORTED_ENCRYPTION_ALGS = { "RSA-OAEP", "RSA-OAEP-256", "ECDH-ES", "ECDH-ES+A128KW", "ECDH-ES+A192KW", "ECDH-ES+A256KW" };

  public static final String[] SUPPORTED_SIGNING_ALGS = { "RS256", "RS384", "RS512", "ES256", "ES384", "ES512" };

  private String jweDefaultAlgorithm = "RSA-OAEP";
  private String jweDefaultEncryption = "A256CBC-HS512";
  private String jwsDefaultAlgorithm = "RS256";
  private Set<String> allowedSigningAlgs = Set.of("RS256", "RS384", "RS512", "ES256", "ES384", "ES512");
  private Set<String> allowedEncryptionAlgs = Set.of("RSA-OAEP", "RSA-OAEP-256", "ECDH-ES", "ECDH-ES+A128KW", "ECDH-ES+A192KW", "ECDH-ES+A256KW");

  public int getDefaultExpiringMinutes() {
    return DEFAULT_EXPIRING_MINUTES;
  }

  public String getDefaultJWEAlgorithm() {
    return jweDefaultAlgorithm;
  }

  @SuppressWarnings("unchecked")
  private GLOBAL_OPTIONS self() { return switch (this) {
    case GLOBAL_OPTIONS it -> it;
    
  }; }

  @SuppressWarnings("unchecked")
  public GLOBAL_OPTIONS setDefaultJWEAlgorithm(String algorithm) {
    if (!Validator.isNullOrEmpty(algorithm)) {
      jweDefaultAlgorithm = algorithm;
    }

    return (GLOBAL_OPTIONS) this;
  }

  public String getDefaultJWEEncryption() {
    return jweDefaultEncryption;
  }

  @SuppressWarnings("unchecked")
  public GLOBAL_OPTIONS setDefaultJWEEncryption(String encMethod) {
    if (!Validator.isNullOrEmpty(encMethod)) {
      jweDefaultEncryption = encMethod;
    }

    return (GLOBAL_OPTIONS) this;
  }

  public String getDefaultJWSAlgorithm() {
    return jwsDefaultAlgorithm;
  }

  @SuppressWarnings("unchecked")
  public GLOBAL_OPTIONS setDefaultJWSAlgorithm(String algorithm) {
    if (!Validator.isNullOrEmpty(algorithm)) {
      jwsDefaultAlgorithm = algorithm;
    }

    return (GLOBAL_OPTIONS) this;
  }

  public Set<String> getAllowedEncryptionAlgs() {
    return Collections.unmodifiableSet(allowedEncryptionAlgs);
  }

  @SuppressWarnings("unchecked")
  public GLOBAL_OPTIONS setAllowedEncryptionAlgs(String... values) {
    if (values.length > 0) {
      allowedEncryptionAlgs = ArrayUtil.asSet(values);
    }

    return (GLOBAL_OPTIONS) this;
  }

  public Set<String> getAllowedSigningAlgs() {
    return Collections.unmodifiableSet(allowedSigningAlgs);
  }

  @SuppressWarnings("unchecked")
  public GLOBAL_OPTIONS setAllowedSigningAlgs(String... values) {
    if (values.length > 0) {
      allowedSigningAlgs = ArrayUtil.asSet(values);
    }

    return (GLOBAL_OPTIONS) this;
  }

  protected void validate() throws OIDCException {
    for (String alg : allowedEncryptionAlgs) {
      if (!ArrayUtil.contains(SUPPORTED_ENCRYPTION_ALGS, alg)) {
        throw new ConfigException(
          "allowedEncryptionAlg %s is not supported", alg);
      }
    }

    if (!allowedEncryptionAlgs.contains(jweDefaultAlgorithm)) {
      throw new ConfigException(
        "Not allowed jweDefaultAlgorithm %s", jweDefaultAlgorithm);
    }

    if (!allowedSigningAlgs.contains(jwsDefaultAlgorithm)) {
      throw new ConfigException(
        "Not allowed jwsDefaultAlgorithm %s", jwsDefaultAlgorithm);
    }

  }

}
