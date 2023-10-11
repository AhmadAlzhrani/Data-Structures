import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Trie {
     
    static ArrayList<String> dic;
    static ArrayList<String> all = new ArrayList<String>();
    // Alphabet size (# of symbols)
    static final int ALPHABET_SIZE = 26;
    static int size = 0 ;
     
    // trie node
    static class TrieNode
    {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];
      
        // isEndOfWord is true if the node represents
        // end of a word
        boolean isEndOfWord;
         
        TrieNode(){
            isEndOfWord = false;
            for (int i = 0; i < ALPHABET_SIZE; i++)
                children[i] = null;
        }
    };
      
    static TrieNode root;
     
    // If not present, inserts key into trie
    // If the key is prefix of trie node,
    // just marks leaf node
    static void insert(String key)
    {
        int level;
        int length = key.length();
        int index;
      
        TrieNode pCrawl = root;
      
        for (level = 0; level < length; level++)
        {
            index = key.charAt(level) - 'A';
            if (pCrawl.children[index] == null)
                pCrawl.children[index] = new TrieNode();
      
            pCrawl = pCrawl.children[index];
        }
      
        // mark last node as leaf
        pCrawl.isEndOfWord = true;
        size++;
        all.add(key);
    }
      
    // Returns true if key presents in trie, else false
    static boolean contains(String key)
    {
        int level;
        int length = key.length();
        int index;
        TrieNode pCrawl = root;
      
        for (level = 0; level < length; level++)
        {
            index = key.charAt(level) - 'A';
      
            if (pCrawl.children[index] == null)
                return false;
      
            pCrawl = pCrawl.children[index];
        }
      
        return (pCrawl.isEndOfWord);
    }

    static boolean isEmpty(TrieNode root)
    {
        for (int i = 0; i < ALPHABET_SIZE; i++)
            if (root.children[i] != null)
                return false;
        return true;
    }

    static int size(){
        return size;
    }

    static boolean isPrefix(String pre){
        
        return getNode(pre) != null;
    }
    static TrieNode getNode(String word){
        TrieNode curr = root;
        for(int i = 0; i<word.length();i++){
            char c = word.charAt(i);
            if (curr.children[c-'A']== null)
                return null;
            curr = curr.children[c-'A'];
        }
        return curr;
    }

    static void clear(){
        root = new TrieNode();
        size = 0;
    }

    static TrieNode delete(TrieNode root, String key, int depth) {   
        // If tree is empty
        if (root == null)
            return null;
 
        // If last character of key is being processed
        if (depth == key.length()) {
            // This node is no more end of word after
            // removal of given key
            if (root.isEndOfWord)
                root.isEndOfWord = false;
 
            // If given is not prefix of any other word
            if (isEmpty(root)) {
                root = null;
            }
            size--;
            all.remove(key);
            return root;
        }
        // If not last character, recur for the child
        // obtained using ASCII value
        int index = key.charAt(depth) - 'A';
        root.children[index] =
            delete(root.children[index], key, depth + 1);
 
        // If root does not have any child (its only child got deleted), and it is not end of another word.
        if (isEmpty(root) && root.isEndOfWord == false){
            root = null;
        }
        return root;
    }
    static void premInsert(String word){
        for(int i=1;i<=word.length();i++){
            if(dic.contains(word.substring(0, i))){
                insert(word.substring(0,i));
            }
        }
    }
    static String [] allPrefix(String p){
        ArrayList<String> pre = new ArrayList<String>();
        for(int i=0; i<all.size();i++){
            if((all.get(i)).substring(0,p.length()).equals(p)){
                pre.add(all.get(i));
            }
        }
        String[] array = pre.toArray(new String[pre.size()]);
        return array;
    }
    static class per {
  
        // permutations of str
        static void printDistinctPermutn(String str, String ans) {
      
            // If string is empty
            if (str.length() == 0) {
      
                premInsert(ans);
                return;
            }
      
            // Make a boolean array of size '26' which
            // stores false by default and make true at the position which alphabet is being used
            boolean alpha[] = new boolean[26];
      
            for (int i = 0; i < str.length(); i++) {
      
                // ith character of str
                char ch = str.charAt(i);
      
                // Rest of the string after excluding 
                // the ith character
                String ros = str.substring(0, i) + str.substring(i + 1);
      
                // If the character has not been used then recursive call will take place. 
                // Otherwise, there will be no recursive call
                if (alpha[ch - 'A'] == false)
                    printDistinctPermutn(ros, ans + ch);
                alpha[ch - 'A'] = true;
            }
        }
      
         // Driver
        public static void main(String args[]) {

            // Input keys (use only 'A' through 'Z' and upper case)
        
            root = new TrieNode();
        
            // Construct file into ArrayList
            dic = new ArrayList<String>();
            try {
                File read = new File("dictionary.txt");
                Scanner reader = new Scanner(read);
                while (reader.hasNextLine()) {
                String data = reader.nextLine();
                if(data.equals("CROSS-BUN"));
                else
                //insert(data);
                dic.add(data);
                }
                reader.close();
                
            } 
            catch (FileNotFoundException e) {
                System.out.println("file not found.");
            }
            boolean option = true;
            while(option != false)
            {
                System.out.println("--------------------------------------------------");
                System.out.println("TRIE PROJECT: Enter your choice?");
                System.out.println("    1) Create an empty trie");
                System.out.println("    2) Create a trie with initial letters");
                System.out.println("    3) Insert a word");
                System.out.println("    4) Delete a word");
                System.out.println("    5) List all words that begin with a prefix");
                System.out.println("    6) Size of the trie");
                System.out.println("    7) Search for word");
                System.out.println("    8) End");
                System.out.print("Enter number----> ");
                Scanner scan = new Scanner(System.in);
                switch ( scan.nextInt() ) {
                    case 1:
                        System.out.println ( "You picked option 1" );
                        System.out.println("Trie set Created.");
                        break;
                    case 2:
                        System.out.println ( "You picked option 2" );
                        System.out.print("Enter your list of letters> ");
                        String word1 = scan.next();
                        System.out.println("");
                        printDistinctPermutn(word1,"");
                        System.out.println("Trie set Created.");
                        break;
                    case 3:
                        System.out.println ( "You picked option 3" );
                        System.out.print("enter the word you want to insert > ");
                        word1 = scan.next();
                        System.out.println("");
                        insert(word1);
                        System.out.println("Done");
                        break;
                    case 4:
                        System.out.println ( "You picked option 4" );
                        System.out.print("enter the word you want to delete > ");
                        word1 = scan.next();
                        System.out.println("");
                        if(contains(word1))
                        {
                            System.out.println("Done");
                            delete(root,word1,0);
                        } 
                        else
                            System.out.println("The word is not in the trie");
                        break;
                    case 5:
                        System.out.println ( "You picked option 5" );
                        System.out.print("Enter the prefix > ");
                        word1 = scan.next();
                        System.out.print("Found the following words:");
                        for(String a:allPrefix(word1) )
                            System.out.print(a+", ");
                        System.out.println("");
                        break;
                    case 6:
                        System.out.println ( "You picked option 6" );
                        System.out.println("The size of the trie is > " + size());
                        break;
                    case 7:
                        System.out.println ( "You picked option 7" );
                        System.out.print("enter word to search for > ");
                        word1 = scan.next();
                        System.out.println("");
                        if(contains(word1))
                            System.out.println("Word found: "+ word1);
                        else
                            System.out.println("Word not found: "+ word1);
                        break;
                    case 8:
                        System.out.println ( "You picked option 8" );
                        System.out.print("*************** EXIT ***************");
                        option = false;
                        break;
                    default:
                        System.err.println ( "Unrecognized option" );
                        scan.close();
                        break;
                }
            } 
        }
    }
}