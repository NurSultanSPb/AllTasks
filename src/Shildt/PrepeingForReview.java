package Shildt;

import java.util.ArrayList;
import java.util.List;

public class PrepeingForReview {
    public static void main(String[] args) {

        Gen<String> stringGen;
        stringGen = new Gen<String>("july");
        stringGen.showType();
        stringGen.getObj();
        List<ArrayList> arrayLists = new ArrayList<ArrayList>();
    }

}
class Gen<T> {
    T obj;

    Gen(T obj) {
        this.obj = obj;
    }

    T getObj() {
        return obj;
    }

    void showType() {
        System.out.println(obj.getClass().getName());
    }
}