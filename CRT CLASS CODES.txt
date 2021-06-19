Check LSB is 1 or 0 :
( a & 1 )
--------------------------------------------------------------------
(a | 1) = a+1 for even and a for odd
--------------------------------------------------------------------
(a ^ 1) = a+1 for even and a-1 for odd
--------------------------------------------------------------------
left shift : a<<i = (a * (2^i)) - eg: 1<<i = 2 power i
--------------------------------------------------------------------
right shift : a>>i = (a / (2^i))
--------------------------------------------------------------------
CheckBit at kth position from LSB 
public static boolean checkBit(int n,int k)
    {
        return (((n>>k) & 1 ) == 1);
        //return (((n>>k) % 2 ) == 1);
        // return ( ((1<<k) & n ) == 1);
    }
--------------------------------------------------------------------
find no of set bits in n
Approach 1:
public static int noofsetbits(int n)
    {
        int c=0;
        while(n>0)
        {
            c=c+(n&1); //LSB -> if 1 count++; else 0 dont increment
            n=n>>1; //Right Shift to get next LSB
        }
        return c;
    }

Approach 2 : 
  public static int noofsetbits(int n)
    {
        int c=0;
        for(int i=0;i<=30;i++) // 32st bit(MSB) is for sign so consider 31 bits (0-30 bits)
	{
		if(checkBit(N,i))
		{
                  c++;
		}
	}
	return c;
    }

Approach 3 :
(n & (n-1)) will unsets least significant bit(removes 1 which is near to lsb)  
    public static int noofsetbits(int n)
    {
        int c=0;
        while(n!=0)
        {
            n= n&(n-1); // check for 1 and unsets it
            c++;//increment c as 1 unsets means 1 is present in n
        }
        return c;
    }
---------------------------------------------------------------------
check n is power of 2 or not 
2-10
4-100
8-1000
16-10000
all powers of 2 has 1 set bit and remaining 0 bits

we know that (n & (n-1)) will unsets least significant bit(removes 1 which is near to lsb)

so if(n & (n-1)) = 0 then it is power of 2
---------------------------------------------------------------------
   x  y -> answer
   3  2 ->    means 3 ones 2 zeroes-> 11100 find sum -> 28 
   2  4 ->    means 2 ones 4 zeroes-> 110000 find sum ->48

Approach 1:

int solve(int x,int y)
{
  int sum=0;
  for(int i=y;i<x+y;i++)
   {
     sum+=(int)Math.pow(2,i);
    }return sum;
}

Approach 2:
 sum = 2^(x+y) - 2^(y) 
int solve(int x,int y)
{
  return ((int)Math.pow(2,x+y) - (int)Math.pow(2,y));
}

Approach 3:
sum = 2^(x+y) - 2^(y) 
 as we know a<<i = a*2^1  so we can write 1<<n = 2^n then

int solve(int x,inty)
{
 return ((1<<(x+y)) - (1<<y));
}
---------------------------------------------------------------------
N=20 divisors of 20 = 1,2,4,5,10,20 (6) return 6

Approach 1: BruteForce
public static int div(int N)
{
  int c=0;
  for(int i=1;i<=N;i++)
  {
    if(N%i==0)
      c++;
  }
  return c;
}

Approach 2: some optimised
public static int div(int N)
{
  int c=2; // 1 and N always divisors so take c=2 at first and doesnt iterate 
  for(int i=2;i<=N/2;i++)
  {
    if(N%i==0)
      c++;
  }
  return c;
}

Approach 3: optimised
 24-> 
	1*24
	2*12     here 1 and 24 both are cofactors so iterate upto sqrt(N) and count 2 each 
	3*8
	4*6

public static int div(int N)
{
  int c=0;
  for(int i=1;i<=Math.sqrt(N);i++)
  {
    if(N%i==0)
      c=c+2;
  }
  return c;
}
---------------------------------------------------------------------
given n elements of array -> all elements expect 1 are repeated 2 times then find that 1element 

Approach 1 : Time, Space - > N2,1 
 Bruteforce : take element & search if not found -> not repeated

