package server;

import com.google.gson.*;

import java.lang.reflect.Type;

public class JSONTypeAdapter<T> implements JsonSerializer<T>, JsonDeserializer<T> {

    @Override
    public T deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        JsonObject jsonObj = (JsonObject) json;
        JsonElement typeElem = jsonObj.get("Type");
        JsonElement dataElem = jsonObj.get("Data");

        Type type;

        try {
            type =  Class.forName(typeElem.getAsString());

        } catch (ClassNotFoundException e) {
            throw new JsonParseException(e);
        }

        return context.deserialize(dataElem, type);

    }

    @Override
    public JsonElement serialize(T src, Type typeOfSrc, JsonSerializationContext context) {

        JsonObject json = new JsonObject();

        json.addProperty("Type", src.getClass().getName());
        json.add("Data", context.serialize(src));

        return json;
    }
}