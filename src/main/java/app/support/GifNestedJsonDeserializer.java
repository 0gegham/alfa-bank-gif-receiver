package app.support;

import app.models.GifData;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

public class GifNestedJsonDeserializer extends JsonDeserializer<GifData> {

    @Override
    public GifData deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException, JsonProcessingException {
        JsonNode jsonNode = jsonParser.getCodec().readTree(jsonParser);
        JsonNode dataNode = jsonNode.get("data");
        return new GifData(dataNode.get("image_original_url").textValue());
    }
}
