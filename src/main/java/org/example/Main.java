package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        String file = "D:\\Paradigme de Programare\\Paradigme\\Laborator5\\src\\fisierTest";

        try {
            // Citim din fisier
            List<String> lines = Files.readAllLines(Paths.get(file));

            // Afisam continutul fisierului
            for (String line : lines) {
                System.out.println(line);
            }
            System.out.println();
            // Sortam liniile si le afisam
            Collections.sort(lines);
            for (String line : lines) {
                System.out.println(line);
            }
            System.out.println();
            // Adaugam cuvintele in HashSet
            Set<String> words = new HashSet<>();
            for (String line : lines) {
                for (String word : line.split("\\s+")) {
                    words.add(word.toLowerCase());
                }
            }
            // Verificam daca exista cuvantul "mere" in HashSet
            if (words.contains("mere")) {
                System.out.println("Exista");
            } else {
                System.out.println("Nu exista");
            }
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }
}