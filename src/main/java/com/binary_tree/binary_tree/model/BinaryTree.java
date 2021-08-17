package com.binary_tree.binary_tree.model;

import com.binary_tree.binary_tree.exception.BinaryTreeException;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BinaryTree {
    private Node root;
    private int grade;
    private int count;

    public void addNode(Boy data) throws BinaryTreeException
    {
        if(root==null)
        {
            root = new Node(data);
        }
        else
        {
            root.addNode(data);
        }
    }



}
