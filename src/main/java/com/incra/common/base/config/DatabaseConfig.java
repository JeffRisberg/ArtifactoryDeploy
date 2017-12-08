package com.incra.common.base.config;

/**
 */
public interface DatabaseConfig {
    /**
     * JDBC driver full class name.
     *
     * @return JDBC driver full class name.
     */
    String getDriverClass();

    /**
     * DB user name.
     *
     * @return db user name.
     */
    String getUsername();

    /**
     * DB password.
     *
     * @return db password.
     */
    String getPassword();

    /**
     * Location and port number of the db.
     *
     * @return location and port number of the db.
     */
    String getServer();

    /**
     * Location and port number of the db for the specified cluster.
     *
     * @return location and port number of the db for the specified cluster.
     */
    String getServer(int clusterNumber);

    /**
     * Default database name.
     *
     * @return default database name.
     */
    String getDb();

    /**
     * Full JDBC url to connect to the db.
     *
     * @return full JDBC url to connect to the db.
     */
    String getUrl();

    /**
     * Full JDBC url to connect to the db with a specified cluster number.
     *
     * @param clusterNumber the specified cluster number.
     * @return full JDBC url to connect to the db with a specified cluster number.
     */
    String getUrl(int clusterNumber);

    int getConnectionMin();

    int getConnectionMax();

    long getConnectionTimeoutMs();

    long getConnectionIdleTimeoutMs();

    long getConnectionMaxLifetimeMs();

    /**
     * 'Test' query fired periodically by the connection pool to keep the connection open.
     *
     * @return 'Test' query fired periodically by the connection pool to keep the connection open.
     */
    String getConnectionTestQuery();
}
