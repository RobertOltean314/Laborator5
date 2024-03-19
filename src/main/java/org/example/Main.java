package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    static String filePath = "D:\\Paradigme de Programare\\Paradigme\\Laborator5\\src\\fisierTest";

    public static void afiseaza(List<String> list) {
        File file = new File(filePath);
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
                list.add(line);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filePath);
        }
    }

    public static void sorteaza(List<String> list) {
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
    }

    public static void gasesteCuvant(List<String> list, String cuvantCautat) {
        // Adaugam cuvintele in HashSet
        Set<String> words = new HashSet<>();
        for (String line : list) {
            for (String word : line.split("\\s+")) {
                words.add(word.toLowerCase());
            }
        }
        // Verificam daca exista cuvantul "mere" in HashSet
        if (words.contains(cuvantCautat.toLowerCase())) {
            System.out.println("Exista");
        } else {
            System.out.println("Nu exista");
        }
    }

    public static void main(String[] args) {

        List<String> lines = new ArrayList<>();
        String cautat = "mere";

        afiseaza(lines);
        System.out.println();
        sorteaza(lines);
        System.out.println();
        afiseaza(lines);
        gasesteCuvant(lines, cautat);

    }
}