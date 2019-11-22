package org.kd.serialization;

import java.io.*;

public class SerializeDemo {

    public static void main(String[] args) {
        Employee e = new Employee();
        e.name = "Reyan Ali";
        e.address = "Phokka Kuan, Ambehta Peer";
        e.SSN = 11122333;
        e.number = 101;

        FileOutputStream fileOut = null;
        ObjectOutputStream out = null;
        try {
            fileOut = new FileOutputStream("employee.txt");
            out = new ObjectOutputStream(fileOut);
            out.writeObject(e);

            System.out.print("Serialized data is saved in /tmp/employee.txt");
        } catch (IOException i) {
            i.printStackTrace();
        } finally {

            try {
                out.close();
                fileOut.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}