package poaAp4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class PrincipalSerializacao {
	public static void main(String[] args) {
		Cachorro c = new Cachorro("Rex", 5, "Labrador");
		try {
			File f = new File("c:/a/");
			if (!f.exists()) f.mkdir();
			FileOutputStream arqOSer = new FileOutputStream("c:/a/rex.ser");
			ObjectOutputStream oOSer = new ObjectOutputStream(arqOSer);
			oOSer.writeObject(c);
			oOSer.close();
			System.out.println("---------------Antes de alterar idade-------------");
			System.out.println(c);
			c.setIdade(6);
			System.out.println("---------------Depois de alterar idade-------------");
			System.out.println(c);
			FileInputStream arqISer = new FileInputStream("c:/a/rex.ser");
			ObjectInputStream iOSer = new ObjectInputStream(arqISer);
			c = (Cachorro) iOSer.readObject();
			iOSer.close();
			System.out.println("---------------Depois de recuperar os valores-------------");
			System.out.println(c);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}