import java.util.HashMap;
import java.util.Map;

public class CountCharacters {
    //拼写单词
    public int countCharacters(String[] words, String chars) {
        int len=0;
        Map<Character,Integer>charsConut=new HashMap<>();
        for(char ch:chars.toCharArray()){
            charsConut.put(ch,charsConut.getOrDefault(ch,0)+1);
        }
        for(String word:words){
            Map<Character,Integer>wordConut=new HashMap<>();
            for(char ch:word.toCharArray()){
                wordConut.put(ch,wordConut.getOrDefault(ch,0)+1);
            }
            boolean flag=true;
            for(char ch:word.toCharArray()){
                //如果没有该字母 或者 该字母出现次数大  不能拼成单词
                if(!charsConut.containsKey(ch)||wordConut.get(ch)>charsConut.get(ch)){
                    flag=false;
                    break;
                }
            }
            if(flag)
                len+=word.length();
        }
        return len;
    }
}
