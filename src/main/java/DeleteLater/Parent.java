package DeleteLater;

import java.util.List;

public class Parent {
    int id;
    List<Child> itemList;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Child> getItemList() {
        return itemList;
    }

    public void setItemList(List<Child> itemList) {
        this.itemList = itemList;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", itemList=" + itemList +
                '}';
    }
}
