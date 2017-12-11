package com.company.common.base.services.config;

import com.company.common.base.config.DatabaseConfig;
import com.company.common.base.services.constants.EnvironmentKeys;

public class EnvironmentBasedMySQLConfiguration implements DatabaseConfig {

    private String getFromEnv(String field) {
        String result = System.getenv(field);
        if (result == null) {
            throw new RuntimeException("Environment variable: '" + field + "' does not exist");
        }
        return result;
    }

    @Override
    public String getDriverClass() {
        return "com.mysql.jdbc.Driver";
    }

    @Override
    public String getUsername() {
        return this.getFromEnv(EnvironmentKeys.MYSQL_USER);
    }

    @Override
    public String getPassword() {
        return this.getFromEnv(EnvironmentKeys.MYSQL_PASSWORD);
    }

    @Override
    public String getServer() {
        return this.getFromEnv(EnvironmentKeys.MYSQL_URL);
    }

    @Override
    public String getServer(final int clusterNumber) {
        throw new UnsupportedOperationException("This method is unsupported, use the 'getUrl()' method.");
    }

    @Override
    public String getDb() {
        return this.getFromEnv(EnvironmentKeys.MYSQL_DEFAULT_DATABASE);
    }

    @Override
    public String getUrl() {
        if (this.getDb().equals("")) {
            return this.getFromEnv(EnvironmentKeys.MYSQL_URL);
        } else {
            return this.getFromEnv(EnvironmentKeys.MYSQL_URL) + "/" + this.getDb();
        }
    }

    @Override
    public String getUrl(final int clusterNumber) {
        throw new UnsupportedOperationException("A MySQL URL does not have a clusterNumber");
    }

    @Override
    public int getConnectionMin() {
        String connectionMin = this.getFromEnv(EnvironmentKeys.MYSQL_CONNECTION_MINIMUM_IDLE);
        return Integer.parseInt(connectionMin);
    }

    @Override
    public int getConnectionMax() {
        String connectionMax = this.getFromEnv(EnvironmentKeys.MYSQL_CONNECTION_MAXIMUM_CONNECTIONS);
        return Integer.parseInt(connectionMax);
    }

    @Override
    public long getConnectionTimeoutMs() {
        String connectionTimeout = this.getFromEnv(EnvironmentKeys.MYSQL_CONNECTION_TIMEOUT);
        return Integer.parseInt(connectionTimeout);
    }

    @Override
    public long getConnectionIdleTimeoutMs() {
        String connectionTimeout = this.getFromEnv(EnvironmentKeys.MYSQL_IDLE_TIMEOUT);
        return Integer.parseInt(connectionTimeout);
    }

    @Override
    public long getConnectionMaxLifetimeMs() {
        return Long.parseLong(this.getFromEnv(EnvironmentKeys.MYSQL_CONNECTION_MAX_LIFETIME));
    }

    @Override
    public String getConnectionTestQuery() {
        return "SELECT 1";
    }
}
