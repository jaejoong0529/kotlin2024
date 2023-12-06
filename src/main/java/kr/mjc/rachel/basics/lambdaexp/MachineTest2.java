package kr.mjc.rachel.basics.lambdaexp;

import java.util.function.Consumer;

public class MachineTest2 {

  // static hello
  public static void staticSayHello(String name) {
    System.out.println("안녕하세요 " + name);
  }

  public static void main(String[] args) {
    new MachineTest2().main();
  }

  public void main() {
    Machine machine = new Machine();

    // anonymous class
    Consumer<String> c1 = new Consumer<>() {
      @Override
      public void accept(String name) {
        System.out.println("Hello " + name);
      }
    };
    machine.doTwice(c1, "Rachel");

    // lambda expression
    Consumer<String> c2 = (name) -> System.out.println("Hello " + name);
    machine.doTwice(c2, "Jacob");

    // parameter가 1개이면 () 생략 가능
    machine.doTwice(name -> System.out.println("Hello " + name), "David");

    // method reference
    machine.doTwice(MachineTest2::staticSayHello, "Paul");
    machine.doTwice(this::sayHello, "Peter");

    machine.doTwice(str -> say(str), "Hello World.");
    machine.doTwice(this::say, "Hello World.");

    machine.doTwice(str -> System.out.println(str), "Say good bye");
    machine.doTwice(System.out::println, "Say good bye");
  }

  // instance hello
  public void sayHello(String name) {
    System.out.println("안녕하세요 " + name);
  }

  // just say
  public void say(String str) {
    System.out.println(str);
  }
}

