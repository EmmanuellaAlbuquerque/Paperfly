package infra;
import business.model.User;

import java.io.File;
import java.io.IOException;
import java.util.TreeMap;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class HandlePersistence {

  public static void writeBinaryFile(TreeMap<String, User> users, String filename) throws IOException {
    File file = new File(filename);
    try {
      file.delete();
      file.createNewFile();

      ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(file));
      objOutput.writeObject(users);
      objOutput.close();

    } catch(IOException errorIO) {
        throw errorIO;
    }
  }

  public static TreeMap<String, User> readBinaryFile(String filename) throws IOException {
    TreeMap<String, User> users = new TreeMap<String, User>();
    try {
      File file = new File(filename);
      if(file.exists()) {
        ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(file));
        users = (TreeMap<String, User>)objInput.readObject();
        objInput.close();
      }
    } catch(IOException errorIO) {
        throw errorIO;
    } catch(ClassNotFoundException errorClass) {
        System.out.printf("ClassNotFoundException error: %s", errorClass.getMessage());
    }
    return(users);
  }
}