int solve(int []a, int n)
    {
      for(int i=0;i<n;i++)
      { 
          int count=0; // int should must declare in for loops only
          for(int j=0;j<n;j++) // j should not start from i+1 b/c it checks front elements also
          {
              if(i!=j)
              {
                  if(a[i] == a[j])
                  {
                      count++;
                  }
              }
              if(count==0) return a[i];
              else return -1;
          }
          
      }

Approach 2: Time ,Space -> (N,1)
apply XOR as we know a^a=0 , a^b^a = b^0 =b
so XOR of all elements gives unrepeated value
---------------------------------------------------------------------
a^N =a^x1+a^x2+a^x3+a^x4+a^x5+.....+a^xm is true

if N = x1+x2+x3...........xm

a^13 = a^1+a^4+a^8  --> as 13 = 1101(2+4+8)

here 0<=N<=10^9  0<=a<=10^9

Approach 1:(logn,1)
int pwr(int a, int n)
    {
        int i=0;
        long ans=1,x=a;
        while(i<31) // 32bit MSB is for sign so consider upto 31 bits(0 to 30)
        {
            if((n>>i)&1 == 1)
               ans=ans+x;
            x=x*x;
            i++;
        }
        return ans;
    }

Approach2: (logn,1)
int pwr(int a, int n)
    {
        long ans = 1,x=a;
        for(int i=0;i<31;i++) // or use while(n>0)
        {
            if((n&1) == 1) //check lsb =1 if 1 then calculate
               ans=ans+x;
            x=x*x;
            n=n>>1;
        }return ans;
    }
---------------------------------------------------------------------
we are given n elements and k 
check sum of any subset equals k or not
 let us take -> a[] =  5 , -2 , 8
****(for n elements we will have 2^n subsets)
generate subsets first then check sum and print

logic will be
0  ->  0   0   0  -> null
1  ->  0   0   1  -> 5 ( 0th index is set so print a[0]->5)
2  ->  0   1   0  -> 2 ( 1th index is set so print a[1])
3  ->  0   1   1  -> 5,-2  ( 0,1 index is set so print a[0],a[1])
4  ->  1   0   0  -> 8( 2th index is set so print a[2])
5 ->   1   0   1  -> 5,-8 ( 0,2 index is set so print a[0],a[2])
6  ->  1   1   0  -> -2,8 ( 1,2 index is set so print a[1],a[2])
7  ->  1   1   1  -> 5,2,8 (0,1,2 index is set print a[0],a[1],a[2])

here for n =  3 elements 2^3  = 8 subsets (0 -  7)

import java.util.*;

public class Main
{
    static boolean subsets(int []a,int n,int k)
    {
        for(int i=0;i<(1<<n);i++)
        {
            int temp=i,sum=0,j=0;
            while(temp!=0)
            {
                if( (temp & 1) == 1) // check lsb == 1
                           sum = sum+a[j];
                j++;
                temp=temp>>1;
            }
            if(sum == k) return true;
            
        }return false;
    }
	public static void main(String[] args) {
	   Scanner sc = new Scanner(System.in);
	   int n  = sc.nextInt();
	   int k = sc.nextInt();
	   int []a = new int[] {5,-2,8};
	   if(subsets(a,n,k))
	   System.out.print("YES");
	   else System.out.print("NO");
	   
	}
}

It is (N*2^N,1) complexity
                               OR

static boolean subsets(int []a,int n,int k)
    {
        for(int i=0;i<(1<<n);i++)
        {
            int sum=0;
            for(int j=0;j<n;j++) //as n=3 in above case so check upto 3 bits (0 1 2) enough 
            {
                if( ((i>>j) & 1) == 1)
                   sum = sum+a[j];
            }
           
            if(sum == k) return true;
            
        }return false;
    }
--------------------------------------------------------------------
each element is repeated 3 times except 1 so print that ele as answer

Approach1:
Brute force-> take ele and search if not found 3 times then print -----> (N^2,1) complexity

Approach 2: using freq or HashMap -> (N,1)

Approach 3: Bit Manipulation

refer cw ....find binary digitscount at each bit and differ the element
since it is array of integer take upto 31 or 30 bits

int solve(int []a,int n)
    {
        int ans= 0;
        for(int i=0;i<31;i++) //for 31 bits in each ele / number
        {
            int c=0;
            for(int j=0;j<n;j++) //for n array ele
            {
                if(checkBit(a[j],i))
                     c++;
            }if(c%3!=0) // ith bit is in 1 category or else 0 category
               ans = ans+(1<<i); // 2^i
        }
    }
--------------------------------------------------------------------
https://codepumpkin.com/series/bit-manipulation-programming-questions/
--------------------------------------------------------------------
Recursion sum of N natural numbers - O(N)
int sum(int N)
{  
  if(N==0) return 0;
  return N+sum(N-1);
}
--------------------------------------------------------------------
Recursion factorial of number N - O(N)
int fact(int N)
{  
  if(N==0) return 1;
  return N*fact(N-1);
}
--------------------------------------------------------------------
Recursion fibonacci of number N - O(2^N)
int fibR(int N)
{  
  if(N<=1) return N;
  return fibR(N-1)+fibR(N-2);
}
--------------------------------------------------------------------
Recursion sum of N terms of Arithmetic progression AP - O(N)
APSUM = a+(a+d)+(a+2d)...+(a+(N-1)d)
int APSum(int a,int N,int d)
{  
  if(N==1) return a;
  return a+(N-1)d +APSum(a,N-1,d);
}
--------------------------------------------------------------------
Towers of hanoi refer cw take 2 disks and solve larger problem - O(2^n)

No of moves takes place is (2^n-1) => ((1<<n)-1)

static void towerOfHanoi(int n, char src, char dest, char temp)
    {
        if (n == 1)
        {
            System.out.println("Move 1 from " +  src + " to " + dest);
            return;
        }
        towerOfHanoi(n-1, src, temp,dest);
        System.out.println("Move " + n + " from " +  src + " to " + dest);
        towerOfHanoi(n-1, temp, dest, src);
    }
     

In main towerOfHanoi(n,'A','C','B');
--------------------------------------------------------------------
a power n => Recursion

Approach 1 :  a^n = a*(a^n-1) --> T(n) = T(n-1)+1 => O(n)
int pwr(int a,int n)
{
  if(n==0) return 1;
  return a*pwr(a,n-1);
}

Approach 2 : a^n = (a^n/2)*(a^n/2) if even , a^n = a*(a^n/2)*(a^n/2) if odd

int pwr(int a,int n) --> T(n) = 2T(n/2)+1 => O(n)
{
  if(n==0) return 1;
  if(n%2==1) //odd
   return a*pwr(a,n/2)*pwr(a,n/2);
  return a*pwr(a,n/2)*pwr(a,n/2); //even
}
--------------------------------------------------------------------
Backtracking SubsetSum : T(n)=2T(n-1)+1 => O(2^n)

subsets for n numbers => 2^n because number has 2 options it can include or not 

boolean subsets(int ar[],int n,intk,int sum,int idx)
{
 if(idx == n)
   return sum==k;
 return (subsets(ar,n,k,sum+ar[idx],idx+1) || subsets(ar,n,k,sum,idx+1)); // include and not include
}
--------------------------------------------------------------------
Backtracking : Open and Close Parenthesis
Input: n = 3 => (2ncn)/(n+1) ==> 6c3/4=5 
Output: A solution set is
[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]

string[] generateParenthesis(int n) {
    string[] combinations
    open = 0
    close = 0
    backtrack(combinations, "", open, close, n)
    return combinations
}

void backtrack(string[] combination, String cur, int open, int close , int n){
    if (cur.length() == n*2) {
        combination.add(cur)
        return;
    }
    if (open < n) {
        backtrack(combination, cur + "(", open + 1, close, n)
    }
    if (close  < open) {
        backtrack(combination, cur + ")", open, close  + 1, n)
    }
}
https://afteracademy.com/blog/generate-parentheses
--------------------------------------------------------------------
Backtracking Interleavings 

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int p=0;p<t;p++)
        {
            String A=sc.next();
            String B=sc.next();
            List<String> al=new ArrayList<>();
            System.out.println("Case #"+(p+1)+":");
            interleavings(A,B,"",al);
            Collections.sort(al);
            for(String str:al){
                System.out.println(str);
            }
        }
        }
    public static void interleavings(String s1,String s2,String temp,List<String> al)
    {
        
        if(s1.length()==0&&s2.length()==0)
        {
            al.add(temp);
            return;
        }
        
        if(s2.length()>0)
        {
            interleavings(s1,s2.substring(1),temp+s2.charAt(0),al);
        }
        if(s1.length()>0)
        {
            interleavings(s1.substring(1),s2,temp+s1.charAt(0),al);
        }
    }
} 
----------------------------------------------------------------------------------
Sorting 

