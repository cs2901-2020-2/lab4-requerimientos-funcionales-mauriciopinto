package cs.lab;

import java.util.List;
import java.util.logging.Logger;

public class  DNASequencer {

    static final Logger logger = Logger.getLogger(DNASequencer.class.getName());
    public DNASequencer() {
        logger.info("Starting sequencer...");
    }

    public String calculate(List<String> part) throws MaxSubsequenceException, EmptyListException, SubseqLengthException {
        String completeSequence = "";
        int currentLetter, nextLetter, first = 0;
        int totalChains = part.size ();
        if (totalChains > 160000)
            throw new MaxSubsequenceException("Too many Subsequences");
        if (totalChains == 0)
            throw new EmptyListException("No subsequences passed!");
        for (int j = 0; j < totalChains - 1; j++) {
            currentLetter = first;
            String currentChain = part.get (j);
            String nextChain = part.get (j + 1);
            if (currentChain.length() > 200)
                throw new SubseqLengthException("Subsequence too large!");
            while (currentChain.charAt(currentLetter) != nextChain.charAt(first)) {
                completeSequence += currentChain.charAt(currentLetter);
                nextLetter = currentLetter + 1;
                if (currentChain.charAt(nextLetter) == nextChain.charAt(first)) {
                    if (currentChain.charAt(nextLetter) == currentChain.charAt(nextLetter + 1))
                        completeSequence += currentChain.charAt(currentLetter + 1);
                }
                currentLetter++;
            }
        }
        String lastChain = part.get (totalChains - 1);
        if (lastChain.length() > 200)
            throw new SubseqLengthException("Subsequence too large!");
        completeSequence += lastChain;
        return completeSequence;
    }
}
