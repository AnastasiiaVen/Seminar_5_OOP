package com.day09;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FillFamily {

    public static void fillPersons(Family family, String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String s;
            String[] temp;
            while ((s = br.readLine()) != null) {
                temp = s.split(" ");
                family.addFamilyMember(new Person(temp[0], temp[1], Integer.parseInt(temp[2])));
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void fillRelations(Family family, String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String s;
            String[] temp;
            while ((s = br.readLine()) != null) {
                temp = s.split(" ");
                family.parentToChildRelation(new Person(temp[0], temp[1]), new Person(temp[2], temp[3]));
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
