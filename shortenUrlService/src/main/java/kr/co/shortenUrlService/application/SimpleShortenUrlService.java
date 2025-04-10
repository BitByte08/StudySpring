package kr.co.shortenUrlService.application;

import kr.co.shortenUrlService.domain.ShortenUrl;
import kr.co.shortenUrlService.domain.ShortenUrlRepository;
import kr.co.shortenUrlService.presentation.ShortenUrlCreateRequestDTO;
import kr.co.shortenUrlService.presentation.ShortenUrlCreateResponseDTO;
import kr.co.shortenUrlService.presentation.ShortenUrlInformationDTO;
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
  ) {
    //해야하는 일
    //1. 원본 URL 과 단축 URL 키 생성
    String originalUrl = shortenUrlCreateRequestDTO.getOriginalUrl();
    String shortenUrlKey = ShortenUrl.generateShortenUrlKey();
    //2. 원본 URL 과 단축 URL 키를 통해 ShortenUrl 객체 생성
    ShortenUrl shortenUrl = new ShortenUrl(originalUrl, shortenUrlKey);
    //3. 생성된 ShortenUrl 객체를 레포지토리를 통해 저장
    shortenUrlRepository.saveShortenUrl(shortenUrl);
    //4. ShortenUrl 을 ShortenUrlCreateResponseDTO 로 변환하여서 반환
    return new ShortenUrlCreateResponseDTO(shortenUrl);
  }

  public ShortenUrlInformationDTO getShortenUrlInformationByShortenUrlKey(String shortenUrlKey) {
    //shortenUrlInfo를 찾기 전에 먼저 key로 shortenUrl 도메인 객체 부터 찾는다.
    ShortenUrl shortenUrl = shortenUrlRepository.findShortenUrlByShortenUrlKey(shortenUrlKey);
    //찾는 shortenUrl을 이용해서 shortenUrlInfomationDTO를 생성해서 반환한다.
    return new ShortenUrlInformationDTO(shortenUrl);
  }

  public String getOriginalUrlByShortenUrlKey(String shortenUrlKey) {
    //레포지토리에서 키를 이용하여 shortenUrl을 우선 찾고, 그 찾은 shortenUrl의 originalUrl을 찾아 반환
    ShortenUrl shortenUrl = shortenUrlRepository.findShortenUrlByShortenUrlKey(shortenUrlKey);
    //리다이렉트 한번 했으니 redirectCount + 1하기
    //자바빈 규약에 따라 도메인의 get(), set() 메서드를 난발하면 안된다.
    //대신 도메인 메서드를 따로 만들어서 호출해야하며
    //이는 캡슐화(encapsulation)를 시켰다라고도 표현한다.
    shortenUrl.increaseRedirectCount();
    return shortenUrl.getOriginalUrl();

  }
}
