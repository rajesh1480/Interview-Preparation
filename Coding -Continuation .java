import java.util.*;
public class Main {

    // STACK-- Continuation

    // stock span

    static void stockspan(int ar[],int n){
        int B[]=new int[n];
            
            B[0]=1;
            for(int i=1;i<n;i++){
                int c=1;
                int j=i-1;
                while(j>=0 && ar[i]>=ar[j]){
                    c++;j--;
                }
                 B[i]=c;
               
            }
            for(int i=0;i<n;i++){
                System.out.print(B[i]+" ");
            }
    }


    // Balance Brackets

    static boolean areBracketsBalanced(String expr)
    {
        Deque<Character> stack = new ArrayDeque<Character>();
        for (int i = 0; i < expr.length(); i++)
        {
            char x = expr.charAt(i);
            if (x == '(' || x == '[' || x == '{')
            {
                stack.push(x);
                continue;
            }
            if (stack.isEmpty())
                return false;
            char check;
            switch (x) {
            case ')':
                check = stack.pop();
                if (check == '{' || check == '[')
                    return false;
                break;
 
            case '}':
                check = stack.pop();
                if (check == '(' || check == '[')
                    return false;
                break;
 
            case ']':
                check = stack.pop();
                if (check == '(' || check == '{')
                    return false;
                break;
            }
        }
        return (stack.isEmpty());
    }

    // Find the first slower element on right side for every element ar[i] in a given array.