Insertion Sort -> O(N^2,1) bubble,insertion,Selection sorts are inplace sort algos wont use extra space

 for(int i=1;i<n;i++)
{
  key = a[i]; 
  j=i-1;
  while(j>=0 && a[j]>key)
  {
    a[j+1] = [j];
    j=j-1;
   }
   a[j+1] = key;
   //print a[j+1] 
}
 print the index at which the ith element gets inserted => means a[j+1] for each iteration
----------------------------------------------------------------------------------
CountSort => (n+m,m)

void cs(int ar[],int m,int n) // n elements m unique elements , cs to store count of m 
{
  int cnt[m+1]={0};
  int  k =0;
  for(int i=0;i<n;i++)
  {
    cnt[ar[i]]++;
  }
  for(int i=0;i<m;i++)
  {
    for(int j=0;j<cnt[i];j++)
    {
      ar[k++] = i;
    }
  }
}
ar[] Array is sorted here 0<=ar[i]<=m

but if a<=ar[i]<=b then count size will be range R=b-a+1 so

void cs(int ar[],int N,int a,int b) 
{ 
  int R = b-a+1;
  int cnt[R]={0};
  int  k =0;
  for(int i=0;i<n;i++)
  {
    cnt[ar[i]+a]++;
  }
  for(int i=0;i<=R;i++)
  {
    for(int j=0;j<cnt[i];j++)
    {
      ar[k++] = i+a;
    }
  }
}
Time Complexity => (N+R,R)
----------------------------------------------------------------------------------
Two Unsorted Arrays An - (nsize) and Bm - (msize) print both in ascending order

