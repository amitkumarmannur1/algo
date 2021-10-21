package test;

import java.util.ArrayList;
import java.util.List;

public class TestList {


    List<String> objList ;

    public List<String> getObjList() {
        return objList;
    }

    public void setObjList(List<String> objList) {
        this.objList = objList;
    }

    public static void main(String[] args) {
        TestList testList = new TestList();
        List<String> strings1 = modifyList();
        List<String> strings = strings1;
        testList.setObjList(strings);
        /*List<String> strings1 = strings;
        System.out.println(strings.size());
        System.out.println(modifyList().size());
        strings = null;*/

        strings= null;
        strings1 = null;
        //System.out.println(strings1.size());

        System.out.println(testList.getObjList().size());


    }

    private static List<String> modifyList() {
        List<String> asd =new ArrayList<>();
        asd.add("123");
        asd.add("423");
        return asd;
    }

}
