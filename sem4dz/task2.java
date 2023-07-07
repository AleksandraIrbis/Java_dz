package sem4dz;
import java.util.Deque;
import java.util.LinkedList;

public class task2 {
    public static Deque<Integer> add(Deque<Integer> num1, Deque<Integer> num2) {
        int carry = 0;
        Deque<Integer> result = new LinkedList<>();

        while (!num1.isEmpty() || !num2.isEmpty() || carry != 0) {
            int digit1 = num1.isEmpty() ? 0 : num1.removeFirst();
            int digit2 = num2.isEmpty() ? 0 : num2.removeFirst();

            int sum = digit1 + digit2 + carry;
            carry = sum / 10;
            int digit = sum % 10;

            result.addLast(digit);
        }

        return result;
    }

    public static void main(String[] args) {
        Deque<Integer> num1 = new LinkedList<>();
        num1.addLast(9);
        num1.addLast(9);
        num1.addLast(9);

        Deque<Integer> num2 = new LinkedList<>();
        num2.addLast(2);
        num2.addLast(3);

        Deque<Integer> sum = add(num1, num2);

        // Выводим сумму
        while (!sum.isEmpty()) {
            System.out.print(sum.removeLast());
        }
        System.out.println();
    }
}
