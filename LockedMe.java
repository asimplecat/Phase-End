import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class LockedMe 
{
	private String path = System.getProperty("user.dir");
	private String holder = path + "\\temp";
	
	public LockedMe()
	{
		generateFiles();
	}

	public void displayFiles()
	{
		File file = new File(holder);
		String[] sam = file.list();
		if (sam.length == 0)
		{
			System.out.println("list is empty");
			return;
		}
		Arrays.sort(sam);
		for (String n : sam)
		{
			System.out.println(n);
		}
	}
	
	public void generateFiles()
	{
		File file = new File(holder);
		if (!file.exists())
		{	
			file.mkdir();
			System.out.println("Directory did not exist, it has been created");
		}
	}
	
	public void addFile(String userInput)
	{
		File file = new File(holder + "\\" + userInput);
		
			try {
				file.createNewFile();
				System.out.println("File added");
			} catch (IOException e) {
				System.out.println("Error: file already exists");
			}
	}
	
	public void deleteFile(String userInput)
	{
		File file = new File(holder + "\\" + userInput);
		if (file.exists())
		{
			boolean check = file.delete();
			System.out.println("file deleted? " + check);
		}
		else {
			System.out.println("File not found in working directory");
		}
	}
	
	public void searchFile(String userInput)
	{
		File file = new File(holder + "\\" + userInput);
		if (file.exists())
		{
			System.out.println("File found in working directory");
		}
		else {
			System.out.println("File not found in working directory");
		}
	}
}
