package org.kd.interface_inheritance;

public class ClassAcceptingInterfaceAB extends SuperClassAcceptingInterfaceAB {

    public ClassAcceptingInterfaceAB(InterfaceAB interfaceAB) {
        super(interfaceAB);
    }

    public void acceptA(InterfaceA interfaceA){
        System.out.println("interfaceA");
    }

    public void testInterfaceAcceptance(){
        acceptA(new ClassAB());
        //acceptA(new ClassB()); //wrong

       // SuperClassAcceptingInterfaceAB c = new ClassAcceptingInterfaceAB(new ClassB());
    }


}
