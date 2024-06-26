package it.spid.cie.oidc.exception;

@SuppressWarnings("serial")
public class SchemaException extends OIDCException {

  private SchemaException(String message) {
    super(message);
  }

  private SchemaException(Throwable cause) {
    super(cause);
  }

  public static class Validation extends SchemaException {

    public Validation(String message) {
      super(message);
    }

    public Validation(Throwable cause) {
      super(cause);
    }

  }

}
