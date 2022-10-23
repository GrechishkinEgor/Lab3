import java.io.*;
import java.util.*;

public class Printer extends Product
{
	private String TypeOfPrint;
	private int DPI;
	private int PaperFormat;
	
	public Printer()
	{
		super();
		TypeOfPrint = "";
		DPI = 0;
		PaperFormat = 0;
		return;
	}
	
	public Printer(Product General)
	{
		super(General);
		TypeOfPrint = "";
		DPI = 0;
		PaperFormat = 0;
		return;
	}
	
	public Printer(Product General, String Type, int DPI, int PaperFormat)
	{
		this(General);
		this.SetTypeOfPrint(Type);
		this.SetDPI(DPI);
		this.SetPaperFormat(PaperFormat);
		return;
	}
	
	public boolean SetTypeOfPrint(String Type)
	{
		if (Type != null)
		{
			this.TypeOfPrint = Type;
			return true;
		}
		else
			return false;
	}
	
	public boolean SetDPI(int DPI)
	{
		if (DPI >= 0)
		{
			this.DPI = DPI;
			return true;
		}
		else
			return false;
	}
	
	public boolean SetPaperFormat(int PaperFormat)
	{
		if (PaperFormat >= 0)
		{
			this.PaperFormat = PaperFormat;
			return true;
		}
		else
			return false;
	}
	
	public String GetTypeOfPrint() {return this.TypeOfPrint; }
	public int GetDPI() {return this.DPI;}
	public int GetPaperFormat() {return this.PaperFormat;}
	
	public void OutputAllInfo()
	{
		super.OutputAllInfo();
		System.out.println("Тип по способу печати: " + this.TypeOfPrint);
		System.out.println("Разрешение (dpi): " + this.DPI);
		System.out.println("Формат бумаги: A" + this.PaperFormat);
		return;
	}
	
	/*Записывает данные в открытый для записи поток. 
	Возврат: 1 - успешно; 0 - ошибка записи в файл*/
public int WriteInFile(FileWriter CurrentFile)
{
	try
	{
		super.WriteInFile(CurrentFile);
		CurrentFile.write(this.TypeOfPrint + "\n");
		CurrentFile.write(Integer.toString(this.DPI) + "\n");
		CurrentFile.write(Integer.toString(this.PaperFormat) + "\n");
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
		this.TypeOfPrint = CurrentFile.nextLine();
		this.DPI = Integer.parseInt(CurrentFile.nextLine());
		this.PaperFormat = Integer.parseInt(CurrentFile.nextLine());
		return 1;
	}
	catch (Exception e)
	{
		System.out.println("Ошибка чтения из файла");
		return 0;
	}
}
};