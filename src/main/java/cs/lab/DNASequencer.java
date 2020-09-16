package cs.lab;

import java.util.List;
import java.util.logging.Logger;
import java.util.ArrayList;

public class  DNASequencer {

    static final Logger logger = Logger.getLogger(DNASequencer.class.getName());
    public DNASequencer() {
        logger.info("Starting sequencer...");
    }

    public String calculate(List<String> part){
        String complete_sequence = "";
        int current_letter, next_letter, first = 0;
        int total_chains = part.size ();
        for (int j = 0; j < total_chains - 1; j++) {
            current_letter = first;
            String current_chain = part.get (j);
            String next_chain = part.get (j + 1);
            while (current_chain.charAt(current_letter) != next_chain.charAt(first)) {
                complete_sequence += current_chain.charAt(current_letter);
                next_letter = current_letter + 1;
                if (current_chain.charAt(next_letter) == next_chain.charAt(first)) {
                    if (current_chain.charAt(next_letter) == current_chain.charAt(next_letter + 1))
                        complete_sequence += current_chain.charAt(current_letter + 1);
                }
                current_letter++;
            }
        }
        complete_sequence += part.get(total_chains - 1);
        return complete_sequence;
    }
}
