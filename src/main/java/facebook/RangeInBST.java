package facebook;

public class RangeInBST {

    public int rangeInBST(TreeNode root, int L , int R){

        int n=0;

        if(root == null){
            return 0;
        }

        if(root.val >= L && root.val <= R ){

            n = root.val;
        }

        if(!(root.val <= L))
        n += rangeInBST(root.left,L,R);
        if(!(root.val >= R))
        n -= rangeInBST(root.right,L,R);

        return n;
    }
}
