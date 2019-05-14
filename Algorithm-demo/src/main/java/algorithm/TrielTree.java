package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 关键字匹配查询
 *
 * @author yanmingkun
 * @date 2018-11-15 14:45
 */
public class TrielTree {
    private Node root;///树根

    public TrielTree() {
        ///初始化trie 树
        root = new Node();
    }

    private class Node {
        /**
         * 出现的主键
         */
        private List<String> ids;
        /**
         * 出现的次数
         */
        private int count;
        /**
         * 字符
         */
        private char ch;

        /**
         * 子节点
         */
        private Node[] children;

        private HashMap<String, Node> childrenNodes;

        public Node() {
            count = 1;
            children = new Node[26];
            childrenNodes = new HashMap<>();
        }

        public Node(String id, char ch, int count) {
            this.ids = new ArrayList<>();
            ids.add(id);
            this.ch = ch;
            this.count = count;
            children = new Node[26];
            childrenNodes = new HashMap<>();
        }

        public void share(String id) {
            this.ids.add(id);
        }
    }

    public void insertArray(List<HashMap<String, String>> list, String identifyKey) {
        list.forEach(item -> insertArrayNode(item, identifyKey));
    }

    public void insertMap(List<HashMap<String, String>> list, String identifyKey) {
        list.forEach(item -> insertMapNode(item, identifyKey));
    }

    /**
     * 使用数组插入字典树
     *
     * @param hashMap
     * @param identifyKey
     */
    public void insertArrayNode(HashMap<String, String> hashMap, String identifyKey) {
        Node tempNode = this.root;
        String identifyValue = hashMap.get(identifyKey);
        for (String itemValue : hashMap.values()) {
            char[] strs = itemValue.toLowerCase().toCharArray();
            for (int i = 0; i < strs.length; i++) {
                int index = strs[i] - 'a';
                if (tempNode.children[index] == null) {
                    tempNode.children[index] = new Node(identifyValue, strs[i], 1);

                    tempNode = tempNode.children[index];
                } else {
                    tempNode.count++;
                    if (i != strs.length - 1) {
                        tempNode.children[index].share(identifyValue);
                    }
                    tempNode = tempNode.children[index];
                }
            }
        }

    }

    /**
     * 使用嗯数组插入字典树
     *
     * @param hashMap
     * @param identifyKey
     */
    public void insertMapNode(HashMap<String, String> hashMap, String identifyKey) {
        Node tempNode = this.root;
        String identifyValue = hashMap.get(identifyKey);
        for (String itemValue : hashMap.values()) {
            char[] strs = itemValue.toLowerCase().toCharArray();
            for (int i = 0; i < strs.length; i++) {
                if (tempNode.childrenNodes.get(String.valueOf(strs[i])) == null) {
                    tempNode.childrenNodes.put(String.valueOf(strs[i]), new Node(identifyValue, strs[i], 1));

                    tempNode = tempNode.childrenNodes.get(String.valueOf(strs[i]));
                } else {
                    tempNode.count++;
                    if (i != strs.length - 1) {
                        tempNode.childrenNodes.get(String.valueOf(strs[i])).share(identifyValue);
                    }
                    tempNode = tempNode.childrenNodes.get(String.valueOf(strs[i]));
                }
            }
        }

    }

    /**
     * 根据关键字查找
     *
     * @param str
     * @return
     */
    public List<String> searchArrayKey(String str) {
        char[] strs = str.toCharArray();
        Node tempNode = this.root;
        for (int i = 0; i < strs.length; i++) {
            int index = strs[i] - 'a';
            if (tempNode.children[index] != null) {
                tempNode = tempNode.children[index];
            } else {
                break;
            }

            if (i == strs.length - 1) {
                return tempNode.ids;
            }
        }
        return new ArrayList<>();
    }

    /**
     * 根据关键字查找
     *
     * @param str
     * @return
     */
    public List<String> searchMapKey(String str) {
        char[] strs = str.toCharArray();
        Node tempNode = this.root;
        for (int i = 0; i < strs.length; i++) {
            int index = strs[i] - 'a';
            if (tempNode.childrenNodes.get(String.valueOf(strs[i])) != null) {
                tempNode = tempNode.childrenNodes.get(String.valueOf(strs[i]));
            } else {
                break;
            }

            if (i == strs.length - 1) {
                return tempNode.ids;
            }
        }
        return new ArrayList<>();
    }

}
