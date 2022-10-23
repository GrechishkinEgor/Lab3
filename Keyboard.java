import java.io.*;
import java.util.*;

public class Keyboard extends Product
{
	private String TypeOfConnection;
	private int LengthOfCable;
	
	public Keyboard()
	{
		super();
		TypeOfConnection = "";
		LengthOfCable = 0;
		return;
	}
	
	public Keyboard(Product General)
	{
		super(General);
		TypeOfConnection = "";
		LengthOfCable = 0;
		return;
	}
	
	public Keyboard(Product General, String Type)
	{
		this(General);
		this.SetTypeOfConnection(Type);
		return;
	}
	
	public Keyboard(Product General, String Type, int Length)
	{
		this(General, Type);
		this.SetLengthOfCable(Length);
		return;
	}
	
	public boolean SetTypeOfConnection(String Type)
	{
		if (Type != null)
		{
			this.TypeOfConnection = Type;
			return true;
		}
		else
			return false;
	}
	
	public boolean SetLengthOfCable(int Length)
	{
		if (Length >= 0)
		{
			this.LengthOfCable = Length;
			return true;
		}
		else
			return false;
	}
	
	public String GetTypeOfConnection() {return this.TypeOfConnection;}
	public int GetLenghtOfCable() {return this.LengthOfCable;}
	
	public void OutputAllInfo()
	{
		super.OutputAllInfo();
		System.out.println("Тип соединения: " + this.TypeOfConnection);
		if (this.LengthOfCable > 0)
			System.out.println("Длина кабеля: " + this.LengthOfCable);
		return;
	}
	
	/*Записывает данные в открытый для записи поток. 
	Возврат: 1 - успешно; 0 - ошибка записи в файл*/
public int WriteInFile(FileWriter CurrentFile)
{
	try
	{
		super.WriteInFile(CurrentFile);
		CurrentFile.write(this.TypeOfConnection + "\n");
		CurrentFile.write(Integer.toString(this.LengthOfCable) + "\n");
		return 1;
	}
	catch (Exception e)
	{
		return 0;
	}
}

/*Прочитать содержимое потока FileReader через Scanner.
	Возврат: 0 - ошибка чтения; 1 - успешно*/
public int ReadFromFile(Scanner CurrentFile)
{
	try
	{
		super.ReadFromFile(CurrentFile);
		this.TypeOfConnection = CurrentFile.nextLine();
		this.LengthOfCable = Integer.parseInt(CurrentFile.nextLine());
		return 1;
	}
	catch (Exception e)
	{
		System.out.println("Ошибка чтения из файла");
		return 0;
	}
}
};