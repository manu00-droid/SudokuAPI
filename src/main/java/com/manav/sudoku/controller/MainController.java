package com.manav.sudoku.controller;

import com.manav.sudoku.service.MoveValidity;
import com.manav.sudoku.service.SudokuSkeletonCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/sudoku")
public class MainController {

    @Autowired
    SudokuSkeletonCreator skeletonCreator;

    @Autowired
    MoveValidity moveValidity;

    @GetMapping("/new")
    public int[][] getGrid() {
        return skeletonCreator.generate();
    }

    @PostMapping("/move")
    public boolean isValidMove(@RequestBody Map<String, Integer[][]> map) {
        return moveValidity.valid_board(map.get("board"));
    }
}