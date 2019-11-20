package org.kd.lists;

import java.util.List;

public class ListIteration {

    private static void list(){
        List<String> stringList = StringListFactory.createInvocationList();
        stringList.stream().map(String::length).filter( l -> l == 3);//TODO
        stringList.remove(0);

        for (String s : stringList)
            System.out.println(s);
    }

    public static void main(String[] args) {
        list();
    }
}
