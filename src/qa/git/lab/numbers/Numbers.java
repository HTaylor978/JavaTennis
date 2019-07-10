package qa.git.lab.numbers;

public class Numbers
{
	public static void main(String argv[])
	{

		
		int i = 1;
		long result = 1;
		while (i < 64)
		{
			result *= 2;
			if (result > 9999999999L)
				break;
			if (i < 10)
				System.out.print(" ");
			System.out.println(i + "\t" + result);
			i++;
		}

 		

    }

}

