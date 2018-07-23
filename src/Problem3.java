//Given the root to a binary tree, implement serialize(root), which serializes the tree into a string,
//        and deserialize(s), which deserializes the string back into the tree.


import java.io.*;

public class Problem3 {

    static node root;
    //Standard Node ckass
    class node{
        int data;
        node left;
        node right;

        public node(int data){
            this.data = data;
            left = null;
            right = null;
        }

    }
    //Inserts the node recursively into the BST
    public node insertNodeRecursive(node current, int data){

        if(current == null) return new node(data);

        if(current.data > data) current.left = insertNodeRecursive(current.left, data);

        else if(current.data < data) current.right = insertNodeRecursive(current.right, data);

        else return current;

        return current;
    }
    //regular insert that calls recursive function
    public void insertNode(int data){

        root = insertNodeRecursive(root, data);
    }
    //prints the BST in order
    public void inOrder(node Node){

        if(Node != null){

            inOrder(Node.left);
            System.out.println(Node.data + " ");
            inOrder(Node.right);

        }
    }

    //This serialize method calls its overloaded function then replaces all empty spaces caused by null references to single spaces
    public String serialize(node root){

        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        String s = sb.toString();
        return s.replaceAll("\\s+" , " ");
    }
    //appends the data onto the stringbuilder since it's more efficient.
    public void serialize(node root, StringBuilder sb){

        if(root == null) sb.append(" ");

        else{
            sb.append(root.data + " ");
            serialize(root.left, sb);
            serialize(root.right,sb);
        }
    }

    //This takes in a file that has the data for BST nodes. File is always in a single line due to code above.
    public node deserialize(File file) throws IOException {
        //if there is no file then we don't do anything
        if(!file.exists()) return null;

        //We have to read the file
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        String s = "";
        while((line = br.readLine())!= null){
            s = line;
        }
        //Then we turn the string into a string array to iterate through
        String[] snums = s.split(" ");

        for(String ss : snums){
            deserializeToTree(ss);
        }
        //we return the root of the tree
        return root;
    }
    //we call this function to insert the nodes onto a new tree
    public void deserializeToTree(String s){
        insertNode(Integer.parseInt(s));
    }



    public static void main(String[] args) {
        //file that is written
        Problem3 p3 = new Problem3();
        //path of the file
        File file = new File("/Users/derianescobar/IdeaProjects/DailyCodingProblem/src/nodes.txt");

        p3.insertNode(3);
        p3.insertNode(10);
        p3.insertNode(5);
        p3.insertNode(2);
        p3.insertNode(1);

        try {
            FileWriter writer = new FileWriter(file);
            writer.write(p3.serialize(root));
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            p3.deserialize(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        p3.inOrder(root);
    }

}
