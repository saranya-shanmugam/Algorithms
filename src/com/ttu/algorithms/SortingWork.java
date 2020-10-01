import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class Sorting {

    public static void main(String[] args) {
        Sorting sorting = new Sorting();
//        sorting.squareOfSortedArray();
        sorting.squareOfSortedArray1();
        sorting.sortArrayByParity();
        sorting.sortArrayByParityInPlace();

    }

    private void sortArrayByParityInPlace() {
        int[] input = {3,1,2,4};
    }

    private void sortArrayByParity() {
        int[] input = {3,1,2,4};
        int[] answer = new int[input.length];
        for(int i=0, j=0, k=input.length-1; i < input.length; i++) {
            if(input[i] % 2 == 0) {
                answer[j++] = input[i];
            } else {
                answer[k--] = input[i];
            }
        }
        System.out.println(Arrays.toString(answer));

    }

    private void squareOfSortedArray1() {
        int[] input = {-4,-1,0,3,10};
        int N = input.length;
        int[] ans = new int[N];
        for (int i = 0; i < N; ++i)
            ans[i] = input[i] * input[i];

        Arrays.sort(ans);
        System.out.println(Arrays.toString(ans));
    }

    private void squareOfSortedArray() {
        int[] input = {1};
        List<Integer> nList = new LinkedList<>();
        int indexZero = -1;
        boolean reversed = false;
        int startIndex = 0;
        for(int i=0; i < input.length; i++) {
            if(input[i] < 0) {
                nList.add(input[i] * input[i]);
            } else if (input[i] >= 0) {
                if(nList.size() == 0) {
                    nList.add(input[i]);
                    continue;
                }
                if(!reversed) {
                    Collections.reverse(nList);
                    reversed = true;
                }
                startIndex = insertValue(input[i] * input[i], nList, startIndex);
            }
        }
        System.out.println(nList);
    }

    private int insertValue(int value, List<Integer> nList, int startIndex) {
        int lastIndex = nList.size() - 1;
        while (startIndex <= lastIndex) {
            int midIndex = ((lastIndex - startIndex) / 2) + startIndex;

            if (value < nList.get(midIndex)) {
                lastIndex = midIndex - 1;
            } else if (value > nList.get(midIndex)) {
                startIndex = midIndex + 1;
            } else {
                nList.add(midIndex, value);
                return midIndex;
            }
            if (lastIndex < 0) {
                nList.add(0, value);
                return 0;
            } else if (startIndex >= nList.size()) {
                nList.add(startIndex, value);
                return startIndex;
            } else if (startIndex > lastIndex) {
                nList.add(startIndex, value);
                return startIndex;
            }
        }
            return -1;
        }
}
