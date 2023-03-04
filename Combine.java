import java.util.ArrayList; 


//Combine every element in an array list with all other values in the array three times
//Take 2 array lists and combine values into a 2d array list so that every value in 
//ArrayList 1 mathces with every item in ArrayList 2 in both orders 


// a1 = [1,2,3,4,5]  length = 5
// a2 = [a,b,c,d,e]  length = 5
//
// a3 = [12, 21, 13, 31, 14, 41, 15, 51, 23, 32, 24, 42, 25, 52, 34, 43, 35, 53, 45, 54]
//  length = (a1.length * a1.length - 1) + (a1.length * 2)

// a4 = [ab, ba, ac, ca, (ac), ad, da, (ad), ae, ea, (ae), bc, cb, (bc), bd, db, (bd), be, eb, (be), cd, dc, (cd), ce, ec, (ce), de, ed, (de) ]
//  
//
//
// a5 = [1a, a1, 2b, b2, 3c, c3, 4d, d4, 5e, e5]
//      [1b, b1, 2c, c2, 3d, d3, 4e, e4, 5a, a5]
//      [1c, c1, 2d, d2, 3e, e3, 4a, a4, 5b, b5]   
//      [1d, d1, 2e, e2, 3a, a3, 4b, b4, 5c, c5]
//      [1e, e1, 2a, a2, 3b, b3, 4c, c4, 5d, d5]
//
//      length = (a1.length * a2.length) * 2 
//
public class Combine{

    private ArrayList<String> a1; 
    private ArrayList<String> a2; 


    public Combine(ArrayList<String> a1, ArrayList<String> a2){
        this.a1 = a1; 
        this.a2 = a2; 
    }

    //Merges ArrayList input parameter 
    public ArrayList<String> mergeSingle(ArrayList<String> a1){

        this.a1 = a1; 

        ArrayList<String> a3 = new ArrayList<>(); 

        int i; 
        int j; 
        for(i = 0; i < a1.size(); i++){
            for(j = 1; j < a1.size(); j++){
                if(i != j && j > i){
                a3.add("" + a1.get(i) + a1.get(j));
                a3.add("" + a1.get(j) + a1.get(i));
                //a3.add("(" + a1.get(i) + a1.get(j) + ")");
                }
            }
        }
        return a3; 


        
    }

    //Merges first ArrayList insance variable
    public ArrayList<String> mergeSingle(){

        ArrayList<String> a3 = new ArrayList<>(); 

        int i; 
        int j; 
        for(i = 0; i < a1.size(); i++){
            for(j = 1; j < a1.size(); j++){
                if(i != j && j > i){
                a3.add("" + a1.get(i) + a1.get(j));
                a3.add("" + a1.get(j) + a1.get(i));
                //a3.add("(" + a1.get(i) + a1.get(j) + ")");
                }
            }
        }
        return a3; 
    }

    //Merges two ArrayLists with the same size
    public ArrayList<ArrayList<String>> mergeDouble(){

        ArrayList<ArrayList<String>> mainList = new ArrayList<>();
        
        int i = 0; 
        int j = 0; 
        int k = 0; 
        int increment = 0;

        
        for(k = 0; k < a2.size(); k++){
            //Create new String list 
            ArrayList<String> listToAdd = new ArrayList<>(); 
        
            for(i = 0; i < a1.size(); i++){
            //Letter list should be incremented by 1 every time through
            j = i + increment;
            //If this is the size or longer, reduce it by the size to be the correct number
            if(j >= a1.size()){
                j = i + increment - a1.size(); 
            }

            //Add in both orders and increment j 
            listToAdd.add("" + a1.get(i) + a2.get(j));
            listToAdd.add("" + a2.get(j) + a1.get(i));
            j++; 

            
        }
        //Add String list to the list of ArrayLists 
        mainList.add(listToAdd);
        increment++; 
        }
        
        //Return list 
        return mainList; 
        
    }

    //Merges both ArrayList input parameters
    public ArrayList<ArrayList<String>> mergeDouble(ArrayList<String> a1, ArrayList<String> a2){

        this.a1 = a1; 
        this.a2 = a2; 

        ArrayList<ArrayList<String>> mainList = new ArrayList<>();
        
        int i = 0; 
        int j = 0; 
        int k = 0; 
        int increment = 0;

        
        for(k = 0; k < a2.size(); k++){
            //Create new String list 
            ArrayList<String> listToAdd = new ArrayList<>(); 
        
            for(i = 0; i < a1.size(); i++){
            //Letter list should be incremented by 1 every time through
            j = i + increment;
            //If this is the size or longer, reduce it by the size to be the correct number
            if(j >= a1.size()){
                j = i + increment - a1.size(); 
            }

            //Add in both orders and increment j 
            listToAdd.add("" + a1.get(i) + a2.get(j));
            listToAdd.add("" + a2.get(j) + a1.get(i));
            j++; 

            
        }
        //Add String list to the list of ArrayLists 
        mainList.add(listToAdd);
        increment++; 
        }
        
        //Return list 
        return mainList; 
    }
    
    public void printList(ArrayList<String> arr){
        System.out.print("[");
        for(int i = 0; i < arr.size() -1 ; i++){
            System.out.print(arr.get(i) + ", ");
        }
        System.out.println(arr.get(arr.size() - 1) + " ]"); 

    }

    public static void main(String[] args){

        ArrayList<String> nums = new ArrayList<String>(); 
        nums.add("1");
        nums.add("2");
        nums.add("3");
        nums.add("4");
        nums.add("5");

        ArrayList<String> chars = new ArrayList<String>(); 
        chars.add("a");
        chars.add("b");
        chars.add("c");
        chars.add("d");
        chars.add("e");

        //Create instance of merge with the 2 String arrays
        Combine merge = new Combine(chars, nums);


        
        //Merge the nums list together 
        ArrayList<String> numsBound = merge.mergeSingle(); 

        //Print the new merged list 
        System.out.println("One List Combination: ");
        merge.printList(numsBound);

        
        
        //Merge the 2 lists together
        ArrayList<ArrayList<String>> doubleBound = merge.mergeDouble(); 
        
        //Print 2d ArrayList 
        System.out.println("\nTwo List Combination: ");
        for(int i = 0; i < doubleBound.size(); i++){
            merge.printList(doubleBound.get(i)); 
        }
        

        

        



    }
}