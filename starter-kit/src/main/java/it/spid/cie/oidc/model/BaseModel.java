package it.spid.cie.oidc.model;

import java.time.LocalDateTime;

public abstract class BaseModel {

  private String storageId;
  private LocalDateTime createDate;
  private LocalDateTime modifiedDate;

  protected BaseModel() {
    this.createDate = LocalDateTime.now();
    this.modifiedDate = createDate;
  }

  public LocalDateTime getCreateDate() {
    return createDate;
  }

  public void setCreateDate(LocalDateTime createDate) {
    this.createDate = createDate;
  }

  public LocalDateTime getModifiedDate() {
    return modifiedDate;
  }

  public void setModifiedDate(LocalDateTime modifiedDate) {
    this.modifiedDate = modifiedDate;
  }

  public String getStorageId() {
    return storageId;
  }

  public void setStorageId(String storageId) {
    this.storageId = storageId;
  }

}
