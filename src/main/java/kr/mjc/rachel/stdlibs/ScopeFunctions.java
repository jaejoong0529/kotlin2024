package kr.mjc.rachel.stdlibs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ScopeFunctions {
  public void readFile() {
    BufferedReader buf = null;
    try {
      buf = new BufferedReader(new FileReader("README.md"));
      String line;
      while ((line = buf.readLine()) != null) {
        System.out.println(line);
      }
    } catch (IOException e) {
      System.err.println(e.getMessage());
    } finally {
      if (buf != null)
        try {
          buf.close();
        } catch (IOException e) {
          System.err.println(e.getMessage());
        }
    }
  }

  /**
   * try-with-resources
   */
  public void readFile2() {
    try (BufferedReader buf = new BufferedReader(new FileReader("README.md"))) {
      String line;
      while ((line = buf.readLine()) != null) {
        System.out.println(line);
      }
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }
  }

  public static void main(String[] args) {
    new ScopeFunctions().readFile2();
  }
}
