package com.binary_tree.binary_tree.model;

import com.binary_tree.binary_tree.exception.BinaryTreeException;
import lombok.*;

@Data
@Getter
@Setter
@ToString
public class Node {
    private Boy data;
    private Node left;
    private Node right;

    public Node(Boy data) {
        this.data = data;
    }

    public boolean isLeaf()
    {
        return left ==null && right==null;
    }

    public void addNode(Boy data) throws BinaryTreeException
    {
        if(data.getIdentification() < this.getData().getIdentification())
        {
            if(this.getLeft()==null)
            {
                this.setLeft(new Node(data));
            }
            else
            {
                this.left.addNode(data);
            }
        }
        else if (data.getIdentification() > this.getData().getIdentification())
        {

            if(this.getRight()==null)
            {
                this.setRight(new Node(data));
            }
            else
            {

                this.right.addNode(data);
            }
        }
        else
        {
            throw new BinaryTreeException("Ya existe un niño con esa identificación");
        }

    }
}
