package kr.co.shortenUrlService.presentation;


import kr.co.shortenUrlService.domain.ShortenUrl;

public class ShortenUrlCreateResponseDTO {
  private String originalUrl;
  private String shortenUrlKey;

  public ShortenUrlCreateResponseDTO(ShortenUrl shortenUrl) {
    this.originalUrl = shortenUrl.getOriginalUrl();
    this.shortenUrlKey = shortenUrl.getShortenUrlKey();
  }

  public String getOriginalUrl() {
    return originalUrl;
  }

  public String getShortenUrlKey() {
    return shortenUrlKey;
  }
}
