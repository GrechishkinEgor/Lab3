import java.io.*;
import java.util.*;

public class Product {
	
protected String Name;
protected String Company;
protected int Price;
protected int Count;

public Product()
{
	this.Name = "";
	this.Company = "";
	this.Price = 0;
	this.Count = 0;
	return;
}
public Product(String Name, String Company, int Price)
{
	this();
	this.SetName(Name);
	this.SetCompany(Company);
	this.SetPrice(Price);
	return;
}
public Product(String Name, String Company, int Price, int Count)
{
	this(Name, Company, Price);
	this.SetCount(Count);
	return;
}

public Product(Product obj)
{
	this.Name = obj.Name;
	this.Company = obj.Company;
	this.Price = obj.Price;
	this.Count = obj.Count;
	return;
}

public boolean SetName(String Name)
{
	if (Name != null)
	{
		this.Name = Name;
		return true;
	}
	else
		return false;
}

public boolean SetCompany(String Company)
{
	if (Company != null)
	{
		this.Company = Company;
		return true;
	}
	else
		return false;
}

public boolean SetPrice(int Price)
{
	if (Price >= 0)
	{
		this.Price = Price;
		return true;
	}
	else
		return false;
}
public boolean SetCount(int Count)
{
	if (Count >= 0)
	{
		this.Count = Count;
		return true;
	}
	else
		return false;
}

public String GetName() {return this.Name;}
public String GetCompany() {return this.Company;}
public int GetPrice() {return this.Price;}
public int GetCount() {return this.Count;}

public boolean IncreaseCount()
{
	if (SetCount(this.Count + 1))
		return true;
	else
		return false;
}
public boolean DecreaseCount()
{
	if (SetCount(this.Count - 1))
		return true;
	else
		return false;
}

public void OutputAllInfo()
{
	System.out.println("Название товара: " + this.Name);
	System.out.println("Компания производитель: " + this.Company);
	System.out.println("Цена товара (в руб.): " + (this.Price / 100.0));
	System.out.println("Количество товара (штук): " + this.Count);
	return;
}

/*Записывает данные в открытый для записи поток. 
	Возврат: 1 - успешно; 0 - ошибка записи в файл*/
public int WriteInFile(FileWriter CurrentFile)
{
	try
	{
		CurrentFile.write(this.Name);
		CurrentFile.write("\n");
		CurrentFile.write(this.Company);
		CurrentFile.write("\n");
		CurrentFile.write(Integer.toString(this.Price));
		CurrentFile.write("\n");
		CurrentFile.write(Integer.toString(this.Count));	
		CurrentFile.write("\n");
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
		this.Name = CurrentFile.nextLine();
		this.Company = CurrentFile.nextLine();
		String PriceLine = CurrentFile.nextLine();	
		this.Price = Integer.parseInt(PriceLine);
		String CountLine = CurrentFile.nextLine();
		this.Count = Integer.parseInt(CountLine);
		return 1;
	}
	catch (Exception e)
	{
		System.out.println("Ошибка чтения из файла");
		return 0;
	}
}

/*Сохраняет данные в файл (путь - Path)
	Возврат: 1 - успешно; 0 - ошибка записи в файл*/
public int Save(String Path)
{
	try
	{
		FileWriter CurrentWriter = new FileWriter(Path);
		int ResWrite = WriteInFile(CurrentWriter);
		CurrentWriter.close();
		return ResWrite;
	}
	catch (Exception e)
	{
		return 0;
	}
}

/*Записывает данные в новый файл.
	Возврат: 1 - успешно; 0 - ошибка записи; -1 - файл существует*/
public int SaveNew(String Path)
{
	File f = new File(Path);
	if (f.exists())
		return -1;
	else
		return Save(Path);
}

/*Считывает данные из файла.
Возврат: 1 - успешно; 0 - ошибка чтения файла; -1 - файл не найден*/
public int Load(String Path)
{
	File f = new File(Path);
	if (f.exists())
	{
		try
		{
			FileReader fr = new FileReader(Path);
			Scanner scan = new Scanner(fr);
			return ReadFromFile(scan);
		}
		catch (Exception e)
		{
			return 0;
		}
	}
	else
		return -1;
}


protected static int TotalCost = 0;
public boolean AddInTotalCost()
{
	if (Product.TotalCost + this.Price * this.Count >= 0)
	{
		Product.TotalCost = Product.TotalCost + this.Price * this.Count;
		return true;
	}
	else
		return false;
}

public static int GetTotalCost() {return Product.TotalCost;}
public static void ResetTotalCost() {Product.TotalCost = 0; return;}
public static boolean CalculateTotalCost(Product[] List)
{
	int Cost = 0;
	for (int i = 0; i < List.length && Cost >= 0; i++)
		Cost += List[i].Price * List[i].Count;
	if (Cost >= 0 && Product.TotalCost + Cost >= 0)
	{
		Product.TotalCost += Cost;
		return true;
	}
	else
		return false;
}
};