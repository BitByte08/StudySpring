package kr.co.shortenUrlService.presentation;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class ShortenUrlRestController {
    //단축 url을 생성하는 api
    @PostMapping("/shortenUrl")
    public ResponseEntity<ShortenUrlCreateResponseDTO> createShortenUrl(
            @RequestBody @Valid ShortenUrlCreateRequestDTO shortenUrlCreateRequestDTO) {
        return ResponseEntity.ok(null);
    }

    //key를 넘겨주면 리다이렉트해주는 api
    @GetMapping("{shortenUrlKey}")
    public ResponseEntity<?> retrieveShortenUrl(){
        return ResponseEntity.ok(null);
    }


    @GetMapping("/shortenUrl/{shortenUrlKey}")
    public ResponseEntity<?> getShortenUrlInformation(){
        return ResponseEntity.ok(null);
    }
}
