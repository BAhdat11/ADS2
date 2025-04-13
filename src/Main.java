import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // === MyStack ===
        MyStack<Integer> stack = new MyStack<>();
        System.out.println("Введите 3 числа для стека:");
        for (int i = 0; i < 3; i++) {
            System.out.print("Число " + (i + 1) + ": ");
            int num = scanner.nextInt();
            stack.push(num);
        }
        System.out.println("Последний элемент в стеке: " + stack.peek());
        System.out.println("Удалён элемент: " + stack.pop());

        // === MyQueue ===
        MyQueue<String> queue = new MyQueue<>();
        scanner.nextLine(); // очистить строку после nextInt()
        System.out.println("\nВведите 3 строки для очереди:");
        for (int i = 0; i < 3; i++) {
            System.out.print("Строка " + (i + 1) + ": ");
            String str = scanner.nextLine();
            queue.enqueue(str);
        }
        System.out.println("Первый элемент в очереди: " + queue.peek());
        System.out.println("Удалён элемент из очереди: " + queue.dequeue());

        // === MyMinHeap ===
        MyMinHeap<Integer> heap = new MyMinHeap<>();
        System.out.println("\nВведите 4 числа для кучи:");
        for (int i = 0; i < 4; i++) {
            System.out.print("Число " + (i + 1) + ": ");
            int num = scanner.nextInt();
            heap.add(num);
        }
        System.out.println("Минимум в куче: " + heap.peek());
        System.out.println("Удалён минимум: " + heap.extractMin());

        scanner.close();
    }
}