    static void firstsmaller(int ar[],int n){
        Stack<Integer> st=new Stack<>();
        int br[]=new int[n];
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && ar[i]<=st.peek()) st.pop();
            if(st.isEmpty()) br[i]=-1;
            else br[i]=st.peek();
            st.push(ar[i]);
        }
        for(int i=0;i<n;i++) System.out.println(ar[i]+" ---> "+br[i]);
    }

    // Implement two stacks in an array.



                        //     class TwoStacks {
                        //     int size;
                        //     int top1, top2;
                        //     int arr[];
                        
                        //     // Constructor
                        //     TwoStacks(int n)
                        //     {
                        //         arr = new int[n];
                        //         size = n;
                        //         top1 = -1;
                        //         top2 = size;
                        //     }
                        
                        //     // Method to push an element x to stack1
                        //     void push1(int x)
                        //     {
                        //         // There is at least one empty space for
                        //         // new element
                        //         if (top1 < top2 - 1) {
                        //             top1++;
                        //             arr[top1] = x;
                        //         }
                        //         else {
                        //             System.out.println("Stack Overflow");
                        //             System.exit(1);
                        //         }
                        //     }
                        
                        //     // Method to push an element x to stack2
                        //     void push2(int x)
                        //     {
                        //         // There is at least one empty space for
                        //         // new element
                        //         if (top1 < top2 - 1) {
                        //             top2--;
                        //             arr[top2] = x;
                        //         }
                        //         else {
                        //             System.out.println("Stack Overflow");
                        //             System.exit(1);
                        //         }
                        //     }
                        
                        //     // Method to pop an element from first stack
                        //     int pop1()
                        //     {
                        //         if (top1 >= 0) {
                        //             int x = arr[top1];
                        //             top1--;
                        //             return x;
                        //         }
                        //         else {
                        //             System.out.println("Stack Underflow");
                        //             System.exit(1);
                        //         }
                        //         return 0;
                        //     }
                        
                        //     // Method to pop an element from second stack
                        //     int pop2()
                        //     {
                        //         if (top2 < size) {
                        //             int x = arr[top2];
                        //             top2++;
                        //             return x;
                        //         }
                        //         else {
                        //             System.out.println("Stack Underflow");
                        //             System.exit(1);
                        //         }
                        //         return 0;
                        //     }
                        
                        //     // Driver program to test twoStack class
                        //     public static void main(String args[])
                        //     {
                        //         TwoStacks ts = new TwoStacks(5);
                        //         ts.push1(5);
                        //         ts.push2(10);
                        //         ts.push2(15);
                        //         ts.push1(11);
                        //         ts.push2(7);
                        //         System.out.println("Popped element from"
                        //                            + " stack1 is " + ts.pop1());
                        //         ts.push2(40);
                        //         System.out.println("Popped element from"
                        //                            + " stack2 is " + ts.pop2());
                        //     }
                        // }

        
    // EValuate Postfix Notation

    static void postfix(String str){
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(Character.isDigit(ch)) st.push(ch-'0');
            else{
                int a=st.pop();
                int b=st.pop();
                switch(ch){
                    case '+': st.push(b+a);break;
                    case '-': st.push(b-a);break;
                    case '/': st.push(b/a);break;
                    case '*': st.push(b*a);break;
                }
            }
        }
        System.out.println(st.pop());
    }


    // Max Rectangle Area Under Histogram

    static void maxrectanglehisto(int ar[],int n){
        Stack<Integer> st=new Stack<>();
        int c=0;
        int top,area;
        int f=0;
        while(f<n){
            if(st.empty()||ar[st.peek()]<=ar[f]){
                st.push(f++);
            }
            else{
                top=st.peek();
                st.pop();
                area=ar[top]*(st.empty()?f:f-st.peek()-1);
                if(c<area){
                    c=area;
                }
            }
        }
        while(st.empty()==false){
            top=st.peek();
            st.pop();
            area=ar[top]*(st.empty()?f:f-st.peek()-1);
            if(c<area){
                c=area;
            }
        }
        System.out.println(c);
    }


    // QUEUES


    // Array Implementation of Queue

                            // class Queue{
                            //     static final int m=10000;
                            //     int ar[]=new int[m];
                            //     int front,rear;
                            //     Queue(){
                            //         front=rear=-1;
                            //     }
                            //     void enqueue(int x){
                            //         if(front==-1){
                            //             front=0;
                            //         }
                            //         ar[++rear]=x;
                            //     }
                            //     void dequeue(){
                            //         if(front==-1|| front > rear) System.out.println("Empty");
                            //         else System.out.println(ar[front++]);
                            //     }
                            // }
    

    // Queue USing Linked List

                            //class Node {
                            //     int data;
                            //     Node next;
                            //     public Node(int data)
                            //     {
                            //         this.data = data;
                            //         this.next = null;
                            //     }
                            // }
                            // class Queue {
                            //     Node front, rear;
                            //     public Queue()
                            //     {
                            //         this.front = this.rear = null;
                            //     }
                            //     void enqueue(int key)
                            //     {
                            //         Node temp = new Node(key);
                            //         if (rear == null) {
                            //             front = rear = temp;
                            //         }
                            //         rear.next = temp;
                            //         rear = temp;
                            //     }
                            //     void dequeue()
                            //     {
                            //         if (front == null)
                            //             return;
                            //         Node temp = front;
                            //         front = this.front.next;
                            //         if (front == null)
                            //             rear = null;
                            //     }
                            // }



    // Queue Using Stacks

                                // static class Queue
                                // {
                                //     static Stack<Integer> s1 = new Stack<Integer>();
                                //     static Stack<Integer> s2 = new Stack<Integer>();
                                
                                //     static void enQueue(int x)
                                //     {
                                //         while (!s1.isEmpty())
                                //         {
                                //             s2.push(s1.pop());
                                //         }
                                //         s1.push(x);
                                //         while (!s2.isEmpty())
                                //         {
                                //             s1.push(s2.pop());
                                //         }
                                //     }
                                //     static int deQueue()
                                //     {
                                //         if (s1.isEmpty())
                                //         {
                                //             System.out.println("Q is Empty");
                                //             System.exit(0);
                                //         }
                                //         int x = s1.peek();
                                //         s1.pop();
                                //         return x;
                                //     }
                                // }


    

    // Sliding Window Maximum


    static void slidingwindowmaximum(int ar[],int n,int k){
        Deque<Integer> d=new LinkedList<Integer>();
        int i=0;
        for(i=0;i<k;i++){
            while(!d.isEmpty() && ar[i]>ar[d.peekLast()]) d.removeLast();
            d.addLast(i);
        }
        int sum=0;
        for(int j=i;j<n;j++){
            sum+=ar[d.peek()];
            while(!d.isEmpty() && d.peek()<=j-k) d.removeFirst();
            while(!d.isEmpty() && ar[j]>ar[d.peekLast()]) d.removeLast();
            d.addLast(j);
        }
        System.out.println(sum+ar[d.peek()]);
    }



    ////   LINKED LIST     //////


               // Insert  Node
                    
                        // void insert(int d){
                        //     Node t=new Node(d);
                        //     if(root!=null) t.next=root;
                        //     root=t;
                        // }







               /// Single Linked List

                        // static Node head;
                        // static class Node {
                        //     int data;
                        //     Node next;
                        //     Node(int d)
                        //     {
                        //         this.data = d;
                        //         next = null;
                        //     }
                        // }

                
                // Print List

                    // void PrintList(Node root){
                    //        while(root!=null){
                    //            System.out.print(root.data+" ");
                    //            root=root.next;
                    //        }
                    // }



                // SIZE of The List  

                    // Iterative
                         
                        //   int length(Node root){
                        //       int c=0;
                        //       while(root!=null){
                        //           root=root.next;
                        //           c++;
                        //       }
                        //       return c;
                        //   }


                    // Recursive

                        //   int RecLen(Node root){
                        //       if(root==null) return 0;
                        //       return 1+RecLen(root.next);
                        //   }


                
                // Print reverse  

                      // Iterative

                            // Node Reverse(Node root){
                            //     Node prev=null,next=null;
                            //     Node t=root;
                            //     while(t!=null){
                            //         next=t.next;
                            //         t.next=prev;
                            //         prev=t;
                            //         t=next;
                            //     }
                            //     return prev;
                            // }

                    
                    // Recursion

                        //   Node Reverse(Node root){
                        //       if(root==null) return root;
                        //       if(root.next==null) return root;
                        //       Node t=Reverse(root.next);
                        //       root.next.next=root;
                        //       root.next=null;
                        //       return t;
                        //   }


                
                // Insert in Particular Location

                    //   Node insert(Node root,int data,int pos){
                    //       if(pos<1 || pos>size(root)+1) return root;
                    //       if(pos==1) Node n=new Node(x); n.next=root; return n;
                    //       Node t=root;
                    //       for(int i=1;i<pos-1;i++){
                    //           t=t.next;
                    //       }
                    //       Node k=new Node(data);
                    //       k.next=t.next;
                    //       t.next=k;
                    //       return root;
                    //   }

                
                // Insert Element in Soarted Position

                        //  Node insert(Node root,int data){
                        //      Node n=new Node(data);
                        //      if(root==null || data<root.data){
                        //          n.next=root;
                        //          return n;
                        //      }
                        //      Node t=root;
                        //      while(t.next!=null && t.next.data<data){
                        //          t=t.next;
                        //      }
                        //      n.next=t.next;
                        //      t.next=n;
                        //      return root;
                        //  }

                // Delete At Particular Position

                    //   Node Delete(Node root,int pos){
                    //       if(pos==1) root=root.next;return root;
                    //       Node t=root;
                    //       int i=0;
                    //       while(i<pos-1 && t.next!=null){
                    //           t=t.next;
                    //       }
                    //       t.next=t.next.next;
                    //       return t;
                    //   }


                // Delete All the Element of The Given Input
                   
                    //   Node Deleteall(Node root,int data){
                    //       if(root==null) return root;
                    //       NOde t=root;
                    //       while(t.next!=null){
                    //           if(t.next.data==data) t.next=t.next.next;
                    //           else t=t.next;
                    //       }
                    //       if(t.data==data) return t.next;
                    //       return t;
                    //   }



                // Remove Repeated  in Soarted Linked List


                    //  Node distinct(Node root){
                    //      if(root==null) return root;
                    //      Node t=root;
                    //      while(t.next!=null){
                    //          if(t.next.data==t.data) t.next=t.next.next;
                    //          else t=t.next;
                    //      }
                    //      return t;
                    //  }


                // Return Unique Elements in The Linked LIst


                    // Node Unique(Node root){
                    //     HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
                    //     for(Node t=root;t!=null;t=t.next){
                    //         if(hm.containsKey(t.data)) hm.put(t.data,hm.get(t.data)+1);
                    //         else hm.put(t.data,1);
                    //     }
                    //     int c=0;
                    //     for(Node t=root;t!=null;t=t.next){
                    //         if(hm.get(t.data)==1) SOP(t.data+" ");c++;
                    //     }
                    //     if(c==0) SOP("No Unique Elements");
                    // }


                // MidPoint of a Linked List

                            //  Node Findmid(Node root){
                            //      Node s=root;
                            //      Node f=root;
                            //      if(root==null) return root;
                            //      while(f!=null && f.next!=null){
                            //          f=f.next.next;
                            //          s=s.next;
                            //      }
                            //      return s.next;
                            //  }


                // Merge 2 Linked List

                        //    Node Merge(Node root1,Node root2){
                        //        Node d=new Node(0);
                        //        while(root1!=null && root2!=null){
                        //            if(root1.data<root2.data) d.next=root1; root1=root1.next;
                        //            else d.next=root2;root2=root2.next;
                        //            d=d.next;
                        //        }
                        //        if(root1!=null) d=root1;
                        //        else d=root2;
                        //        return d.next;
                        //    }


                // Sort an Linked List Using Merge Sort


                    //    Node MergeSort(Node root){
                    //        if(root==null || root.next==null) return root;
                    //        Node mid=Findmid(root);
                    //        Node t=mid;
                    //        mid.next=null;
                    //        node left=MergeSort(root);
                    //        node right=MergeSort(t);
                    //        node merge=Merge(left,right);
                    //        return merge;
                    //    }


                // Adding two Nodes


                        // Node addtwolists(Node A,Node B){
                        //     int c=0;
                        //     Node d=new Node(0);
                        //     Node td=d;
                        //     while(A!=null || b!=null || c>0){
                        //         int sum=(A!=null?A.data:0)+(B!=null?B.data:0)+c;
                        //         c=sum>9?1:0;
                        //         td.next=new Node(sum%10);
                        //         A=(A!=null?A.next:A);
                        //         B=(B!=null?B.next:B);
                        //         td=td.next;
                        //     }
                        //     return d.next;
                        // }


                // Intersection Point of Two Nodes


                    //  Node Intersect(Node h1,Node h2){
                    //      int a=size(h1);
                    //      int b=size(h2);
                    //      int d=Math.abs(a-b);
                    //      for(i=0;i<d;i++){
                    //          if(h1==null) return -1;
                    //          h1=h1.next;
                    //      }
                    //      while(h1!=null && h2!=null){
                    //          if(h1.data==h2.data) return h1.data;
                    //          h1=h1.next;
                    //          h2=h2.next;
                    //      }
                    //      return -1;
                    //  }


                // Detect And Remove Loop


                //    Void DetectandRemoveloop(Node root){
                //        if(root==null || root.next==null) return ;
                //        Node s=root;
                //        Node f=root;
                //        s=s.next;
                //        f=f.next.next;
                //        while(f!=null && f.next!=null){
                //            if(s==f) break;
                //            s=s.next;
                //            f=f.next.next;
                //        }
                //        if(s==f){
                //            s=root;
                //            if(s!=f){
                //                while(s.next!=f.next){
                //                    s=s.next;
                //                    f=f.next;
                //                }
                //                f.next=null;
                //            }
                //            else {
                //                while(f.next!=s){
                //                    f=f.next;
                //                }
                //                f.next=null;
                //            }
                //        }
                //    }


            // Clone of a SLL

                // Node CLone(Node root){
                //     if(root==null) return root;
                //     Node d=new Node(0);
                //     while(root!=null){
                //         d.next=new Node(root.data);
                //         root=root.next;
                //         d=d.next;
                //     }
                //     return d.next;   
                // }



            // REVERse Every Kth Node


                  // Recursive
                     
                        // Node Reverse(Node root,int k){
                        //     if(root==null) return null;
                        //     Node prev=null,next=null;
                        //     NOde t=root;
                        //     int c=0;
                        //     while(root!=null && c<k){
                        //         next=root.data;
                        //         root.data=prev;
                        //         prev=root;
                        //         root=next;
                        //         c++;
                        //     }
                        //     root.next=Reverse(root,k);
                        //     return prev;
                        // }


                 // Iterative


                    //   Node Reverse(Node root,int k){
                    //       Node d=new Node(-1);
                    //       Node p2=root;
                    //       Node p1=d;
                    //       Node prev=null;
                    //     while(root!=null){
                    //         node* tmp = root->next;
                    //         root->next = prev;
                    //         prev = root;
                    //         root = tmp;
                    //         cnt++;
                    //         if(cnt == k) {
                    //         cnt = 0;
                    //         p1->next = prev;
                    //         prev = NULL;
                    //         p1 = p2; p2 = root;
                    //         }
                    //     }
                    //     p1->next = prev;
                    //     return d->next;
                    //   }


              
              // Delete Nth Node From Linked List End

                  
                    void nthendLinekdlist(Node root,int k){
                        Node s=root;
                        Node f=root;
                        for(int i=0;i<k;i++){
                            if(f.next==null){
                                if(i==k-1) root=root.next;
                            }
                            f=f.next;
                        }
                        while(f.next!=null){
                            s=s.next;
                            f=f.next;
                        }
                        SOP(s.next.data);
                        s.next=s.next.next;
                    }



    


    //////   TREES     ///////





                       


            
                     

                




                    




                

                





    













    public static void main(String args[]) {
        Scanner s=new Scanner(System.in);
        // int n=s.nextInt();
        // int ar[]=new int[n];
        // for(int i=0;i<n;i++) ar[i]=s.nextInt();

        // stockspan(ar,n);

        // String expr = "([{}])(";
        // if (areBracketsBalanced(expr))
        //     System.out.println("Balanced ");
        // else
        //     System.out.println("Not Balanced ");


        // firstsmaller(ar,n);

        // String str="231*+9-";

        // postfix(str);

        // maxrectanglehisto(ar,n);

        // int k=s.nextInt();

        // slidingwindowmaximum(ar,n,k);

        Main list = new Main();
        list.head = new Node(85);
        list.head.next = new Node(15);
        list.head.next.next = new Node(4);
        list.head.next.next.next = new Node(20);




    }
}