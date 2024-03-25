package kr.mjc.rachel.concepts.classesandobjects;

public class Baseb {
  private final String name;
  private final int size;

  public Baseb(String name) {
    this.name = name;
    System.out.println("Initializing a base class");
    size = name.length();
  }

  public final String getName() {
    return name;
  }

  public int getSize() {
    return size;
  }
}

final class Derivedb extends Baseb {
  private final String lastName;
  private final int size;

  public Derivedb(String name, String lastName) {
    super(name);
    this.lastName = lastName;
    System.out.println("Initializing a derived class");
    this.size = super.getSize() + lastName.length();
  }

  public String getLastName() {
    return lastName;
  }

  @Override
  public int getSize() {
    return size;
  }

  public static void main(String[] args) {
    Derivedb db = new Derivedb("Timotheee", "Chalamet");
    System.out.println(db.getSize());
  }
}