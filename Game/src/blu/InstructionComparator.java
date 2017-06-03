/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blu;

import java.util.Comparator;

/**
 *
 * @author Archax
 */
public class InstructionComparator implements Comparator<instructionClass>{

    @Override
    public int compare(instructionClass o1, instructionClass o2) {
       return o1.getPriority() - o2.getPriority();
    }
   
}
