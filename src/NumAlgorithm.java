
public class NumAlgorithm {

    /**
     *实现 函数 double Power（ double base, int exponent）， 求 base 的 exponent 次方。
     * 不得 使用 库 函数， 同时 不需要 考虑 大数 问题。
     *
     */
    public static double power(double base,int exp){
            if (base == 0 && exp < 0) return 0; //基数为0，指数为负数，无意义
            if (exp == 0) return  1;
            if (exp == 1) return  base;

            int absExp;

            if (exp < 0){
                absExp = -exp;
            }else {
                absExp = exp;
            }

            double result= power(base,absExp>>1);
            result *= result;
            if ((absExp&0x1) == 1){//判断指数是否为奇数
                result *= base;
            }

            if (exp<0){
                result = 1/result;
            }

            return result;
    }


    /**
     *  输入 数字 n， 按 顺序 打 印出 从 1 最大 的 n 位 十进制 数。 比如 输入 3，
     *  则 打 印出 1、 2、 3 一直 到 最大 的 3 位数 即 999。
     *
     *  采用递归实现，需要注意大数问题，数字前面0问题
     */
    public static void printOneTOMaxOfNDigits(int n){
        if (n<=0) return;
        char[] number = new char[n];
        for (int i=0;i<10;i++){
          number[0] = (char) ('0'+i);
          printOneToMax(number,n,0);
        }
    }

    public static void printOneToMax(char[] number,int len,int index){
        if (index == len-1){
            printNum(number);
            return;
        }

        for (int i=0; i<10;i++){
            number[index+1] =(char)(i +'0');
            printOneToMax(number,len,index+1);
        }
    }


    public static void printNum(char[] nums){
        boolean isBeginningZero = true;
        int len =  nums.length;

        for (int i = 0; i< len; i++){
            if (isBeginningZero && nums[i] != '0'){
                isBeginningZero = false;
            }

            if (!isBeginningZero){
                System.out.print(nums[i]);
            }
        }
        System.out.println("\n");
    }


    /**
     * 输入 一个 整数 n， 求 从 1 到 n 这 n 个 整数 的 十进制 表示 中 1 出现 的 次数。 例如 输入 12，
     * 从 1 到 12 这些 整数 中 包含 1 的 数字 有 1， 10， 11 和 12， 1 一共 出现 了 5 次。
     *
     *
     */
    public static int numOf1(int n){
        if (n<=0) return  0;
        int count = 0;
        int base = 1;
        int round = n;
        while (round>0){
            int weight = round%10;
            round /= 10;
            count += round*base;

            if (weight == 1){
                count += (n%base) +1;
            }else if (weight>1){
                count += base;
            }

            base *= 10;
        }

        return count;
    }



}