Approach1: take new array of size[n+m] and merge them and sort -> (N+M + (N+M)^2 ,N+M)copy sort space

Approach2: take element of A/B and check and shift array then print -> (N+M*N,N+M) 

Approach3: comparing each element of a and b if less print and increment -> (N+M,1) optimised

void function (int A[],int N,int B[],int m)
{
 int p1=0,p2=0;
 while(p1<n && p2<m)
 {
  if(A[p1]<B[p2])
  {
   print(A[p1]);
   p1++;
  }
  else
  {
   print(B[p2]);
   p2++;
  }
 }
 while(p1<N) 
   print(A[p1++]);
 while(p2<M)
   print(B[p2++);
}
----------------------------------------------------------------------------------
Given An and Bm both arrays and finally all elements should be in A and sorted 

Approach 1:copy B to A ans Sort -> (M+ N^2,1)

Approach 2:check and array shift as previous question worst case we may shift N-M -> (M*(N-M),1)

Approach 3:compare and print -> same as prev

Approach 4:take new array of size n and compare and print in new array at last copy new array in to A -> (N,N)

Approach 5:refers others book
----------------------------------------------------------------------------------
Sort zeroes and ones - 2 pointers -> (N,1)
public static void check(int a[],int n)
{
  int p1=0;
  int p2=n-1;
  while(p1<p2)
  {
    while(a[p1]==0 && p1<p2)
	 p1++;
    while(a[p2]==1 && p1<p2)
	 p2--;
   if (p1 < p2)
   {
      a[p1] = 0;
      a[p2] = 1;
      p1++;
      p2--;
   }
  }
}
----------------------------------------------------------------------------------
find (i,j) pairs in array A[] such that i<j and ar[i]>ar[j]
that means how many low elements are behind high -> merge sort ->(NlogN,N) N space mergesort but quick 1

Smaller elements 

import java.io.*;
import java.util.*;

public class Solution {
    
    public static long merge (int ar[],int l,int h){
    int m=(l+h)/2,n=h-l+1;
    int te[]= new int[n],k=0;
    int i=l,j=m+1;
    long xx=0;
    while(i<=m && j<=h){
        if(ar[i]<=ar[j])
            te[k++]=ar[i++];
        else{
            te[k++]=ar[j++];
            xx+=m-i+1;}
    }
    while(i<=m){
        te[k++]=ar[i++];
    }
    while(j<=h){
        te[k++]=ar[j++];
    }
    for (int p=l;p<=h;p++){
        ar[p]=te[p-l];
    }
    
    return xx;
    
}
   public static long ms(int ar[],int l ,int h){
    long count=0;
    if (l==h) return 0;
    int m=(l+h)/2;
    count+=ms(ar,l,m);
    count+=ms(ar,m+1,h);
    count+=merge(ar,l,h);
    return count;
}

    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int n = sc.nextInt();
            int ar[] = new int[n];
            for(int i=0;i<n;i++)
            {
                ar[i] = sc.nextInt();
            }
            System.out.println(ms(ar,0,n-1));
        }
    }
}
----------------------------------------------------------------------------------
masters theorem
T(n) = aT(n/b) + f(n)
t = logabaseb f(n) = N^c

t<c then O(N^c)
t==c then O(N^t*logN)
t>c then O(N^t)
----------------------------------------------------------------------------------
sum of pairs a+b=k (a,b) exist or not

Approach !: Bruteforce N^2,1

Approach 2:MergeSort + two pointer 

public static void chkpointer(int a[],int p1,int p2,int k)
    { 
      int c = 0;
      while(p1<p2){
                int sum=a[p1]+a[p2];
                if(sum<k)
                    p1++;
                else if(sum>k)
                    p2--;
                else
                {
                    System.out.println("True");
                    c=1;
                    break;
                }
            }
            if(c==0)
            System.out.println("False");
       
    }
----------------------------------------------------------------------------------
Pair with diff k -  a-b=k
 MergeSort+two pointer
 public static void chkpointer(int a[], int l, int h, int k) {
        int c = 0;
        int n=h+1;
        int p1=1,p2=0;
        while (p1<n &&  p2<n) {
            int sum = a[p1] - a[p2];
            if (sum < k)
                p1++;
            else if (sum > k)
                p2++;
            else ( sum == k && p1!=p2){
                System.out.println("true");
                c = 1;
                break;
            }
        }
        if (c == 0)
            System.out.println("false");

    }

----------------------------------------------------------------------------------
triplet sum a+b+c=k with two pointer refer smartinter..
----------------------------------------------------------------------------------
BinarySearchIterative:

int binarySearch(int arr[], int x)
    {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
  
            
            if (arr[m] == x)
                return m;
  
            
            if (arr[m] < x)
                l = m + 1;
  
            
            else
                r = m - 1;
        }
        return -1;
    }

BinarySearchRecursive:

