package DTO;

import java.util.ArrayList;
import java.util.List;

public class TrieNode {
    public Character currentChar = null;
    public List<String> words = new ArrayList<>();
    public TrieNode[] children = new TrieNode[2];
    public List<String> leaf = null;
    public TrieNode(){
        words = new ArrayList<>();
        children = new TrieNode[2];
        leaf = new ArrayList<>();
    }
}
