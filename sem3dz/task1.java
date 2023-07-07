package sem3dz;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class task1 {
    public static void main(String[] args) {
        List<Integer> randomNumbers = generateRandomNumbers(10, 1, 100);
        System.out.println("Исходный список: " + randomNumbers);

        // Удаление четных чисел
        List<Integer> oddNumbers = new ArrayList<>();
        for (Integer number : randomNumbers) {
            if (number % 2 != 0) {
                oddNumbers.add(number);
            }
        }
        randomNumbers = oddNumbers;
        System.out.println("Список после удаления четных чисел: " + randomNumbers);

        // Поиск минимального значения
        int min = Integer.MAX_VALUE;
        for (Integer number : randomNumbers) {
            if (number < min) {
                min = number;
            }
        }
        System.out.println("Минимальное значение: " + min);

        // Поиск максимального значения
        int max = Integer.MIN_VALUE;
        for (Integer number : randomNumbers) {
            if (number > max) {
                max = number;
            }
        }
        System.out.println("Максимальное значение: " + max);

        //Поиск среднего значения из всех числе в списке
        double sum = 0;
        for (Integer number : randomNumbers) {
            sum += number;
        }
        double average = sum / randomNumbers.size();
        System.out.println("Среднее значение: " + average);
    }

    public static List<Integer> generateRandomNumbers(int size, int minValue, int maxValue) {
        List<Integer> randomNumbers = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            int randomNumber = random.nextInt(maxValue - minValue + 1) + minValue;
            randomNumbers.add(randomNumber);
        }

        return randomNumbers;
    }
}
