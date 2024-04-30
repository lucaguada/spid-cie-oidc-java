package it.spid.cie.oidc.config;

import it.spid.cie.oidc.exception.ConfigException;
import it.spid.cie.oidc.exception.OIDCException;
import it.spid.cie.oidc.schemas.ClaimItem;
import it.spid.cie.oidc.schemas.ClaimSection;
import org.json.JSONObject;

import java.util.*;
import java.util.stream.Stream;

import static it.spid.cie.oidc.schemas.ClaimSection.ID_TOKEN;
import static it.spid.cie.oidc.schemas.ClaimSection.USER_INFO;
import static java.util.Collections.emptySet;
import static java.util.Collections.unmodifiableSet;

public record ClaimOptions(Map<ClaimSection, Set<OptionItem>> claims) {
  public ClaimOptions() {
    this(new HashMap<>());
  }

  public void addSectionItem(ClaimSection section, ClaimItem claimItem, Boolean essential) throws OIDCException {
    Set<OptionItem> options = claims.computeIfAbsent(section, _ -> new HashSet<>());

    options.add(new OptionItem(claimItem, essential));
  }

  public Set<OptionItem> getSectionItems(ClaimSection section) {
    return unmodifiableSet(claims.getOrDefault(section, emptySet()));
  }

  public boolean hasEssentialItem(String value) {
    return Stream.concat(
        getSectionItems(ID_TOKEN).stream(),
        getSectionItems(USER_INFO).stream()
      )
      .anyMatch(it -> it.isEssential() && it.matchesClaimItem(value));
  }

  public boolean isEmpty() {
    return claims.isEmpty();
  }

  public JSONObject asJson() {
    JSONObject idToken = new JSONObject();

    for (OptionItem option : getSectionItems(ID_TOKEN)) {
      JSONObject value = new JSONObject();

      option.essential.ifPresent(essential -> value.put("essential", essential));

      idToken.put(option.claimItem().getAlias(), value);
    }

    JSONObject userInfo = new JSONObject();

    for (OptionItem option : getSectionItems(USER_INFO)) {
      JSONObject value = new JSONObject();

      option.essential().ifPresent(essential -> value.put("essential", essential));

      userInfo.put(option.claimItem().getAlias(), value);
    }

    return new JSONObject()
      .put("id_token", idToken)
      .put("userinfo", userInfo);
  }

  public record OptionItem(ClaimItem claimItem, Optional<Boolean> essential) {
    public OptionItem(ClaimItem claimItem, Boolean essential) throws OIDCException {
      if (claimItem == null) throw new ConfigException("claimItem is null");

      this(claimItem, Optional.ofNullable(essential));
    }

    public boolean isEssential() {
      return essential.orElse(false);

    }

    public boolean matchesClaimItem(String value) {
      return Objects.equals(value, claimItem.getName()) || Objects.equals(value, claimItem.getAlias());
    }
  }

}
