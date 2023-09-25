package application.Config;

import java.util.HashMap;
import java.util.Map;

public class SessionManager {
    private static Map<String, Object> sessionData = new HashMap<>();

    public static Map<String, Object> getInstance() {
        return sessionData;
    }

    public static void setAttribute(String key, Object value, long durationMillis) {
        sessionData.put(key, new SessionData(value, durationMillis));
    }

    public static Object getAttribute(String key) {
        return sessionData.get(key);
    }

    public static void removeAttribute(String key) {
        sessionData.remove(key);
    }

    public static void clearSession() {
        sessionData.clear();
    }

    private static class SessionData {
        private Object value;
        private long expirationTimeMillis;

        SessionData(Object value, long durationMillis) {
            this.value = value;
            this.expirationTimeMillis = System.currentTimeMillis() + durationMillis;
        }

        Object getValue() {
            return value;
        }

        boolean isExpired() {
            return System.currentTimeMillis() >= expirationTimeMillis;
        }
    }
}

