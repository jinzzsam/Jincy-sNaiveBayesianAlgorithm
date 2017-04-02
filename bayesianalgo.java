import java.util.*;
class bayesianalgo
{
	public static void main(String args[])
	{
	int i,j;
	String yes=new String();
	String no=new String();

	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the number of columns: ");
	int col=sc.nextInt();
	
	System.out.println("Enter the number of rows: ");
	int row=sc.nextInt();
		
	String array[][]=new String [row+1][col+1];
	
	//Initializing array
	for(i=0;i<row+1;i++)
		for(j=0;j<col+1;j++)
			array[i][j]="1";
	System.out.println("NOTE: Please use lower case characters only");
	sc.nextLine();

	//Initializing tupleX
	String xattr[]=new String[col-1];
	
	//Taking attribute names
	for(i=1;i<=col;i++)
	{	
		System.out.print("Enter attribute name for col "+i+" : ");
		
		array[0][i]=sc.nextLine();
	}
	
	//For Sr. no
	array[0][0]="RID";
	for(i=1;i<=row;i++)
		array[i][0]=String.valueOf(i);

	//Enter attribute values
	for(i=1;i<=col;i++)
	{
		System.out.println("Enter attribute values for "+array[0][i]+" : ");
		for(j=1;j<=row;j++)
			array[j][i]=sc.nextLine();
	
	}
		
	//Enter attribute to classify
	System.out.println("Enter tuple to classify: ");
	for(i=1;i<col;i++)
	{
		System.out.println(array[0][i]+ " : ");
		xattr[i-1]=sc.nextLine();
	}
	
	//Identifying class attribute values
	for(i=1;i<=row;i++)
	{
		if (Objects.equals(array[i][col],"positive")==true)
		{
			yes="positive";
			no="negative";
		}
		else if (Objects.equals(array[i][col],"yes")==true)
		{
			yes="yes";
			no="no";
		}
		else if (Objects.equals(array[i][col],"y")==true)
		{
			yes="y";
			no="n";
		}
		else if (Objects.equals(array[i][col],"p")==true)
		{
			yes="p";
			no="n";
		}
	}
	
	//Display array
	for(i=0;i<row+1;i++)
	{		
		System.out.println();
		for(j=0;j<col+1;j++)
			System.out.print(array[i][j]+"\t\t");
	}
	System.out.println();
	
	//Calculations part 1
	System.out.println();
	
	int x=0,y=0,x1=0,y1=0,x2=0,y2=0,x3=0,y3=0,x4=0,y4=0,x5=0,y5=0;
	for(i=1;i<=row;i++)
	{
		if(Objects.equals(array[i][col],yes)==true)
			x++;
		else y++;
	}
	System.out.println("P("+array[0][col]+"=yes) : "+x+"/"+row+" = "+(float)x/row);
	System.out.println("P("+array[0][col]+"=no) : "+y+"/"+row+" = "+(float)y/row);
	System.out.println();
	//Calculations part 2
	for(i=1;i<=row;i++)
	{
		if(Objects.equals(xattr[0],array[i][1])==true)
		{
			if(Objects.equals(array[i][col],yes)==true)
				x1++;
			else y1++;
		}
	}
	System.out.println("P("+xattr[0]+"|"+array[0][col]+"=yes) = "+x1+"/"+x+" = "+(float)x1/x);	
	System.out.println("P("+xattr[0]+"|"+array[0][col]+"=no) = "+y1+"/"+y+" = "+(float)y1/x);	
	
	for(i=1;i<=row;i++)
	{
		if(Objects.equals(xattr[1],array[i][2])==true)
		{
			if(Objects.equals(array[i][col],yes)==true)
				x2++;
			else y2++;
		}
	}
	System.out.println("P("+xattr[1]+"|"+array[0][col]+"=yes) = "+x2+"/"+x+" = "+(float)x2/x);	
	System.out.println("P("+xattr[1]+"|"+array[0][col]+"=no) = "+y2+"/"+y+" = "+(float)y2/x);	
	
	if(col-1>2)
	{
		for(i=1;i<=row;i++)
		{
			if(Objects.equals(xattr[2],array[i][3])==true)
			{
				if(Objects.equals(array[i][col],yes)==true)
					x3++;
				else y3++;
			}
		}
	System.out.println("P("+xattr[2]+"|"+array[0][col]+"=yes) = "+x3+"/"+x+" = "+(float)x3/x);	
	System.out.println("P("+xattr[2]+"|"+array[0][col]+"=no) = "+y3+"/"+y+" = "+(float)y3/x);	
	}
	else 
	{
		x3=1;
		y3=1;
	}
	
	if(col-1>3)	
	{	
		for(i=1;i<=row;i++)
		{
			if(Objects.equals(xattr[3],array[i][4])==true)
			{
				if(Objects.equals(array[i][col],yes)==true)
					x4++;
				else y4++;
			}
		}
		System.out.println("P("+xattr[3]+"|"+array[0][col]+"=yes) = "+x4+"/"+x+" = "+(float)x4/x);	
		System.out.println("P("+xattr[3]+"|"+array[0][col]+"=no) = "+y4+"/"+y+" = "+(float)y4/x);	
	}
	else 
	{
		x4=1;
		y4=1;
	}
	/*for(i=1;i<=row;i++)
	{
		if(Objects.equals(xattr[4],array[i][4])==true)
		{
			if(Object.equals(array[i][col],yes)==true)
				x5++;
			else y5++;
		}
	}
	System.out.println("P("+xattr[4]+"|"+array[0][col]+"=yes) = "+x5+"/"+x+" = "+x5/x);	
	System.out.println("P("+xattr[4]+"|"+array[0][col]+"=no) = "+y5+"/"+y+" = "+y5/x);*/	
	
	System.out.println();
	
	//Calculation part 3
	float yes1=(float)x1*x2*x3*x4/(float)(Math.pow(x,col-1));
	float no1=(float)y1*y2*y3*y4/(float)(Math.pow(y,col-1));
	System.out.println("P(X|"+array[0][col]+"=yes) = "+yes1);
	System.out.println("P(X|"+array[0][col]+"=no) = "+no1);
	System.out.println();

	//Calculation part 4
	float finalyes=(float)yes1*x/row;
	float finalno=(float)no1*y/row;
	System.out.println("P(X|"+array[0][col]+"=yes).P("+array[0][col]+"=yes) = "+finalyes);
	System.out.println("P(X|"+array[0][col]+"=no).P("+array[0][col]+"=no) = "+finalno);
	System.out.println();
	if(finalyes>finalno)
		System.out.println("Classified as yes");
	else System.out.println("Classified as no");

}}
