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
	}
}