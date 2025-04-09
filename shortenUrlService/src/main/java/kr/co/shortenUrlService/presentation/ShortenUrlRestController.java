package kr.co.shortenUrlService.presentation;

import jakarta.validation.Valid;
import kr.co.shortenUrlService.application.SimpleShortenUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;


@RestController
public class ShortenUrlRestController {
    private SimpleShortenUrlService simpleShortenUrlService;

    @Autowired
    public ShortenUrlRestController(SimpleShortenUrlService simpleShortenUrlService) {
        this.simpleShortenUrlService = simpleShortenUrlService;
    }


    //단축 url을 생성하는 api
    @PostMapping("/shortenUrl")
    public ShortenUrlCreateResponseDTO createShortenUrl(
        @Valid @RequestBody ShortenUrlCreateRequestDTO shortenUrlCreateRequestDTO
    ) {
        //Service 코드를 추가해야한다.
        //DTO 타입으로 반환해야한다.

      return simpleShortenUrlService.generateShortenUrl(shortenUrlCreateRequestDTO);
    }

    //key를 넘겨주면 리다이렉트해주는 api
    @GetMapping("{shortenUrlKey}")
    public ResponseEntity<?> retrieveShortenUrl(
        @PathVariable String shortenUrlKey
    ){
      String originalUrl = simpleShortenUrlService.getOriginalUrlByShortenUrlKey(shortenUrlKey);
      URI redirectUri = URI.create(originalUrl);
      HttpHeaders httpheaders = new HttpHeaders();
      httpheaders.setLocation(redirectUri);
      return new ResponseEntity<>(httpheaders,HttpStatus.MOVED_PERMANENTLY);
    }


    @GetMapping("/shortenUrl/{shortenUrlKey}")
    public ShortenUrlInformationDTO getShortenUrlInformation(
        @PathVariable String shortenUrlKey
    ){
      return simpleShortenUrlService.getShortenUrlInformationByShortenUrlKey(shortenUrlKey);
    }
}
