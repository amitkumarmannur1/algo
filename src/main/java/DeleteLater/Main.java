package DeleteLater;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Parent parent = new Parent();
        parent.setId(1);

        List<Child> children = new ArrayList<>();
        Child child = new Child();
        child.setId(1);
        child.setParent(parent);
        children.add(child);

        Child child2 = new Child();
        child2.setId(2);
        child2.setParent(parent);
        children.add(child2);
        Child child3 = new Child();
        child3.setId(2);
        //child3.setParent(child2);
        children.add(child3);
        parent.setItemList(children);
        System.out.println(parent);

        Set<Parent> parentHashMap = new HashSet<>();
        parentHashMap.add(parent);
        Set<Child> childHashSet = new HashSet<>();
        List<Child> totalChilders = new ArrayList<>();
        System.out.println(parent.id);
        parent.getItemList().stream().forEach(e -> {

            if (parentHashMap.contains(e) || childHashSet.contains(e)) {
                if (childHashSet.contains(e))
                    totalChilders.add(e);
                else parentHashMap.add(e.getParent());
            }else
                childHashSet.add(e);


        });
        System.out.println(parentHashMap);
        System.out.println(childHashSet);
        //System.out.println(child);


    }

}
