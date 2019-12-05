package json;

/**
 * Created by Andrii_Rodionov on 1/4/2017.
 */
public class JsonBoolean extends Json {
    private Boolean value;
    public JsonBoolean(Boolean bool) {
        this.value = bool;
    }

    @Override
    public String toJson() {
        return this.value.toString();
    }
}