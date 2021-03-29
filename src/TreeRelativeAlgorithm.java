import java.util.Arrays;

public class TreeRelativeAlgorithm {

    /**
     * 根据先序以及中序，重建二叉树
     */
    public static TreeNode reBuildTree(int[] pre,int[] in){
        if (pre == null || pre.length <= 0 || in == null || in.length <= 0) return null;
        TreeNode head = new TreeNode(pre[0]);

        for (int i=0;i<in.length;i++){
            if (in[i] == pre[0]){
                head.leftNode = reBuildTree(Arrays.copyOfRange(pre,1,i+1),Arrays.copyOfRange(in,0,i));
                head.rightNode = reBuildTree(Arrays.copyOfRange(pre,i+1,pre.length),Arrays.copyOfRange(in,i+1,in.length));
                break;
            }
        }
        return head;
    }


}
