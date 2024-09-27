import java.util.Scanner;

class Node{
    String name;
    String mobile;
    Node left;
    Node right;

    public Node(String name, String mobile){
        this.name = name;
        this.mobile = mobile;
        left = null;
        right = null;
    }
}

class PD{
    public Node root = null;

    public void sortedWithName(Node node){
        //node which is given must be root node of the BT
        if (node == null) {
            return;
        }

        //left root right
        sortedWithName(node.left);
        System.out.println(node.name+" "+node.mobile);
        sortedWithName(node.right);
    }

    public void desendingWithName(Node node){
        //node which is given must be root node of the BT
        if (node == null) {
            return;
        }

        //left root right
        desendingWithName(node.right);
        System.out.println(node.name+" "+node.mobile);
        desendingWithName(node.left);
    }

    public void insertRecord(String rName, String rMobile){
        if(root == null){
            root = new Node(rName, rMobile);
            return;
        }
        Node curr = root;
        while (true) {
            if (curr.name.compareTo(rName) == 0) {
                return;
            }

            if (curr.name.compareTo(rName) > 0) {
                if (curr.left == null) {
                    curr.left = new Node(rName, rMobile);
                    return;
                }
                curr = curr.left;
            }
            else{
                if (curr.right == null) {
                    curr.right = new Node(rName, rMobile);
                    return;
                }
                curr = curr.right;
            }
        }
    }

    public Node searchWithname(String rName){
        if (root == null) {
            return null;
        }

        Node curr = root;
        while (true) {
            if (curr.name.equals(rName)) {
                return curr;
            }

            if (curr.name.compareTo(rName) > 0) {
                if (curr.left != null) {
                    curr = curr.left;
                }
                else{
                    break;
                }
            }

            if (curr.name.compareTo(rName) < 0) {
                if (curr.right != null) {
                    curr = curr.right;
                }
                else{
                    break;
                }
            }
        }
        return null;
    }

    public Node deleteNode(String rName) {
        if(root == null) return null;

        Node curr = root;
        if(curr.name.equals(rName)) return helper(curr);

        while(curr != null){
            if(curr.name.compareTo(rName) > 0){
                if(curr.left != null && curr.left.name.equals(rName)){
                    curr.left = helper(curr.left);
                    break;
                }
                else{
                    curr = curr.left;
                }
            }
            else{
                if(curr.right != null && curr.right.name.equals(rName)){
                    curr.right = helper(curr.right);
                    break;
                }
                else{
                    curr = curr.right;
                }
            }
        }
        return root;
    }

    public Node helper(Node root){
        if(root.left == null){
            return root.right;
        }
        else if(root.right == null){
            return root.left;
        }
        else{
            Node leftChild = root.left;
            Node lastLeft = findLastLeft(root.right);
            lastLeft.left = leftChild;
            return root.right;
        }
    }

    public Node findLastLeft(Node root){
        if(root.left == null){
            return root;
        }
        return findLastLeft(root.left);
    }
    
}

public class PhoneBook {
    public static void main(String[] args) {
        // PD pd = new PD();

        // pd.insertRecord("Prem", "123");
        // pd.insertRecord("Jani", "1234");    
        // pd.insertRecord("Abc", "1234321");
        // pd.insertRecord("BCd", "12341");

        // // pd.sortedWithName(pd.root);

        // // Node t = pd.searchWithname("Jani");
        // // System.out.println(t.name+" "+t.mobile);

        // // pd.desendingWithName(pd.root);

        // Node t = pd.deleteNode("Abc");
        // pd.sortedWithName(t);

        Scanner sc = new Scanner(System.in);
        PD pd = new PD();

        int x = -1;
        while (x < 6) {
            System.out.println("Enter 1 for insert mobile number");
            System.out.println("      2 for delete mobile number");
            System.out.println("      3 for search mobile number");
            System.out.println("      4 for display name in ascending order ");
            System.out.println("      5 for display name in descending order ");
            System.out.println("      6 for break");

            x = sc.nextInt();

            switch (x) {
                case 1:
                    System.out.println("---------- Insert Mobile Number ----------");
                    System.out.println("Enter Name : ");
                    String n = sc.nextLine();
                    System.out.println("Enter Valid Mobile Number : ");
                    String p = sc.next();
                    if (p.length() != 10) {
                        System.out.println("Entered Mobile No. is Not Valid.");
                        return;
                    }
                    pd.insertRecord(n, p);
                    break;
                
                case 2:
                    System.out.println("---------- Delete Mobile Number ----------");
                    System.out.println("Enter name : ");
                    String name = sc.next();
                    pd.deleteNode(name);
                    break;
                
                case 3:
                    System.out.println("---------- Search Mobile Number ----------");
                    System.out.println("Enter name for search : ");
                    String tname = sc.next();
                    pd.searchWithname(tname);
                    break;
                
                case 4:
                    System.out.println("----------- Phone Dictionary ----------");
                    pd.sortedWithName(pd.root);
                    System.out.println();
                    break;
                
                case 5:
                    System.out.println("----------- Phone Dictionary ----------");
                    pd.desendingWithName(pd.root);
                    System.out.println();
                    break;

                case 6:
                    break;

                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        }
        sc.close();
    }
}
