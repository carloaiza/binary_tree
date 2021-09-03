package com.binary_tree.binary_tree.service;

import com.binary_tree.binary_tree.application.dto.ResponseBinaryTreeDto;
import com.binary_tree.binary_tree.controller.dto.ErrorDTO;
import com.binary_tree.binary_tree.exception.BinaryTreeException;
import com.binary_tree.binary_tree.exception.DataNotFoundException;
import com.binary_tree.binary_tree.model.BinaryTree;
import com.binary_tree.binary_tree.model.Boy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BinaryTreeService {
    private BinaryTree binaryTree= new BinaryTree();


    public ResponseEntity<ResponseBinaryTreeDto> addBoy(Boy boy) throws BinaryTreeException
    {
        binaryTree.addNode(boy);
            return new ResponseEntity<>(
                    new ResponseBinaryTreeDto(boy,"Se ha guardado exitosamente",
                            null),HttpStatus.OK);
    }

    public ResponseEntity<ResponseBinaryTreeDto> listBoys(int which) throws DataNotFoundException
    {
        return new ResponseEntity<ResponseBinaryTreeDto>(
          new ResponseBinaryTreeDto(binaryTree.listBoys(which),"Success", null)
                ,HttpStatus.OK
        );
    }

    public ResponseEntity<ResponseBinaryTreeDto> prune() throws DataNotFoundException
    {
        return new ResponseEntity<ResponseBinaryTreeDto>(
                new ResponseBinaryTreeDto(binaryTree.prune(),"Success", null)
                ,HttpStatus.OK
        );
    }

    public ResponseEntity<ResponseBinaryTreeDto> getBoysGrade() throws DataNotFoundException
    {
        return new ResponseEntity<ResponseBinaryTreeDto>(
                new ResponseBinaryTreeDto(binaryTree.getBoysGrade(),"Success", null)
                ,HttpStatus.OK
        );
    }

    public ResponseEntity<ResponseBinaryTreeDto> getBoysByLevel(int searchLevel) throws DataNotFoundException,BinaryTreeException
    {
        return new ResponseEntity<ResponseBinaryTreeDto>(
                new ResponseBinaryTreeDto(binaryTree.getBoysByLevel(searchLevel),"Success", null)
                ,HttpStatus.OK
        );
    }
}
