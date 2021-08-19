package com.binary_tree.binary_tree.service;

import com.binary_tree.binary_tree.application.dto.ResponseBinaryTreeDto;
import com.binary_tree.binary_tree.controller.dto.ErrorDTO;
import com.binary_tree.binary_tree.exception.BinaryTreeException;
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
        //try {
            binaryTree.addNode(boy);
            return new ResponseEntity<>(
                    new ResponseBinaryTreeDto(boy,"Se ha guardado exitosamente",
                            null),HttpStatus.OK);
        /*} catch (BinaryTreeException e) {
            List<ErrorDTO> errors = new ArrayList<>();
            errors.add(new ErrorDTO(HttpStatus.CONFLICT.value(), e.getMessage()));
            return new ResponseEntity<ResponseBinaryTreeDto>(
                    new ResponseBinaryTreeDto(boy,null,errors
                            ),HttpStatus.CONFLICT);
        }

         */
    }
}
