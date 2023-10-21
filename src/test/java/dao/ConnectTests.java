package dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectTests {
    @Test
    public void testConnection() throws Exception{
        Class.forName("org.mariadb.jdbc.Driver"); //JDBC 드라이버 클래스를 메모리상에 로딩

        Connection con = DriverManager.getConnection( //Connection 클래스: DB와 자바 연결 성립, 인자는 DB 관련 정보들
                "jdbc:mariadb://localhost:3306/webdb",
                "webuser",
                "webuser"
        );
        Assertions.assertNotNull(con); // Not Null 여부 테스트
        con.close(); // 연결 종료
    }

}
