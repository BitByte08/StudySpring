package kr.co.shortenUrlService.presentation;

public class ShortenUrlInformationDTO {
  private String originalUrl;
  private String shortenUrlKey;
  private Integer redirectCount;

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
