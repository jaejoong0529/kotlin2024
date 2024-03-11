package kr.mjc.rachel.concepts.classesandobjects;

public class Personc {
  private final String firstName;
  private final String lastName;
  private int age;

  public Personc(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
    age = 1;
  }

  public Personc(String firstName, String lastName, int age) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public static void main(String[] args) {
    Personc pc1 = new Personc("Timothee", "Chalamet", 29);
    Personc pc2 = new Personc("Timothee", "Chalamet");
    pc2.setAge(29);
  }
}
