package cs.lab;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.io.FileWriter;

@Test
public class DNASequencerTest {
    public int MAX_SUBSEQUENCES = 180000;

    public void testCase0() throws Exception {
        generic(0);
    }

    @Test(expectedExceptions = SubseqLengthException.class)
    public void testCase1 () throws Exception {
        generic(1);
    }

    @Test(expectedExceptions = MaxSubsequenceException.class)
    public void testCase2 () throws Exception {
        generateLines ();
        generic(2);
    }

    @Test(invocationCount = 50, threadPoolSize = 50)
    public void testCase3 () throws Exception {
        generic (3);
    }

    @Test(expectedExceptions = EmptyListException.class)
    public void testCase4 () throws Exception{
        DNASequencer seq = new DNASequencer();
        List<String> empty = new ArrayList<String>();
        seq.calculate(empty);
    }
    private void generic(int i) throws IOException, Exception {
        List<String> input = readInput(i);
        String output = readOutput(i);
        DNASequencer sequencer = new DNASequencer();
        String response = sequencer.calculate(input);
        Assert.assertEquals(response, output);
    }

    private List<String> readInput(int testNumber){
        List<String> lines = readFile(testNumber, "input");
        return lines;
    }

    private String readOutput(int testNumber){
        List<String> lines = readFile(testNumber, "output");
        return lines.get(0);
    }

    public List<String> readFile(int testNumber, String type){
        String fileName = "test_case<testNumber>_<type>";
        fileName = fileName.replace("<testNumber>", Integer.toString(testNumber));
        fileName = fileName.replace("<type>", type);
        InputStream is = getClass().getClassLoader().getResourceAsStream(fileName);
        Scanner scan = new Scanner(is);
        List<String> lines = new ArrayList<String>();
        while(scan.hasNextLine()) {
            String line = scan.nextLine();
            lines.add(line);
        }
        return lines;
    }
    public void generateLines () throws IOException, Exception {
        FileWriter outputFile = new FileWriter("src/main/resources/test_case2_input");
        for (int i = 0; i < MAX_SUBSEQUENCES + 1; i++) {
            outputFile.write ("AGATTA\n");
        }
    }
}