package facebook;

import java.util.ArrayList;
import java.util.List;

class TreeNodeMerge {
    TreeNodeMerge left;
    TreeNodeMerge right;
    int[] data;


    public TreeNodeMerge(int[] data) {
        this.data = data;
    }

    TreeNodeMerge insert(TreeNodeMerge root, int[] data) {

        if (root == null) {
            root = new TreeNodeMerge(data);
            return root;
        }

        if (root.data[1] >= data[0]) {
            root.data[1]  = Math.max(root.data[1],data[1]);
            if(root.data[0] > data[0]){
                root.data[0] = Math.min(root.data[0],data[0]);
            }

        }
        else {
            root.right = insert(root.right, data);
            //root.right = insert(root.right, data);
        }

        return root;
    }

    List<int[]> ints = new ArrayList<>();

    void inorderRec(TreeNodeMerge root) {
        if (root != null) {
            inorderRec(root.left);
            ints.add(root.data);
            inorderRec(root.right);
        }
    }
}


public class MergeIntervalWithTrees {

    public static void main(String[] args) {
        MergeIntervalWithTrees mergeIntervalWithTrees = new MergeIntervalWithTrees();
        TreeNodeMerge treeNodeMerge = new TreeNodeMerge(new int[]{1,4});
        treeNodeMerge.insert(treeNodeMerge,new int[]{0,0});
        treeNodeMerge.insert(treeNodeMerge,new int[]{8,10});
        treeNodeMerge.insert(treeNodeMerge,new int[]{15,18});
        treeNodeMerge.inorderRec(treeNodeMerge);
        System.out.println(treeNodeMerge.ints);
        //{1,5},{2,7},{9,12},{11,11}

    }
}