int binarySearch(int arr[], int l, int r, int x)
    {
        if (r >= l) {
            int mid = l + (r - l) / 2;

            if (arr[mid] == x)
                return mid;
  
            if (arr[mid] > x)
                return binarySearch(arr, l, mid - 1, x);
  
            return binarySearch(arr, mid + 1, r, x);
        }
        return -1;
    }
----------------------------------------------------------------------------------
find max element which is lessthan or equal to k

Approach 1:( N*Q,1 ) if Q queries
int sol(int ar[],int n,int k)
{
 ans = Integer.MIN_VALUE;
 for(int i=0;i<n;i++)
 {
  if(ar[i]>ans && ar[i]<k )
  {
    ans = ar[i];
  }
 }
 return ans;
}

Approach 2: binary search - (Nlogn + Qlogn,1)

int solve(int ar[],int n;int k)
{
 int low=0;high=n-1;
 while(low<=high)
 {
  int mid = (low+high)/2;
  if(ar[mid]>k)
    high = mid+1;
  else
  {
    ans = ar[mid];
    low = high+1;
  }
 }
 return ans;
}

----------------------------------------------------------------------------------
Finding frequencies of elements in an array

Approach 1 :  brute force
Approach 2 : count sort
Approach 3 : sort + binary search + iterate

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {
    
    public static int bs1(int a[],int n,int k)
    {
        int low = 0,high=n-1,index = -1,it=0,c=1;
        while(low<=high)
        {
            int mid = (low+high)/2;
            if(a[mid]>k)
                 high=mid-1;
            else if(a[mid]<k)
                 low=mid+1;
            else if(a[mid] == k)
            {
                it = mid;
                
                
                for(int i = it-1;i>=0;i-- )
                {
                    if(a[i] == k) c++;
                    else break;
                }
                for(int i = it+1;i<n;i++)
                {
                    if(a[i] == k) c++;
                    else break;
                }return c;
            }
        }return c ;
    }
    
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int t=s.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++)
        {
            a[i]=s.nextInt();
        }
        Arrays.sort(a);
        int result = bs1(a,n,t);
        System.out.println(result);     
        
    }
}


Approach 4 : sort + binary search + two pointers method

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public static int bs1(int a[],int n,int k)
    {
        int low = 0,high=n-1,index = -1;
        while(low<=high)
        {
            int mid = (low+high)/2;
            if(a[mid]>k)
                 high=mid-1;
            else if(a[mid]<k)
                 low=mid+1;
            else if(a[mid] == k)
            {
                index = mid;
                high = mid-1;
            }
        }return index;
    }
    public static int bs2(int a[],int n,int k)
    {
        int low = 0,high=n-1,index = -2;
        while(low<=high)
        {
            int mid = (low+high)/2;
            if(a[mid]>k)
                 high=mid-1;
            else if(a[mid]<k)
                 low=mid+1;
            else if(a[mid] == k)
            {
                index = mid;
                low = mid+1;
            }
        }return index;
    }

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++)
        {
            a[i]=s.nextInt();
        }
       Arrays.sort(a);
        int t=s.nextInt();
        for(int i=0;i<t;i++)
        {
            int query=s.nextInt();
            int result = bs2(a,n,query) - bs1(a,n,query) +1;
            System.out.println(result);
            
        }
    }
}

Approach 5 : sort + binary search + divide into two arrays

import java.util.*;
public class freqUsingAB {
	static int findIndex(List<Integer> a,int key) {
		int idx=-1;
		int l=0,h=a.size()-1;
		while(l<h) {
			int mid = (l+h)/2;
			if(a.get(mid)==key)
				return mid;
			else if(a.get(mid)<key)
				l=mid+1;
			else
				h=mid-1;
		}
		return idx;
		
	}
	public static void main(String argsA[]) {
		Scanner sc=new Scanner(System.in);
		int arr[]= {-8,-2,3,5,5,5,5,7,7,10,10,18};
		ArrayList<Integer> A=new ArrayList<>();
		ArrayList<Integer> B=new ArrayList<>();
		for(int i=0;i<arr.length-1;i++) {
			if(arr[i]!=arr[i+1])
				A.add(arr[i]);
		}
		A.add(arr[arr.length-1]);
		System.out.println("Unique elements array A : ");
		for(int i:A)
			System.out.print(i+" ");
		int count=1;
		for(int i=0;i<arr.length-1;i++) {
			if(arr[i]==arr[i+1])
				count++;
			else {
				B.add(count);
				count=1;
			}	
		}
		B.add(count);
		System.out.println("Frequency Array B : ");
		for(int i:B)
			System.out.print(i+" ");
		System.out.println("Enter the query : ");
		int query = sc.nextInt();
		int idx = findIndex(A,query);
		if(idx==-1)
			System.out.println("The frequency is 0");
		else
		System.out.println("The frequency of the entered number is : "+B.get(idx));
	}
}

