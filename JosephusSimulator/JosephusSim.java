
/*
 * Name: Mya Maxine Villa
 * Course: CS 143 - Fall 2026
 * Assignment: Program #5 - Josephus Problem
 *
 * Description:
 * Simulates the Josephus Problem using a linked list.
 * Names are read from a text file and stored in
 * PersonNode objects.
 *
 * Commit 2: Read names and build a singly linked list.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class JosephusSim {

    private PersonNode first;
    private int size;
    private int eliminationCount;

    /**
     * Reads names from a file and creates a
     * singly linked list of PersonNode objects.
     *
     * @param fileName the input file containing names
     */
    public JosephusSim(String fileName) {
        first = null;
        size = 0;

        PersonNode last = null;

        try {
            Scanner input = new Scanner(new File(fileName));

            while (input.hasNextLine()) {
                String name = input.nextLine().trim();

                if (!name.isEmpty()) {
                    PersonNode newNode = new PersonNode(name);

                    if (first == null) {
                        first = newNode;
                    } else {
                        last.next = newNode;
                    }

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
    }
}
