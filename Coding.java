import java.util.*;
public class Main {

    

    // BIT MANIPULATION



    // check bit 
    static void checkbit(int n,int i){
        if((n&(1<<i))==1) System.out.println("Yes");
        else System.out.println("No");
    }

    //no of check bits

    static void Noofcheckbits(int n){
        int c=0;
        while(n>0){
            if((n&1) == 1) c++;
            n=n>>1;
        }
        System.out.println(c);
    }

    //unset least set bit

    static void unsetleastsetbit(int n){
        System.out.println((n&(n-1)));
    }

    //check given no is power of 2 or not

    static void powerof2ornot(int n){
        if(n!=0 && (n&(n-1))==0) System.out.println("YES");
        else System.out.println("NO");
    }

    // check given 2 signed integers are of same sign or not

    static void samesignoroppsign(int a,int b){
        if(((a^b)>>31)==0) System.out.println("Same Sign");
        else System.out.println("Opposite Sign");
    }

    // Binary Representation of an Integer

    static void integertobinary(int n){
        if(n>1) integertobinary(n/2);
        System.out.print(n%2);
    }

    //Given 2 bit positions: x,y, return a number with those bits set.

    static void setbitsof2(int x,int y){
        System.out.println((1<<x)|(1<<y));
    }

    // Construct a number with x set bits, followed by y unset bits. 1 <= x,y <= 10.
    //  Example: x=3, y=5 -> 11100000
    //           x=2, y=1 -> 110

    static void solve(int x,int y){
        int c=(1<<(x+y))-(1<<y);
        System.out.println(c);
    }

    // Power(a,n)

    static void pow(int a,int n){
        int c=1;
        while(n>0){
            if((n&1)==1) c=c*a;
            a=a*a;
            n=n>>1;
        }
        System.out.println(c);
    }


    // You are given an array with size n, which contains elements from range 1 to n. One
    //      element is repeated and one element is missing. Find these 2 elements.

    static void compute(int ar[],int n){
        HashMap<Integer, Boolean> hm= new HashMap<>();
        for (Integer i : ar) {
            if (hm.get(i) == null) {
                hm.put(i, true);
            }
            else {
                System.out.println("Repeating = " + i);
            }
        }
        for (int i = 1; i <= n; i++) {
            if (hm.get(i) == null) {
                System.out.println("Missing = " + i);
            }
        }
    }

    //No Of Divisors

    static void noofdivisors(int n){
        int c=0;
        for(int i=1;i<=Math.sqrt(n);i++){
            if(n%i==0){
                if(n/i==i) c++;
                else c=c+2;
            }
        }
        System.out.println(c);
    }

    // Linear Search 

    static void LinearSearch(int ar[],int n,int x){
        int f=0;
        for(int i=0;i<n;i++){
            if(ar[i]==x){
                System.out.println("True");
                f=1;break;
            }
        }
        if(f==0) System.out.println("False");
    }


    //Every Element is repeated twice except one  (Bits)

    static void twicerepeated(int ar[],int n){
        int c=0;
        for(int i=0;i<n;i++) c=c^ar[i];
        System.out.println(c);
    }

    //NO of subsets with sum k (BIts)

    static void subsetsusingbits(int ar[],int n ,int k){
        int f=0;
        for(int i=0;i<(1<<n);i++){
            int s=0;
            for(int j=0;j<n;j++){
                if(((i>>j)&1)==1) s+=ar[j];
            }
            if(s==k){
                System.out.println("True");
                f=1;
                break;
            }
        }
        if(f==0) System.out.println("False");
    }

    // Each Element Repeated Twice Except one

    static void thricerepeated(int ar[],int n){
        int f=0;
        for(int i=0;i<32;i++){
            int s=0;
            for(int j=0;j<n;j++){
                if(((ar[j]>>i)&1)==1) s++;
            }
            if(s%3!=0) f+=(1<<i);
        }
        System.out.println(f);
    }



    // RECURSION


    // Sum of Numbers from 1 to n

    static int sumofnumbers(int n){
        if(n==0) return 0;
        return n+sumofnumbers(n-1); 
    }


    // Fibonocci number of nth term

    static int fibo(int n){
        if(n<=1) return n;
        return fibo(n-1)+fibo(n-2);
    }

    // Tower Of Hanoi

    static void TOH(int n,char a,char c,char b){
        if(n==0) return ;
        TOH(n-1,a,b,c);
        System.out.println("Move "+n+" from "+a+" to "+c);
        TOH(n-1,b,c,a);
    }


    // power a^n

