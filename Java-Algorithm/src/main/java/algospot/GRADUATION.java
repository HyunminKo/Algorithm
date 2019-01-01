package algospot;

import java.util.Arrays;
import java.util.Scanner;

public class GRADUATION {
    static final int INF = 987654321;
    static int N, K, M, L;
    static int classes[] = new int[10], preRequisite[] = new int[12];
    static int cache[][] = new int[10][1 << 12];

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();
        while (tc-- > 0) {
            N = sc.nextInt(); K = sc.nextInt(); M = sc.nextInt(); L = sc.nextInt();

            for(int [] row: cache){
                Arrays.fill(row, -1);
            }
            Arrays.fill(preRequisite, 0);
            Arrays.fill(classes, 0);

            getInfoFromInput(sc, N, preRequisite);

            getInfoFromInput(sc, M, classes);

            int result = graduate(0, 0);
            if (result == INF)
                System.out.println("IMPOSSIBLE");
            else
                System.out.println(result);
        }

        sc.close();
    }

    private static void getInfoFromInput(Scanner sc, int count, int[] ary) {
        for (int i = 0; i < count; i++) {
            int cnt = sc.nextInt();
            for (int j = 0; j < cnt; j++) {
                int p = sc.nextInt();
                ary[i] |= (1 << p);
            }
        }
    }

    static int graduate(int semester, int taken) {
        if (Integer.bitCount(taken) >= K)
            return 0;
        if (semester == M)
            return INF;

        if (cache[semester][taken] != -1)
            return cache[semester][taken];

        cache[semester][taken] = INF;

        int canTake = (classes[semester] & ~taken);

        for (int i = 0; i < N; i++) {
            if ((canTake & (1 << i)) > 0 && ((taken & preRequisite[i]) != preRequisite[i])) {
                canTake &= ~(1 << i);
            }
        }

        for (int take = canTake; take > 0; take = ((take - 1) & canTake)) {
            if (Integer.bitCount(take) > L)
                continue;

            cache[semester][taken] = Math.min(cache[semester][taken], graduate(semester + 1, taken | take) + 1);
        }

        cache[semester][taken] = Math.min(cache[semester][taken], graduate(semester + 1, taken)); // 안들음

        return cache[semester][taken];
    }
}
