package 添加与搜索单词_数据结构设计;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @TaskCode:
 * @description:
 * @author: minshuai.chen
 * @create: 2021/10/19 14:41
 **/
 public class WordDictionary {

    Map<Integer, Set<String>> map = new HashMap<>();

    public WordDictionary() {

    }

    public void addWord(String word) {
       int length = word.length();
       if (map.get(length) != null) {
          map.get(length).add(word);
       }else {
          Set<String> set = new HashSet<>();
          set.add(word);
          map.put(length, set);
       }
    }
 
    public boolean search(String word) {
       Set<String> set = map.get(word.length());
       if (set == null) {
          return false;
       }
       if (set.contains(word)){
          return true;
       }
       char[] chars = word.toCharArray();
       boolean s = false;
       for (String str : set) {
          char[] chars1 = str.toCharArray();
          for (int i = 0; i < chars1.length; i++) {
             if (chars[i] != '.' && chars[i] != chars1[i]) {
                s = true;
                break;
             }
          }
          if (s){
             s= false;
             continue;
          }
          set.add(word);
          return true;
       }
      return false;
    }

//   public boolean search(String word) {
//      Set<String> set = map.get(word.length());
//      if(set==null){  //不存在该长度的字符串，直接返回false；
//         return false;
//      }
//      if(set.contains(word)) return true;
//      char[] chars = word.toCharArray();
//      P:for(String s : set){
//         if(word.length()!=s.length()){
//            continue;
//         }
//         char[] cs = s.toCharArray();
//         for(int i = 0; i< cs.length; i++){//逐个字符对比
//            if(chars[i] != '.' && chars[i] != cs[i]){
//               continue P;
//            }
//         }
//         set.add(word);
//         return true;
//      }
//      return false;
//   }

   public static void main(String[] args) {
      WordDictionary wordDictionary = new WordDictionary();

      wordDictionary.addWord("bad");
      wordDictionary.addWord("dad");
      wordDictionary.addWord("mad");

//      boolean pad = wordDictionary.search("pad");// return False
//      System.out.println(pad);
//      boolean bad = wordDictionary.search("bad");// return True
//      System.out.println(bad);
//      boolean search = wordDictionary.search(".ad");// return True
//      System.out.println(search);
      boolean search1 = wordDictionary.search("b..");// return True
      System.out.println(search1);
//      boolean search2 = wordDictionary.search(".b");
//      System.out.println("ab" + search2);
//      boolean search3 = wordDictionary.search(".a");
//      System.out.println(".a" + search3);
//      boolean search4 = wordDictionary.search(".b");
//      System.out.println(".b" + search4);
//      boolean search5 = wordDictionary.search("ab.");
//      System.out.println("ab." + search5);
//      boolean search6 = wordDictionary.search(".");
//      System.out.println("." + search6);
//      boolean search7 = wordDictionary.search("..");
//      System.out.println(".." + search7);

   }
}
