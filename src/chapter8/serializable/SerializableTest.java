package chapter8.serializable;

import java.io.*;
import java.util.Date;

public class SerializableTest {

    public static void main(String... args){



        try(ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("C:/Temp/test.dat")))){

        }
        catch(IOException ioe){}

    }

}

class Bond{

    String ticker = "bac";
    double coupon = 8.3;
    java.util.Date maturity = new Date();

}

class Portfolio implements Serializable{

    String accountName;
    transient Bond[] bonds = new Bond[]{ }; // must be transient because Bond class does not implement Serializable

    private void writeObject(ObjectOutputStream os) throws Exception{
        os.defaultWriteObject();
        os.writeInt(bonds.length);
        //write the state of bond objects
        for(int i=0; i<bonds.length; i++) {
            os.writeObject(bonds[i].ticker);
            os.writeDouble(bonds[i].coupon);
            os.writeObject(bonds[i].maturity);
        }
    }

    private void readObject(ObjectInputStream os) throws Exception{
        os.defaultReadObject();
        int n = os.readInt();
        this.bonds = new Bond[n];
        //read the state of bond objects.
        for(int i=0; i<bonds.length; i++) {
            bonds[i] = new Bond();
            bonds[i].ticker = (String) os.readObject();
            bonds[i].coupon = os.readDouble();
            bonds[i].maturity = (java.util.Date) os.readObject();
        }
    }
}