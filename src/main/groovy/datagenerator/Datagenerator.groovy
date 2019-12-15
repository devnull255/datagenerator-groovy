/**
 * The Datagenerator class generates fields of various types for test datasets
 */
package datagenerator

import java.text.SimpleDateFormat

class Datagenerator {
    /**
     * _firstNames is a String list of first names
     */
    List<String> _firstNames = ['Michael', 'Paul', 'Amy', 'George', 'John', 'Thomas'] 
    /**
     * _lastNames is a list of last names
     */
    List<String> _lastNames = ['Mabin', 'Anderson', 'Washington', 'Jefferson', 'Adams', 'Simpson', 'Smithers',
       'Burns', 'Cartman', 'Bravlovski', 'Marsh']
    /** 
     * _states is a list of the 50 state codes
     */
    List<String> _states = ['AL', 'AK', 'AZ', 'AS', 'CA', 'CO', 'CN', 'DE', 'FL', 'GA', 'HI', 'ID','IL', 'IN',
       'IA', 'KS', 'KY', 'LA', 'ME', 'MD', 'MA', 'MI', 'MN', 'MS', 'MO', 'MT', 'NE', 'NV', 'NH', 'NJ', 'NM',
       'NY', 'NC', 'ND', 'OH', 'OK', 'OR', 'PA', 'RI', 'SC', 'SD', 'TN', 'TX', 'UT', 'VT', 'VA', 'WA', 'WV',
       'WI', 'WY']
    /**
     * random is the Random number generator for the class to shuffle lists and generate random integers
     */ 
    Random random

    /**
     * The getGreeting method returns the string 'hello world'
     */
    String getGreeting() {
        return 'Hello world.'
    }

    /**
     * Datagenerator constructor
     */
    public Datagenerator() {

       // Create new randomizer
       random = new Random()
    }

    /**
     * The getFirstName method returns a random firstName from _firstNames
     */
    public String getFirstName() {
       Collections.shuffle _firstNames
       _firstNames.first()
    }

    /** 
     * The getLastName method returns a random lastName from _lastNames
     */
    public String getLastName() {
       Collections.shuffle _lastNames
       _lastNames.first()
    }

    /**
     * The nextInt method returns the next randomly-generated integer
     */
    public int nextInt(int range) {
       random.nextInt(range)
    }

    /**
     * The digits method returns a string of digits of length characters
     */
    public String digits(int length) {
        // Returns a string of digits for specified length
        def numString = ''
        length.times { numString += random.nextInt(9).toString() }
        numString
    }

    /**
     * The alpha method returns an alpha character string of length characters 
     */
    public String alpha(int length, String withCase='lower') {
        // Returns a string of letters for specified lengh
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray()
        def alphaString = ''
        length.times { 
               String letter = alphabet[random.nextInt(25)]
               switch(withCase) {
                  case 'lower':
                     letter = letter.toLowerCase()
                     break
                  case 'upper':
                     letter = letter.toUpperCase()
                     break
                  case 'mixed':
                     int anyCase = random.nextInt(2)
                     if (anyCase == 0) {
                        letter = letter.toLowerCase()
                     } else {
                        letter = letter.toUpperCase()
                     }
                     break
                  default: // use lower case for now 
                     println "invalid withCase option: $withCase ignored"
                     break
               }
               alphaString += letter
        }
        alphaString
    }

    /**
     * The getState method returns a random state code from _states
     */
    public String getState() {
      Collections.shuffle _states
      _states.first()
    }
 
    /**
     * The getCurrentDate returns the current date formatted as "yyyy-MM-dd"
     */
    public String getCurrentDate() {
      def curDate = new Date()
      def format = new SimpleDateFormat("yyyy-MM-dd")
      format.format(curDate) 
    }

    /**
     * The getCurrentTimestamp returns the current date and time formatted "yyyy-MM-dd-HH-mm-ss"
     */ 
    public String getCurrentTimestamp() {
      def curTimestamp = new Date()
      def format = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss")
      format.format(curTimestamp)
    }

    static void main(String[] args) {
        Datagenerator dg = new Datagenerator()
        println dg.getGreeting()
        10.times {
            println dg.getFirstName() + ' ' +  dg.getLastName()
            println dg.nextInt(100)
            println dg.digits(9)
            println dg.alpha(11)
            println dg.alpha(15, "lower")
            println dg.alpha(10, "upper")
            println dg.alpha(20, "mixed")
            println dg.getState()
            println dg.getCurrentDate()
            println dg.getCurrentTimestamp()
        }
    }
}
