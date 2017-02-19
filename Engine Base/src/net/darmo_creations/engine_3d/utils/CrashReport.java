package net.darmo_creations.engine_3d.utils;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

/**
 * This class is used to write error log files.
 * 
 * @author Damien Vergnet
 */
public class CrashReport {
  private static final List<String> funPhrases;
  
  static {
    funPhrases = new ArrayList<String>();
    
    funPhrases.add("Ouch!");
    funPhrases.add("This doesn't make any sense!");
    funPhrases.add("Please, don't hurt me!");
    funPhrases.add("Why did you do that?!");
    funPhrases.add("I won't do it again, I promise!");
    funPhrases.add("Sorry :(");
    funPhrases.add("That's not my fault!");
    funPhrases.add("Hey! ò∧ó");
  }
  
  private Throwable cause;
  private Calendar when;
  
  /**
   * Creates a new report.
   * 
   * @param cause the cause of the bug
   */
  public CrashReport(Throwable cause) {
    this.cause = cause;
    this.when = Calendar.getInstance();
  }
  
  /**
   * @return the cause
   */
  public Throwable getCause() {
    return this.cause;
  }
  
  /**
   * Writes the report to a file.
   * 
   * @return the path to the error log or null if the file could not be written
   */
  public String saveReport() {
    String y = "" + this.when.get(Calendar.YEAR);
    String m = addLeadingZero(this.when.get(Calendar.MONTH));
    String d = addLeadingZero(this.when.get(Calendar.DAY_OF_MONTH));
    String h = addLeadingZero(this.when.get(Calendar.HOUR_OF_DAY));
    String i = addLeadingZero(this.when.get(Calendar.MINUTE));
    String s = addLeadingZero(this.when.get(Calendar.SECOND));
    String fName = JarUtils.getJarDir() + String.format("errlog_%s-%s-%s_%s-%s-%s.txt", y, m, d, h, i, s);
    
    try (PrintWriter pw = new PrintWriter(fName, "UTF-8")) {
      Random rand = new Random();
      
      pw.println("--- JTerraria Crash Report ---");
      pw.println("// " + funPhrases.get(rand.nextInt(funPhrases.size())));
      pw.println();
      pw.println("Time: " + m + "/" + d + "/" + y + " " + h + ":" + i + ":" + s);
      pw.println();
      pw.println("--- Exception ---");
      pw.println(this.cause.getClass().getName());
      pw.println();
      pw.println("--- Message ---");
      pw.println(this.cause.getMessage());
      pw.println();
      pw.println("--- Full Stack Trace ---");
      this.cause.printStackTrace(pw);
      
      return fName;
    }
    catch (FileNotFoundException | UnsupportedEncodingException e) {
      Logger.getLogger().severe("Could not write error log.");
      return null;
    }
  }
  
  /**
   * Adds a leading zero if the value is between 0 and 9.
   * 
   * @param val the value
   * 
   * @return the zero-led value
   */
  private static String addLeadingZero(int val) {
    return val >= 0 && val < 10 ? "0" + val : "" + val;
  }
}
