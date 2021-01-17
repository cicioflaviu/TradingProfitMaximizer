# Trade in Timboektoe
## Facts
* Fluts are manufactured in schuurs
* Every flut is packed in a box
* The price is written on the side of each box
* The price depends on the time it takes to manufacture a flut
* On a good day the price of a flut would be 1 or 2 florins
* On a bad day the price easily rises to 15 florins or more
* This has nothing to do with the quality of the fluts. Each of them had the same value
* In those days fluts sold for 10 florins each in Holland

## Objective
Buy fluts in Timboektoe, sell them in Holland for maximum profit

## Rules
* All schuurs in Timboektoe sell their fluts starting from the top of the pile

# Program

## Input (text)
* First line is the number of schuurs, let's call it Z
* The subsequent Z lines describes a pile of fluts
  * The first number in each line is the amount E of boxes in the pile
  * The  subsequent numbers in each line are the prices (in florins) of the fluts in the pile, from top to bottom
* The input ends with a test case with 0 amount of schuurs  
    
## Output (console)
* For each test case the program will print:
  * A line containing test case number (the amount of schuurs)
  * A line containing the amount of fluts that the merchant has to buy to obtain the predicted profit
    * If there are multiple amount options, only the 10 smallest are printed
  * A blank line which acts as a separator between test cases
  
## Possible Improvements
### Testing
* Improve testability by moving the private methods from `Application` into a separate class, and make them public
* Implement unit tests for the previously mentioned methods, and also for `MaximumProfit` and `TestCaseUtil`
### Validation
* Add validation for the input file
* Implement special exception for the file validation
### Performance
* Execute each test case in a new thread