Approach 6 :  Sort array + Sort queries + 2-pointer + BS in original queries


Approach 7 : using hashmap 

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=s.nextInt();
        }
        HashMap<Integer,Integer> h=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            if(h.containsKey(arr[i]))
            {
                int c=h.get(arr[i]);
                h.put(arr[i],c+1);
            }
            else{
                h.put(arr[i],1);
            }
        }
        int t=s.nextInt();
        for(int i=0;i<t;i++)
        {
            int query=s.nextInt();
            if(h.containsKey(query))
                System.out.println(h.get(query));
            else
                System.out.println(0);
        }
    }
}
--------------------------------------------------------------------------
Hashing Map and sets

sum of pairs : a+b=k

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
    
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc=new Scanner(System.in);
        int test=sc.nextInt();
        while(test-->0){
            int n=sc.nextInt();
            int k=sc.nextInt();
            int []ar = new int[n];
            for(int i=0;i<n;i++)
            {
                ar[i] =sc.nextInt();
            }int a,b,c=0;
            HashMap<Integer, Integer> hm = new HashMap<>();
            for(int i=0;i<n;i++){
                 a=ar[i];
                b=k-ar[i];
                if(hm.containsKey(b))
                    c=1;
                else
                hm.put(a,1);
            }
            if(c==1) System.out.println("True");
            else System.out.println("False");  
        }
    }
}
--------------------------------------------------------------------------
Pair with diff k :  a-b =k or b-a=k similarly

 HashMap<Integer, Integer> hm = new HashMap<>();
            for(int i=0;i<n;i++){
                 a=ar[i];
                b=ar[i]-k;
                d = ar[i]+k;
                
                if(hm.containsKey(b))
                    c=1;
                else if(hm.containsKey(d))
                    c=1; 
                else
                hm.put(a,1);
            }
            if(c==1) System.out.println("true");
            else System.out.println("false");
--------------------------------------------------------------------------
repeated 2 times except 1 using binary...
--------------------------------------------------------------------------
cabinet partioning
--------------------------------------------------------------------------
refer notes for hash methods 
--------------------------------------------------------------------------

pending




--------------------------------------------------------------------------
Strings
ASCII A-65 Z-90 (65+26-1)
      a-97 z-122 (97+26-1)

ascii from 0-127
for(int i=0;i<127;i++)
 {
   System.out.println((char)i);
 }

--------------------------------------------------------------------------
First repeating character
Str :  x p d s y d m p y
output1 : d which will repeat at first
output 2 : p which has duplicates first ( repeating character)

output1: take set<char> and read inputs into it and search contains method break and print 
                or 
         take boolean array cnt[26]={f} make true if we found and search continues if true is encountered break and print

output2: take hashmap iterate and populate then iterate if cnt>=1 break and print

/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Solution
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
         sc.nextLine();
        while(t-->0){
        String s = sc.nextLine();
        HashMap<Character,Integer> hm = new HashMap<>();
        
            char[] a = s.toCharArray();
       
         for (char c : a) {
            if (hm.containsKey(c)) {
  
                
                hm.put(c, hm.get(c) + 1);
            }
            else {
  
                
                hm.put(c, 1);
            }
        }
         int v=0;
            for (char c : a)
            {
            if (hm.get(c) > 1)
            {
                System.out.println(c);
                 v=1;
                break;
            }
        }
        if(v==0)
        {
            
                System.out.println(".");
            
        }}
    }
}

                or 

 take cnt array cnt[26]={0}and populate then iterate and if cnt>=1 print and break

--------------------------------------------------------------------------
longest palindrome string (refer cw for logic)
import java.io.*;
import java.util.*;

public class Solution {

    public static int palindrome(String s, int l, int r) {
    
    while (l >= 0 && r < s.length()
            && s.charAt(l) == s.charAt(r)) {
        
        l--; r++;
    }
    
    return ( r - l - 1);
}
    public static int longestpalindrome(String s)
    {
       
        int ans=0;
       for (int i = 0; i < s.length(); i++) {
        
        int s1 = palindrome(s, i, i);
        
        int s2 = palindrome(s, i, i + 1);
        
        ans = ans > s1 ? ans : s1;
        ans = ans > s2 ? ans : s2;
        
    }
    return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int n = sc.nextInt();
            sc.nextLine();
            String s = sc.nextLine();
            System.out.println(longestpalindrome(s));
        }
    }
}
--------------------------------------------------------------------------
si enclosing substring

str:
An: s y a d z m p y b a d z p a d t x y d
Bm: data 
here ans is 8-14 index len=7 or 10-16 index length = 7 

Approach 1 : Brute force (N^2 * (N+N*M),N)
 generate substrings n2 +copy N + match them N*M  and n space for copy
 
Approach 2 : Count arrays / Map (M + N^2(N+26),26+26)
 count array of B-M +substrings N^2+iterate and make count array N+for comparing 26

