public class CharAlgorithm {

    /**
     * 输入一个字符串，打印所有排列
     * 如输入abc, 打印：abc,acb,bac,bca,cab,cba
     *
     */
   public static void charPermutation(String str){
            if (str == null || str == "") return;

            char[] chars = str.toCharArray();

            permutation(chars,0);
    }

    public static void permutation(char[] chars,int begin){
       if (begin==chars.length-1){
           System.out.println("str="+new String(chars));
       }else {
           for (int i=begin;i<chars.length;i++){
               char temp = chars[i];
               chars[i] = chars[begin];
               chars[begin] = temp;

               permutation(chars,begin+1);

               char temp1 = chars[i];
               chars[i] = chars[begin];
               chars[begin] = temp1;
           }
       }

    }
}
