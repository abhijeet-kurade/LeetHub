class Solution {
    public List<List<String>> groupAnagrams(String[] input) {
        HashMap<String, List<String>> map = new HashMap<>();
        
        for(String word : input){
            int[] anagram = new int[26];
            for(char c : word.toCharArray()){
                anagram[c - 'a'] += 1;
            }
            String anagrm = getAnagramString(anagram);
            if(map.get(anagrm) == null) map.put(anagrm, new ArrayList<>());
            map.get(anagrm).add(word);
        }
        List<List<String>> output = new ArrayList<>();
        for(String anagram : map.keySet()){
            output.add(map.get(anagram));
        }
        return output;
    }
    public static String getAnagramString(int[] anagram){
        String anagrm = "";
        for(int num : anagram){
            anagrm += String.valueOf(num)+",";
        }
        return anagrm;
    }
}