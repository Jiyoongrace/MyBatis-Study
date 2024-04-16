package example;

import example.dao.BookDAO;
import example.mybatis.MyBatisConnectionFactory;
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
//        HashMap<String, Object> result = dao.selectByISBNHashMap("89-7914-274-9");
//
//        // 결과가 null이 아닌 경우에만 처리
//        if (result != null) {
//            for (String key : result.keySet()) {
//                System.out.println(key + " : " + result.get(key));
//            }
//        }
        List<HashMap<String, Object>> result = dao.selectByAllHashMap();
        for(HashMap<String, Object> map : result) {
            for (String key: map.keySet()) {
                System.out.println(key + " : " + map.get(key));
            }
            System.out.println();
        }
    }
}
