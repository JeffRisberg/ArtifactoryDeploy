package com.company.common.base.config;

import org.apache.commons.configuration.Configuration;

import java.util.Iterator;

/**
 * Application Config.
 */
public interface AppConfig {
    @Deprecated
    String getString(String key, String defaultValue);

    String getString(String key);

    @Deprecated
    int getInt(String key, int defaultValue);

    int getInt(String key);

    @Deprecated
    long getLong(String key, long defaultValue);

    long getLong(String key);

    @Deprecated
    double getDouble(String key, double defaultValue);

    double getDouble(String key);

    @Deprecated
    boolean getBoolean(String key, boolean defaultValue);

    boolean getBoolean(String key);

    Iterator<String> getKeys(String prefix);

    Configuration getUnderlyingConfig();

    /**
     * Sets an instance-level override. This will trump everything including
     * dynamic properties and system properties. Useful for tests.
     *
     * @param key   the specified key.
     * @param value the specified value.
     */
    void setOverrideProperty(String key, Object value);
}
