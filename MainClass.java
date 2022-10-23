import java.io.*;
import java.util.*;

public class MainClass {
	public static void main(String[] args)
	{
		/*Product FirstProduct = new Product("Клава", "defender", 5000, 6);
		Product SecondProduct = new Product("Мышь", "мышица", 4000, 2);
		FirstProduct.OutputAllInfo();
		try
		{
			FileWriter fw = new FileWriter("Hello.txt");
			FirstProduct.WriteInFile(fw);
			SecondProduct.WriteInFile(fw);
			fw.close();
		}
		catch (Exception e)
		{
			System.out.println("Ошибка открытия файла.");
		}
		
		Product ThirdProduct = new Product();
		Product FourthProduct = new Product();
		try
		{
			FileReader fr = new FileReader("Hello.txt");
			Scanner scan = new Scanner(fr);
			ThirdProduct.ReadFromFile(scan);
			ThirdProduct.OutputAllInfo();
			
			FourthProduct.ReadFromFile(scan);	
			FourthProduct.OutputAllInfo();
			fr.close();
		}
		catch (Exception e)
		{
			System.out.println("Ошибка открытия файла.");
		}*/
		
		Product FifthProduct = new Product("Монитор", "LG", 70000, 4);
		/*FifthProduct.OutputAllInfo();
		FifthProduct.Save("printer.txt");
		Product SixthProduct = new Product();
		SixthProduct.Load("printer.txt");
		SixthProduct.OutputAllInfo();
		
		if (SixthProduct.SaveNew("printer1.txt") == 1)
			System.out.println("Файл не существовал. Запись произошла");
		else
			System.out.println("Файл существовал. Запись не осуществлена");
		*/
		Monitor FirstMonitor = new Monitor(FifthProduct);
		FirstMonitor.SetDiagonal(90);
		FirstMonitor.SetSize(40, 50);
		FirstMonitor.OutputAllInfo();
		FirstMonitor.Save("Monitor.txt");
		Monitor SecondMonitor = new Monitor();
		SecondMonitor.Load("Monitor.txt");
		SecondMonitor.OutputAllInfo();
		int sizes[] = FirstMonitor.GetSize();
		System.out.println(sizes[0] + " x " + sizes[1]);
	}
}