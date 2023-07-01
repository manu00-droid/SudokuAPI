package com.manav.sudoku.service;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class MoveValidity {
    private int valid_row(int row, Integer[][] grid) {
        Integer[] temp = grid[row];
        Set<Integer> set = new HashSet<Integer>();
        for (int value : temp) {
            // Checking for values outside 0 and 9;
            // 0 is considered valid because it
            // denotes an empty cell.
            // Removing zeros and the checking for values and
            // outside 1 and 9 is another way of doing
            // the same thing.
            if (value < 0 || value > 9) {
                System.out.println("Invalid value");
                return -1;
            }
            //Checking for repeated values.
            else if (value != 0) {
                if (!set.add(value)) {
                    return 0;
                }
            }
        }
        return 1;
    }

    // Function to check if a given column is valid. It will return:
    // -1 if the column contains an invalid value
    // 0 if the column contains repeated values
    // 1 is the column is valid.
    private int valid_col(int col, Integer[][] grid) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            // Checking for values outside 0 and 9;
            // 0 is considered valid because it
            // denotes an empty cell.
            // Removing zeros and the checking for values and
            // outside 1 and 9 is another way of doing
            // the same thing.
            if (grid[i][col] < 0 || grid[i][col] > 9) {
                System.out.println("Invalid value");
                return -1;
            }
            // Checking for repeated values.
            else if (grid[i][col] != 0) {
                if (!set.add(grid[i][col])) {
                    return 0;
                }
            }
        }
        return 1;
    }

    // Function to check if all the subsquares are valid. It will return:
    // -1 if a subsquare contains an invalid value
    // 0 if a subsquare contains repeated values
    // 1 if the subsquares are valid.
    private int valid_subsquares(Integer[][] grid) {
        for (int row = 0; row < 9; row = row + 3) {
            for (int col = 0; col < 9; col = col + 3) {
                Set<Integer> set = new HashSet<Integer>();
                for (int r = row; r < row + 3; r++) {
                    for (int c = col; c < col + 3; c++) {
                        // Checking for values outside 0 and 9;
                        // 0 is considered valid because it
                        // denotes an empty cell.
                        // Removing zeros and the checking for values and
                        // outside 1 and 9 is another way of doing
                        // the same thing.
                        if (grid[r][c] < 0 || grid[r][c] > 9) {
                            System.out.println("Invalid value");
                            return -1;
                        }
                        // Checking for repeated values.
                        else if (grid[r][c] != 0) {
                            if (!set.add(grid[r][c])) {
                                return 0;
                            }
                        }
                    }
                }
            }
        }
        return 1;
    }

    //Function to check if the board invalid.
    public boolean valid_board(Integer[][] grid) {
        // Checking the rows and columns.
        for (int i = 0; i < 9; i++) {
            int res1 = valid_row(i, grid);
            int res2 = valid_col(i, grid);
            // if a row or column is invalid, then the board is invalid.
            if (res1 < 1 || res2 < 1) {
                System.out.println("The board is invalid.");
                return false;
            }
        }
        int res3 = valid_subsquares(grid);
        // if any one the subsquares is invalid, then the board is invalid.
        if (res3 < 1) {
            System.out.println("The board is invalid.");
            return false;
        } else {
            System.out.println("The board is valid.");
            return true;
        }
    }
}
