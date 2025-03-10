package org.xixum.nlx.dictionary;

/**
 * @author schaller
 * interface class that converts info from IItem for dictionary.
 * Because circular dependencies are not allowed
 */
@SuppressWarnings("all")
public class DictItem {
  private String name;

  private long id = (-1);

  private String type;

  private String innerType;

  public DictItem(final String name, final String type) {
    this(name, type, (-1));
  }

  public DictItem(final String name, final String type, final long id) {
    this(name, type, null, id);
  }

  public DictItem(final String name, final String type, final String innerType, final long id) {
    this.name = name;
    this.type = type;
    this.innerType = innerType;
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public String getType() {
    return this.type;
  }

  public long getId() {
    return this.id;
  }

  public String getInnerType() {
    return this.innerType;
  }
}
