/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 *
 * @author mk
 */
public class HeureSystem {
    
    private String timeStamp;
    
    public HeureSystem() {
    }
    
    public String getCurrentTimeStamp() {        
                
                String timeStamp = new SimpleDateFormat("yyyy.MM.dd HH.mm.ss.SSSSS").format(new Timestamp(System.currentTimeMillis()));
		//java.util.Date today = new java.util.Date();
		return timeStamp;
	}
    
    
}

    
