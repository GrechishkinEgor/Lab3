import java.io.*;
import java.util.*;

public class Mouse extends Product{
	private String TypeOfConnection;
	private int LengthOfCable;
	private int Sensitivity;
	private int CountOfButtons;
	
	public Mouse()
	{
		super();
		TypeOfConnection = "";
		LengthOfCable = 0;
		Sensitivity = 0;
		CountOfButtons = 0;
		return;
	}
	
	public Mouse(Product General)
	{
		super(General);
		TypeOfConnection = "";
		LengthOfCable = 0;
		Sensitivity = 0;
		CountOfButtons = 0;
		return;
	}
	
	public Mouse(Product General, int Sensitivity, int CountOfButtons, String TypeOfConnection)
	{
		this(General);
		this.SetSensitivity(Sensitivity);
		this.SetCountOfButtons(CountOfButtons);
		this.SetTypeOfConnection(TypeOfConnection);
		return;
	}
	
	public Mouse(Product General, int Sensitivity, int CountOfButtons, String TypeOfConnection, int LengthOfCable)
	{
		this(General, Sensitivity, CountOfButtons, TypeOfConnection);
		this.SetLengthOfCable(LengthOfCable);
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
	
	public boolean SetSensitivity(int Sensitivity)
	{
		if (Sensitivity >= 0)
		{
			this.Sensitivity = Sensitivity;
			return true;
		}
		else
			return false;
	}
	
	public boolean SetCountOfButtons(int Count)
	{
		if (Count >= 0)
		{
			this.CountOfButtons = Count;
			return true;
		}
		else
			return false;
	}
	
	public String GetTypeOfConnection() {return this.TypeOfConnection;}
	public int GetLengthOfCable() {return this.LengthOfCable;}
	public int GetSensitivity() {return this.Sensitivity;}
	public int GetCountOfButtons() {return this.CountOfButtons;}
	
	public void OutputAllInfo()
	{
		super.OutputAllInfo();
		System.out.println("Тип соединения: " + this.TypeOfConnection);
		if (this.LengthOfCable > 0)
			System.out.println("Длина кабеля (см): " + this.LengthOfCable);
		System.out.println("Разрешение датчика (dpi): " + this.Sensitivity);
		System.out.println("Количество кнопок: " + this.CountOfButtons);
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
		CurrentFile.write(Integer.toString(this.Sensitivity) + "\n");
		CurrentFile.write(Integer.toString(this.CountOfButtons) + "\n");
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
		this.Sensitivity = Integer.parseInt(CurrentFile.nextLine());
		this.CountOfButtons = Integer.parseInt(CurrentFile.nextLine());
		return 1;
	}
	catch (Exception e)
	{
		System.out.println("Ошибка чтения из файла");
		return 0;
	}
}
};