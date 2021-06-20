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



                        class TwoStacks {
                            int size;
                            int top1, top2;
                            int arr[];
                            TwoStacks(int n)
                            {
                                arr = new int[n];
                                size = n;
                                top1 = -1;
                                top2 = size;
                            
                            void push1(int x)
                            {
                                
                                if (top1 < top2 - 1) {
                                    top1++;
                                    arr[top1] = x;
                                }
                                else {
                                    System.out.println("Stack Overflow");
                                    System.exit(1);
                                }
                            }
                        
                            void push2(int x)
                            {
                                if (top1 < top2 - 1) {
                                    top2--;
                                    arr[top2] = x;
                                }
                                else {
                                    System.out.println("Stack Overflow");
                                    System.exit(1);
                                }
                            }
                        
                            // Method to pop an element from first stack
                            int pop1()
                            {
                                if (top1 >= 0) {
                                    int x = arr[top1];
                                    top1--;
                                    return x;
                                }
                                else {
                                    System.out.println("Stack Underflow");
                                    System.exit(1);
                                }
                                return 0;
                            }
                            int pop2()
                            {
                                if (top2 < size) {
                                    int x = arr[top2];
                                    top2++;
                                    return x;
                                }
                                else {
                                    System.out.println("Stack Underflow");
                                    System.exit(1);
                                }
                                return 0;
                            }
                        
                            // Driver program to test twoStack class
                            public static void main(String args[])
                            {
                                TwoStacks ts = new TwoStacks(5);
                                ts.push1(5);
                                ts.push2(10);
                                ts.push2(15);
                                ts.push1(11);
                                ts.push2(7);
                                System.out.println("Popped element from"
                                                   + " stack1 is " + ts.pop1());
                                ts.push2(40);
                                System.out.println("Popped element from"
                                                   + " stack2 is " + ts.pop2());
                            }
                        }

        
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

                  
                    // void nthendLinekdlist(Node root,int k){
                    //     Node s=root;
                    //     Node f=root;
                    //     for(int i=0;i<k;i++){
                    //         if(f.next==null){
                    //             if(i==k-1) root=root.next;
                    //         }
                    //         f=f.next;
                    //     }
                    //     while(f.next!=null){
                    //         s=s.next;
                    //         f=f.next;
                    //     }
                    //     SOP(s.next.data);
                    //     s.next=s.next.next;
                    // }



          //   LRU Cache Replacement Technique  
                         
                        //   https://www.interviewbit.com/problems/lru-cache/



        //////   TREES     ///////

        // SIZE OF TREE

               static int Size(Node root){
                   if(root==null) return 0;
                   return Size(root.left)+Size(root.right)+1;
               }

        // Sum Of All Node

             static int Sum(Node root){
                 if(root==null) return 0;
                 return root.data+Sum(root.left)+Sum(root.right);
             }

        // Max Node 

            static int Max(Node root){
                if(root==null) return Integer.MIN_VALUE;
                return Math.max(root.data,Math.max(Max(root.left),Max(root.right)));
            }

        // Height of a tree

            static int Height(Node root){
                if(root==null) return -1;
                return  Math.max(Height(root.left),Height(root.right))+1;
            }

        // Fill Depth of a tree

           static void FillDepth(Node root,int d){// Intinally d=0
                      if(root==null) return ;
                      root.depth=d;
                      FillDepth(root.left,d+1);
                      FillDepth(root.right,d+1);
           }

        // Tree Traversal

           static void Inorder(Node root){
               if(root==null) return;
               Inorder(root.left);
               System.out.print(root.data+" ");
               Inorder(root.right);
           }

           static void Preorder(Node root){
               if(root==null) return;
               System.out.print(root.data+" ");
               Preorder(root.left);
               Preorder(root.right);
           }

           static void Postorder(Node root){
               if(root==null) return;
               Postorder(root.left);
               Postorder(root.right);
               System.out.print(root.data+" ");
           }


      // Level Order Traversal

         static void Level(Node root){
             if(root==null) return ;
             Queue<Node> q=new LinkedList<Node>();
             q.add(root);
             q.add(null);
             while(!q.isEmpty()){
                 Node t=q.poll();
                 if(t==null){
                     if(!q.isEmpty){
                         q.add(null);
                         System.out.println();
                     }
                 }
                 else{
                     if(t.left!=null) q.add(t.left);
                     if(t.right!=null) q.add(t.right);
                     System.out.print(t.data+" ");
                 }

             }
         }


      // Zig Zag Level Order Traversal

           static void ZigZag(Node root){
               if(root==null) return;
               Stack<Node> st=new Stack<>();
               st.push(root);
               boolean f=false;
               while(!st.isEmpty()){
                   Stack<Node> st1=new Stack<>();
                   while(!st.isEmpty()){
                       Node t=st.pop();
                       System.out.print(t.data+" ");
                       if(f){
                           if(t.left!=null) st1.push(t.left);
                           if(t.right!=null) st1.push(t.right);
                       }
                       else{
                           if(t.right!=null) st1.push(t.right);
                           if(t.left!=null) st1.push(t.left);
                       }
                   }
                   f=!f;
                   st=st1;
               }
           }

        // Bottom Up level order of Tree

          static void Level(Node root,int l){
              if(root==null) return;
              if(l==1) System.out.print(root.data+" ");
              Level(root.left,l-1);
              Level(root.right,l-1);
          }


           static void Bottom(Node root){
               if(root==null) return;
               int h=Height(root);
               for(int i=h;i>=0;i--){
                   Level(root,i+1);
                   System.out.println();
               }
           }

        // Zig Zag Bootom Up Level Order of Tree



        // Convert Binary Tree to Mirror Tree

           static void Mirror(Node root){
               if(root==null) return;
               Node t=root.left;
               root.left=root.right;
               root.right=t;
               Mirror(root.left);
               Mirror(root.right);
           }

        // Check If two Trees are Mirror to Each Other 

            static boolean Mirror(Node a ,Node b){
                if(a==null && b==null) return true;
                if(a==null || b==null) return false;
                return a.data==b.data && Mirror(a.left,b.right) && Mirror(a.right,b.left);
            }

        // Vertical Order Of a Tree

            static void gverti(Node root,int c,TreeMap<Integer,List<Integer>> hm){
                if(root==null) return;
                List<Integer> l=hm.get(c);
                if(l==null){
                    l=new ArrayList<>();
                    l.add(root.data);
                }
                else l.add(root.data);
                hm.put(c,l);
                gverti(root.left,c-1,hm);
                gverti(root.right,c+1,hm);
            }
            
            static void Verti(Node root){
                TreeMap<Integer,List<Integer>> hm=new TreeMap<>();
                int c=0;
                gverti(root,c,hm);
                for(Map.Entry<Integer,List<Integer>> e:hm.entrySet()){
                    List<Integer> a=e.getValue();
                    Collections.sort(a);
                    for(int i=0;i<a.size();i++){
                        System.out.print(a.get(i)+" ");
                    }
                    System.out.println();
                }
            }

        // Is FULL BINARY TREE

            static boolean BT(Node root){
                if(root==null) return true;
                if(root.left==null && root.right==null) return true;
                if((root.left!=null) && (root.right!=null))
                    return (BT(root.left) && BT(root.right));
                return false;
            }

        // is COMPLETE BINARY TREE

            static int S(Node root){
                if(root == null) return 0;
                return  S(root.left)+S(root.right)+1;
            }
            
            static boolean CBT(Node root,int n,int k){//k=S(root);
                if(root==null)  return true;
                if(n>=k) return false;
                return (CBT(root.left,2*n+1,k) && CBT(root.right,2*n+2,k));
            }

        // is Balanced Tree

                static boolean BT(Node root){
                    if(root==null) return true;
                    int l=Height(root.left);
                    int r=Height(root.right);
                    if(Math.abs(l-r)<=1)
                        if(BT(root.left) && BT(root.right)) return true;
                    return false;
                }


        //  Left View Of Tree

             static void Leftview(Node root){
                 if(root==null) return;
                 Queue<Node> q=new LinkedList<>();
                 q.add(root);
                 while(!q.isEmpty()){
                     int k=q.size();
                     for(int i=1;i<=k;i++){
                         Node t=q.poll();
                         if(i==1) System.out.print(t.data+" ");
                         if(t.left!=null) q.add(t.left);
                         if(t.right!=null) q.add(t.right);
                     }
                 }
             }

        // Right View of Tree

             static void Leftview(Node root){
                 if(root==null) return;
                 Queue<Node> q=new LinkedList<>();
                 q.add(root);
                 while(!q.isEmpty()){
                     int k=q.size();
                     for(int i=1;i<=k;i++){
                         Node t=q.poll();
                         if(i==k) System.out.print(t.data+" ");
                         if(t.left!=null) q.add(t.left);
                         if(t.right!=null) q.add(t.right);
                     }
                 }
             }

        // Top View of Tree


            static void Top_view(Node root){
                if(root!=null){
                    top_View(root.left,true);
                    System.out.print(root.data+" ");
                    top_View(root.right,false);
                }
            }

            static void top_View(Node root,boolean t){
                if(root!=null){
                    if(t){
                        top_view(root.left,t);
                        System.out.print(root.data+" ");
                    }
                    else{
                        System.out.print(root.data+" ");
                        top_view(root.right,t);
                    }
                }
            }

        
        // Length of Path From x to y

            static Node LCA(Node root, int n1, int n2){
                        if (root == null)
                            return root;
                        if (root.value == n1 || root.value == n2)
                            return root;
                
                        Node left = LCA(root.left, n1, n2);
                        Node right = LCA(root.right, n1, n2);
                
                        if (left != null && right != null)
                            return root;
                        if (left == null && right == null)
                            return null;
                        if (left != null)
                            return LCA(root.left, n1, n2);
                        else
                            return LCA(root.right, n1, n2);
                    }

                     static int findLevel(Node root, int a, int level){
                            if (root == null)
                                return -1;
                            if (root.value == a)
                                return level;
                            int left = findLevel(root.left, a, level + 1);
                            if (left == -1)
                                return findLevel(root.right, a, level + 1);
                            return left;
                        }
 
               

                static int findDistance(Node root, int a, int b){
                        Node lca = LCA(root, a, b);
                        int d1 = findLevel(lca, a, 0);
                        int d2 = findLevel(lca, b, 0);
                        return d1 + d2;
                    }

            

            

            






        // Sum of Numbers From root to Leaf Paths

            static int cd(int k){
                String s=Integer.toString(k);
                return s.length();
            }
            
            static int Sum(Node root,int k){
                if(root==null) return 0;
                k=((k*Math.pow(10,Cd(root.data)))+root.data);
                if(root.left==null && root.right==null) return k;
                return Sum(root.left,k)+Sum(root.right,k);
            }

        // Given PreOrder ,Inorder  return Post Order


            static int f;
            //Main
            f=0;
            Node t=PIP(pre,in,0,n-1);
            PostOrder(t);

            //function

            static int Find(int ar[],int l,int h,int k){
                for(int i=l;i<=h;i++) if(ar[i]==k) return i;
                return -1;
            }

            static Node PIP(int pre[],int in[],int l,int h){
                if(l>h) return null;
                Node root=new Node(pre[f++]);
                int pos=Find(in,l,h,root.data);
                if(l==h) return root;
                root.left=PIP(pre,in, l,pos-1);
                root.right=PIP(pre,in,pos+1,h);
                return root;
            }


        // Binary Search Tree


           //Main for Insert

               int n=s.nextInt();
               Node root=null;
               while(n-->0){
                   x=s.nextInt();
                   root=Insert(root,x);
               }


           static Node Insert(Node root,int k){
               if(root==null) return new Node(k);
               if(k<root.data) root.left=Insert(root.left,k);
               else root.right=Insert(root.right,k);
               return root;
           }


           static boolean Search(Node root,int k){
               if(root==null) return false;
               if(root.data==k) return true;
               if(root.data > k) return Search(root.left,k);
               else return Search(root.right,k); 
           }

           static DeleteNode(Node root,int k){
               if(root==null) return null;
               if(root.data > k) root.left=DeleteNode(root.left,k);
               if(root.data < k) root.right=DeleteNode(root.right,k);
               else{
                   if(root.left==null)
                       return root.right;
                   else if(root.right==null)
                       return root.left;
                   else{
                       root.data=findMax(root.left);
                       root.left=DeleteNode(root.data,root.left);
                   }
               }
               return root;
           }

           //find Max

              static int findMax(Node root){
                  while(root.right!=null) root=root.right;
                  return root.data;
              }


        // Convert Given Array to CBT


             // Main
                
                  Node root=null;
                  int ar[]=new int[n];
                  for(int i=0;i<n;i++) ar[i]=s.nextInt();
                  root=Insert(root,ar,0);

            // function

               static Node Insert(Node root,int ar[],int k){
                   if(k<ar.length){
                       Node t=new Node(ar[k]);
                       root=t;
                       root.left=Insert(root.left,ar,2*k+1);
                       root.right=Insert(root.right,ar,2*k+2);
                   }
                   return root;
               }

        // Is BST or Not

           // Main  

              if(BST(root,Integer.MIN_VALUE,Integer.MAX_VALUE))
                System.out.println("True");
              else
                System.out.println("False");

          // Function

             static boolean BST(Node root,int a,int b){
                 if(root==null) return true;
                 if(root.data>=a && root.data<=b && BST(root.left,a,root.data) && BST(root.left,root.data,b))
                      return true;

                 return false;
             }

        // Floor & Ceil of Bst

          //main
           int floor=-1;
           int ceil=-1;
           floorandceil(root,k);

         // function 

           static void floorandceil(Node root,int k){
               while(root!=null){
                   if(root.data==k){
                       floor=root.data;
                       ceil=root.data;
                   }
                   if(root.data > k){
                       floor=root.data;
                       root=root.right;
                   }
                   else{
                       ceil=root.data;
                       root=root.left;
                   }
               }
           }

      
      // Trim of BST FRom range

        static Node Trim(Node root,int a,int b){
            if(root==null) return root;
            if(root.data > b) return Trim(root.left,a,b);
            if(root.data < a) return Trim(root.right,a,b);
            root.left=Trim(root.left,a,b);
            root.right=Trim(root.right,a,b);
            return root;
        }

     
     // Max Sum of Nodes ALong any Path Of BT

        int ans=0;
        static int maxsum(Node root){
            if(root==null) return 0;
            int l=maxsum(root.left);
            int r=maxsum(root.right);
            cans=l+r+root.data;
            // ans=Math.max(ans,cans);
            return Math.max(Math.max(l,r)+root.data,root.data);
        }

    // Diagonal Levele Order Traversal

        static void gDiagonal(Node root,int c,TreeMap<Integer,List<Integer>> hm){
                if(root==null) return;
                List<Integer> l=hm.get(c);
                if(l==null){
                    l=new ArrayList<>();
                    l.add(root.data);
                }
                else l.add(root.data);
                hm.put(c,l);
                gDiagonal(root.left,c-0,hm);
                gDiagonal(root.right,c+1,hm);
            }
            
            static void Diagonal(Node root){
                TreeMap<Integer,List<Integer>> hm=new TreeMap<>();
                int c=0;
                gDiagonal(root,c,hm);
                for(Map.Entry<Integer,List<Integer>> e:hm.entrySet()){
                    List<Integer> a=e.getValue();
                    Collections.sort(a);
                    for(int i=0;i<a.size();i++){
                        System.out.print(a.get(i)+" ");
                    }
                    System.out.println();
                }
            }

        // Length of Path Fro X to Y

           static Node LCA(Node root, int n1, int n2){
                if (root == null)
                    return root;
                if (root.value == n1 || root.value == n2)
                    return root;
        
                Node left = LCA(root.left, n1, n2);
                Node right = LCA(root.right, n1, n2);
        
                if (left != null && right != null)
                    return root;
                if (left == null && right == null)
                    return null;
                if (left != null)
                    return LCA(root.left, n1, n2);
                else
                    return LCA(root.right, n1, n2);
            }

              static int findLevel(Node root, int a, int level){
                    if (root == null)
                        return -1;
                    if (root.value == a)
                        return level;
                    int left = findLevel(root.left, a, level + 1);
                    if (left == -1)
                        return findLevel(root.right, a, level + 1);
                    return left;
                }

                 static int findDistance(Node root, int a, int b){
                        Node lca = LCA(root, a, b);
                
                        int d1 = findLevel(lca, a, 0);
                        int d2 = findLevel(lca, b, 0);
                
                        return d1 + d2;
                    }

        

        

        


         

       

         

            


        



            

          
           
              
          


        

           

          

           







            
              


                         


            


        



    





                       


            
                     

                




                    




                

                





    













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