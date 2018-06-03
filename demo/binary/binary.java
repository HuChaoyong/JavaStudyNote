public class binary {
    public static void main(String[] args) {
        int a;
        a = (-1 >> 2);
        // 1***000001
        // 1***111110
        /// 1 *** 111;  这 tm 还是 -1
        System.out.println(a);
    }

    // java 里面所有的操作，都是操作的补码，
    // 不管是 ~ 取反
    // 或 |
    // 且 |
    // 都是
    //  >> 算术右移:  低位溢出, 符号位不变, 并用符号位补溢出的高位
    //  >> 符号位不变, 低位补0
    //  >>> 逻辑右移, 低位溢出,高位补0
}