    static int powRec(int a,int n){
        if(n==0) return 1;
        int x=powRec(a,n/2);
        if(n%2==0) return x*x;
        else return a*x*x;
    }

    // subset with sum k (REcursion)

    static boolean SubsetRec(int ar[],int n,int k,int sum,int idx){
        if(idx==n) return sum==k;
        return SubsetRec(ar,n,k,sum+ar[idx],idx+1) || SubsetRec(ar,n,k,sum,idx+1);
    }


    // Lexicographical Order of Common Brackets

    static void commombracket(char str[],int n,int idx,int open,int close){
        if(idx==n){
            for(int i=0;i<str.length;i++) System.out.print(str[i]);
            System.out.println();return;
        }
        if(open < n/2){
            str[idx]='(';
            commombracket(str,n,idx+1,open+1,close);
        }
        if(close<open){
            str[idx]=')';
            commombracket(str,n,idx+1,open,close+1);
        }
    }

    // Interleaving of 2 strings

     static void interleavings(String a,String b,String ans,ArrayList<String> al){
        if(a.length()==0 && b.length()==0){
            al.add(ans);
        }
        if(b.length()>0){
            interleavings(a,b.substring(1),ans+b.charAt(0),al);
        }
        if(a.length()>0){
            interleavings(a.substring(1),b,ans+a.charAt(0),al);
        }
        
     }

     // Magic Square

    static int magic[][]=new int[3][3];
    static int ans=100;
    static int used[]=new int[10];

     static void solve(int magics[],int index){
        if(index==9){
            if(MS(magics)==true)
            ans=Math.min(ans,cost(magics));
        }
        if(index==3&&(magics[0]+magics[1]+magics[2])!=15)
        return;
        if(index==6&&(magics[3]+magics[4]+magics[5])!=15)
        return;
        for(int i=1;i<=9;i++){
            if(used[i]==0){
                used[i]=1;
                magics[index]=i;
                solve(magics,index+1);
                used[i]=0;
            }
        }
    }
    static boolean MS(int s[]){
            if((s[0]+s[1]+s[2])==(s[3]+s[4]+s[5])&&(s[3]+s[4]+s[5])==(s[6]+s[7]+s[8])&&(s[3]+s[4]+s[5])==(s[0]+s[3]+s[6])&&(s[3]+s[4]+s[5])==(s[4]+s[1]+s[7])&&(s[3]+s[4]+s[5])==(s[2]+s[5]+s[8])&&(s[3]+s[4]+s[5])==(s[0]+s[4]+s[8])&&(s[3]+s[4]+s[5])==(s[6]+s[4]+s[2]))
            return true;
            else
            return false;
        }
    static int cost(int magics[]){
            int ans=0,f=0;
            for(int i=0;i<magic.length;i++){
                for(int j=0;j<magic.length;j++){
                    ans=ans+Math.abs(magic[i][j]-magics[f]);
                    f++;
                }
            }
            return ans;
        }


    // Partition the Given String such that each part is a valid word in the list

    static boolean Partition(HashSet<String> al , String str){
        int n=str.length();
        if(n==0) return true;
        for(int i=1;i<=n;i++){
            if(al.contains(str.substring(0,i))){
                if(Partition(al,str.substring(i,n))) return true;
            }
        }
        return false;
    } 

    // count partitions


     static int Partitions(HashSet<String> al , String str){
        int n=str.length();
        if(n==0) return 1;
        int ans=0;
        for(int i=1;i<=n;i++){
            if(al.contains(str.substring(0,i))){
                ans=ans+(Partitions(al,str.substring(i,n)));
            }
        }
        return ans;
    } 




    // SORTING

    //Bubble sort

    static void bubblesort(int ar[],int n){
        int f;
        for(int i=0;i<n-1;i++){
            f=0;
            for(int j=0;j<n-i-1;j++){
                if(ar[j]>ar[j+1]){
                    int t=ar[j];
                    ar[j]=ar[j+1];
                    ar[j+1]=t;
                    f=1;
                }
            }
            if(f==0) break;
        }
    }


    // Selection Sort

    static void Selectionsort(int ar[],int n){
        for(int i=0;i<n-1;i++){
            int minidx=i;
            for(int j=i+1;j<n;j++){
                if(ar[j]<ar[minidx]){
                    minidx=j;
                }
            }
            int t=ar[minidx];
            ar[minidx]=ar[i];
            ar[i]=t;
        }
    }

    //Insertion Sort

