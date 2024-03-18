/*
 * @FunctionalInterface : abstract 메서드가 1개 있는 인터페이스
 * Runnable : 인자도 없고, 리턴도 없는 함수를 갖는 @FunctionalInterface
 */
package kr.mjc.rachel.concepts.functions;

public class RunnerExample {
  /**
   * runnable.run()을 n번 반복한다.
   */
  public void repeat(int n, Runnable runnable) {
    for (int i = 0; i < n; i++)
      runnable.run();
  }

  public static void main(String[] args) {

    RunnerExample exam = new RunnerExample();
    Runnable r1 = new Runnable() {  // anonymous class
      @Override
      public void run() {
        System.out.println("Hello, World!");
      }
    };

    exam.repeat(3, r1);
  }
}
