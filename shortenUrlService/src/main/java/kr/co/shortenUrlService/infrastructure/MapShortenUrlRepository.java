package kr.co.shortenUrlService.infrastructure;

import kr.co.shortenUrlService.domain.ShortenUrl;
import kr.co.shortenUrlService.domain.ShortenUrlRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class MapShortenUrlRepository implements ShortenUrlRepository {
  private Map<String, ShortenUrl> shortenUrls = new ConcurrentHashMap<>();

  @Override
  public void saveShortenUrl(ShortenUrl shortenUrl) {

  }
}
