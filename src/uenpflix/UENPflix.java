/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uenpflix;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author jscal
 */
public class UENPflix {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        String horario = String.valueOf(sdf.format(new Date()));
        JOptionPane.showMessageDialog(null, horario);
        
    }
    
}
