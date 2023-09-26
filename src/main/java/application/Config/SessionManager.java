package application.Config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class SessionManager {
    private static Map<String, SessionData> sessionData = new HashMap<>();

    public SessionManager() {
    }

    public static void setAttribute(String key, Integer value, long durationMillis) {
        sessionData.put(key, new SessionData(value, durationMillis));
    }
    public static Boolean verifyValue(String key, int otp) {
        for (Map.Entry<String, SessionData> s : sessionData.entrySet()) {
            if (Objects.equals(s.getKey(), key)) {
                SessionData se = s.getValue();
                if (se != null && !se.isExpired() && se.getValue() == otp) {
                    return true; // Session data is valid
                }
            }
        }
        return false; // Session data is either expired or not found
    }

    public static void removeAttribute(String key) {
        sessionData.remove(key);
    }

    public static void clearSession() {
        sessionData.clear();
    }

    private static class SessionData {
        private Integer value;
        private long expirationTimeMillis;

        SessionData(Integer value, long durationMillis) {
            this.value = value;
            this.expirationTimeMillis = System.currentTimeMillis() + durationMillis;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        boolean isExpired() {
            return System.currentTimeMillis() >= expirationTimeMillis;
        }
    }
}

