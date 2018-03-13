
import java.util.HashMap;
import java.util.Map;

public class Trie {

    //Подкласс: узел дерева
    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean wordEnd;
    }

    //Инициализатор корневого узла
    TrieNode node = new TrieNode();


    //Добавление ключа в дерево
    public void put(String string) {
        TrieNode emptyNode = node;
        for (int i = 0; i <= string.length(); i++) {
            if (i == string.length()) {
                emptyNode.wordEnd = true;
            } else {
                if (!emptyNode.children.containsKey(string.charAt(i))) {
                    emptyNode.children.put(string.charAt(i), new TrieNode());
                }
                emptyNode = emptyNode.children.get(string.charAt(i));
            }
        }
    }

    //Нахождение ключа в дереве
    public boolean find(String string) {
        TrieNode emptyNode = node;
        for (int i = 0; i <= string.length(); i++) {
            if (i == (string.length())) {
                return emptyNode.wordEnd;
            } else {
                if (emptyNode.children.containsKey(string.charAt(i))) {
                    emptyNode = emptyNode.children.get(string.charAt(i));
                } else return false;
            }
        }
        return false;
    }

    //Удаление ключа из дерева
    public void delete(String string) {
        TrieNode emptyNode = node;
        for (int i = 0; i <= string.length(); i++) {
            if (i == string.length()) {
                emptyNode.wordEnd = false;
            } else {
                if (!emptyNode.children.containsKey(string.charAt(i))) {
                    break;
                } else emptyNode = emptyNode.children.get(string.charAt(i));
            }
        }
    }


    //Тестовая функция
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.put("hello");
        trie.put("hell");
        trie.put("house");
        trie.put("world");
        trie.delete("hell");
        System.out.println(trie.find("hell"));
        System.out.println(trie.find("hello"));
        System.out.println(trie.find("hel"));
    }
}