package ru.itech.sno_api.config


/*
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import ru.itech.sno_api.video.VideoStream
import java.io.File

import java.io.IOException

class VideoStreamConverter : JsonSerializer<VideoStream>, JsonDeserializer<VideoStream> {

    override fun serialize(value: VideoStream, gen: JsonGenerator, serializers: SerializerProvider) {
        gen.writeStartObject()
        gen.writeObjectField("file", value.file)
        gen.writeEndObject()
    }
    open fun deserialize(p: JsonParser, ctxt: DeserializationContext): VideoStream {
        val node = p.codec.readTree(p)
        val file = node.get("file").toString()
        return VideoStream(File(file))
    }

    override fun handledType(): Class<VideoStream> {
        return VideoStream::class.java
    }

}


*/