Approach 3:to optimise this 

Approach 4 :

Approach 5 :

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        
        for(int p=0;p<t;p++)
        {
            
            String b=sc.next();
            String a=sc.next();
            int l1=a.length();
            int l2=b.length();
            int ca[]=new int[256];
            int cb[]=new int[256];
            Arrays.fill(ca,0);
            Arrays.fill(cb,0);
            if(l2>l1)
            {
                System.out.println("-1");
                
            }
            for(int s=0;s<l2;s++)
            {
                cb[b.charAt(s)]++;
            }
            int p1=0,ct=0;
            int ans=Integer.MAX_VALUE;
            int flag=-1;
            for(int i=0;i<l1;i++)
            {
                ca[a.charAt(i)]++;
                if(ca[a.charAt(i)]<=cb[a.charAt(i)])
                    ct+=1;
                if(ct==l2)
                {
                    
                    while(cb[a.charAt(p1)]==0||(ca[a.charAt(p1)]>cb[a.charAt(p1)]))
                    {
                        if(ca[a.charAt(p1)]>cb[a.charAt(p1)])
                            ca[a.charAt(p1)]-=1;
                        p1+=1;
                    }
                    int temp=i-p1+1;
                    if(temp<ans)
                    {
                        ans=temp;
                        flag=p1;
                    }
                }
            }
            if(flag==-1)
                System.out.println("-1");
            else
            {
               
                System.out.println(ans);
            }
        }
      
    }
}
--------------------------------------------------------------------------
sum of subarrays
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int n=Integer.parseInt(br.readLine());
        String str[]=br.readLine().trim().split(" ");
        int a[]=new int[n];
        for(int i=0;i<n;i++)
            a[i]=Integer.parseInt(str[i]);
        long x[]=new long[n];
        x[0]=a[0];
        for(int i=1;i<n;i++)
            x[i]=x[i-1]+a[i];
        int T=Integer.parseInt(br.readLine());
        
        
        while(T-->0) {
            String z[]=br.readLine().trim().split(" ");
            int s=Integer.parseInt(z[0]);
            int e=Integer.parseInt(z[1]);
            long ans=0;
            if(s == 0)
            {
             ans = x[e];
            }
            else
            {
                ans=x[e]-x[s-1];
            }
            // simple way is -> long ans=x[e]-x[s]+a[s];
            bw.write(ans+"\n");
            
        }
        bw.flush();
    }
}
--------------------------------------------------------------------------
substring(A,i,j) == substring(B,k,l)  for this we use Hash(A)==Hash(B) approach refer cw
--------------------------------------------------------------------------
KMP -  topcoder ,Boyer moore refer any site 
Rabin karp String matching Algo

using HASHING concept hash(a)==hash(b) 

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static int k= 1000000007;
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int te = sc.nextInt();
        int c=0;
        sc.nextLine();
        while(te-->0)
        {
            String str []= sc.nextLine().split(" ");
            String b = str[0];
            String a=str[1];
            //System.out.println(a+" "+b);
            long ha1=0,ha2=0,hb1=0,hb2=0,p1=43,p2=59,t1=p1,t2=p2;
            ha1=(a.charAt(0)*t1)%k;
            hb1=(b.charAt(0)*t1)%k;
            t1=(t1*p1)%k;
            ha2=(a.charAt(0)*t2)%k;
            hb2=(b.charAt(0)*t2)%k;
            t2=(t2*p2)%k;
        
            for(int i=1;i<b.length();i++)
            {
                hb1 = (hb1%k +(b.charAt(i)*t1)%k)%k;
                ha1 = (ha1%k +(a.charAt(i)*t1)%k)%k;
                t1=(t1*p1)%k;
                hb2 = (hb2%k +(b.charAt(i)*t2)%k)%k;
                ha2 = (ha2%k +(a.charAt(i)*t2)%k)%k;
                t2=(t2*p2)%k;
            }
            if(ha1 == hb1 && ha2 == hb2) c++;
            long d1 = p1,d2=p2;
            //int cnt=0;
            for(int i=b.length();i<a.length();i++)
            {
                ha1 = (ha1%k+(a.charAt(i)*t1)%k - ((a.charAt(i-b.length()))*(d1))%k +k)%k;
                 ha2 = (ha2%k+(a.charAt(i)*t2)%k - ((a.charAt(i-b.length()))*(d2))% k +k)%k;
                d1=(d1*p1)%k;
                d2=(d2*p2)%k;
                t1=(t1*p1)%k;
                t2=(t2*p2)%k;
                hb1=(hb1*p1)%k;
                hb2=(hb2*p2)%k;
                if(ha1 == hb1 && ha2==hb2)
                    c++;
            }
            System.out.println(c);
            c=0;
        }
    }
}
--------------------------------------------------------------------------
ar[k]=ar[k]+x prefix sum related - refer cw
--------------------------------------------------------------------------
sorted rotated array no duplicates 
degree of rotation not mentioned find whether given element is present in array or not 
(refer geeks for geeks for explaination Interview bit solution )

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
  static int search(List<Integer> arr, int l,int h,int key)
  {
      if (l > h)
            return -1;
  
        int mid = (l + h) / 2;
        if (arr.get(mid) == key)
            return mid;
        //out of 2 parts 1 part is sorted for sure 
        if (arr.get(l) <= arr.get(mid)) {  //if 1st part is sorted 
            
            if (key >= arr.get(l) && key <= arr.get(mid)) //if key present in this part search here 
                return search(arr, l, mid - 1, key);
            
            return search(arr, mid + 1, h, key);//else search next part
        }
  
        
        if (key >= arr.get(mid) && key <= arr.get(h)) //that means 2nd part is sorted and if key present in this part search here
            return search(arr, mid + 1, h, key); 
  
        return search(arr, l, mid - 1, key); //else search 1st part
  }
    public int search(final List<Integer> arr, int key) {
        
        int l=0;
        int h=arr.size()-1;
        
        int res = search(arr,l,h,key);
        return res;   
    }
}
--------------------------------------------------------------------------
find 1st missing integer - refer cw
--------------------------------------------------------------------------
find longest sub array with equal 0,1 
import java.io.*;
import java.util.*;

