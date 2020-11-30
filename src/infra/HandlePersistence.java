package infra;
import util.InfraException;

import java.io.File;
import java.io.IOException;
import java.util.TreeSet;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class HandlePersistence<E> {

  public void writeBinaryFile(TreeSet<E> users, String filename) throws IOException {
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

  public TreeSet<E> readBinaryFile(String filename) throws IOException {
    TreeSet<E> users = new TreeSet<E>();
    try {
      File file = new File(filename);
      if(file.exists()) {
        ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(file));
        users = (TreeSet<E>)objInput.readObject();
        objInput.close();
      }
    } catch(IOException errorIO) {
        throw errorIO;
    } catch(ClassNotFoundException errorClass) {
        System.out.printf("ClassNotFoundException error: %s", errorClass.getMessage());
    }
    return(users);
  }

  public TreeSet<E> load(String filename) throws InfraException {
    TreeSet<E> usersFile = new TreeSet<E>();

    try {
      usersFile = readBinaryFile(filename);
      System.out.println("Carregando...<users>");

    } catch (IOException e) {
    // System.out.printf("Não foi possível carregar os usuários.");
      throw new InfraException("Não foi possível carregar os usuários.");
    // e.printStackTrace();
      // throw e;
    }
    return usersFile;
  }

  public void save(TreeSet<E> users, String filename) throws InfraException {
    TreeSet<E> usersFile = new TreeSet<E>();

    usersFile.addAll(users);
    System.out.println("Salvando...<users>");

    try {
      writeBinaryFile(usersFile, filename);
    } catch (IOException e) {
      // System.out.printf("Não foi possível salvar os usuários.");
      throw new InfraException("Não foi possível salvar os usuários.");
      // e.printStackTrace();
    }
  }
}
