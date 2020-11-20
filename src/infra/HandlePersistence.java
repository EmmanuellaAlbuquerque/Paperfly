package infra;
import business.model.User;

import java.io.File;
import java.io.IOException;
import java.util.TreeSet;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class HandlePersistence {

  public static void writeBinaryFile(TreeSet<User> users, String filename) throws IOException {
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

  public static TreeSet<User> readBinaryFile(String filename) throws IOException {
    TreeSet<User> users = new TreeSet<User>();
    try {
      File file = new File(filename);
      if(file.exists()) {
        ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(file));
        users = (TreeSet<User>)objInput.readObject();
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
