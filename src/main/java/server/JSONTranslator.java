package server;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Bond;
import entity.Date;

import java.io.*;

public class JSONTranslator {
    public void writeToJSON(Object javaObj, String fileName) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(javaObj);
        try(FileWriter writer = new FileWriter(fileName)){
            gson.toJson(javaObj, writer);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public Object readFromJSON(Class<?> t, String fileName) throws FileNotFoundException {
        Gson gson = new Gson();
        try(Reader reader = new FileReader(fileName)){
            Object javaObj = gson.fromJson(reader, t);
            return javaObj;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    //TESTING PURPOSES
    public static void main(String [] args) throws IOException {
        Bond b = new Bond(3, 4.00, 3.23, new Date(2021,2,1), "Jackson");
        System.out.println(b);
        JSONTranslator jsonT = new JSONTranslator();
        jsonT.writeToJSON(b, "Data.json");
        System.out.println(jsonT.readFromJSON(Bond.class, "Data.json"));
    }
}
