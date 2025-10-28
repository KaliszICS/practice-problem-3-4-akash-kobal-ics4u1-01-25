public class PracticeProblem {

    public static void main(String[] args) {
        int[] result = recaman(6);
        for (int x : result) {
            System.out.print(x + " ");
        }
    }

    public static int[] recaman(int n) {
        // base case for invalid or zero
        if (n <= 0) return new int[0];

        int[] seq = new int[n + 1]; // include 0 internally
        seq[0] = 0;
        helper(seq, 1);

        // create array without the initial 0
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = seq[i + 1];
        }
        return result;
    }

    private static void helper(int[] seq, int i) {
        if (i == seq.length) return; // stop when done

        int curr = seq[i - 1] - i;
        if (curr < 0 || contains(seq, curr, i)) {
            curr = seq[i - 1] + i;
        }
        seq[i] = curr;
        helper(seq, i + 1);
    }

    private static boolean contains(int[] seq, int val, int upto) {
        for (int j = 0; j < upto; j++) {
            if (seq[j] == val) return true;
        }
        return false;
    }
}
