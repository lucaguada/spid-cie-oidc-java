package it.spid.cie.oidc.exception;

import it.spid.cie.oidc.model.TrustChain;

import java.time.LocalDateTime;

public class TrustChainException extends OIDCException {

  private static final long serialVersionUID = 602471019127315717L;

  private TrustChainException(String message) {
    super(message);
  }

  @SuppressWarnings("serial")
  public static class MissingProvider extends TrustChainException {

    public static final String DEFAULT_MESSAGE =
      "Missing provider url. Please try '?provider=https://provider-subject/'";

    public MissingProvider() {
      super(DEFAULT_MESSAGE);
    }

  }

  @SuppressWarnings("serial")
  public static class InvalidRequiredTrustMark extends TrustChainException {

    public InvalidRequiredTrustMark(String message) {
      super(message);
    }

  }

  @SuppressWarnings("serial")
  public static class InvalidTrustAnchor extends TrustChainException {

    public static final String DEFAULT_MESSAGE = "Unallowed Trust Anchor";

    public InvalidTrustAnchor() {
      super(DEFAULT_MESSAGE);
    }

  }

  @SuppressWarnings("serial")
  public static class InvalidTrustChain extends TrustChainException {

    public InvalidTrustChain(String message) {
      super(message);
    }

  }

  @SuppressWarnings("serial")
  public static class MissingMetadata extends TrustChainException {

    public MissingMetadata(String message) {
      super(message);
    }

  }

  @SuppressWarnings("serial")
  public static class TrustAnchorNeeded extends TrustChainException {

    public TrustAnchorNeeded(String message) {
      super(message);
    }

  }

  @SuppressWarnings("serial")
  public static class TrustChainDisabled extends TrustChainException {

    public TrustChainDisabled(TrustChain trustChain) {
      super(getDefaultMessage(trustChain.getModifiedDate()));
    }

    public TrustChainDisabled(String message) {
      super(message);
    }

    public static String getDefaultMessage(LocalDateTime modifiedDate) {
      return String.format(
        "TrustChain DISABLED at %s", String.valueOf(modifiedDate));
    }
  }

}
