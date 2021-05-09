package app.services;

import app.models.GifData;
import org.springframework.http.ResponseEntity;

public interface GifService {
    ResponseEntity<GifData> randomGifByTag(String tag);
}