    static void InsertionSort(int ar[],int n){
        for(int i=1;i<n;i++){
            int c=ar[i];
            int j=i-1;
            while(j>=0 && ar[j]>c){
                ar[j+1]=ar[j];
                j--;
            }
            ar[j+1]=c;
        }
    }


    //Merge Sort 

    static void Merge(int ar[],int l,int m,int h){
        int p1=l,p2=m+1;
        int t[]=new int[h-l+1];
        int idx=0;
        while(p1<=m && p2 <=h){
            if(ar[p1]<ar[p2]) t[idx++]=ar[p1++];
            else t[idx++]=ar[p2++];
        }
        while(p1<=m) t[idx++]=ar[p1++];
        while(p2<=h) t[idx++]=ar[p2++];
        for(int i=l;i<=h;i++) ar[i]=t[i-l];
    }

    static void MergeSort(int ar[],int n,int l,int h){
        if(l==h) return;
        int m=(l+h)/2;
        MergeSort(ar,n,l,m);
        MergeSort(ar,n,m+1,h);
        Merge(ar,l,m,h);
    }


    // Quick Sort


    static int QuickPartition(int ar[],int n,int l,int h){
        int pivot=ar[h];
        int j=(l-1);
        for(int i=l;i<=h;i++){
            if(ar[i]<pivot){
                j++;
                int t=ar[j];
                ar[j]=ar[i];
                ar[i]=t;
            }
        }
        int k=ar[j+1];
        ar[j+1]=ar[h];
        ar[h]=k;
        return (j+1);

    }

    static void Quicksort(int ar[],int n,int l,int h){
        if(l<h){
            int pi=QuickPartition(ar,n,l,h);
            Quicksort(ar,n,l,pi-1);
            Quicksort(ar,n,pi+1,h);
        }
    }


    // Given 2 Soarted Array  sort them 

    static void SortedArray2(int ar[],int n,int br[],int m){
        int p1=0,p2=0;
        while(p1<n && p2<m){
            if(ar[p1]<br[p2]) System.out.print(ar[p1++]+" ");
            else System.out.print(br[p2++]+" ");
        }
        while(p1<n) System.out.print(ar[p1++]+" ");
        while(p2<m) System.out.print(br[p2++]+" ");

    } 


    // Sort 0s and 1s

    static void sort0s1s(int ar[],int n){
        int p1=0,p2=n-1;
        while(p1<p2){
            while(ar[p1]==0) p1++;
            while(ar[p2]==1) p2--;
            if(p1<p2){
                ar[p1]=0;
                ar[p2]=1;
                p1++;p2--;
            }
        }
        for(int i=0;i<n;i++) System.out.print(ar[i]+" ");
    }
    
    // sum of pairs using Binary Search


    static boolean sumofpairs(int ar[],int n,int x){
        int l=0,h=n-1;
        while(l<=h){
            int m=(l+h)/2;
            if(ar[m]==x) return true;
            if(ar[m]>x) h=m-1;
            else l=m+1;
        }
        return false;
    } 


    // Difference of Pairs

    static boolean diffofpairs(int ar[],int n,int x){
        int l=0,h=n-1;
        while(l<=h){
            int m=(l+h)/2;
            if(ar[m]==x) return true;
            if(ar[m]>x) h=m-1;
            else l=m+1;
        }
        return false;
    } 


    // max of element < query

    static int maxofarraylessthanquery(int ar[],int x,int l,int h){
        int ans=Integer.MIN_VALUE;
        while(l<=h){
            int m=(l+h)/2;
            if(ar[m]==x) ans=ar[m];
            if(ar[m]>x) h=m-1;
            else{
                ans=ar[m];
                l=m+1;
            }
        }
        return ans;

    }


    // frequency of an query using BS

    static int BS1(int ar[],int x,int l,int h){
        int ans=-1;
        while(l<=h){
            int m=(l+h)/2;
            if(ar[m]>x) h=m-1;
            else if(ar[m]<x) l=m+1;
            else{
                ans=m;
                h=m-1;
            }
        }
        return ans;
    }

    static int BS2(int ar[],int x,int l,int h){
        int ans=-2;
        while(l<=h){
            int m=(l+h)/2;
            if(ar[m]>x) h=m-1;
            else if(ar[m]<x) l=m+1;
            else{
                ans=m;
                l=m+1;
            }
        }
        return ans;
    }


    // square root of a number

    static int squareroot(int n){
        int l=1,h=n;
        int ans=-1;
        while(l<=h){
            int m=(l+h)/2;
            if(m*m > n) h=m-1;
            else if(m*m < n){
                l=m+1;ans=m;
            }
            else{ans=m;break;}
        }
        return ans;
    }


