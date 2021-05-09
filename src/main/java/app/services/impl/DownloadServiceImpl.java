package app.services.impl;

import app.client.Download;
import app.services.DownloadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;

@Service
@RequiredArgsConstructor
public class DownloadServiceImpl implements DownloadService {

    private final Download download;

    @Override
    public ResponseEntity<byte[]> downloadByUrl(String url) {
        return download.downloadByUrl(URI.create(url));
    }
}
