package org.slashdash.config;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.slashdash.constant.Constants.CONFIG_FILE;

public class DatabaseConfig {
  private static final Config config = ConfigFactory.load(CONFIG_FILE).getConfig("database");

  private static final String URL = config.getString("url");
  private static final String USER = config.getString("user");
  private static final String PASSWORD = config.getString("password");

  public static DSLContext getDSLContext() throws SQLException {
    Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
    return DSL.using(conn, SQLDialect.POSTGRES);
  }
}
