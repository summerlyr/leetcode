import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PalindromePairs {

	public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if(words.length<=1) return res;
        Map<String,Integer> map = new HashMap<String,Integer>();
        for(int i=0;i<words.length;i++) {
            map.put(words[i],i);
        }
        for(int i=0;i<words.length;i++) {
            for(int j=0;j<=words[i].length();j++) {
                String str1 = words[i].substring(0,j);
                String str2 = words[i].substring(j);
                if(isPar(str1)) {
                    String str2res = new StringBuilder(str2).reverse().toString();
                    if(map.containsKey(str2res)&&map.get(str2res)!=i) {
                        List<Integer> list = new LinkedList<Integer>();
                        list.add(map.get(str2res));
                        list.add(i);
                        res.add(list);
                    }
                }
                if(isPar(str2)) {
                    String str1res = new StringBuilder(str1).reverse().toString();
                    if(map.containsKey(str1res)&&map.get(str1res)!=i&&str2.length()!=0) {
                        List<Integer> list = new LinkedList<Integer>();
                        list.add(i);
                        list.add(map.get(str1res));
                        res.add(list);
                    }
                }
            }
        }
        return res;
    }
    public boolean isPar(String str) {
        int left = 0;
        int right = str.length()-1;
        while(left<right) {
            if(str.charAt(left++)!=str.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

}