    // every Element Repeated Twice Except one Using Binary Search

    static void bsrepeatedtwice(int ar[],int l,int h){
        if(l>h) return;
        if(l==h) System.out.println(ar[l]);
        int m=(l+h)/2;
        if(m%2==0){
            if(ar[m]==ar[m+1]) bsrepeatedtwice(ar,m+2,h);
            else bsrepeatedtwice(ar,l,m-2);
        }
        else{
            if(ar[m]==ar[m-1]) bsrepeatedtwice(ar,m+1,h);
            else bsrepeatedtwice(ar,l,m-1);
        }
    }

    // Cabinet Partition

    static boolean isValid(int ar[],int n,int t,int m){
        int s=1;
        int c=0;
        for(int i=0;i<n;i++){
            if(c+ar[i]>m){
                c=ar[i];
                s++;
                if(s>t) return false; 
            }
            else c+=ar[i];
        }
        return true;
    }

    static int cabinetpartition(int t,int[] ar,int n){
        int c=0;
        int l=0,h=0;
        for(int i=0;i<n;i++){
            c+=ar[i];
            l=Math.max(l,ar[i]);
        }
        h=c;
        int ans=0;
        while(l<=h){
            int m=(l+h)/2;
            if(isValid(ar,n,t,m)){
                ans=m;h=m-1;
            }
            else l=m+1;
        }
        return ans;   
    }


    // Given n houses Place k Families in the n Houses as far asa possible

    static boolean isValids(int m,int ar[],int n,int k){
        int pos=ar[0];
        int s=1;
        for(int i=1;i<n;i++){
            if(ar[i]-pos >=m){
                pos=ar[i];
                s++;
                if(s==k) return true;
            }
        }
        return false;
    }
    
    
    static int nhouses(int ar[],int n,int k){
        int c=-1;
        int l=ar[0];
        int h=ar[n-1]-ar[0];
        while(l<=h){
            int m=(l+h)/2;
            if(isValids(m,ar,n,k)){
                c=Math.max(c,m);
                l=m+1;
            }
            else h=m-1;
        }
        return c;
    }

    // Implementation Of Hash Map

    //              file:///F:/BTECH/A%20Interview%20Preparation/HashMap.java


    // Best Hashing for String 
    //             n-1
    // hash(str)=sigma str(i) * p^(i+1)   where p is prime
    //            i=0


    // Finding Frequeny using HashMap


    static void findfrequency(int ar[],int n){
        LinkedHashMap<Integer,Integer> hm=new LinkedHashMap<>();
        for(int i=0;i<n;i++){
            if(hm.containsKey(ar[i])) hm.put(ar[i],hm.get(ar[i])+1);
            else hm.put(ar[i],1);
        }
        for(Map.Entry<Integer,Integer> e:hm.entrySet()){
            System.out.println("Frequency of "+e.getKey()+" ----> "+e.getValue());
        }
    }


    // Maximum Subarray Sum Using Kadane Algorithm

    static void maxsubarraysum(int ar[],int n){
        int c=0;
        int s=0;
        for(int i=0;i<n;i++){
            c+=ar[i];
            if(c<0) c=0;
            if(c>s) s=c;
        }
        System.out.println(s);
    }


    // count no of non - decresing Subsequences

    static void countnondecresingsunsequences(int ar[],int n){
        int c[]=new int[10];
        for(int i=0;i<n;i++){
            for(int j=ar[i]-1;j>=0;j--) c[ar[i]]+=c[j];
            c[ar[i]]++;
        }
        int ans=0;
        for(int i=0;i<10;i++) ans+=c[i];
        System.out.println(ans);
    }


    // Length of Longest Subarray with COntinuous order

    static void lengthoflongestsubarraywithcontiorder(int ar[],int n){
        int lmax=1;
        for(int i=0;i<n;i++){
            int mn=ar[i],mx=ar[i];
            for(int j=i+1;j<n;j++){
                mn=Math.min(mn,ar[j]);
                mx=Math.max(mx,ar[j]);
                if((mx-mn)==(j-i)) lmax=Math.max(lmax,mx-mn+1);
            }
        }
        System.out.println(lmax);
    }



    // Distinct Element in an Window

