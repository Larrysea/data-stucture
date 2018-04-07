package ninechapter.dfs;

import data_stucture.PrintUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 单词搜索II
 *
 * @author
 * @create 2018-04-07 下午4:43
 **/
public class WordSearchII {

    public static void main(String[] args) {
        String test = "afdaba";

        for (int i = 0; i < test.length(); i++) {
//            System.out.println(test.charAt(i) - 'a');
        }
        char[][] board = {{'d', 'o', 'a', 'f'}, {'a', 'g', 'a', 'i'}, {'d', 'c', 'a', 'n'}};
        List<String> word = new ArrayList<>();
        String[] strArray = {"dog", "dad", "dgdg", "can", "again"};
        for (int i = 0; i < 5; i++) {
            word.add(strArray[i]);
        }

        PrintUtil.printStringList(wordSearchII(board, word));
    }


    /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
    public static List<String> wordSearchII(char[][] board, List<String> words) {
        // write your code here

        //结题思路，通过将词典构建成一个trie tree 然后遍历棋盘，然后不停的查找，看是否可以查找到对应的单词，如果可以查找到，如果可以查找到则添加到结果中去，否则不做处理

        List<String> result = new ArrayList<>();

        if (board.length == 0 || board[0].length == 0 || words.size() == 0) {
            return result;
        }


        TrieTreeNode root = buildTree(words);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                helper(board, i, j, result, root);
            }
        }

        return result;
    }

    static class TrieTreeNode {
        //trie树节点
        TrieTreeNode[] next = new TrieTreeNode[26];

        String word;

    }

    //构建一棵树
    private static TrieTreeNode buildTree(List<String> word) {
        TrieTreeNode root = new TrieTreeNode();
        //尝试构建一棵树
        for (String str : word) {
            char[] array = str.toCharArray();
            TrieTreeNode node = root;
            for (char c : array) {
                int n = c - 'a';

                if (node.next[n] == null) {
                    //构建下一个孩子
                    node.next[n] = new TrieTreeNode();
                }

                //设置当前节点下移一层
                node = node.next[n];
            }
            //达到自叶子节点，设置单词
            node.word = str;
        }
        return root;
    }


    //查找
    private static void helper(char[][] board, int i, int j, List<String> result, TrieTreeNode node) {

        //范围检查
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return;
        }


        //如果已经访问过改点，或者是改点不在查找树上则返回
        char chess = board[i][j];
        if (chess == '#' || node.next[chess - 'a'] == null) {
            return;
        }

        //移动节点
        node = node.next[chess - 'a'];
        //标记为节点已经访问过
        board[i][j] = '#';
        //如果在该点有结果
        if (node.word != null) {
            result.add(node.word);
            //只允许使用一遍
            node.word = null;
        }


        //然后继续在四个方向上进行搜索

        helper(board, i + 1, j, result, node);
        helper(board, i - 1, j, result, node);
        helper(board, i, j + 1, result, node);
        helper(board, i, j - 1, result, node);

        board[i][j] = chess;

    }


}
