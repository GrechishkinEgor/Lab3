import java.io.*;
import java.util.*;

public class MainClass {
	public static void main(String[] args)
	{
		Product FirstProduct = new Product();
		FirstProduct.SetCount(5);
		FirstProduct.SetPrice(500000);
		FirstProduct.AddInTotalCost();
		System.out.println("Совокупная стоимость: " + (Product.GetTotalCost() / 100.0));
		
		Monitor FirstMonitor = new Monitor();
		FirstMonitor.SetAspectRatio(16, 9);
		FirstMonitor.SetSize(1600, 900);
		Monitor.Aspects InfoAboutFirstMonitorAspect = FirstMonitor.GetAspectRatio();
		System.out.println("Соотношение сторон экрана монитора: " + InfoAboutFirstMonitorAspect.Aspect1 + ":" + InfoAboutFirstMonitorAspect.Aspect2);
		Monitor.Sizes InfoAboutFirstMonitorSizes = FirstMonitor.GetSize();
		System.out.println("Размер экрана: " + InfoAboutFirstMonitorSizes.Size1 + " x " + InfoAboutFirstMonitorSizes.Size2);
	}
}