public class Solution {
    
    public static int solve(int[] a, int n){
        HashMap<Integer,Integer> k=new HashMap<>();
        
        int sum=0;
        int maxans=0,ans=0;
        
        
        for(int i=0;i<n;i++){
            if(a[i]==0){
                a[i]=-1;
            }
            
        }
        int x[]=new int[n];
        x[0]=a[0];
        for(int i=1;i<n;i++)
            x[i]=x[i-1]+a[i];
        
        k.put(0,-1);
            
        for(int i=0;i<n;i++){
            if(!k.containsKey(x[i])){
                k.put(x[i],i);
            }
            else{
                ans = i-k.get(x[i]);
                if(maxans<ans) maxans = ans;
                    
            }
            
        }
        
            
        
        return maxans;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int[] a=new int[n];
            for(int i=0;i<n;i++){
                a[i]=sc.nextInt();
            }
            
            int c=solve(a,n);
            System.out.println(c);
        }
        
    }
}
--------------------------------------------------------------------------
--------------------------------------------------------------------------

----------------------------------------------------------------------------------
A XOR B = C they will give C find A and B such that A*B is max

import java.util.*;
import java.lang.*;
import java.io.*;


public class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0)
		{
			int n = sc.nextInt(); //eg : 13 -> 1101
			long d = (long)(Math.log(n)/Math.log(2)); //gives (count of bits -1) here count=4 it will give (4-1) = 3
   // as he finding max of A and B so as C=13-> 1101 MSB is 1 so max value must have 1 so out of 4 bits 1st bit is 1 fixed so assume 1000
			d=(1<<d);  // here we get 1000
   //as 1st bit is done now remaining 3 bits should be manipulated to get max of A and B so if we consider
   // some examples remaining 3 bits will be negation of C value (3 bits)
			long z=n-d; // now z = 1101-1000 = 101 (remaining 3 bits to manipulate)
			z=~z;  //111111......010
                        z+=d*2; // these 2 lines will negotiate and get ans -> z as 1010
              //her 010 is value to be consider to get max of A and B now 1010 = 10 is max of A and B 
//A=10 C=13 now to get B = A XOR C
            System.out.println(z*(z^n)); // A * B -> A * (A XOR C)
		}
	}
}


Approach2:

 import java.util.*;
class MyClass {
    public static void main(String args[]) {
      Scanner s=new Scanner(System.in);
      int t=s.nextInt();
      while(t-->0)
      {
          int n=s.nextInt();
         int k=n;
         int count=0;
         while(k!=0) // while loop for counting no of bits in C = 13 -> 1101
         {
             k>>=1;
             count++;
         }// here count = 4
         long a=0,b=0; // to store final result of a and b
         long u=1;
         for(int i=count-1;i>=0;i--) // 3 2 1 0 -> bit positions
         {
             if(((n>>i)&u)==1) // to get bit is 1 or 0 at ith position and if equals 1 then
             {
                if(((a+(u<<i))(b))>=(a(b+(u<<i)))) // if 1 is put in A and 0 in B check greater one 
                    a=a+(u<<i);
                else  // or else put 1 on b 
                    b+=u<<i;
             }
             
             else //if ith position is 0 then A ,B has 1 and 1 or 0 and 0 to be consider but we want
          //if we take 1 and 1 in A and B we get max A*B so take only 1 at ith position of A and B 
             {
                 a+=u<<i;
                 b+=u<<i;
             }
         }
         long ans=a*b;
         System.out.println(ans);
      }
    }
}
----------------------------------------------------------------------------------
