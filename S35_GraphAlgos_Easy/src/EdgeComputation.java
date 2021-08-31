import java.io.*;
import java.util.*;

/**
 * This is the main class where the edges are computed, and all functionality is
 */
public class EdgeComputation {
    // read the file
    // Hashmap with String, and array list of strings
    //
    //
    // making it a hashmap so each one has its own arraylist of words connecting it
    // making it arraylists because we dont know how many edges each has
     HashMap<String, ArrayList<String>>  edges = new HashMap<>(); // hashmap: key = word, value = arraylist of related words
     ArrayList<String> zeroEdges = new ArrayList<>(); //arraylist of words with 0 edges
     ArrayList<Integer> numOfEdges = new ArrayList<>(); // arraylist of number of edges
     ArrayList<String> maximumEdges = new ArrayList<>(); // arraylist of words with the maximum edges

    /**
     * This is the constructor where all of the functionality is for the class
     * @throws IOException Throws exception if file is not read
     */
    public EdgeComputation() throws IOException {
        //Reading in words.dat file
        Scanner scan = new Scanner(new File("/iahome/m/mm/mmkemerling/Desktop/GIT/mmkemerling_swd/oral_exam2/S35_GraphAlgos_Easy/src/words.dat"));
        ArrayList<String> list = new ArrayList<String>(); // making an arraylist of the words
        while (scan.hasNext()){ // adding each next element to the array list
            list.add(scan.next());
        }
        scan.close(); // closing the scanner
        //System.out.println(list); // for testing purposes

        // goes through each word and finds the edges to the word
        for(int m = 0; m < list.size()-1; m++){ // for one word in the list
            int currentEdges = 0; // current edges for each word
            for( int l = 0; l < list.size()-1; l++){ // it iterates through all of the other words in the list
                if( m != l){ // if the indexes of the words are not equal
                    if(hasEdgesCalculation(list.get(m), list.get(l))){ // and if the edges calculation == 1
                        currentEdges++; //incrementing the current edges
                        if(edges.get(list.get(m)) == null){ // if there is no arraylist for m
                            edges.put(list.get(m),new ArrayList<String>()); // put m in the hashmap, and make a new array
                        }
                        edges.get(list.get(m)).add(list.get(l)); // add the new word to the arraylist
                    }
                }
            }
            numOfEdges.add(currentEdges); // adding the number of edges to an arraylist
            if(currentEdges == 0){ // if there are 0 edges, add
                zeroEdges.add(list.get(m));
            }

        } // end of for loops

        //computing maximum and average
        float sum = 0;
        float avg;
        int maximumEdgesInt = 0;
        for(int a = 0; a < numOfEdges.size(); a++){ //finding the average
            sum += numOfEdges.get(a);
            if(numOfEdges.get(a) > maximumEdgesInt){
                maximumEdgesInt = numOfEdges.get(a);
            }
        }
        avg = sum/numOfEdges.size(); // average number of edges
        //System.out.println(maximumEdgesInt);

        // this for loop is to find the words associated with the maximum number of edges
        for (Map.Entry<String, ArrayList<String>> entry : edges.entrySet()) {
            if (entry.getValue().size() == maximumEdgesInt) {
                maximumEdges.add(entry.getKey());
            }
        }

        // printing out the results
        System.out.println("Here are the  number words with 0 edges : " + zeroEdges.size());
        System.out.println("Here is the average number of edges: " + avg);
        System.out.println("The words with the most edges:" + maximumEdges + " with " + maximumEdgesInt + " vertices.");


        //Expected Output
        //avg num of connections: 4.910543685947542
        //num nodes with no edges: 671
        //nodes with the most edges: [cores, bares] with 25 vertices each
    }

    /**
     * This method finds if two given words have an edge, or have only one letter difference
     * @param currentWord The current word
     * @param wordToCompare the word to compare to
     * @return boolean true if they have an edge
     */
    public boolean hasEdgesCalculation(String currentWord,String wordToCompare){
        int characterDifference = 0;
        //goes through each letter and compares it to the other string
        for(int i = 0; i < currentWord.length(); i ++) {
            if (currentWord.charAt(i) != wordToCompare.charAt(i)){ // if the letters do NOT match
                characterDifference++; // increment by 1
            }
        }
        return characterDifference == 1; // returns true if 1
    }
}
