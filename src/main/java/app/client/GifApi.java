package app.client;

import app.models.GifData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "gif-api", url = "${gif.url}")
public interface GifApi {
    @GetMapping("/random?api_key=${gif.api_key}")
    ResponseEntity<GifData> getRandomGifByTag(@RequestParam(value = "tag") String tag);
}
