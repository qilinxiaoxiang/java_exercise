package com.wsbo.demo.testcase;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Achievements {
    @Test
    public void testAchievements() {
        String standardFile = "C:\\Users\\wq551\\Desktop\\achievements.txt";
        String selfFile = "C:\\Users\\wq551\\Desktop\\achievements_already_get.txt";
        List<String> achievements = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(new File(standardFile)));) {
            String line;
            while ((line = br.readLine()) != null) {
                achievements.add(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        List<String> alreadyGet = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(new File(selfFile)));) {
            String line;
            int index = 1;
            while ((line = br.readLine()) != null) {
                if (index % 4 == 2) {
                    alreadyGet.add(line);
                }
                index++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        int index = 1;
        for (String achievement : achievements) {
            if (!alreadyGet.contains(achievement)) {
                System.out.println(index + ". " + achievement);
            }
            index++;
        }
    }
}
