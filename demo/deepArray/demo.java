public class demo {
    public static void main(String[] args) {
        int[][] a = new int [3][4];
        a[1][2] = 1;
        a[2][1] = 2;
        a[2][3] = 3;

        // 输出
        for (int i = 0; i <  a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}