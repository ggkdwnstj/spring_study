package dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectTests {
    @Test
    public void testConnection() throws Exception {
        Class.forName("org.mariadb.jdbc.Driver"); //JDBC 드라이버 클래스를 메모리상에 로딩

        Connection conn = DriverManager.getConnection( //Connection 클래스: DB와 자바 연결 성립, 인자는 DB 관련 정보들
                "jdbc:mariadb://localhost:3306/webdb",
                "webuser",
                "webuser"
        );
        Assertions.assertNotNull(conn); // Not Null 여부 테스트
        conn.close(); // 연결 종료
    }

    @Test
    public void testHikariCP() throws Exception {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("org.mariadb.jdbc.Driver");
        config.setJdbcUrl("jdbc:mariadb://localhost:3306/webdb");
        config.setUsername("webuser");
        config.setPassword("webuser");
        config.addDataSourceProperty("cachePrepStmts", true);
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        HikariDataSource ds = new HikariDataSource(config);
        Connection conn = ds.getConnection();
        System.out.println("connection");

        conn.close();
    }
}
