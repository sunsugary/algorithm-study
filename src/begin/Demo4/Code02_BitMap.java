package begin.Demo4;

public class Code02_BitMap {


    public static class BitMap {

        private long[] bits;

        public BitMap(int max) {
            bits = new long[(max + 64) >> 6];
        }

        public void add(int num) {
            //首先确定num在哪个index,用num/64  == num >> 6得到index
            //再需要确定这个index上64个字节，哪一个字节能表示该数值
            //用num % 64 == num & 63 得到
            //bits[num >> 6] = bits[num >> 6] | (1L << (num & 63))
            bits[num >> 6] |= (1L << (num & 63));
        }

        public void delete(int num) {
            //取反运算符~
            bits[num >> 6] &= ~(1L << (num & 63));
        }

        public boolean contains(int num) {
            return (bits[num >> 6] & (1L << (num & 63))) != 0;
        }

    }


    public static void print(int num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
        }
    }


}
