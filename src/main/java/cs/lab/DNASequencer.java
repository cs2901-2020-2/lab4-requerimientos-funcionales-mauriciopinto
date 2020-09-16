package cs.lab;

import java.util.List;
import java.util.logging.Logger;
import java.util.ArrayList;

public class  DNASequencer {

    static final Logger logger = Logger.getLogger(DNASequencer.class.getName());
    public DNASequencer() {
        logger.info("Starting sequencer...");
    }

    /*public void main (String args[]) {
        List<String> part = new ArrayList<String>();
        part.add()
    }*/
    public String calculate(List<String> part){
        String complete_sequence = "";
        int i;
        int total_chains = part.size ();
        /*for (int k = 0; k < total_chains; k++) {
            System.out.println(part.get(k));
        }*/
        for (int j = 0; j < total_chains - 1; j++) {
            i = 0;
            String current_chain = part.get (j);
            String next_chain = part.get (j + i);
            while (current_chain.charAt(i) != next_chain.charAt(0)) {
                complete_sequence += current_chain.charAt(i);
                i++;
            }
        }
        complete_sequence += part.get(total_chains - 1);
        return complete_sequence;
    }
}
