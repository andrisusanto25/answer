package com.example.demo.app;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * The answer java basic B
 */
public class TextManipulation {
    public static void main(String[] args) {
        String in = "Saya sedang Belajar Bahasa PemOgraman JAVA";
        StringBuilder string = new StringBuilder();
        for (int i=0; i<in.length(); i++) {
            char let = in.charAt(i);
            if (Character.isLowerCase(let)) {
                string.append(Character.toUpperCase(let));
            } else {
                string.append(Character.toLowerCase(let));
            }
        }

        System.out.println("Balik Case :" + string);
        System.out.println("Hapus Huruf Vocal : " + in.replaceAll("[aeiouAEIOU]", ""));

        String text = "Since 1995, Java has changed our world ... and our expectations..  " +
                "Today, with technology such a part of our daily lives, we take it for granted that we can be connected and access applications and content anywhere, anytime. Because of Java, we expect digital devices to be smarter, more functional, and way more entertaining. " +
                "In the early 90s, extending the power of network computing to the activities of everyday life was a radical vision. " +
                "In 1991, a small group of Sun engineers called the \"Green Team\" believed that the next wave in computing was the union of digital consumer devices and computers. Led by James " +
                "Gosling, the team worked around the clock and created the programming language that would revolutionize our world – Java.  The Green Team demonstrated their new language with an interactive, handheld home-entertainment controller that was originally targeted at the digital cable television industry. " +
                "Unfortunately, the concept was much too advanced for the them at the time. But it was just right for the Internet, which was just starting to take off. In 1995, the team announced that the Netscape Navigator Internet browser would incorporate Java technology. " +
                "Today, Java not only permeates the Internet, but also is the invisible force behind many of the applications and devices that power our day-to-day lives. From mobile phones to handheld devices, games and navigation systems to e-business solutions, Java is everywhere!";

        text = text.toLowerCase().replaceAll("[^a-z A-Z]", "").replaceAll(" +", " ");
        String[] textArray = text.trim().split(" ");
        List<String> wordList = Arrays.asList(textArray);
        Map<String, Long> collect = wordList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        LinkedHashMap<String, Long> countByWordSorted = collect.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (v1, v2) -> {
                            throw new IllegalStateException();
                        },
                        LinkedHashMap::new
                ));

        Map.Entry<String, Long> maxEntry = null;
        int total = 0;
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Long> entry : countByWordSorted.entrySet()) {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                maxEntry = entry;
            }
            if (entry.getValue() == 1L) {
                total++;
                list.add(entry.getKey());
            }
        }
        System.out.println("Jumlah kata : " + countByWordSorted.size());
        System.out.println("Jumlah kemunculan tiap kata : " + countByWordSorted);
        System.out.println("Jumlah kata yang muncul 1 kali : " + total);
        System.out.println("Jumlah kata yang paling banyak muncul : " + maxEntry);
        System.out.println("Kata yang paling sedikit muncul : " + list.toString());
    }
}