# MyBatis-Study
MyBatis-Study


## 1. MyBatis

- Database 연동을 도와주는 Framework
    
    <aside>
    💡 기존 바닐라 형태 JDBC는 연동 과정도 복잡하고, 반복적인 코드가 나오면서 SQL 문장이 자바 코드와 섞여 있어서 유지보수가 힘들다. 따라서 이런 점을 개선하여 편의성과 유지보수성을 높이기 위하 목적으로 사용된다.
    
    </aside>
    
- Controller에서 Service를 호출하고 Service에서 DAO를 이용해서 Database를 처리할 때 DAO에서 MyBatis를 사용해서 Database 처리를 하게 된다.

### 1.1 MyBatis 특징

- 복잡한 JDBC 코드를 걷어내고 **`깔끔한 소스 코드`**를 유지할 수 있다.
- SQL 실행 결과가 기본적으로 **`Map에 Mapping`** 된다.
    - 기본 JDBC는 ResultSet이라는 커서를 리턴 받아서 일반적으로 while을 돌면서 결과 처리를 하게 되는데, 이 과정이 생략되고 자동으로 결과 데이터가 HashMap에 저장된다. HashMap 뿐만 아니라 **`VO에도 저장이 가능`**하다.
- SQL 문장을 자바 소스 코드에서 분리해서 따로 **`XML 파일`**로 관리한다.
- DataSource 기능과 Transaction 처리 기능을 제공한다.
    - DataSource(Connection Pool)
    - Pool은 Resource를 모아놓은 저장소
    - Connection의 집합체 = Connection Pool
        ![Untitled (25)](https://github.com/Jiyoongrace/MyBatis-Study/assets/88182667/2d93ec74-be90-4125-bc43-2d990a0d0091)

        
        
    

## 2. MyBatis download & 설정

## 3. XML(SqlMapConfig.xml)파일 생성
