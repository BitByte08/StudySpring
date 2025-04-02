package kr.co.shortenUrlService.domain;

import org.springframework.stereotype.Repository;


//Repository 의 역할은 서비스로부터 받아온 Domain 객체를 Database 에 저장함.
//여기서는 Java 자료구조에만 저장하여 로컬에서만 사용함.
//어떤 레포지토리는 데이터베이스에 저장하고 어떤 레포지토리는 자바 자료구조에 저장하도록 유연하게
// 코드를 작성하려면 레포지토이를 인터페이스로 만드는 것이 좋음
@Repository
public class ShortenUrlRepository {

}
