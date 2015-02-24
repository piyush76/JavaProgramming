package com.piyush.learning.datastructure.stringProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class SingleThreadedSolution {

    public static void main(String[] args) {
        testProblemWithSample1();

        testProblemWithSample2();

        //testProblemWithInputFile("/home/kdeb/win_C_drive/work/Algorithm_questions/Cloudera_coding_test/input1.txt");

    }


    private static void testProblemWithInputFile(String inputFileLocation) {
        try {
            readInputFile(inputFileLocation);
        } catch (IOException e) {
            System.err.println("Input file: " + inputFileLocation + " could not be read. Exception: ");
            e.printStackTrace(System.err);
        }
    }

    private static void readInputFile(String inputFileLocation) throws IOException {
        Path file = Paths.get(inputFileLocation);
        BufferedReader reader = Files.newBufferedReader(file, Charset.defaultCharset());
        StringBuilder content = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null) {
            content.append(line).append("/n");
        }
        System.out.println("Content: " + content.toString());
    }

    private static void testProblemWithSample1() {
        //Initializing the problem in a single string, sample input
        String problem1Org = "C: -20\n" +
                "B: -10\n" +
                "A: -3\n" +
                "B: 7\n" +
                "A: 8\n" +
                "C: 17\n" +
                "B: 4\n" +
                "A: -14\n" +
                "B: 7\n" +
                "A: -6\n";
        //Problem length is given in input file, initializing it with a sample input
        int problem1Length = 10;
        String[] problem1 = problem1Org.split("\n");

        //System.out.println("Problem1 = \n" + problem1Org);

        System.out.println("Problem1 output = " + solveProblem(problem1,problem1Length));
    }

    private static void testProblemWithSample2() {
        //Initializing the problem in a single string, sample input
        String problem2Org = "A: -95\n" +
                "A: -87\n" +
                "B: -66\n" +
                "C: 31\n" +
                "C: -87\n" +
                "C: -5\n" +
                "B: -69\n" +
                "A: 24\n" +
                "C: -61\n" +
                "A: 45\n" +
                "C: -91\n" +
                "A: -73\n" +
                "C: -77\n" +
                "B: -72\n" +
                "C: -16\n" +
                "C: 98\n" +
                "A: -79\n" +
                "B: -97\n" +
                "B: -15\n" +
                "B: 46\n" +
                "B: 49\n" +
                "A: 92\n" +
                "C: -73\n" +
                "A: -50\n" +
                "C: -61\n" +
                "B: -50\n" +
                "A: -83\n" +
                "B: -3\n" +
                "C: -97\n" +
                "A: -11\n" +
                "C: -79\n" +
                "C: -73\n" +
                "C: 32\n" +
                "A: -96\n" +
                "B: 84\n" +
                "A: -83\n" +
                "C: -96\n" +
                "A: 69\n" +
                "B: -25\n" +
                "C: -58\n" +
                "A: 11\n" +
                "C: 80\n" +
                "A: 3\n" +
                "C: 44\n" +
                "B: 12\n" +
                "A: -39\n" +
                "A: -51\n" +
                "B: -66\n" +
                "C: -63\n" +
                "A: -11\n" +
                "C: -6\n" +
                "A: -18\n" +
                "C: -60\n" +
                "B: 11\n" +
                "C: -61\n" +
                "A: -10\n" +
                "A: -56\n" +
                "B: 57\n" +
                "C: 93\n" +
                "C: -72\n" +
                "A: -27\n" +
                "B: 96\n" +
                "C: -59\n" +
                "A: -75\n" +
                "A: -74\n" +
                "B: -9\n" +
                "A: -68\n" +
                "C: -20\n" +
                "C: 77\n" +
                "A: 28\n" +
                "A: -2\n" +
                "B: 73\n" +
                "C: -22\n" +
                "A: 55\n" +
                "B: -35\n" +
                "C: 22\n" +
                "A: 17\n" +
                "B: 100\n" +
                "C: 27\n" +
                "B: -33\n" +
                "B: -9\n" +
                "A: 95\n" +
                "B: -84\n" +
                "C: -49\n" +
                "C: -27\n" +
                "A: -16\n" +
                "B: 97\n" +
                "C: 9\n" +
                "C: -64\n" +
                "C: -37\n" +
                "C: -49\n" +
                "A: -11\n" +
                "A: 13\n" +
                "A: -95\n" +
                "C: -94\n" +
                "C: -43\n" +
                "A: 90\n" +
                "C: -38\n" +
                "B: 71\n" +
                "B: 93\n" +
                "B: -20\n" +
                "C: 1\n" +
                "C: -80\n" +
                "C: -40\n" +
                "B: 7\n" +
                "C: 97\n" +
                "B: 49\n" +
                "A: -66\n" +
                "B: -95\n" +
                "B: -88\n" +
                "A: 68\n" +
                "B: -62\n" +
                "B: -16\n" +
                "A: 81\n" +
                "A: -24\n" +
                "A: 89\n" +
                "C: 79\n" +
                "A: -45\n" +
                "C: 37\n" +
                "A: -84\n" +
                "B: -49\n" +
                "C: -12\n" +
                "C: -27\n" +
                "A: -36\n" +
                "B: 96\n" +
                "B: -33\n" +
                "C: 29\n" +
                "A: 4\n" +
                "A: 7\n" +
                "B: 88\n" +
                "A: -45\n" +
                "B: 61\n" +
                "A: -6\n" +
                "B: -32\n" +
                "B: 90\n" +
                "B: 44\n" +
                "B: 81\n" +
                "A: -31\n" +
                "B: 68\n" +
                "A: 45\n" +
                "C: 34\n" +
                "A: -32\n" +
                "A: -56\n" +
                "C: 94\n" +
                "A: -85\n" +
                "C: 90\n" +
                "C: 67\n" +
                "B: 2\n" +
                "C: -47\n" +
                "A: 55\n" +
                "C: 41\n" +
                "B: -70\n" +
                "A: 25\n" +
                "B: -10\n" +
                "B: -70\n" +
                "B: 50\n" +
                "A: 19\n" +
                "A: -80\n" +
                "B: -31\n" +
                "C: -71\n" +
                "A: -34\n" +
                "C: -10\n" +
                "B: -87\n" +
                "C: -11\n" +
                "C: -81\n" +
                "A: -11\n" +
                "B: -56\n" +
                "C: 80\n" +
                "C: -66\n" +
                "C: 1\n" +
                "B: 26\n" +
                "C: -52\n" +
                "A: -4\n" +
                "B: -68\n" +
                "A: 65\n" +
                "C: -75\n" +
                "C: -52\n" +
                "C: 27\n" +
                "B: -29\n" +
                "C: -23\n" +
                "B: 41\n" +
                "B: -34\n" +
                "C: -29\n" +
                "B: -99\n" +
                "C: -30\n" +
                "B: -78\n" +
                "A: -89\n" +
                "C: 84\n" +
                "C: -1\n" +
                "A: 71\n" +
                "B: 63\n" +
                "B: -20\n" +
                "A: 63\n" +
                "C: 10\n" +
                "B: -24\n" +
                "A: 95\n" +
                "A: -95\n" +
                "A: 54\n" +
                "C: 40\n" +
                "B: -54\n" +
                "C: 2\n" +
                "B: 23\n" +
                "C: -34\n" +
                "C: -40\n" +
                "C: -100\n" +
                "C: -27\n" +
                "B: -88\n" +
                "A: -18\n" +
                "A: -33\n" +
                "C: 95\n" +
                "C: 87\n" +
                "B: 91\n" +
                "C: 74\n" +
                "B: 7\n" +
                "C: 37\n" +
                "A: -62\n" +
                "A: 57\n" +
                "C: -56\n" +
                "C: -50\n" +
                "A: -40\n" +
                "C: 1\n" +
                "A: -32\n" +
                "C: -37\n" +
                "A: -51\n" +
                "A: 2\n" +
                "A: 12\n" +
                "B: -24\n" +
                "C: -34\n" +
                "A: 38\n" +
                "C: 11\n" +
                "C: -11\n" +
                "C: 69\n" +
                "C: 37\n" +
                "A: 100\n" +
                "A: 4\n" +
                "A: -76\n" +
                "B: 3\n" +
                "B: -56\n" +
                "B: -6\n" +
                "B: 17\n" +
                "B: -85\n" +
                "B: 74\n" +
                "B: -23\n" +
                "B: -88\n" +
                "A: -57\n" +
                "B: -5\n" +
                "C: 64\n" +
                "B: -43\n" +
                "A: -20\n" +
                "B: -37\n" +
                "B: -79\n" +
                "B: -61\n" +
                "B: -6\n" +
                "C: -19\n" +
                "B: -69\n" +
                "A: -54\n" +
                "B: -68\n" +
                "B: 46\n" +
                "C: -8\n" +
                "B: -1\n" +
                "C: -83\n" +
                "C: -71\n" +
                "A: -5\n" +
                "B: 41\n" +
                "C: -35\n" +
                "B: 77\n" +
                "A: -7\n" +
                "A: -69\n" +
                "A: -4\n" +
                "B: 43\n" +
                "A: -98\n" +
                "A: -16\n" +
                "C: -7\n" +
                "B: -67\n" +
                "B: -49\n" +
                "C: -91\n" +
                "C: -68\n" +
                "C: -28\n" +
                "A: -14\n" +
                "B: -7\n" +
                "B: -65\n" +
                "C: 74\n" +
                "A: -1\n" +
                "B: 58\n" +
                "A: 10\n" +
                "B: -84\n" +
                "C: 60\n" +
                "B: -21\n" +
                "B: -14\n" +
                "A: -75\n" +
                "B: 6\n" +
                "A: 88\n" +
                "A: 78\n" +
                "A: 1\n" +
                "C: 48\n" +
                "A: -48\n" +
                "A: -64\n" +
                "C: -65\n" +
                "C: -34\n" +
                "B: -19\n" +
                "C: -17\n" +
                "C: 77\n" +
                "C: 60\n" +
                "A: -79\n" +
                "A: -21\n" +
                "A: 64\n" +
                "A: -34\n" +
                "A: -99\n" +
                "B: 36\n" +
                "B: -13\n" +
                "A: 56\n" +
                "C: -44\n" +
                "A: -70\n" +
                "B: -55\n" +
                "B: -73\n" +
                "B: 97\n" +
                "C: 9\n" +
                "A: 37\n" +
                "A: -55\n" +
                "A: 78\n" +
                "C: -9\n" +
                "C: 75\n" +
                "C: -12\n" +
                "B: -62\n" +
                "B: 94\n" +
                "B: -87\n" +
                "C: -2\n" +
                "C: -79\n" +
                "C: -61\n" +
                "A: 23\n" +
                "B: 73\n" +
                "C: -51\n" +
                "C: -81\n" +
                "A: -54\n" +
                "A: -59\n" +
                "A: -74\n" +
                "B: -50\n" +
                "C: -15\n" +
                "B: 24\n" +
                "A: -19\n" +
                "A: -58\n" +
                "C: 10\n" +
                "C: -1\n" +
                "A: -47\n" +
                "B: -49\n" +
                "C: -4\n" +
                "A: -5\n" +
                "C: -15\n" +
                "A: -57\n" +
                "C: -37\n" +
                "C: -50\n" +
                "C: 80\n" +
                "B: 31\n" +
                "B: -21\n" +
                "A: -42\n" +
                "B: 21\n" +
                "C: -38\n" +
                "A: -61\n" +
                "A: -87\n" +
                "C: -27\n" +
                "A: -98\n" +
                "B: -32\n" +
                "B: -47\n" +
                "B: 89\n" +
                "C: -49\n" +
                "B: -69\n" +
                "C: -99\n" +
                "A: -25\n" +
                "C: -42\n" +
                "B: -58\n" +
                "B: 22\n" +
                "B: -81\n" +
                "B: -6\n" +
                "B: -97\n" +
                "B: -88\n" +
                "B: 68\n" +
                "B: 59\n" +
                "C: 92\n" +
                "C: -94\n" +
                "A: 86\n" +
                "C: 40\n" +
                "A: -88\n" +
                "A: 6\n" +
                "A: 54\n" +
                "C: 87\n" +
                "A: -48\n" +
                "A: 31\n" +
                "A: 18\n" +
                "C: 45\n" +
                "C: -80\n" +
                "A: -12\n" +
                "A: -12\n" +
                "A: -54\n" +
                "C: -23\n" +
                "A: -58\n" +
                "B: -88\n" +
                "A: 82\n" +
                "C: -81\n" +
                "A: 80\n" +
                "C: -88\n" +
                "A: -4\n" +
                "C: 3\n" +
                "A: -96\n" +
                "A: -95\n" +
                "A: -77\n" +
                "A: 65\n" +
                "A: -95\n" +
                "C: -81\n" +
                "A: -43\n" +
                "A: 56\n" +
                "C: 34\n" +
                "C: -2\n" +
                "A: -1\n" +
                "B: -74\n" +
                "A: -59\n" +
                "B: 65\n" +
                "A: 12\n" +
                "A: -8\n" +
                "B: -56\n" +
                "A: -42\n" +
                "A: 87\n" +
                "B: -70\n" +
                "B: -77\n" +
                "C: -84\n" +
                "A: -68\n" +
                "B: 52\n" +
                "C: 26\n" +
                "C: -12\n" +
                "A: 60\n" +
                "C: -24\n" +
                "A: -89\n" +
                "A: -27\n" +
                "A: 9\n" +
                "A: -20\n" +
                "C: -10\n" +
                "B: 38\n" +
                "A: 13\n" +
                "B: -2\n" +
                "A: -63\n" +
                "A: 79\n" +
                "A: -79\n" +
                "C: 21\n" +
                "A: -74\n" +
                "C: -62\n" +
                "C: -30\n" +
                "B: -71\n" +
                "C: -90\n" +
                "C: 67\n" +
                "C: -39\n" +
                "B: -9\n" +
                "B: -84\n" +
                "C: -58\n" +
                "A: -30\n" +
                "A: 18\n" +
                "A: -5\n" +
                "C: -64\n" +
                "C: -69\n" +
                "A: -82\n" +
                "C: -46\n" +
                "C: -5\n" +
                "A: -84\n" +
                "A: 31\n" +
                "A: 49\n" +
                "A: -85\n" +
                "C: -53\n" +
                "A: 61\n" +
                "A: 89\n" +
                "C: -84\n" +
                "C: -26\n" +
                "B: 97\n" +
                "C: 72\n" +
                "B: -95\n" +
                "C: -42\n" +
                "B: 22\n" +
                "A: -8\n" +
                "C: 7\n" +
                "C: -48\n" +
                "A: 19\n" +
                "A: 10\n" +
                "C: 17\n" +
                "C: -78\n" +
                "A: 50\n" +
                "B: 15\n" +
                "A: -70\n" +
                "C: -87\n" +
                "C: 99\n" +
                "B: -44\n" +
                "A: 4\n" +
                "C: -96\n" +
                "B: -34\n" +
                "B: -94\n" +
                "A: 39\n" +
                "C: 28\n" +
                "C: 73\n" +
                "C: -91\n" +
                "B: -64\n" +
                "C: -91\n" +
                "C: -96\n" +
                "C: -12\n" +
                "B: 50\n" +
                "A: -79\n" +
                "C: -78\n" +
                "A: -70\n" +
                "B: -67\n" +
                "B: -49\n" +
                "B: 2\n" +
                "A: -50\n" +
                "C: 68\n" +
                "B: -57\n" +
                "B: 6\n" +
                "B: 10\n" +
                "C: -84\n" +
                "B: -100\n" +
                "C: -7\n" +
                "A: -100\n" +
                "B: 4\n" +
                "C: -27\n" +
                "A: 28\n" +
                "A: 87\n" +
                "B: 85\n" +
                "A: 17\n" +
                "B: -37\n" +
                "C: -68\n" +
                "C: -99\n" +
                "B: 6\n" +
                "A: -75\n" +
                "A: -25\n" +
                "A: -57\n" +
                "A: -93\n" +
                "B: 23\n" +
                "B: 73\n" +
                "A: -18\n" +
                "C: -73\n" +
                "C: -82\n" +
                "B: -96\n" +
                "A: -1\n" +
                "B: -1\n" +
                "B: -8\n" +
                "A: 1\n" +
                "B: -32\n" +
                "C: -77\n" +
                "C: -85\n" +
                "B: 86\n" +
                "C: 44\n" +
                "A: 63\n" +
                "A: 95\n" +
                "B: 41\n" +
                "B: -53\n" +
                "B: -76\n" +
                "C: -67\n" +
                "B: -82\n" +
                "B: -15\n" +
                "C: 88\n" +
                "A: 17\n" +
                "C: -10\n" +
                "C: 72\n" +
                "B: 22\n" +
                "B: -48\n" +
                "B: -83\n" +
                "C: 82\n" +
                "B: 91\n" +
                "B: -40\n" +
                "C: -78\n" +
                "C: -100\n" +
                "A: -88\n" +
                "C: -96\n" +
                "A: 46\n" +
                "B: -19\n" +
                "A: 25\n" +
                "C: -33\n" +
                "C: -76\n" +
                "B: -72\n" +
                "A: 95\n" +
                "C: -76\n" +
                "A: 81\n" +
                "B: 77\n" +
                "A: -98\n" +
                "A: 92\n" +
                "C: 78\n" +
                "B: 46\n" +
                "A: -16\n" +
                "C: -46\n" +
                "B: -31\n" +
                "B: 72\n" +
                "B: -69\n" +
                "B: 100\n" +
                "B: 78\n" +
                "C: 87\n" +
                "A: -42\n" +
                "A: 65\n" +
                "B: -85\n" +
                "B: -66\n" +
                "C: -13\n" +
                "B: 22\n" +
                "B: -51\n" +
                "A: 25\n" +
                "C: -94\n" +
                "B: -84\n" +
                "C: 34\n" +
                "C: -5\n" +
                "A: -99\n" +
                "C: -25\n" +
                "A: 43\n" +
                "C: -84\n" +
                "B: 1\n" +
                "A: 22\n" +
                "C: -89\n" +
                "B: -27\n" +
                "B: -53\n" +
                "A: -31\n" +
                "B: -84\n" +
                "C: 5\n" +
                "C: -67\n" +
                "B: 33\n" +
                "B: -82\n" +
                "B: 32\n" +
                "C: -39\n" +
                "B: -37\n" +
                "C: -78\n" +
                "C: -56\n" +
                "B: -86\n" +
                "C: -29\n" +
                "C: 4\n" +
                "C: -18\n" +
                "B: -20\n" +
                "A: -58\n" +
                "C: 37\n" +
                "B: 68\n" +
                "C: -55\n" +
                "A: -21\n" +
                "C: -85\n" +
                "A: -9\n" +
                "B: -26\n" +
                "C: 12\n" +
                "A: 76\n" +
                "A: 82\n" +
                "B: -33\n" +
                "C: 80\n" +
                "B: 76\n" +
                "B: -50\n" +
                "C: 55\n" +
                "C: 28\n" +
                "A: 1\n" +
                "C: 86\n" +
                "A: -49\n" +
                "B: -24\n" +
                "A: 58\n" +
                "C: -39\n" +
                "B: 86\n" +
                "A: -16\n" +
                "C: -79\n" +
                "A: -56\n" +
                "C: -59\n" +
                "C: -98\n" +
                "A: -86\n" +
                "A: 46\n" +
                "B: -25\n" +
                "C: -33\n" +
                "B: -18\n" +
                "A: -45\n" +
                "C: 45\n" +
                "C: 45\n" +
                "A: 71\n" +
                "B: 66\n" +
                "B: 82\n" +
                "B: -95\n" +
                "B: -74\n" +
                "A: -96\n" +
                "C: -36\n" +
                "B: -62\n" +
                "C: -21\n" +
                "A: 31\n" +
                "B: -49\n" +
                "A: -10\n" +
                "A: -35\n" +
                "A: -25\n" +
                "A: 82\n" +
                "A: 40\n" +
                "C: 96\n" +
                "A: 85\n" +
                "C: 37\n" +
                "C: -87\n" +
                "A: 36\n" +
                "A: -13\n" +
                "B: -28\n" +
                "C: 25\n" +
                "B: 18\n" +
                "C: -21\n" +
                "C: 38\n" +
                "B: 47\n" +
                "C: -34\n" +
                "A: 49\n" +
                "A: 86\n" +
                "A: 71\n" +
                "A: -37\n" +
                "A: -19\n" +
                "B: -76\n" +
                "A: 54\n" +
                "A: 51\n" +
                "C: -62\n" +
                "B: 1\n" +
                "A: -52\n" +
                "B: -67\n" +
                "C: -50\n" +
                "A: 42\n" +
                "B: -24\n" +
                "A: -5\n" +
                "A: -22\n" +
                "C: -34\n" +
                "A: -19\n" +
                "A: 33\n" +
                "C: -74\n" +
                "A: 60\n" +
                "B: -60\n" +
                "C: 68\n" +
                "A: -22\n" +
                "B: 54\n" +
                "C: -71\n" +
                "C: 64\n" +
                "B: -26\n" +
                "A: -61\n" +
                "C: 27\n" +
                "B: 39\n" +
                "A: -53\n" +
                "B: 81\n" +
                "A: -49\n" +
                "A: -7\n" +
                "A: -11\n" +
                "C: 100\n" +
                "B: 94\n" +
                "B: -33\n" +
                "A: 2\n" +
                "A: 80\n" +
                "B: 45\n" +
                "B: 37\n" +
                "A: -95\n" +
                "C: -86\n" +
                "B: 92\n" +
                "C: -31\n" +
                "C: -23\n" +
                "C: -79\n" +
                "A: -94\n" +
                "B: -32\n" +
                "A: -39\n" +
                "B: -86\n" +
                "B: 54\n" +
                "C: -24\n" +
                "B: -50\n" +
                "A: -31\n" +
                "A: 8\n" +
                "C: -55\n" +
                "B: 41\n" +
                "C: 79\n" +
                "A: 74\n" +
                "A: -56\n" +
                "A: -3\n" +
                "A: 56\n" +
                "B: -100\n" +
                "B: -39\n" +
                "B: 63\n" +
                "A: 6\n" +
                "B: -27\n" +
                "B: -43\n" +
                "B: -42\n" +
                "C: 41\n" +
                "A: -73\n" +
                "B: -59\n" +
                "A: 17\n" +
                "C: 41\n" +
                "B: -53\n" +
                "B: -89\n" +
                "A: -28\n" +
                "B: -98\n" +
                "B: -28\n" +
                "A: 17\n" +
                "C: -37\n" +
                "A: -58\n" +
                "B: -26\n" +
                "A: 63\n" +
                "A: -74\n" +
                "A: -98\n" +
                "C: -70\n" +
                "A: 91\n" +
                "C: -89\n" +
                "A: 79\n" +
                "C: -31\n" +
                "A: 22\n" +
                "B: 3\n" +
                "A: -47\n" +
                "C: 75\n" +
                "A: -86\n" +
                "B: -61\n" +
                "C: -2\n" +
                "A: -64\n" +
                "C: -43\n" +
                "B: 39\n" +
                "B: -76\n" +
                "C: -33\n" +
                "B: -21\n" +
                "B: -25\n" +
                "C: 4\n" +
                "B: -73\n" +
                "B: 85\n" +
                "B: 10\n" +
                "B: 63\n" +
                "A: 61\n" +
                "B: 95\n" +
                "B: -58\n" +
                "A: -33\n" +
                "A: -92\n" +
                "A: -87\n" +
                "C: -76\n" +
                "A: -12\n" +
                "C: -34\n" +
                "C: 56\n" +
                "C: -51\n" +
                "A: -10\n" +
                "A: -18\n" +
                "C: 50\n" +
                "C: -89\n" +
                "A: -46\n" +
                "B: -8\n" +
                "A: -11\n" +
                "B: -28\n" +
                "C: 63\n" +
                "C: -12\n" +
                "C: -90\n" +
                "B: 54\n" +
                "B: 91\n" +
                "C: -29\n" +
                "B: 33\n" +
                "C: 65\n" +
                "C: -27\n" +
                "C: 84\n" +
                "A: -48\n" +
                "A: -52\n" +
                "A: 68\n" +
                "B: -76\n" +
                "B: -63\n" +
                "C: 67\n" +
                "B: -55\n" +
                "B: -30\n" +
                "A: -15\n" +
                "A: -56\n" +
                "B: -58\n" +
                "B: 76\n" +
                "A: -50\n" +
                "B: -6\n" +
                "B: -19\n" +
                "C: 7\n" +
                "A: -68\n" +
                "C: 98\n" +
                "C: -30\n" +
                "A: 52\n" +
                "A: 9\n" +
                "A: -76\n" +
                "B: -17\n" +
                "A: -11\n" +
                "A: 67\n" +
                "A: -6\n" +
                "C: -39\n" +
                "A: 19\n" +
                "B: 79\n" +
                "C: -50\n" +
                "B: 26\n" +
                "C: -56\n" +
                "C: -100\n" +
                "C: 58\n" +
                "C: 11\n" +
                "C: 95\n" +
                "C: 67\n" +
                "A: 59\n" +
                "A: 43\n" +
                "C: 75\n" +
                "A: -22\n" +
                "B: -55\n" +
                "B: -24\n" +
                "B: -64\n" +
                "A: -5\n" +
                "B: 12\n" +
                "B: -36\n" +
                "B: -19\n" +
                "C: -58\n" +
                "A: -9\n" +
                "C: -17\n" +
                "A: -6\n" +
                "C: -66\n" +
                "C: 9\n" +
                "B: -47\n" +
                "C: 99\n" +
                "C: -83\n" +
                "B: -77\n" +
                "C: 65\n" +
                "C: 84\n" +
                "C: -80\n" +
                "A: 34\n" +
                "A: 49\n" +
                "A: -74\n" +
                "C: -89\n" +
                "C: -84\n" +
                "C: 64\n" +
                "A: -39\n" +
                "A: -53\n" +
                "C: 79\n" +
                "B: 28\n" +
                "B: 45\n" +
                "C: 49\n" +
                "A: -38\n" +
                "B: 27\n" +
                "C: -8\n" +
                "A: -40\n" +
                "A: 24\n" +
                "C: 13\n" +
                "B: -90\n" +
                "B: 69\n" +
                "A: -56\n" +
                "C: 92\n" +
                "C: 46\n" +
                "A: 41\n" +
                "C: 13\n" +
                "C: 71\n" +
                "B: -47\n" +
                "A: 14\n" +
                "B: -5\n" +
                "B: 74\n" +
                "C: 4\n" +
                "A: -19\n" +
                "A: -9\n" +
                "A: -15\n" +
                "B: -8\n" +
                "C: -57\n" +
                "A: -15\n" +
                "A: 71\n" +
                "C: -71\n" +
                "A: 59\n" +
                "B: 45\n" +
                "C: -72\n" +
                "C: -6\n" +
                "C: -18\n" +
                "B: 18\n" +
                "B: 27\n" +
                "B: 29\n" +
                "A: 27\n" +
                "B: -5\n" +
                "C: -77\n" +
                "A: -55\n" +
                "B: 11\n" +
                "A: 97\n" +
                "C: -61\n" +
                "B: -56\n" +
                "C: -1\n" +
                "B: 1\n" +
                "C: 55\n" +
                "C: -50\n" +
                "C: -78\n" +
                "C: 81\n" +
                "C: -94\n" +
                "B: 53\n" +
                "B: -49\n" +
                "C: -20\n" +
                "C: -8\n" +
                "C: -54\n" +
                "A: -51\n" +
                "A: 24\n" +
                "C: 43\n" +
                "C: -59\n" +
                "B: 56\n" +
                "C: 88\n" +
                "A: -89\n" +
                "C: -89\n" +
                "A: 84\n" +
                "B: 7\n" +
                "A: 49\n" +
                "C: -18\n" +
                "B: -5\n" +
                "B: -57\n" +
                "B: -42\n" +
                "A: -85\n" +
                "A: 99\n" +
                "B: 71\n" +
                "B: -31\n" +
                "B: 1\n" +
                "B: 37\n" +
                "C: -28\n" +
                "C: -77\n" +
                "B: -51\n" +
                "B: -67\n" +
                "B: 30\n" +
                "A: -60\n" +
                "C: 3\n" +
                "C: -24\n" +
                "B: 62\n" +
                "C: -14\n" +
                "A: -69\n" +
                "A: 35\n" +
                "A: 68\n" +
                "A: 54\n" +
                "C: 73\n" +
                "A: 73\n" +
                "C: 100\n" +
                "A: -90\n" +
                "C: -16\n" +
                "C: -2\n" +
                "A: -82\n" +
                "B: -69\n" +
                "C: 1\n" +
                "C: 21\n" +
                "A: -71\n" +
                "B: -13\n" +
                "C: -43\n" +
                "B: -34\n" +
                "A: -59\n" +
                "B: 5\n" +
                "A: 35\n" +
                "A: -3\n" +
                "C: 17\n" +
                "C: 51\n" +
                "C: -82\n" +
                "C: 45\n" +
                "A: -85\n" +
                "A: -19\n" +
                "C: -55\n" +
                "A: -72\n" +
                "A: 36\n" +
                "C: -90\n" +
                "A: 57\n" +
                "A: -71\n" +
                "B: 45\n" +
                "A: 2\n" +
                "B: -75\n" +
                "C: 34\n" +
                "B: 83\n" +
                "C: -13\n" +
                "B: -38\n" +
                "A: -1\n" +
                "B: 26\n" +
                "A: -86\n" +
                "B: -49\n" +
                "A: -21\n" +
                "B: 2\n" +
                "B: 99\n" +
                "A: 20\n" +
                "A: 47\n" +
                "B: 48\n" +
                "A: 10\n" +
                "C: -4\n" +
                "A: -15\n" +
                "A: -87\n" +
                "A: -68\n" +
                "B: 53\n" +
                "B: 77\n" +
                "B: 97\n" +
                "C: 3\n" +
                "C: -35\n" +
                "A: 83\n" +
                "C: 54\n" +
                "A: -72\n" +
                "B: -27\n" +
                "C: 32\n" +
                "C: 49\n" +
                "A: -50\n" +
                "C: -28\n" +
                "C: 83\n" +
                "B: -91\n" +
                "B: 89\n" +
                "A: 93\n" +
                "B: -88\n" +
                "C: -54\n" +
                "B: -33\n" +
                "A: -21\n" +
                "A: -66\n" +
                "C: 46\n" +
                "C: -27\n" +
                "C: -31\n" +
                "C: -40\n" +
                "A: 63\n" +
                "C: 34\n" +
                "A: -65\n" +
                "A: -28\n" +
                "A: -63\n" +
                "B: 2\n" +
                "B: 65\n" +
                "B: 12\n" +
                "C: -50\n" +
                "A: -61\n" +
                "B: 26\n" +
                "C: -9\n" +
                "C: -34\n" +
                "B: 12\n" +
                "A: -24\n" +
                "B: 12\n" +
                "B: 48\n" +
                "A: 28\n" +
                "A: -30\n" +
                "C: -23\n" +
                "B: -48\n" +
                "C: -70\n" +
                "A: -54\n" +
                "A: 30\n" +
                "A: 43\n" +
                "B: -31\n" +
                "A: 24\n" +
                "C: -50\n" +
                "B: 53\n" +
                "B: -4\n" +
                "B: 96\n" +
                "C: 38\n" +
                "B: 78\n" +
                "B: 83\n" +
                "B: -35\n" +
                "C: -73\n" +
                "A: -8\n" +
                "A: -55\n" +
                "C: 78\n" +
                "C: 5\n" +
                "B: -3\n" +
                "B: -32\n" +
                "C: -12\n" +
                "A: 41\n" +
                "C: 4\n" +
                "B: -49\n" +
                "C: -86\n" +
                "A: -84\n" +
                "A: 87\n" +
                "C: -8\n" +
                "A: -75\n" +
                "C: 95\n" +
                "B: 45\n" +
                "A: -57\n" +
                "C: -59\n" +
                "A: -57\n" +
                "C: -100\n" +
                "A: -44\n" +
                "B: -42\n" +
                "C: -5\n" +
                "B: 7\n" +
                "A: -29\n" +
                "C: -57\n" +
                "B: -65\n" +
                "B: -67\n" +
                "B: -93\n" +
                "C: -68\n" +
                "B: -58\n" +
                "C: 44";
        //Problem length is given in input file, initializing it with a sample input
        int problem1Length = 1144;
        String[] problem2 = problem2Org.split("\n");

        System.out.println("Problem1 output = " + solveProblem(problem2,problem1Length));
    }


    private static int solveProblem(String[] problem, int problemLength) {

        int lengthOfLargestSubstring = 0;

        //Loop for substring size - start from maximum, i.e. problemLength and go till 3
        //Why 3 - Assuming we need to have at least one of each letter, A,B,C
        for (int subStringBlockSize = problemLength; subStringBlockSize > 3; subStringBlockSize--) {

            //Variable to count the starting position in the array
            int startPosition = 0;

            //If following condition is met, keep checking blocks for condition
            while((startPosition+subStringBlockSize)<=problemLength){
                //Map to save the sum of each letter
                Map<String, Integer> eachLetterSum = new HashMap<String, Integer>();

                //Loop for getting subStringBlockSize number of elements from problemArray
                for (int i = startPosition; i < (startPosition + subStringBlockSize); i++) {

                    //Extract the letter and number
                    String[] element = problem[i].split(": ");
                    String letter = element[0];
                    int number = Integer.parseInt(element[1]);

                    if (eachLetterSum.containsKey(letter)) {
                        eachLetterSum.put(letter, (eachLetterSum.get(letter) + number));
                    } else {
                        eachLetterSum.put(letter, number);
                    }
                }

                //Check if we found a substring satisfying the condition
                //If yes, no need to iterate anymore, return the block size.
                // i.e. our result for this problem
                if (verifyCondition(eachLetterSum)) {
                    return subStringBlockSize;
                }

                //StartPosition should move one place before starting next iteration of the loop
                startPosition++;
            }
        }

        return lengthOfLargestSubstring;
    }

    private static boolean verifyCondition(Map<String, Integer> eachLetterSum) {
        //Check if the sum of all numbers for each letter is greater than 0

        for (String letter : eachLetterSum.keySet()) {

            //Debug
            //System.out.println("eachLetterSum = " + eachLetterSum);

            if (eachLetterSum.get(letter)<=0){
                return false;
            }
        }

        return true;
    }


}
