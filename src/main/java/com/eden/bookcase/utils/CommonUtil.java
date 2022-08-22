package com.eden.bookcase.utils;

import java.util.List;
import java.util.Map;

public class CommonUtil {

  /**
   * 공백 또는 Null 체크
   *
   * @param obj
   * @return
   */
  public static boolean isEmpty(Object obj) {
    if (obj == null) return true;
    if ((obj instanceof String) && (((String) obj).trim().length() == 0)) {
      return true;
    }
    if (obj instanceof Map) {
      return ((Map<?, ?>) obj).isEmpty();
    }
    if (obj instanceof Map) {
      return ((Map<?, ?>) obj).isEmpty();
    }
    if (obj instanceof List) {
      return ((List<?>) obj).isEmpty();
    }
    if (obj instanceof Object[]) {
      return (((Object[]) obj).length == 0);
    }
    return false;
  }

//  public static String paramToQueryString(Map<String, Object> paramMap) {
//    List<NameValuePair> params = new ArrayList<>();
//    if (paramMap != null) {
//      for (Map.Entry<String, Object> paramEntry : paramMap.entrySet()) {
//        Object value = paramEntry.getValue();
//        if (value != null) {
//          params.add(new BasicNameValuePair(paramEntry.getKey(), value.toString()));
//        }
//      }
//    }
//    return URLEncodedUtils.format(params, "UTF-8");
//  }


}
