package server;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Bond;
import entity.Date;

import java.io.*;

public class JSONTranslator {
    /**
     *
     * @param javaObj java object to be stored into json file
     * @param fileName name of json file that java object will be stored in
     * @throws IOException In/Out stream error
     */
    public void writeToJSON(Object javaObj, String fileName) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try(FileWriter writer = new FileWriter(fileName)){
            gson.toJson(javaObj, writer);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * reads JSON file and returns a java Object of type t
     * @param t the type of class
     * @param fileName the name of the file it will read from
     * @return JavaObject converted from json
     * @throws FileNotFoundException for issues where file not found
     */
    public Object readFromJSON(Class<?> t, String fileName) throws FileNotFoundException {
        Gson gson = new Gson();
        try(Reader reader = new FileReader(fileName)){
            return gson.fromJson(reader, t);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
