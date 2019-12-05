package json;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JsonObject extends Json {
    private Hashtable<String, Json> pairs = new Hashtable<>();

    public JsonObject(JsonPair... jsonPairs) {
        for (int i = 0; i < jsonPairs.length; i ++){
            this.add(jsonPairs[i]);
        }
    }

    @Override
    public String toJson() { return "{" + getJsonBody() + "}";
    }

    private String getJsonBody(){
        if (this.isEmpty()){
            return "";
        }
        StringBuilder body = new StringBuilder();
        int i = 0;

        for (String key: this.pairs.keySet()) {
            body.append(new JsonString(key).toJson()).append(":").append(this.pairs.get(key).toJson()).append(",");
        }
        return String.copyValueOf(body.toString().toCharArray(), 0, body.length() - 1);

    }

    public void add(JsonPair jsonPair) {
        this.pairs.put(jsonPair.key, jsonPair.value);
    }

    public Json find(String name) {
        if (this.isKey(name)){
            return this.pairs.get(name);
        }
        return null;
    }

    public JsonObject projection(String... names) {
        JsonObject proj = new JsonObject();
        for(String key: this.pairs.keySet()) {
            for (String name : names) {
                if (key.equals(name)){
                    proj.add(new JsonPair(key, this.find(key)));
                }
            }
        }
        return proj;
    }

    private boolean isEmpty(){
        return pairs.isEmpty();
    }

    private boolean isKey(String key){
        return this.pairs.containsKey(key);
    }
}
