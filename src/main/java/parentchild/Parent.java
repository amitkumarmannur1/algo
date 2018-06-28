package parentchild;

import DeleteLater.Child;

import java.util.List;

public class Parent {
    int id;
    List<Child> childList;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Child> getChildList() {
        return childList;
    }

    public void setChildList(List<Child> childList) {
        this.childList = childList;
    }
}
