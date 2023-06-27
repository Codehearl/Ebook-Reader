package main.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Query {
    List<String> query;
    public Query(String query){
        List<String> list = new ArrayList<>();
        Collections.addAll(list, query.split(""));
        this.query = list;
    }

    public Tokens tokenize(List<String> content) {
        return null;
    }

}
