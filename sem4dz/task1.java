package sem4dz;
import java.util.Deque;
import java.util.LinkedList;

public class task1 {
    public static Deque<Integer> multiply(Deque<Integer> num1, Deque<Integer> num2) {
        int carry = 0;
        Deque<Integer> result = new LinkedList<>();

        while (!num1.isEmpty() || !num2.isEmpty() || carry != 0) {
            int digit1 = num1.isEmpty() ? 0 : num1.removeFirst();
            int digit2 = num2.isEmpty() ? 0 : num2.removeFirst();

            int product = digit1 * digit2 + carry;
            carry = product / 10;
            int digit = product % 10;

            result.addLast(digit);
        }

        return result;
    }

    public static void main(String[] args) {
        Deque<Integer> num1 = new LinkedList<>();
        num1.addLast(2);
        num1.addLast(1);
        

        Deque<Integer> num2 = new LinkedList<>();
        num2.addLast(4);
        

        Deque<Integer> product = multiply(num1, num2);

        // Выводим произведение
        while (!product.isEmpty()) {
            System.out.print(product.removeLast());
        }
        System.out.println();
    }
}

