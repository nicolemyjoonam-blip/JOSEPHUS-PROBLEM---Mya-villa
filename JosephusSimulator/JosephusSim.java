
/*
 * Name: Mya Maxine Villa
 * Course: CS 143 - Fall 2026
 * Assignment: Program #5 - Josephus Problem
 *
 * Description:
 * Simulates the Josephus Problem using a linked list.
 * Reads names from a file and puts them into a circle.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;

public class JosephusSim {

    private PersonNode first;
    private int size;
    private int eliminationCount;

    // read names from file and make the linked list
    public JosephusSim(String fileName) {
        first = null;
        size = 0;

        PersonNode last = null;

        try {
            Scanner input = new Scanner(new File(fileName));

            // go through each name in the file
            while (input.hasNextLine()) {
                String name = input.nextLine().trim();

                if (!name.isEmpty()) {

                    // make a new node for each person
                    PersonNode newNode = new PersonNode(name);

                    if (first == null) {
                        first = newNode;
                    } else {
                        last.next = newNode;
                    }

                    // update last node and size
                    last = newNode;
                    size++;
                }
            }

            input.close();

        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException(
                "File not found: " + fileName, e
            );
        }

        // check if the file is empty
        if (size == 0) {
            throw new IllegalArgumentException(
                "The file must contain at least one name."
            );
        }

        // connect last node back to the first
        last.next = first;

        // pick a random elimination count
        Random random = new Random();

        eliminationCount = random.nextInt(
            Math.max(1, size / 2)
        ) + 1;

        // print elimination count
        System.out.println(
            "=== Elimination count is " +
            eliminationCount + " ==="
        );
    }
}
