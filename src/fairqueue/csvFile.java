/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fairqueue;

import java.util.Date;

/**
 *
 * @author Sayyed Shozib Abbas
 */
class csvFile {
    public Date startdate;
    public Date enddate;
    public String activity;
    
    csvFile(Date a, Date b, String c) {
        startdate = a;
        enddate = b;
        activity = c;
    }
}
