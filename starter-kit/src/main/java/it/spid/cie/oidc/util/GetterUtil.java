package it.spid.cie.oidc.util;

public class GetterUtil {

  public static long getLong(String value) {
    return getLong(value, 0L);
  }

  public static long getLong(String value, long defaultValue) {
    try {
      return Long.parseLong(value);
    } catch (Exception e) {
      return defaultValue;
    }
  }

  public static <T> T getObject(T value, T defaultValue) {
    return value != null ? value : defaultValue;

  }

  public static int getRangeEnd(int value, int maxValue) {
    return Math.min(value, maxValue);
  }

  public static int getRangeStart(int value) {
    return getRangeStart(0, value);
  }

  public static int getRangeStart(int value, int minValue) {
    return Math.max(value, minValue);
  }

  public static String getString(Object obj) {
    return switch (obj) {
      case String s -> s;
      default -> obj.toString();
    };
  }

  public static String getString(Object obj, String defaultValue) {
    if (obj == null) {
      return defaultValue;
    }
    if (obj instanceof String) {
      return (String) obj;
    } else {
      return obj.toString();
    }
  }

}
