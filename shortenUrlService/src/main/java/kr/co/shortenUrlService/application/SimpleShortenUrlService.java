package kr.co.shortenUrlService.application;

import kr.co.shortenUrlService.presentation.ShortenUrlCreateRequestDTO;
import kr.co.shortenUrlService.presentation.ShortenUrlCreateResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


//Service 코드의 역할
// - Controller 로 부터 넘어온 requestDTO 를 가지고 Domain 객체를 만들어서
//   레포지로리에게 전달해준다.
// - 만든 Domain 객체를 반환하기 위해 responseDTO 로 변환하여 반환한다.
@Service
public class SimpleShortenUrlService{
  private ShortenUrlRepository shortenUrlRepository;

  @Autowired
  public SimpleShortenUrlService(ShortenUrlRepository shortenUrlRepository) {
    this.shortenUrlRepository = shortenUrlRepository;
  }


  public ShortenUrlCreateResponseDTO generateShortenUrl(
      ShortenUrlCreateRequestDTO shortenUrlCreateRequestDTO
  ){
    //해야하는 일
    //1. 원본 URL과 단축 URL 키 생성

    //2. 원본 URL과 단축 URL 키를 통해 ShortenUrl 객체 생성

    //3. 생성된 ShortenUrl 객체를 레포지토리를 통해 저장

    //4. ShortenUrl 을 ShortenUrlCreateResponseDTO로 변환하여서 반환

    return null;
  }
}
