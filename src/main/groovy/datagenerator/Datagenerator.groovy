/*
 * This Groovy source file was generated by the Gradle 'init' task.
 */
package datagenerator

class Datagenerator {
    List<String> _firstNames = ['Michael', 'Paul', 'Amy', 'George', 'John', 'Thomas'] 
    List<String> _lastNames = ['Mabin', 'Anderson', 'Washington', 'Jefferson', 'Adams', 'Simpson', 'Smithers',
       'Burns', 'Cartman', 'Bravlovski', 'Marsh']
    Random random
    String getGreeting() {
        return 'Hello world.'
    }

    public Datagenerator() {

       // Create new randomizer
       random = new Random()
    }

    public String getFirstName() {
       Collections.shuffle _firstNames
       _firstNames.first()
    }

    public String getLastName() {
       Collections.shuffle _lastNames
       _lastNames.first()
    }

    public int nextInt(int range) {
       random.nextInt(range)
    }

    public String digits(int length) {
        // Returns a string of digits for specified length
        def numString = ''
        length.times { numString += random.nextInt(9).toString() }
        numString
    }

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
        }
    }
}
