import java.util.*;
import java.io.*;

public class twitter_hashtag_solution{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        //array to store tweets
        String tweets[] = new String[n];
        
        //data structure to store frequency of hashtags 
        Map<String, Integer> hashTags = new HashMap<String, Integer>();
        
        for(int i = 0; i < n; i++){
            tweets[i] = br.readLine();
        }
        
        for(String tweet : tweets){
            
            //splitted tweet based on whitespace to extract words properly
            String[] words = tweet.split("\\s");
            for(String word : words){
                
                //if first character is #, it means it's a hashtag
                if(word.charAt(0) == '#'){
                    //taking the hashtag word
                    String hashtagWord = word.substring(1);
                    
                    //if the hashtag word is present in dictionary
                    //then increment the frequency or else set frequency to 1
                    if(hashTags.containsKey(hashtagWord)){
                        hashTags.put(hashtagWord, hashTags.get(hashtagWord) + 1);
                    }else{
                        hashTags.put(hashtagWord, 1);
                    }
                }
            }
        }
        
        //arraylist to store frequencies
        ArrayList<Integer> frequencyOfHashTags = new ArrayList<Integer>();
        
        for(Map.Entry<String, Integer> entry : hashTags.entrySet()){
            int frequency = (int)entry.getValue();
            
            frequencyOfHashTags.add(frequency);
        }
        
        //sorting the frequencies
        Collections.sort(frequencyOfHashTags);
        
        //reversing to get top hashtags
        Collections.reverse(frequencyOfHashTags);
        
        System.out.println("Top 10 hashtags are as follows : \n");
        
        //to ensure same word not getting printed multiple times
        Set<String> seen = new HashSet<String>();
        
        for(int i = 0; i < 10; i++){
            for(Map.Entry<String, Integer> entry : hashTags.entrySet()){
                String word = entry.getKey();
                
                //getting the word whose frequency matches the current frequency value from sorted arraylist
                //there could be duplicate frequencies
                //so taking set to ensure same word does not get printed multiple times
                if(frequencyOfHashTags.get(i) == entry.getValue() && !seen.contains(word)){
                    System.out.println(word+"  "+entry.getValue());
                    seen.add(word);
                    break;
                }
            }
        }
    }
}
