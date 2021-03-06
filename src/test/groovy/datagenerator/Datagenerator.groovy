/*
 * This Spock specification was generated by the Gradle 'init' task.
 */
package datagenerator

import spock.lang.Specification
import java.text.SimpleDateFormat

class DatageneratorTest extends Specification {
    List<String> firstNames = ['Michael', 'Paul', 'Amy', 'George', 'John', 'Thomas']
    List<String> lastNames = ['Mabin', 'Anderson', 'Washington', 'Jefferson', 'Adams', 'Simpson', 'Smithers',
       'Burns', 'Cartman', 'Bravlovski', 'Marsh']
    List<String> states = ['AL', 'AK', 'AZ', 'AS', 'CA', 'CO', 'CN', 'DE', 'FL', 'GA', 'HI', 'ID','IL', 'IN',
       'IA', 'KS', 'KY', 'LA', 'ME', 'MD', 'MA', 'MI', 'MN', 'MS', 'MO', 'MT', 'NE', 'NV', 'NH', 'NJ', 'NM',
       'NY', 'NC', 'ND', 'OH', 'OK', 'OR', 'PA', 'RI', 'SC', 'SD', 'TN', 'TX', 'UT', 'VT', 'VA', 'WA', 'WV',
       'WI', 'WY']


    def "datagenerator has a greeting"() {
        setup:
        def dg = new Datagenerator()

        when:
        def result = dg.greeting

        then:
        result != null
    }
   
    def "datagenerator getFirstName returns what is in firstNames list"() {
        setup:
        def dg = new Datagenerator()

        when:
        def result = dg.getFirstName()
 
        then:
        firstNames.contains(result)
    }

    def "datagenerator getLastName returns a name from lastNames"() {
        setup:
        def dg = new Datagenerator()

        when:
        def result = dg.getLastName()
 
        then:
        lastNames.contains(result)
    }

    def "datagenerator nextInt returns an int in range"() {
        setup:
        def dg = new Datagenerator()

        when:
        def result = dg.nextInt(100)

        then:
        result >= 0 && result < 100
    }

    def "datagenerator digits returns a numeric string of n length"() {
        setup:
        def dg = new Datagenerator()

        when:
        def result = dg.digits(9)

        then:
        result.length() == 9
        result.isNumber()
    }

    def "datagenerator alpha returns an alpha string of n length"() {
        setup:
        def dg = new Datagenerator()
 
        when:
        def result = dg.alpha(8)
        
        then:
        result.length() == 8
        result.matches("[a-zA-Z]+")
    }

    def "datagenerator alpha returns string of lower case"() {
        setup:
        def dg = new Datagenerator()
     
        when:
        def result = dg.alpha(10, "lower")

        then:
        result.matches("[a-z]+")
    }

    def "datagenerator alpha returns string of upper case"() {
        setup:
        def dg = new Datagenerator()

        when:
        def result = dg.alpha(10, "upper")

        then:
        result.matches("[A-Z]+")
    }

    def "datagenerator alpha returns string of mixed case"() {
        setup:
        def dg = new Datagenerator()

        when:
        def result = dg.alpha(20, "mixed")
        
        then:
        result.matches("[a-zA-Z]+")
     }        
    
    def "datagenerator getState returns a state in states list"() {
        setup:
        def dg = new Datagenerator()

        when:
        def result = dg.getState()

        then:
        states.contains(result)

    }
    
    def "datagenerator getCurrentDate returns formatted current date string"() {
        setup:
        def dg = new Datagenerator()
        def curDate = new Date()
        def format = new SimpleDateFormat("yyyy-MM-dd")
        def curDateString = format.format(curDate)

        when:
        def result = dg.getCurrentDate()
        
        then:
        curDateString == result
    }

    def "datagenerator getCurrentTimestamp returns formatted timestamp string"() {
        setup:
        def dg = new Datagenerator()
        def curTimestamp = new Date()
        def format = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss")
        def curDateString = format.format(curTimestamp)

        when:
        def result = dg.getCurrentTimestamp()
        
        then:
        curDateString == result
    }

}
