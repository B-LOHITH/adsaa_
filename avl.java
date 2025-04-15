import java.util.*;
class Node{
    int data;
    int h;
    Node rc;
    Node lc;
    Node(){
        data=0;
        h=0;
        rc=null;
        lc=null;
    
    }
    Node(int value){
        data=value;
        h=0;
        rc=null;
        lc=null;
    }
}
class cavl{
    private Node root;
    public cavl(){
        root=null;
    }
    public void insert(int val){
        root=insert(root,val);
    }
    public int height(Node n){
        return n==null?-1:n.h;
    }
    public int max(int l,int r){
        return l>r?l:r;
    }
    public Node insert(Node n,int val){
        if(n==null){
            n=new Node(val);
        }
        else if(n.data>val){
            n.lc=insert(n.lc,val);
            if(height(n.lc)-height(n.rc)==2){
                if(n.lc.data>val){
                    n=rlc(n);
                }
                else{
                    n=drlc(n);
                }
            }
        }
        else if(n.data<val){
            n.rc=insert(n.rc,val);
            if(height(n.rc)-height(n.lc)==2){
                if(n.rc.data>val){
                    n=rrc(n);
                }
                else{
                    n=drrc(n);
                }
            }
        }
        else{
            ;
        }
        n.h=max(height(n.rc),height(n.lc))+1;
        return n;
    }
    public Node rlc(Node n2){
        Node n1=n2.lc;
        n2.lc=n1.rc;
        n1.rc=n2;
        n2.h=max(height(n2.lc),height(n2.rc))+1;
        n1.h=max(height(n1.lc),n2.h)+1;
        return n1;
    }
    public Node rrc(Node n1){
        Node n2=n1.rc;
        n1.rc=n2.lc;
        n2.lc=n1;
        n1.h=max(height(n1.lc),height(n1.rc))+1;
        n2.h=max(height(n2.rc),n1.h)+1;
        return n2;
    }
    public Node drlc(Node n3){
        n3.lc=rrc(n3.lc);
        return rlc(n3);
    }
    public Node drrc(Node n1){
        n1.rc=rlc(n1.rc);
        return rrc(n1);
    }
    public void inorderTraversal()   
     {   
          inorderTraversal(root);   
     }   
     private void inorderTraversal(Node node)   
     {   
          if (node != null)   
          {   
               inorderTraversal(node.lc);   
               System.out.print(node.data+" ");   
               inorderTraversal(node.rc);   
          }   
     } 
    public void preorderTraversal()   
         {   
              preorderTraversal(root);   
        }   

    private void preorderTraversal(Node node){  
        if (node != null)   
            {   
                System.out.print(node.data+" "); 
                preorderTraversal(node.lc);                   
                preorderTraversal(node.rc);   
            }   
     } 
    public void postorderTraversal(){   
          postorderTraversal(root);   
     }   
     private void postorderTraversal(Node node)   
     {   
          if (node != null)   
          {   
            postorderTraversal(node.lc);                   
            postorderTraversal(node.rc);   
            System.out.print(node.data+" "); 
          }   
     } 
    public void search(int key) { 
        Node n = search(root, key); 
        if(n == null) System.out.println("Key is not found in the Tree"); 
        else System.out.println("Key is found"); 
    } 
    private Node search(Node node, int key) { 
        if (node==null || node.data==key) return node; 
        else if(key < node.data) return search(node.lc, key); 
        else return search(node.rc, key);  
    } 
} 
 
 
 
 
 
public class avl{ 
 public static void main(String[] args) 
 { 
  Scanner sc = new Scanner(System.in); 
  cavl  avl = new cavl(); 
  while(true) 
  { 
   System.out.println("1. Insert an element"); 
   System.out.println("2. Search for an element"); 
   System.out.println("3. Inorder Traversal\n4. Preorder Traversal\n5. Postorder Traversal"); 
   System.out.println("6. Exit"); 
   System.out.println("Enter your choice: "); 
   int  ch = sc.nextInt(); 
   switch(ch) 
   { 
    case 1:  System.out.println("Enter element:"); 
                   int item = sc.nextInt(); 
                   avl.insert(item); 
                   break; 
    case 2:  System.out.println("Enter the key element to search"); 
                   int key = sc.nextInt(); 
                   avl.search(key); 
                   break;     
    case 3:  System.out.println("Inorder Traversal:"); 
                   avl.inorderTraversal(); 
                   System.out.println(); 
                   break;  
    case 4:  System.out.println("Preorder Traversal:"); 
                   avl.preorderTraversal(); 
                   System.out.println(); 
                   break; 
    case 5:  System.out.println("Postorder Traversal:"); 
                   avl.postorderTraversal(); 
                   System.out.println(); 
                   break;  
    case 6:  System.exit(0);   
   } 
  } 
 
}
}