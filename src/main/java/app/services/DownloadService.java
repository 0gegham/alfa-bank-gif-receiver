package app.services;

import org.springframework.http.ResponseEntity;

public interface DownloadService {
    ResponseEntity<byte[]> downloadByUrl(String url);
}
