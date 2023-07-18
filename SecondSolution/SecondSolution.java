package SecondSolution;

// Попытка настроить отрицательные числа. Как-то рабоатет, но не совсем так как я хочу. Мозг сказал хватит, не насилуй меня.Поэтому оставлю так)))

import java.util.ArrayDeque;
import java.util.Deque;

public class SecondSolution {
  public static void main(String[] args) {
    // Примеры входных данных
    Deque<Integer> num1 = new ArrayDeque<>();
    num1.add(0);
    num1.add(8);

    Deque<Integer> num2 = new ArrayDeque<>();
    num2.add(-5);

    // Умножение чисел
    Deque<Integer> multiplicationResult = multiplyLinkedLists(new ArrayDeque<>(num1), new ArrayDeque<>(num2));
    printList(multiplicationResult);

    // Сложение чисел
    Deque<Integer> additionResult = addLinkedLists(new ArrayDeque<>(num1), new ArrayDeque<>(num2));
    printList(additionResult);
  }

  // Метод для умножения двух чисел в виде связанных списков
  public static Deque<Integer> multiplyLinkedLists(Deque<Integer> num1, Deque<Integer> num2) {
    int n1 = dequeToNumber(num1);
    int n2 = dequeToNumber(num2);
    int result = n1 * n2;
    return numberToDeque(result);
  }

  // Метод для сложения двух чисел в виде связанных списков
  public static Deque<Integer> addLinkedLists(Deque<Integer> num1, Deque<Integer> num2) {
    Deque<Integer> result = new ArrayDeque<>();
    int carry = 0;

    while (!num1.isEmpty() || !num2.isEmpty() || carry != 0) {
      int sum = carry;
      if (!num1.isEmpty()) {
        sum += num1.pollLast();
      }
      if (!num2.isEmpty()) {
        sum += num2.pollLast();
      }

      result.addFirst(sum % 10);
      carry = sum / 10;
    }

    return result;
  }

  // Метод для преобразования связанного списка в число
  private static int dequeToNumber(Deque<Integer> deque) {
    int num = 0;
    int sign = 1;

    while (!deque.isEmpty()) {
      int digit = deque.pollFirst();
      if (digit == -1) {
        sign = -1;
      } else {
        num = num * 10 + digit;
      }
    }

    return num * sign;
  }

  // Метод для преобразования числа в связанный список
  private static Deque<Integer> numberToDeque(int num) {
    Deque<Integer> result = new ArrayDeque<>();
    if (num == 0) {
      result.add(0);
      return result;
    }

    if (num < 0) {
      result.add(-1); // Метка для отрицательного числа
      num = -num; // Преобразуем число в положительное
    }

    while (num > 0) {
      result.addFirst(num % 10);
      num /= 10;
    }

    return result;
  }

  // Метод для вывода связанного списка на экран
  private static void printList(Deque<Integer> deque) {
    for (int digit : deque) {
      System.out.print(digit + " -> ");
    }
    System.out.println("null");
  }
}
