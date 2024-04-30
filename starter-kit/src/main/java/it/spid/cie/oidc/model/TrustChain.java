package it.spid.cie.oidc.model;

import org.json.JSONObject;

import java.time.LocalDateTime;

public class TrustChain extends BaseModel {

  private boolean active;
  private String chain;
  private LocalDateTime exp;
  private LocalDateTime iat;
  private String log = "";
  private String metadata;
  private String partiesInvolved;
  private LocalDateTime processingStart;
  private String status = "unreachable";
  private String sub;
  private String trustAnchor;
  private String trustMarks;
  private String type;

  public TrustChain() {
    super();
    this.iat = LocalDateTime.now();
  }

  /**
   * @return the string representation of a JSONArray with the list of entity statements
   * collected during the metadata discovery
   */
  public String getChain() {
    return chain;
  }

  public TrustChain setChain(String chain) {
    this.chain = chain;

    return this;
  }

  public LocalDateTime getExpiresOn() {
    return exp;
  }

  public TrustChain setExpiresOn(LocalDateTime expiresOn) {
    this.exp = expiresOn;

    return this;
  }

  public LocalDateTime getIssuedAt() {
    return iat;
  }

  public TrustChain setIssuedAt(LocalDateTime issuedAt) {
    this.iat = issuedAt;

    return this;
  }

  public String getLog() {
    return log;
  }

  public TrustChain setLog(String log) {
    this.log = log;

    return this;
  }

  /**
   * @return the string representation of a JSONObject with the final metadata applied
   * with the metadata policy built over the chain
   */
  public String getMetadata() {
    return metadata;
  }

  public TrustChain setMetadata(String metadata) {
    this.metadata = metadata;

    return this;
  }

  public JSONObject getMetadataAsJSON() {
    try {
      return new JSONObject(this.metadata);
    } catch (Exception e) {
      // Ignore
    }

    return new JSONObject();
  }

  public String getPartiesInvolved() {
    return partiesInvolved;
  }

  public TrustChain setPartiesInvolved(String partiesInvolved) {
    this.partiesInvolved = partiesInvolved;

    return this;
  }

  public LocalDateTime getProcessingStart() {
    return processingStart;
  }

  public TrustChain setProcessingStart(LocalDateTime processingStart) {
    this.processingStart = processingStart;

    return this;
  }

  public String getSubject() {
    return sub;
  }

  public TrustChain setSubject(String subject) {
    this.sub = subject;

    return this;
  }

  public String getStatus() {
    return status;
  }

  public TrustChain setStatus(String status) {
    this.status = status;

    return this;
  }

  public String getTrustAnchor() {
    return trustAnchor;
  }

  public TrustChain setTrustAnchor(String trustAnchor) {
    this.trustAnchor = trustAnchor;

    return this;
  }

  public String getTrustMarks() {
    return trustMarks;
  }

  public TrustChain setTrustMarks(String trustMarks) {
    this.trustMarks = trustMarks;

    return this;
  }

  public String getType() {
    return type;
  }

  public TrustChain setType(String type) {
    this.type = type;

    return this;
  }

  public boolean isActive() {
    return active;
  }

  public TrustChain setActive(boolean active) {
    this.active = active;

    return this;
  }

  public boolean isExpired() {
    if (exp != null) {
      return exp.isBefore(LocalDateTime.now());
    }

    return true;
  }

}
