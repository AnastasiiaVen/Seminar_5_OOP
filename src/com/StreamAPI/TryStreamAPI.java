package com.StreamAPI;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class TryStreamAPI {
    public static void main(String[] args) {

        List listOfString = new ArrayList<>(Arrays.asList("s1", "s2"));
        List listOfInt = new ArrayList<>(Arrays.asList(1, 2));

        System.out.println(getElement(listOfString, 0));
        System.out.println(getElement(listOfInt, 0));

        Repository<AudioContent> aC = new Repository<>("AC");
        Repository<VideoContent> vC = new Repository<>("VC");

        aC.addContent(new AudioContent("song1"));
        vC.addContent(new VideoContent("vid1"));

        aC.showRep();
        vC.showRep();
    }

    public static <U, V> U getElement(List<U> myList, V index){
        return myList.get((int) index);
    }
}
