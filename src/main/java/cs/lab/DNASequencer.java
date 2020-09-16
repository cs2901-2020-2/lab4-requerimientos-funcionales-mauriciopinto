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
        int i;
        int total_chains = part.size ();
        for (int j = 0; j < total_chains - 1; j++) {
            i = 0;
            String current_chain = part.get (j);
            String next_chain = part.get (j + 1);
            while (current_chain.charAt(i) != next_chain.charAt(0)) {
                complete_sequence += current_chain.charAt(i);
                if (current_chain.charAt(i + 1) == current_chain.charAt(i + 2))
                    complete_sequence+= current_chain.charAt(i + 1);
                i++;
            }
        }
        complete_sequence += part.get(total_chains - 1);
        return complete_sequence;
    }
}
