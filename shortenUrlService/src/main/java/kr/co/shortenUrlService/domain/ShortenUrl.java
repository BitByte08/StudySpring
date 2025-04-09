package kr.co.shortenUrlService.domain;


import java.util.Random;

//여기 비밀리에 매우 중요하게 수행되는 핵심 비즈니스 로직들이 저장되어야 함.
//이를테면 키 생성 알고리즘 코드를 여기에 넣는 것이 적절해 보임.
public class ShortenUrl {
    private String originalUrl;
    private String shortenUrlKey;
    private Integer redirectCount;

    public ShortenUrl(String originalUrl, String shortenUrlKey) {
        this.originalUrl = originalUrl;
        this.shortenUrlKey = shortenUrlKey;
        this.redirectCount = 0;
    }

    public static String generateShortenUrlKey(){
        String base56Characters = "23456789ABCDEFGHJKLNMPQRSTUVWXYZabcdefghijkmnpqrstuvwxyz";
        Random random = new Random();
        StringBuilder shortenUrlKey = new StringBuilder();
        for(int i=0;i<8;i++){
            char base56Character = base56Characters.charAt(random.nextInt(base56Characters.length()));
            shortenUrlKey.append(base56Character);
        }
        return shortenUrlKey.toString();
    }

  public String getShortenUrlKey() {
      return shortenUrlKey;
  }

  public String getOriginalUrl() {
    return originalUrl;
  }

  public void increaseRedirectCount() {
      this.redirectCount++;
  }

  public Integer getRedirectCount() {
      return redirectCount;
  }
}