    static void distinctelementinwindow(int ar[],int n,int t){
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<t;i++){
            if(hm.containsKey(ar[i])) hm.replace(ar[i],hm.get(ar[i])+1);
            else hm.put(ar[i],1);
        }
        System.out.print(hm.size()+" ");
        for(int i=t;i<n;i++){
             if(hm.containsKey(ar[i])) hm.replace(ar[i],hm.get(ar[i])+1);
             else hm.put(ar[i],1);
             hm.replace(ar[i-t],hm.get(ar[i-t])-1);
             if(hm.get(ar[i-t])==0) hm.remove(ar[i-t]);
             System.out.print(hm.size()+" ");
        }
    }


    // STRINGS


    // frequency of characters

    static void charfreq(String str){
        int c[]=new int[26];
        for(int i=0;i<26;i++) c[i]=0;
        for(int i=0;i<str.length();i++){
            int n=str.charAt(i)-'a';
            c[n]++;
        }
        for(int i=0;i<26;i++) System.out.print(c[i]+" ");
    }


    // First Repeated Character

    static void firstrepeatedcharacter(String str){
        HashMap<Character,Integer> hm=new HashMap<>();
        for(int i=0;i<str.length();i++){
            if(hm.containsKey(str.charAt(i))){
                System.out.println(str.charAt(i));
                break;
            }
            else hm.put(str.charAt(i),1);
        }
    }


    // Longest Palindrome Substring

    static void longestpalindromesubstring(String str){
        int c=1;
        int s=0;
        int n=str.length();
        int l,h;
        for(int i=1;i<n;i++){
            l=i-1;
            h=i;
            while(l>=0 && h<n && str.charAt(l)==str.charAt(h)){
                if(h-l+1>c){
                    s=l;c=h-l+1;
                }
                l--;h++;
            }
            l=i-1;
            h=i+1;
            while(l>=0 && h<n && str.charAt(l)==str.charAt(h)){
                if(h-l+1>c){
                    s=l;c=h-l+1;
                }
                l--;h++;
            }
        }
        // System.out.println(str.substring(s,s+c));
        System.out.println(c);
    }


    // subsequence 

    static void subsequence(String s1,String s2){
        int n=s1.length();
        int m=s2.length();
        int j=0;
        for(int i=0;i<m && j<n;i++){
            if(s1.charAt(j)==s2.charAt(i)) j++;
        }
        if(j==n) System.out.println("True");
        else System.out.println("False");
    }

    // string 1 is Substring of String 2

    static boolean isSubstring(String s1, String s2)
    {
        int m = s1.length();
        int n = s2.length();
        for (int i=0;i<=n-m;i++) {
            int j;
            for (j=0;j<m;j++)
                if (s2.charAt(i+j)!= s1.charAt(j)) break;
            if (j==m) return true;
        }
        return false;
    }

    // for Efficient Solution Use KMP  (GFG)


    // Sum Of Sub Arrays 

    static void sumofsubarray(int ar[],int n,int a,int b){
        int c[]=new int[n];
        c[0]=ar[0];
        for(int i=1;i<n;i++){
            c[i]=c[i-1]+ar[i]; // Prefix sum
        }
        System.out.println(c[b]-c[a]+ar[a]);
    }


    // Rabin Karp Algorithm 

    // https://www.hackerrank.com/contests/smart-interviews/challenges/si-rabin-karp-string-matching-algorithm

    // Rotated Soarted Array

    static int rotatedsoartedarray(int ar[],int l,int h,int k){
        if(l>h) return -1;
        int m=(l+h)/2;
        if(ar[m]==k) return m;
        if(ar[l]<=ar[m]){
            if(k>=ar[l] && k<=ar[m]) return rotatedsoartedarray(ar,l,m-1,k);
            else return rotatedsoartedarray(ar,m+1,h,k);
        }
        else{
            if(k>=ar[m] && k<=ar[h]) return rotatedsoartedarray(ar,m+1,h,k);
            else return rotatedsoartedarray(ar,l,m-1,k);
        }
    }


    // First Missing Positive Integer

    static int firstmissingpsveinteger(int ar[],int n){
        for(int i=0;i<n;i++){
            if(ar[i]<=0 || ar[i]>n) ar[i]=n+1;
        }
        for(int i=0;i<n;i++){
            int c=Math.abs(ar[i]);
            if(c!=n+1 && ar[c-1]>0) ar[c-1]=-ar[c-1];
        }
        for(int i=0;i<n;i++){
            if(ar[i]>0) return i+1;
        }
        return -1;
    }


    // Longest Subarray with Equal No of 0s and 1s

    static int longestsubarraywithequalsnoof0sand1s(int ar[],int n){
        HashMap<Integer,Integer> hm = new HashMap<>();
        int sum=0;
        int c=0;
        int end=-1;
        for(int i=0;i<n;i++) if(ar[i]==0) ar[i]=-1;
        for(int i=0;i<n;i++){
            sum+=ar[i];
            if(sum==0){
                c=i+1;
                end=i;
            }
            if(hm.containsKey(sum)){
                if(c<i-hm.get(sum)){
                    c=i-hm.get(sum);
                    end=i;
                }
            }
            else hm.put(sum,i);
        } 
        return c;
    }


    // Convert Upper Case to Lower Case && lower Case to Upper

    static String Opposite(char[] a){
        for(int i=0;i<a.length;i++){
            a[i]^=32;
        }
        return String.valueOf(a);
    }


    // ANAGRAMS

    static boolean anagrams(String s1,String s2){
        if(s1.length()!=s2.length()) return false;
        int c[]=new int[26];
        for(int i=0;i<26;i++) c[i]=0;
        for(int i=0;i<s1.length();i++){
            int idx=s1.charAt(i)-'a';
            int idx1=s2.charAt(i)-'a';
            c[idx]++;
            c[idx1]--;
        }
        for(int i=0;i<26;i++){
            if(c[i]!=0) return false;
        }
        return true;
    }

    // Given 3 Arrays Choose # elemenets From # arrays ANd Find Max , Min , And Then Subtract

     static void findClosest(int A[], int B[], int C[], int p, int q, int r)
    {
        int diff = Integer.MAX_VALUE; 
        int a =0, b = 0, c = 0;
        int i = 0, j = 0, k = 0;
        while (i < p && j < q && k < r)
        {
            int mn = Math.min(A[i],Math.min(B[j], C[k]));
            int mx = Math.max(A[i],Math.max(B[j], C[k]));
            if (mx-mn < diff)
            {
                a = i; b = j;c = k;
                diff = mx - mn;
            }
            if (diff == 0) break;
            if (A[i] == mn) i++;
            else if (B[j] == mn) j++;
            else k++;
        }
     
        // System.out.println(A[a] + " " + B[b] + " " + C[c]);
        System.out.println(diff);
    }


    // Frequency Using indexes  +100  /100

    static void frequencyusingindex(int ar[],int n){
        for(int i=0;i<n;i++) ar[i]=ar[i]-1;
        for(int i=0;i<n;i++){
            ar[ar[i]%n]+=n;
        }
        for(int i=0;i<n;i++){
            System.out.println(i+1+" --- > "+ar[i]/n);
        }
    }

    // Given Soarted Rotated array
    // Find The Highest Element(PIVOT) index 

    static void rotatedpivot(int ar[],int n){
        int l=0,h=n-1;
        while(l<=h){
            int m=(l+h)/2;
            if(m>l && ar[m]<ar[m-1]){ System.out.println(ar[m-1]+" Index "+(m-1));break;}
            if(m<h && ar[m]>ar[m+1]){ System.out.println(ar[m]+" Index "+m);break;}
            if(ar[l]>=ar[m]) h=m-1;
            else l=m+1;
        }
        if(l>h) System.out.println("No Pivot");
    }


    // Given Row-wise And Colunm-wise Soarted Matrix Search Element

    static void matrix(int ar[][],int n,int m,int k){
        int i=0;
        int j=m-1;int f=0;
        while(i<n && j>=0){
            if(ar[i][j]==k){
                System.out.println("Elelemt Found At : ["+i+","+j+"]");
                f=1;break;
            }
            if(ar[i][j]>k) j--;
            else i++;
        }
        if(f==0) System.out.println("Element Not Found");
    }


    // Given Matrix with 0s and 1s Find the Row Which Max No of 1s

    static void maxcount1srow(int ar[][],int n,int m){
        int j=m-1;
        int row=0;
        for(int i=0;i<n;i++){
            while(j>=0 && ar[i][j]==1){
                j--;row=i;
            }
        }
        System.out.println("row : "+(row+1));
        System.out.println("max No of 1s : "+(m-j-1));
    }

    // Rain Water Trapping

    static void rainwatertrapping(int ar[],int n){
        int ml[]=new int[n];
        int mr[]=new int[n];
        ml[0]=ar[0];
        for(int i=1;i<n;i++) ml[i]=Math.max(ml[i-1],ar[i]);
        mr[n-1]=ar[n-1];
        for(int i=n-2;i>=0;i--) mr[i]=Math.max(mr[i+1],ar[i]);
        int ans=0;
        for(int i=0;i<n;i++) ans+=(Math.min(ml[i],mr[i])-ar[i]);
        System.out.println(ans);
    }


    // Prime Seive

    static void PrimeSeive(int a[],int n){
        a[0]=a[1]=0;
        a[2]=1;
        for(int i=3;i<=n;i+=2) a[i]=1;
        for(int i=3;i<=n;i+=2){
            if(a[i]==1){
                for(int j=i*i;j<=n;j+=2*i) a[j]=0;
            }
        }
        for(int i=0;i<=n;i++){
            if(a[i]==1) System.out.print(i+" ");
        }
    }


    // GAME THEORY


    // Santa and Banta are playing a game of coins. They have a pile containing N coins.
    //  Players take alternate turns, removing some coins from the pile. 
    //  On each turn, a player can remove either one coin or coins equal to some prime power
    //   (i.e. px coins, where p - prime number and x - positive integer).
    //    Game ends when the pile becomes empty.
    //  The player who can not make a move in his turn loses.

    static void gametheory(int n){
        if(n%6==0) System.out.println("Banta");
        else System.out.println("Santa");
    }


   // STACKS

    //stack implementation using array

    static class Stack{
        static final int m=1000;
        int ar[]=new int[m];
        int top;
        Stack(){
            this.top=-1;
        }
        void push(int k){
            if(top>=(m-1)){
                System.out.println("Full");
            }
            else{
                this.top++;
                ar[top]=k;
            }
        } 
        void pop(){
            if(top<0){
                System.out.println("Empty");
            }
            else{
                int x=ar[top];
                this.top--;
                System.out.println(x);
            }
            
        }
    } 

    // stack using SLL

    static class StackUsingLinkedlist {
        private class Node {
            int data; 
            Node next; 
        }
        Node top;
        StackUsingLinkedlist()
        {
            this.top = null;
        }
        public void push(int x)
        {
            Node temp = new Node();
            if (temp == null) {
                System.out.print("\nHeap Overflow");
                return;
            }
            temp.data = x;
            temp.next = top;
            top = temp;
        }
        public boolean isEmpty()
        {
            return top == null;
        }
        public int peek()
        {
            if (!isEmpty()) {
                return top.data;
            }
            else {
                System.out.println("Stack is empty");
                return -1;
            }
        }
        public void pop()
        {
            if (top == null) {
                System.out.print("\nStack Underflow");
                return;
            }
            top = top.next;
        }
    
        public void display()
        {
            if (top == null) {
                System.out.printf("\nStack Underflow");
                System.exit(0);
            }
            else {
                Node temp = top;
                while (temp != null) {
                    System.out.printf("%d->", temp.data);
                    temp = temp.next;
                }
            }
        }
    }




    



    





    public static void main(String args[]) {
        Scanner s=new Scanner(System.in);
        
        int n=s.nextInt();
        // int x=s.nextInt();
        
        // checkbit(n,x);

        // Noofcheckbits(n);

        // unsetleastsetbit(n);

        // powerof2ornot(n);

        // samesignoroppsign(n,x);

        // integertobinary(n);

        // setbitsof2(n,x);

        // solve(n,x);

        // pow(n,x);

        // int ar[]=new int[n];
        // for(int i=0;i<n;i++) ar[i]=s.nextInt();

        // compute(ar,n);

        // noofdivisors(n);

        // LinearSearch(ar,n,x);

        // twicerepeated(ar,n);

        // subsetsusingbits(ar,n,x);

        // thricerepeated(ar,n);

        // System.out.println(sumofnumbers(n));

        // System.out.println(fibo(n));

        // TOH(n,'A','C','B');

        // System.out.println(powRec(n,x));

        // if(SubsetRec(ar,n,x,0,0)) System.out.println("True");
        // else System.out.println("False");

        // char str[]=new char[2*n];
        // commombracket(str,n,0,0,0);

        // String st=s.next();
        // String str=s.next();
        // ArrayList<String> al=new ArrayList<>();
        // interleavings(st,str,"",al);
        // // Collections.sort(al);
        // for(int j=0;j<al.size();j++) System.out.println(al.get(j));


        // int st[]=new int[9];
        // for(int i=0;i<3;i++){
        //     for(int j=0;j<3;j++){
        //         magic[i][j]=s.nextInt();
        //     }
        // }
        // solve(st,0);
        // System.out.println(ans);


        // ArrayList<String> al={"smart","int","view","s","inter","views","art","mart","sm"};
        // HashSet<String> al=new HashSet<>();
        // al.add("smart");al.add("int");al.add("view");al.add("s");al.add("inter");
        // al.add("views");al.add("art");al.add("mart");al.add("sm");
        // String str=s.next();
        // // if(Partition(al,str)) System.out.println("true");
        // // else System.out.println("False");

        // System.out.println(Partitions(al,str));


        // bubblesort(ar,n);

        // Selectionsort(ar,n);

        // InsertionSort(ar,n);
        
        //  MergeSort(ar,n,0,n-1);

        //  Quicksort(ar,n,0,n-1); 

        //  for(int i=0;i<n;i++) System.out.print(ar[i]+" ");

        // int br[]=new int[x];
        // for(int i=0;i<x;i++) br[i]=s.nextInt();

        // SortedArray2(ar,n,br,x);

        //  sort0s1s(ar,n);

        // int f=0;
        // for(int i=0;i<n;i++){
        //     int b=x-ar[i];
        //     if(sumofpairs(ar,n,b)){
        //         System.out.println("True");
        //         f=1;
        //         break;
        //     }
        // }
        // if(f==0) System.out.println("False");



        // int f=0;
        // for(int i=0;i<n;i++){
        //     int b=x+ar[i];
        //     if(diffofpairs(ar,n,b)){
        //         System.out.println("True");
        //         f=1;
        //         break;
        //     }
        // }
        // if(f==0) System.out.println("False");


        // System.out.println(maxofarraylessthanquery(ar,x,0,n-1));

        // int p1=BS1(ar,x,0,n-1);
        // int p2=BS2(ar,x,0,n-1);
        // int ans=p2-p1+1;
        // System.out.println(ans);

        // System.out.println(squareroot(n));

        // bsrepeatedtwice(ar,0,n-1);

        // int t=s.nextInt();
        // System.out.println(cabinetpartition(t,ar,n));

        // System.out.println(nhouses(ar,n,t));

        // findfrequency(ar,n);

        // maxsubarraysum(ar,n);

        // countnondecresingsunsequences(ar,n);

        // lengthoflongestsubarraywithcontiorder(ar,n);

        // distinctelementinwindow(ar,n,t);

        // String str=s.next();
        // String str1=s.next();

        // charfreq(str);

        // firstrepeatedcharacter(str);

        // longestpalindromesubstring(str);

        // subsequence(str,str1);

        // if(isSubstring(str,str1)) System.out.println("True");
        // else System.out.println("No");

        // int a=s.nextInt();
        // int b=s.nextInt();

        // sumofsubarray(ar,n,a,b);

        // System.out.println(rotatedsoartedarray(ar,0,n-1,x));

        // System.out.println(firstmissingpsveinteger(ar,n));

        // System.out.println(longestsubarraywithequalsnoof0sand1s(ar,n));

        // String str=s.next();
        // str=Opposite(str.toCharArray());
        // System.out.println(str);

        // if(anagrams(str,str1)) System.out.println("Anagrams");
        // else System.out.println("Not Anagrams");

        // int A[] = {2,-8,15,10,28};
        // int B[] = {6,12,-3,20,-10};
        // int C[] = {18,7,-1,4,14};
     
        // int p = A.length;
        // int q = B.length;
        // int r = C.length;
     
        // findClosest(A, B, C, p, q, r);

        // frequencyusingindex(ar,n);

        // rotatedpivot(ar,n);

        // int n=s.nextInt();
        // int m=s.nextInt();
        // int ar[][]=new int[n][m];
        // for(int i=0;i<n;i++)
        // for(int j=0;j<m;j++)
        // ar[i][j]=s.nextInt();
        // int k=s.nextInt();


        // matrix(ar,n,m,k);


        // maxcount1srow(ar,n,m);

        // rainwatertrapping(ar,n);
        // int t=s.nextInt();
        // while(t-->0){
        //     int a=s.nextInt();
        //     int b=s.nextInt();
        //     Queries(ar,n,a,b);
        // }

        // int ar[]=new int[n+1];
        // for(int i=0;i<n;i++) ar[i]=0;
        // PrimeSeive(ar,n);

        // gametheory(n);

        // Stack st=new Stack();
        // st.push(1);
        // st.push(4);
        // st.push(2);
        // st.push(3);
        // st.pop();
        // st.pop();
        // st.pop();
        // st.pop();
        // st.pop();

        StackUsingLinkedlist obj = new StackUsingLinkedlist();
        obj.push(11);
        obj.push(22);
        obj.push(33);
        obj.push(44);
        obj.display();
        System.out.printf("\nTop element is %d\n", obj.peek());
        obj.pop();
        obj.pop();
        obj.display();
        System.out.printf("\nTop element is %d\n", obj.peek());

    }
}