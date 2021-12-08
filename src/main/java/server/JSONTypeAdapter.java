package server;

import com.google.gson.*;

import java.lang.reflect.Type;

public class JSONTypeAdapter<T> implements JsonSerializer<T>, JsonDeserializer<T> {

    /**
     * Get the type and data tag info in the json so that when converting you do not instantiate a abstract object
     * and instead instantiate a downcasted object in list that holds any object that is child of the abstract type
     * @param json - jsonObject
     * @param typeOfT - Object type
     * @param context - object context from JSONDeserializer
     * @return javaObj
     * @throws JsonParseException - jsontranslation error
     */
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

    /**
     * during storing, not Data and Type in the json so JSONTypeAdapter can contextualize the json file and the object
     * types
     * @param src - javaObj
     * @param typeOfSrc - Type of the javaObj
     * @param context - context from JSONSerializer
     * @return jsonElement
     */
    @Override
    public JsonElement serialize(T src, Type typeOfSrc, JsonSerializationContext context) {

        JsonObject json = new JsonObject();

        json.addProperty("Type", src.getClass().getName());
        json.add("Data", context.serialize(src));

        return json;
    }
}