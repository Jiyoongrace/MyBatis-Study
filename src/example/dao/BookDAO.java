package example.dao;

import example.vo.BookVO;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.HashMap;
import java.util.List;

public class BookDAO {

    // 여기서 SqlSessionFactory를 직접 얻어내지 않는다.
    // 생성자를 통해 주입받아서 사용한다.
    private SqlSessionFactory sqlSessionFactory;

    public BookDAO() {
    }

    // 생성자 주입 Constructor Injection
    public BookDAO(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    // 1. ISBN 번호를 입력으로 받아서 책 1권의 데이터를 HashMap으로 만들어서 리턴하는 method를 작성해보자.
    public HashMap<String, Object> selectByISBNHashMap(String bisbn) {

        HashMap<String, Object> result = null;
        SqlSession session = sqlSessionFactory.openSession();

        try {
            result = session.selectOne("example.mybook.selectByISBNHashMap", bisbn);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            session.close();
        }
        return result;
    }

    // 2. 모든 책의 데이터를 HashMap의 List로 만들어서 리턴하는 method를 작성해보자.
    public List<HashMap<String, Object>> selectByAllHashMap() {

        List<HashMap<String, Object>> result = null;
        SqlSession session = sqlSessionFactory.openSession();

        try {
            result = session.selectList("example.mybook.selectByAllHashMap");
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            session.close();
        }
        return result;
    }

    // 3. ISBN 번호를 입력으로 받아서 책 1권의 데이터를 BookVO로 만들어서 리턴하는 method를 작성해보자.
    public BookVO selectByISBNBookVO(String bisbn) {

        BookVO result = null;
        SqlSession session = sqlSessionFactory.openSession();

        try {
            result = session.selectOne("example.mybook.selectByISBNBookVO", bisbn);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            session.close();
        }
        return result;
    }

    // 4. ISBN 번호를 이용해서 책 1권의 정보를 BookVO로 변환해서 가져오기
    // 그러나 table의 column명이 VO의 field명과 다른 경우 하는 방법
    public BookVO selectByISBNResultMap(String bisbn) {

        BookVO result = null;
        SqlSession session = sqlSessionFactory.openSession();

        try {
            result = session.selectOne("example.mybook.selectByISBNBookVO", bisbn);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            session.close();
        }
        return result;
    }

    // 5. ISBN 번호를 이용해서 책 1권의 정보를 변경하고 싶다.
    // 책 제목을 바꿀 때
    public int titleUpdate(BookVO bookVO) {

        int result = 0;
        SqlSession session = sqlSessionFactory.openSession();

        try {
            result = session.update("example.mybook.titleUpdate", bookVO);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            session.commit(); // update 계열은 반드시 처리해야 한다. 하지 않으면 데이터베이스에 반영이 안된다.
            session.close();
        }
        return result;
    }
}
