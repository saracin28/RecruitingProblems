import java.util.*;

public class Problem1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        Integer[] numbers = new Integer[n];
        Map<Integer, Integer> freq = new HashMap<>();
        Integer[] result = new Integer[k];

        //Input numbers in array && set keys in map
        for (int i = 0; i < n; i++) {
            int x=scanner.nextInt();
            freq.put(x, 0);
            numbers[i] = x;
        }

        //Set the value of keys equal with their frequency in our array
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            for (int i : numbers) {
                if (i == entry.getKey()) {
                    entry.setValue(entry.getValue() + 1);
                }
            }
        }

        //Compare the values of our keys
        for (int i = 0; i < k; i++) {
            int max = Integer.MIN_VALUE;
            int s=0;
            for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
                if (entry.getValue() > max ||(entry.getValue() == max && entry.getKey()>s)) {
                    max = entry.getValue();
                    s= entry.getKey();
                }
            }
            freq.remove(s);
            result[i] = s;
        }

        //Sort and print
        Arrays.sort(result, Collections.reverseOrder());
        System.out.println(Arrays.toString(result));
    }
}
