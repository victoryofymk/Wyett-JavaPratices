package algorithm;

import java.util.HashMap;

/**
 * @author yanmingkun
 * @date 2018-11-15 14:37
 */
public class TrieAlgoruthmTest {
    public static void main(String args[])  //Just used for test
    {
        TrieAlgoruthm trie = new TrieAlgoruthm();
        trie.insert("I");
        trie.insert("Love");
        trie.insert("China");
        trie.insert("China");
        trie.insert("China");
        trie.insert("China");
        trie.insert("China");
        trie.insert("xiaoliang");
        trie.insert("xiaoliang");
        trie.insert("man");
        trie.insert("handsome");
        trie.insert("love");
        trie.insert("chinaha");
        trie.insert("her");
        trie.insert("know");

        HashMap<String, Integer> map = trie.getAllWords();

        for (String key : map.keySet()) {
            System.out.println(key + " 出现: " + map.get(key) + "次");
        }


        map = trie.getWordsForPrefix("chin");

        System.out.println("\n\n包含chin（包括本身）前缀的单词及出现次数：");
        for (String key : map.keySet()) {
            System.out.println(key + " 出现: " + map.get(key) + "次");
        }

        if (trie.isExist("xiaoming") == false) {
            System.out.println("\n\n字典树中不存在：xiaoming ");
        }


    }
}
