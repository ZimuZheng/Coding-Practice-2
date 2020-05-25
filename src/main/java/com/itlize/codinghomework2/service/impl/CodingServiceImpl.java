package com.itlize.codinghomework2.service.impl;

import com.itlize.codinghomework2.service.CodingService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.*;

@Service
public class CodingServiceImpl implements CodingService {

    @Override
    public ResponseEntity<?> codingTestOne(String number) {
        Integer value = Integer.parseInt(number);
        int sum = 0;
        String[] digits = number.split("");
        for (int i=0; i<digits.length; i++) {
            sum += (int) Math.pow(Integer.parseInt(digits[i]),digits.length);
        }
        if (sum == value.intValue()) {
            return ResponseEntity.ok("True");
        } else {
            return ResponseEntity.ok("False");
        }
    }

    private static final int[] ARR = new int[]{0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4};
    @Override
    public ResponseEntity<?> codingTestTwo(String path) throws IOException {
        String pathname = path;
        File filename = new File(pathname);
        InputStreamReader reader = new InputStreamReader(
                new FileInputStream(filename));
        BufferedReader br = new BufferedReader(reader);
        String line = "";
        line = br.readLine();
        int number;
        List<Integer> anwser = new ArrayList<Integer>();
        while (line != null) {
            number = Integer.parseInt(line);
            line = br.readLine();
            int result = 0;
            while(Math.abs(number) > 0 || number == Integer.MIN_VALUE)
            {
                result += this.ARR[number & 0xF];
                number >>>= 4;
            }
            anwser.add(result);
        }
        return ResponseEntity.ok(anwser);
    }

    @Override
    public ResponseEntity<?> codingTestThree(String path) throws IOException {
        String pathname = path;
        File filename = new File(pathname);
        InputStreamReader reader = new InputStreamReader(
                new FileInputStream(filename));
        BufferedReader br = new BufferedReader(reader);
        String line = "";
        line = br.readLine();

        Map<String,Integer> map = new HashMap<String,Integer>();
        List<Integer> counts = new ArrayList<Integer>();
        List<Integer> answer = new ArrayList<Integer>();
        while (line != null) {
            line = line.toLowerCase();
            line.replace(" ","");
            String[] letters = line.split("");
            for (int i=0; i<letters.length; i++) {
                if (map.containsKey(letters[i])){
                    Integer key = map.get(letters[i]);
                    counts.set(map.get(letters[i]).intValue(),counts.get(map.get(letters[i]))+1);
                } else {
                    if (letters[i].matches("[a-zA-Z]")){
                        map.put(letters[i],counts.size());
                        counts.add(1);
                    } else {
                        continue;
                    }

                }
            }
            counts.sort(Comparator.comparingInt(o -> o));
            int value = 26;
            int sum = 0;
            for(int i=counts.size(); i>0; i--) {
                sum += counts.get(i-1)*value;
                value -= 1;
            }
            counts.clear();
            map.clear();
            answer.add(sum);
            line = br.readLine();
        }
        return ResponseEntity.ok(answer);
    }


    public static final String[] line1 = new String[]{"-**--","--*--","***--","***--","-*---","****-","-**--","****-","-**--","-**--"};
    public static final String[] line2 = new String[]{"*--*-","-**--","---*-","---*-","*--*-","*----","*----","---*-","*--*-","*--*-"};
    public static final String[] line3 = new String[]{"*--*-","--*--","-**--","-**--","****-","***--","***--","--*--","-**--","-***-"};
    public static final String[] line4 = new String[]{"*--*-","--*--","*----","---*-","---*-","---*-","*--*-","-*---","*--*-","---*-"};
    public static final String[] line5 = new String[]{"-**--","-***-","****-","***--","---*-","***--","-**--","-*---","-**--","--**-"};

    @Override
    public ResponseEntity<?> codingTestFour(String path) throws IOException {
        String pathname = path;
        File filename = new File(pathname);
        InputStreamReader reader = new InputStreamReader(
                new FileInputStream(filename));
        BufferedReader br = new BufferedReader(reader);
        String line = "";
        line = br.readLine();

        StringBuilder printLine1 = new StringBuilder();
        StringBuilder printLine2 = new StringBuilder();
        StringBuilder printLine3 = new StringBuilder();
        StringBuilder printLine4 = new StringBuilder();
        StringBuilder printLine5 = new StringBuilder();
        StringBuilder separator = new StringBuilder();

        while (line != null) {
            String[] numbers = line.split("");
            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i].matches("[0-9]")) {
                    Integer index = Integer.parseInt(numbers[i]);
                    printLine1.append(this.line1[index]);
                    printLine2.append(this.line2[index]);
                    printLine3.append(this.line3[index]);
                    printLine4.append(this.line4[index]);
                    printLine5.append(this.line5[index]);
                    separator.append("-----");
                }
            }
            System.out.println(printLine1);
            System.out.println(printLine2);
            System.out.println(printLine3);
            System.out.println(printLine4);
            System.out.println(printLine5);
            System.out.println(separator);
            printLine1.setLength(0);
            printLine2.setLength(0);
            printLine3.setLength(0);
            printLine4.setLength(0);
            printLine5.setLength(0);
            separator.setLength(0);
            line = br.readLine();
        }
        return ResponseEntity.ok("Print Success!");
    }

    @Override
    public ResponseEntity<?> codingTestFive(String path) throws IOException {
        String pathname = path;
        File filename = new File(pathname);
        InputStreamReader reader = new InputStreamReader(
                new FileInputStream(filename));
        BufferedReader br = new BufferedReader(reader);
        String line = "";
        line = br.readLine();
        List<String> anwser = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        Boolean jolly = true;
        while (line != null) {
            String[] numbers = line.split(" ");
            if (Integer.parseInt(numbers[0]) == 1) {
                anwser.add("Jolly");
                System.out.println("Jolly");
            } else {
                for (int i=2; i<numbers.length; i++) {
                    Integer difference = Integer.parseInt(numbers[i])-Integer.parseInt(numbers[i-1]);
                    if (difference<0) {
                        difference = -difference;
                    }

                    if (difference == 0 || difference >= Integer.parseInt(numbers[0]) || map.containsKey(difference)) {
                        jolly = false;
                        break;
                    } else {
                        map.put(difference,1);
                    }
                }
                if (jolly) {
                    anwser.add(("Jolly"));
                    System.out.println("Jolly");
                } else {
                    anwser.add("Not Jolly");
                    System.out.println("Not Jolly");
                }
            }
            map.clear();
            jolly = true;
            line = br.readLine();
        }
        return ResponseEntity.ok(anwser);
    }
}