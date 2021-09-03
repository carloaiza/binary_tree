package com.binary_tree.binary_tree.controller;

import com.binary_tree.binary_tree.exception.BinaryTreeException;
import com.binary_tree.binary_tree.exception.DataNotFoundException;
import com.binary_tree.binary_tree.model.Boy;
import com.binary_tree.binary_tree.service.BinaryTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "binarytree")
@Validated
public class BinaryTreeController {

    @Autowired
    private BinaryTreeService binaryTreeService;

    @PostMapping
    public @ResponseBody
    ResponseEntity<?> addBoy(@Valid @RequestBody Boy boy) throws BinaryTreeException {
        return binaryTreeService.addBoy(boy);
    }

    @GetMapping("/preorden")
    public @ResponseBody
    ResponseEntity<?> listBoysPreOrden() throws DataNotFoundException {
        return binaryTreeService.listBoys(1);
    }

    @GetMapping("/inorden")
public @ResponseBody
ResponseEntity<?> listBoysInOrden() throws DataNotFoundException {
    return binaryTreeService.listBoys(2);
}

    @GetMapping("/postorden")
    public @ResponseBody
    ResponseEntity<?> listBoysPostOrden() throws DataNotFoundException {
        return binaryTreeService.listBoys(3);
    }

    @GetMapping("/prune")
    public @ResponseBody
    ResponseEntity<?> prune() throws DataNotFoundException {
        return binaryTreeService.prune();
    }

    @GetMapping("/boysgrade")
    public @ResponseBody
    ResponseEntity<?> getBoysGrade() throws DataNotFoundException {
        return binaryTreeService.getBoysGrade();
    }

    @GetMapping("/{level}")
    public @ResponseBody
    ResponseEntity<?> getBoysByLevel(@PathVariable int level) throws DataNotFoundException,BinaryTreeException {
        return binaryTreeService.getBoysByLevel(level);
    }

}
