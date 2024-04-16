package example.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

public class MyBatisConnectionFactory {
    // 실제 프로그램에서 (DAO)에서 사용하는 데이터베이스 연결 객체는
    // 기존에는(JDBC)일 때는 Connection 객체를 이용했다.
    // MyBatis에서는 SqlSession이라는 객체를 이용한다.
    private static SqlSessionFactory sqlSessionFactory;

    // 이 Factory 객체는 해당 클래스로부터 객체가 1개만 만들어져서 사용되도록 처리할 것이다.
    // => Singleton으로 동작하게끔 만든다.
    static {
        try {
            String resource = "./SqlMapConfig.xml";
            Reader reader = Resources.getResourceAsReader(resource);

            if (sqlSessionFactory == null) {
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }

}
