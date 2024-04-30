package it.spid.cie.oidc.util;

import org.json.JSONArray;

import java.util.Objects;

public interface Json {

  static JSONArray array(String... values) {
    return new JSONArray(values);
  }

  static boolean contains(JSONArray array, String value) {
    if (array.isEmpty()) {
      return false;
    }

    for (int x = 0; x < array.length(); x++) {
      String elem = array.optString(x);

      if (Objects.equals(value, elem)) {
        return true;
      }
    }

    return false;
  }

}
