package com.hitsoft.mongo.basic;

/**
 * Helper to build DBObjects. Overrides BasicDBObjectBuilder with working with enum fields
 */
public class DBObjectBuilder {

  DBObjectExt obj = new BasicDBObjectExt();

  private DBObjectBuilder() {
  }

  public static DBObjectBuilder start() {
    return new DBObjectBuilder();
  }

  public DBObjectBuilder addNotNull(Enum field, Object value) {
    if (value != null)
      obj.put(field, value);
    return this;
  }

  public DBObjectBuilder add(String field, Object value) {
    obj.put(field, value);
    return this;
  }

  public DBObjectBuilder add(Enum field, Object value) {
    obj.put(field, value);
    return this;
  }

  public DBObjectBuilder add(Enum[] field, Object value) {
    obj.put(field, value);
    return this;
  }

  public DBObjectBuilder add(DBObjectExt values) {
    obj.asDBObject().putAll(values.asDBObject().toMap());
    return this;
  }

  public DBObjectExt get() {
    return obj;
  }

  public static DBObjectExt single(Enum field, Object value) {
    return start().add(field, value).get();
  }
}
