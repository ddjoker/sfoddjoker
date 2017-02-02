package json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by dong on 2017/2/1.
 */
public class JsonBuilder {
  public static final String toJson(Object value){
    return create().toJson(value);
  }
  public static final Gson create(){
    return new GsonBuilder().create();
  }
}
