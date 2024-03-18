package kr.mjc.rachel.jdbc;

import org.mariadb.jdbc.MariaDbDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

public class DataSourceFactory {

  private static final DataSource dataSource = createDataSource();

  private static DataSource createDataSource() {
    Properties props = new Properties();
    try {
      props.load(DataSourceFactory.class.getResourceAsStream(
          "/application.properties"));
      return new MariaDbDataSource(props.getProperty("db.url"));
    } catch (IOException | SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public static DataSource getDataSource() {
    return dataSource;
  }
}
