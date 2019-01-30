import java.util.Random;
public class Theorem {
	static Random RandNum= new Random ();
	static int [] nums=new int[10];
	static int [] numberArray= new int [] {1,3,5,7,9,11,13,15,17,19};
	static boolean [] boolArray= new boolean [] {false,false,false,false,false,false,false,false,false,false};
	static final int Max=32;
	static int clockposition=0;
	static int Sum=0;
	static int combination=0;
	static boolean flag=false;
	static boolean restart=true;
	public static void main(String[] args) 
	{
		while (restart) 
		{
		clockposition=0;
		Sum=0;
		combination=0;
		flag=false;
		boolArray= new boolean [] {false,false,false,false,false,false,false,false,false,false};
		GenerateClock();
		PrintClock();
		while (clockposition<10 && flag!=true) 
		{
			doSum();
			if (flag==true) 
			{
				System.out.println("combination failed");
				break;
			}
			else 
			{
				clockposition++;
			}
		}
		if(combination==20) 
		{
			System.out.println("Its done");
			restart=false;		
		}
		}
		PrintClock();

	}
	public static void GenerateClock() 
	{
		for (int c=0; c<10;c++) 
		{
			int x=RandNum.nextInt(9);
			while (boolArray[x]==true) 
			{
				x=RandNum.nextInt(10);
			}
			nums[c]=numberArray[x];
			boolArray[x]=true;
		}
	}
	public static void PrintClock() 
	{
		for (int c=0; c<10; c++) 
		{
			System.out.print(nums[c]+" ");
		}
	}
	public static void doSum() 
	{
	Sum=nums[clockposition]+nums[clockposition+1]+nums[clockposition+2];
	if(Sum<Max) 
	{
		combination++;
		if (clockposition==0) 
		{
			Sum=nums[clockposition]+nums[(clockposition-1)+10]+nums[(clockposition-2)+10];

		}
		else if(clockposition<=1) 
		{ 
		Sum=nums[clockposition]+nums[(clockposition-1)]+nums[(clockposition-2)+10];
		}
		else 
		{
			Sum=nums[clockposition]+nums[clockposition-1]+nums[clockposition-2];
		}
		if (Sum<Max) 
		{
			combination++;
		}
		else 
		{
			flag=true;
		}
	}
	else 
	{
		flag=true;
	}
	}
}
