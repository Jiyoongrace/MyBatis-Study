package example;

import example.dao.BookDAO;
import example.mybatis.MyBatisConnectionFactory;
import example.vo.BookVO;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // 데이터베이스 처리
        // DAO가 있어야 데이터베이스 처리를 할 수 있다.
        // DAO를 만들려면 SqlSessionFactory를 먼저 확보해야 이것을 주입해서 DAO를 만들 수 있다.
        SqlSessionFactory factory = MyBatisConnectionFactory.getSqlSessionFactory();
        BookDAO dao = new BookDAO(factory);


        // 1.
//        HashMap<String, Object> result = dao.selectByISBNHashMap("89-7914-274-9");
//
//        for (String key : result.keySet()) {
//                System.out.println(key + " : " + result.get(key));
//        }

        // 2.
//        List<HashMap<String, Object>> result = dao.selectByAllHashMap();
//        for(HashMap<String, Object> map : result) {
//            for (String key: map.keySet()) {
//                System.out.println(key + " : " + map.get(key));
//            }
//            System.out.println();
//        }

        // 3. ISBN 번호로 책 1권의 정보 BookVO로 변환
//        BookVO result = dao.selectByISBNBookVO("89-7914-274-9");
//        System.out.println(result);

        // 4. ISBN 번호를 이용해서 책 1권의 정보를 BookVO로 변환해서 가져오기
        // 그러나 table의 column명이 VO의 field명과 다른 경우 하는 방법
//        BookVO result = dao.selectByISBNResultMap("89-7914-274-9");
//        System.out.println(result);

        // 5. ISBN 번호를 이용해서 책 1권의 정보를 변경하고 싶다.
        // 책 제목을 바꿀 때
        BookVO bookVO = new BookVO("89-7914-274-9", "나는 고수 프로그래머다.", 0, null);
        int result = dao.titleUpdate(bookVO);
        System.out.println("영향을 받은 행의 개수: " + result);
    }
}
