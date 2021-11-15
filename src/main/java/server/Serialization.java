package server;

import entity.Bond;
import entity.Date;

import java.io.*;

public class Serialization{
    private FileOutputStream file;
    private ObjectOutputStream out;
    private FileInputStream fileIn;
    private ObjectInputStream in;

    public Serialization() throws IOException{
        try{
            file = new FileOutputStream("File_Data_Storing.TXT");
            out = new ObjectOutputStream(file);
            fileIn = new FileInputStream("File_Data_Storing.TXT");
            in = new ObjectInputStream(fileIn);
        }catch (IOException ex){
            System.out.print("Serialization Class Initialization Error");
        }
    }

    public void Serialize(Object obj) throws IOException {
        try {
            out.writeObject(obj);

            out.close();
            file.close();

            System.out.println("Object has been serialized\n" + "Data before Deserialization.");
            System.out.println(obj);//for testing purposes

        }catch (IOException ex){
            System.out.print("Serialization Error");
        }
    }

    public Object Deserialize() throws IOException {
        Object obj;
        try{
            obj = in.readObject();
            return obj;
        } catch (IOException i) {
            i.printStackTrace();
            System.out.print("Deserialization Error");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


    //TESTING PURPOSES AND SHOWING HOW TO USE CLASS
    public static void main(String []args) throws IOException {
        Bond b = new Bond(3, 4, 3.23, new Date(2021,2,1), "bond1");
        printData(b);
        Serialization ser = new Serialization();
        ser.Serialize(b);
        Bond bond2 = (Bond) ser.Deserialize();
        printData(bond2);
    }
    public static void printData(Bond b){
        System.out.println("Volume = " + b.getVolume());
        System.out.println("Annual Int = " + b.getAnnualInterestRate());
        System.out.println("Date of Maturity = " + b.getDateOfMaturity());
        System.out.println("Price Per Bond = " + b.getPricePerBond());
    }
}
