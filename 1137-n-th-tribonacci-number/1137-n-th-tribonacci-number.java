class Solution {
    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        // 배열을 사용하지 않고 세 개의 변수로 이전 값을 저장
        int t0 = 0, t1 = 1, t2 = 1;
        int tn = 0;

        // T3부터 Tn까지 계산
        for (int i = 3; i <= n; i++) {
            tn = t0 + t1 + t2;
            t0 = t1;
            t1 = t2;
            t2 = tn;
        }

        return tn;
    }
}