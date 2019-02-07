package org.thehunter365.particlemaths.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonManager {

    private Gson gson;

    public JsonManager() {
        this.gson = new GsonBuilder()
                .setPrettyPrinting()
                .serializeNulls()
                .create();
    }

    public Gson getGson() {
        return gson;
    }

    public String serialize(GsonSerializable gsonSerializable) {
        return this.gson.toJson(gsonSerializable);
    }

    public <T> T deserialize(String json, Class<T> tClass) {
        return this.gson.fromJson(json, tClass);
    }
}
