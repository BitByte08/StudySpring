package kr.co.shortenUrlService.presentation;

import kr.co.shortenUrlService.domain.ShortenUrl;

public class ShortenUrlInformationDTO {
  private String originalUrl;
  private String shortenUrlKey;
  private Integer redirectCount;

  public ShortenUrlInformationDTO(ShortenUrl shortenUrl) {
    this.originalUrl = shortenUrl.getOriginalUrl();
    this.shortenUrlKey = shortenUrl.getShortenUrlKey();
    this.redirectCount = 0;
  }

  public Integer getRedirectCount() {
    return redirectCount;
  }

  public String getShortenUrlKey() {
    return shortenUrlKey;
  }

  public String getOriginalUrl() {
    return originalUrl;
  }
}
