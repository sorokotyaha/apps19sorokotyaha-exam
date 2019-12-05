package domain;

import com.sun.org.apache.xpath.internal.operations.String;
import json.*;

/**
 * Created by Andrii_Rodionov on 1/5/2017.
 */
public class BasicStudent implements Jsonable {

    protected String name;
    protected String surname;
    protected Integer year;

    public BasicStudent() {
    }

    public BasicStudent(String name, String surname, Integer year) {
        this.name = name;
        this.surname = surname;
        this.year = year;
    }

    @Override
    public JsonObject toJsonObject() {

        return new JsonObject(new JsonPair("name", (Json) new JsonString(this.name),
                new JsonPair("surname", (Json) new JsonString(this.surname)),
                new JsonPair("year", (Json) new JsonNumber(this.year))));
    }
}
