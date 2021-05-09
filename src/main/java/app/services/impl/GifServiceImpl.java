package app.services.impl;

import app.client.GifApi;
import app.models.GifData;
import app.services.GifService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GifServiceImpl implements GifService {

    private final GifApi gifApi;

    @Override
    public ResponseEntity<GifData> randomGifByTag(String tag) {
        return gifApi.getRandomGifByTag(tag);
    }
}
