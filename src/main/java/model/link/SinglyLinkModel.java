package model.link;

import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;

/**
 * 单向链表
 * Created by dong on 2017/2/4.
 *
 * @param <T> the type parameter
 */
public class SinglyLinkModel<T> implements JsonSerializer<T> {

  public SinglyLinkModel(T value) {
    this.value = value;
  }

  public SinglyLinkModel() {
  }

  private T value;

  private SinglyLinkModel<T> next;

  /**
   * Gets value.
   *
   * @return the value
   */
  public T getValue() {
    return value;
  }

  /**
   * Sets value.
   *
   * @param value the value
   */
  public void setValue(T value) {
    this.value = value;
  }

  /**
   * Gets next.
   *
   * @return the next
   */
  public SinglyLinkModel<T> getNext() {
    return next;
  }

  /**
   * Sets next.
   *
   * @param next the next
   */
  public void setNext(SinglyLinkModel<T> next) {
    this.next = next;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public JsonElement serialize(T t, Type type, JsonSerializationContext jsonSerializationContext) {
    return jsonSerializationContext.serialize(value);
  }
}
