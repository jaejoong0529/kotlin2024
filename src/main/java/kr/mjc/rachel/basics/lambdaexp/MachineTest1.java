package kr.mjc.rachel.basics.lambdaexp;

public class MachineTest1 {

  // static hello
  public static void sayHelloRachel() {
    System.out.println("안녕하세요 레이첼.");
  }

  public static void main(String[] args) {
    new MachineTest1().main();
  }

  public void main() {
    Machine machine = new Machine();

    // anonymous class
    Runnable r1 = new Runnable() {
      @Override
      public void run() {
        System.out.println("Hello Jacob.");
      }
    };
    machine.doTwice(r1);

    // lambda expression
    Runnable r2 = () -> System.out.println("Hello David.");
    machine.doTwice(r2);

    machine.doTwice(() -> System.out.println("Hello Rachel."));

    // method reference
    machine.doTwice(MachineTest1::sayHelloRachel);
    machine.doTwice(this::sayHelloJacob);
  }

  // instance hello
  public void sayHelloJacob() {
    System.out.println("안녕하세요 제이콥.");
  }
}
