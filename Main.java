import java.util.*;
import java.util.List;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        // Создаем словарь для хранения количества голосов для каждой пары
        Map<Integer, Integer> votes = new HashMap<>();

        // Считываем номера пар и увеличиваем соответствующее количество голосов в словаре
        for (int i = 0; i < N; i++) {
            int pairNumber = scanner.nextInt();
            if(pairNumber > 16){
                System.out.println("Неверный номер пары");
                i--;
            }
            else{
                votes.put(pairNumber, votes.getOrDefault(pairNumber, 0) + 1);
            }
        }

        // Создаем список призеров и сортируем его по количеству голосов в убывающем порядке
        List<Map.Entry<Integer, Integer>> sortedVotes = new ArrayList<>(votes.entrySet());
        sortedVotes.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        // Выводим список призеров
        for (Map.Entry<Integer, Integer> entry : sortedVotes) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
