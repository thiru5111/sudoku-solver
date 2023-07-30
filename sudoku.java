import java.util.Scanner;
import java.io.*;

public class sudoku
{
Scanner sc=new Scanner(System.in);
public boolean safe(int[][] a,int r,int c,int n)
{

//loop for checking clash in row
for(int i=0;i<a.length;i++)
{
if(a[r][i]==n)
{
return false;
}
}

//loop for checking clash in column
for(int j=0;j<a.length;j++)
{
if(a[j][c]==n)
{
return false;
}
}

//loop for checking clash in grid
int sqt=(int)Math.sqrt(a.length);
int boxrowst=r-r%sqt;
int boxcolst=c-c%sqt;

for(int r1=boxrowst;r1<boxrowst+sqt;r1++)
{
for(int d=boxcolst;d<boxcolst+sqt;d++)
{
if(a[r1][d]==n)
{
return false;
}
}
}
return true;

}


public boolean solve(int[][] a,int num)
{
int r=-1;
int c=-1;
boolean notvacant=true;
for(int i=0;i<num;i++)
{
for(int j=0;j<num;j++)
{
if(a[i][j]==0)
{
r=i;
c=j;
notvacant=false;
break;
}
}
if(!notvacant)
{
break;
}
}
if(notvacant)
{
return true;
}

for(int no=1;no<=num;no++)
{
if(safe(a,r,c,no))
{
a[r][c]=no;
if(solve(a,num))
{
return true;
}
else
{
a[r][c]=0;
}
}
}
return false;
}


public void display(int[][] a,int n)
{
for(int i=0;i<n;i++)
{
for(int j=0;j<n;j++)
{
System.out.print(a[i][j]);
System.out.print(" ");
}
System.out.print("\n");

if((i+1)%(int)Math.sqrt(n)==0)
{
System.out.print("");
}
}
}

// main method
public static void main(String args[])
{
Scanner sc=new Scanner(System.in);
int[][] a=new int[9][9];
System.out.println("enter the question grid");
for(int i=0;i<a.length;i++)
{
for(int j=0;j<a.length;j++)
{
a[i][j]=sc.nextInt();
}
}
sudoku s1=new sudoku();
int size=a.length;

if(s1.solve(a,size))
{
System.out.println("the solution is");
s1.display(a,size);
}
else
{
System.out.println("there is no solution");
}
}
}


