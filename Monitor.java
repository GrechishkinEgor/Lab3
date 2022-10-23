import java.io.*;
import java.util.*;

public class Monitor extends Product
{
	private int Diagonal;
	private int Frequency;
	private int Size[];
	private int AspectRatio[];
	
	public Monitor()
	{
		super();
		Diagonal = 0;
		Frequency = 0;
		Size = new int[2];
		Size[0] = 0;
		Size[1] = 0;
		AspectRatio = new int[2];
		AspectRatio[0] = 0;
		AspectRatio[1] = 0;
		return;
	}
	
	public Monitor(Product General)
	{
		super(General);
		Diagonal = 0;
		Frequency = 0;
		Size = new int[2];
		Size[0] = 0;
		Size[1] = 0;
		AspectRatio = new int[2];
		AspectRatio[0] = 0;
		AspectRatio[1] = 0;
		return;
	}
	
	public Monitor(Product General, int Diagonal, int Frequency, int Size1, int Size2, int Aspect1, int Aspect2)
	{
		this(General);
		this.SetDiagonal(Diagonal);
		this.SetSize(Size1, Size2);
		this.SetAspectRatio(Aspect1, Aspect2);
		return;
	}
	
	public boolean SetDiagonal(int Diagonal)
	{
		if (Diagonal >= 0)
		{
			this.Diagonal = Diagonal;
			return true;
		}
		else
			return false;
	}
	
	public boolean SetFrequency(int Frequency)
	{
		if (Frequency >= 0)
		{
			this.Frequency = Frequency;
			return true;
		}
		else
			return false;
	}
	
	public boolean SetSize(int Size1, int Size2)
	{
		if (Size1 >= 0 && Size2 >= 0)
		{
			this.Size[0] = Size1;
			this.Size[1] = Size2;
			return true;
		}
		else
			return false;
	}
	
	public boolean SetAspectRatio(int Aspect1, int Aspect2)
	{
		if (Aspect1 >= 0 && Aspect2 >= 0)
		{
			this.AspectRatio[0] = Aspect1;
			this.AspectRatio[1] = Aspect2;
			return true;
		}
		else
			return false;
	}
	
	public int GetDiagonal() {return Diagonal;}
	public int GetFrequency() {return Frequency;}
	public int[] GetSize()
	{
		int Result[] = new int[2];
		Result[0] = Size[0];
		Result[1] = Size[1];
		return Result;
	}
	public int[] GetAspectRatio()
	{
		int Result[] = new int[2];
		Result[0] = AspectRatio[0];
		Result[1] = AspectRatio[1];
		return Result;
	}
	
	public void OutputAllInfo()
	{
		super.OutputAllInfo();
		System.out.println("Диагональ матрицы в дюймах: " + this.Diagonal);
		System.out.println("Частота обновления экрана (в герцах): " + this.Frequency);
		System.out.println("Разрешение экрана: " + this.Size[0] + " x " + this.Size[1]);
		System.out.println("Соотношение сторон: " + this.AspectRatio[0] + ":" + this.AspectRatio[1]);
		return;
	}
	
	
	/*Записывает данные в открытый для записи поток. 
	Возврат: 1 - успешно; 0 - ошибка записи в файл*/
public int WriteInFile(FileWriter CurrentFile)
{
	try
	{
		super.WriteInFile(CurrentFile);
		CurrentFile.write(Integer.toString(this.Diagonal) + "\n");
		CurrentFile.write(Integer.toString(this.Frequency) + "\n");
		CurrentFile.write(Integer.toString(this.Size[0]) + "\n");
		CurrentFile.write(Integer.toString(this.Size[1]) + "\n");
		CurrentFile.write(Integer.toString(this.AspectRatio[0]) + "\n");
		CurrentFile.write(Integer.toString(this.AspectRatio[1]) + "\n");
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
		this.Diagonal = Integer.parseInt(CurrentFile.nextLine());
		this.Frequency = Integer.parseInt(CurrentFile.nextLine());
		this.Size[0] = Integer.parseInt(CurrentFile.nextLine());
		this.Size[1] = Integer.parseInt(CurrentFile.nextLine());
		this.AspectRatio[0] = Integer.parseInt(CurrentFile.nextLine());
		this.AspectRatio[1] = Integer.parseInt(CurrentFile.nextLine());
		return 1;
	}
	catch (Exception e)
	{
		System.out.println("Ошибка чтения из файла");
		return 0;
	}
}

};