/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dell
 */
public class Score implements Serializable {

    private String name;
    private String timeplay;
    private long score;
    private int sumHit;
    private int sumMiss;
    private int level;
    private boolean result;
    private static final String fileName = "src\\Data\\score.txt";

    public Score() {
    }

    public Score(String name, String timeplay, long score, int sumHit, int sumMiss, int level) {
        this.name = name;
        this.timeplay = timeplay;
        this.score = score;
        this.sumHit = sumHit;
        this.sumMiss = sumMiss;
        this.level = level;
    }

    public Score(String name, String timeplay, long score, int sumHit, int sumMiss, int level, boolean result) {
        this.name = name;
        this.timeplay = timeplay;
        this.score = score;
        this.sumHit = sumHit;
        this.sumMiss = sumMiss;
        this.level = level;
        this.result = result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTimeplay() {
        return timeplay;
    }

    public void setTimeplay(String timeplay) {
        this.timeplay = timeplay;
    }

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }

    public int getSumHit() {
        return sumHit;
    }

    public void setSumHit(int sumHit) {
        this.sumHit = sumHit;
    }

    public int getSumMiss() {
        return sumMiss;
    }

    public void setSumMiss(int sumMiss) {
        this.sumMiss = sumMiss;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Score{" + "name=" + name + ", timeplay=" + timeplay + ", score=" + score + ", sumHit=" + sumHit + ", sumMiss=" + sumMiss + ", level=" + level + ", result=" + result + '}';
    }

    public void WriteFile(List<Score> scores){
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(scores);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
//        try (ObjectOutputStream outputStream = new ObjectOutputStream(
//                new BufferedOutputStream(
//                        new FileOutputStream(fileName))); OutputStreamWriter streamWriter = new OutputStreamWriter(
//                outputStream, StandardCharsets.UTF_8)) {
//            for (Score object : scores) {
//                outputStream.writeObject(object);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        /*try (Writer writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(fileName), StandardCharsets.UTF_8))) {
            for (Score obj : scores) {
                writer.write(obj.toString());
                writer.write(System.lineSeparator());
            }
        } */

    }

    public List<Score> ReadFile(){
        List<Score> scores = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            scores = (List<Score>) ois.readObject();
            ois.close();
//            for (Score score : scores) {
//                System.out.println(score.getName() + " " + score.getTimeplay() + " " + score.getScore() + " " + score.getSumHit() + " " + score.getSumMiss() + " " + score.getLevel());
//            }
        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
        }
        return scores;

//        String fileName = "src\\Data\\score.txt";
//        try (ObjectInputStream inputStream = new ObjectInputStream(
//                new BufferedInputStream(
//                        new FileInputStream(fileName,))); InputStreamReader streamReader = new InputStreamReader(
//                inputStream, StandardCharsets.UTF_8)) {
//            while (true) {
//                try {
//                    Score object = (Score) inputStream.readObject();
//                    scores.add(object);
//                } catch (EOFException e) {
//                    break;
//                }
//            }
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
        /*List<Score> scores = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.isEmpty()) {
                    String[] fields = line.split(",");
                    for(String i: fields)
                    {
                        System.out.println(i);
                    }
                    String name = fields[0];
                    String timeplay = fields[1];
                    long score = Long.parseLong((fields[2].substring(fields[2].indexOf("=") + 1)));
                    int sumHit = Integer.parseInt(fields[3].substring(fields[3].indexOf("=") + 1));
                    int sumMiss = Integer.parseInt(fields[4].substring(fields[4].indexOf("=") + 1));
                    int level = Integer.parseInt(fields[5].substring(fields[5].indexOf("=") + 1,fields[5].indexOf("}")));
                    Score scoreObj = new Score(name, timeplay, score, sumHit, sumMiss, level);
                    scores.add(scoreObj);
                }
            } 
        } */
//        return scores;
    }

    public static void main(String[] args){
//        Score c = new Score();
//        List<Score> scores = new ArrayList<>();
//        scores.add(new Score("Xuân Diệu", "2023-02-26 09:00", 5000, 10, 2, 1));
//        scores.add(new Score("Xuân Diệu2222", "2023-02-26 09:00", 3000, 10, 2, 1));
//        c.WriteFile(scores);
//        List<Score> objectsToRead = c.ReadFile();
//        for (Score object : objectsToRead) {
//            System.out.println(object.toString());
//        }
    }
}
