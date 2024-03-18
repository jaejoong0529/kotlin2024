package kr.mjc.rachel.concepts;
import java.util.ArrayList;
import java.util.List;
public class list {
    public class Main {
        public static void main(String[] args) {
            // 읽기 전용 리스트
            List<String> numbers1 = List.of("one", "two", "three", "four");
            System.out.println(numbers1);
            System.out.println("Number of elements: " + numbers1.size());
            System.out.println("Third element: " + numbers1.get(2));
            System.out.println("Fourth element: " + numbers1.get(3));

            // 수정 가능한 리스트
            List<Integer> numbers2 = new ArrayList<>();
            numbers2.add(1);
            numbers2.add(2);
            numbers2.add(3);
            numbers2.add(4);
            System.out.println(numbers2);
            numbers2.add(5);       // [1,2,3,4,5]
            numbers2.remove(1);    // [1,3,4,5]
            numbers2.set(0, 0);    // [0,3,4,5]
            System.out.println(numbers2);
        }
    }
}
