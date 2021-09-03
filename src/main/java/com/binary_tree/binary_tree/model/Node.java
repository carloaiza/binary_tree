package com.binary_tree.binary_tree.model;

import com.binary_tree.binary_tree.controller.dto.BoyGradeDTO;
import com.binary_tree.binary_tree.exception.BinaryTreeException;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
@ToString
public class Node {
    private Boy data;
    private Node left;
    private Node right;
    private int grade;

    public Node(Boy data) {
        this.data = data;
        this.grade=1;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }

    public void addNode(Boy data) throws BinaryTreeException {
        if (data.getIdentification() < this.getData().getIdentification()) {
            if (this.getLeft() == null) {
                this.setLeft(new Node(data));
            } else {
                this.left.addNode(data);
            }
            this.calculateGrade();
        } else if (data.getIdentification() > this.getData().getIdentification()) {

            if (this.getRight() == null) {
                this.setRight(new Node(data));
            } else {

                this.right.addNode(data);
            }
            this.calculateGrade();
        } else {
            throw new BinaryTreeException("Ya existe un niño con esa identificación");
        }

    }

    public List<Boy> preOrden() {
        List<Boy> listBoys = new ArrayList<>();
        listBoys.add(this.getData());
        if (this.getLeft() != null) {
            listBoys.addAll(this.getLeft().preOrden());
        }
        if (this.getRight() != null) {
            listBoys.addAll(this.getRight().preOrden());
        }
        return listBoys;
    }

    public List<Boy> inOrden() {
        List<Boy> listBoys = new ArrayList<>();
        if (this.getLeft() != null) {
            listBoys.addAll(this.getLeft().inOrden());
        }
        listBoys.add(this.getData());
        if (this.getRight() != null) {
            listBoys.addAll(this.getRight().inOrden());
        }
        return listBoys;
    }

    public List<Boy> postOrden()
    {
        List<Boy> listBoys = new ArrayList<>();
        if (this.getLeft() != null) {
            listBoys.addAll(this.getLeft().postOrden());
        }
        if (this.getRight() != null) {
            listBoys.addAll(this.getRight().postOrden());
        }
        listBoys.add(this.getData());
        return listBoys;
    }

    public void prune()
    {
        if(this.getRight()!=null)
        {
            if(this.getRight().isLeaf())
            {
                this.setRight(null);
            }
            else
            {
                this.getRight().prune();
            }
        }
        if(this.getLeft()!=null)
        {
            if(this.getLeft().isLeaf())
            {
                this.setLeft(null);
            }
            else
            {
                this.getLeft().prune();
            }
        }
    }

    public int calculateGrade()
    {
        int gradeLeft= this.getLeft()!=null ? this.getLeft().getGrade():0;
        int gradeRight= this.getRight()!=null ? this.getRight().getGrade():0;
        this.grade= gradeLeft >= gradeRight ? 1+ gradeLeft: 1 + gradeRight;
        return this.grade;
    }

    public List<BoyGradeDTO> getBoysGrade() {
        List<BoyGradeDTO> listBoys = new ArrayList<>();
        listBoys.add(new BoyGradeDTO(this.getData(),this.grade));
        if (this.getLeft() != null) {
            listBoys.addAll(this.getLeft().getBoysGrade());
        }
        if (this.getRight() != null) {
            listBoys.addAll(this.getRight().getBoysGrade());
        }
        return listBoys;
    }

    public List<Boy> getBoysByLevel(int searchLevel, int yourLevel)
    {
           List<Boy> listBoysLevel= new ArrayList<>();
           if(this.isLeaf())
                return listBoysLevel;

           if(searchLevel == yourLevel+1)
           {

               if(this.getLeft()!=null)
               {
                   listBoysLevel.add(this.getLeft().getData());
               }
               if(this.getRight()!=null)
               {
                   listBoysLevel.add(this.getRight().getData());
               }
           }
           else
           {
               if(this.getLeft()!=null)
               {
                    listBoysLevel.addAll(this.getLeft().getBoysByLevel(searchLevel,yourLevel+1));
               }
               if(this.getRight()!=null)
               {
                   listBoysLevel.addAll(this.getRight().getBoysByLevel(searchLevel,yourLevel+1));
               }
           }
           return listBoysLevel;
    }
}
