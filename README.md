# Transformer Battle
ccf
Robot fighting command line application.

## Requirements

- JUnit4 for Testing
- Java 1.8 Runtime

## Getting Started

javac Main.java Battle.java Transformer\/\*.java Exception/*.java

### Usage

Use - main \<input file.txt\>

The input text file must follow this format:

\<transformer name>, <A/D>, #,#,#,#,#,#,#,#

...

eg.
Soundwave, D,8,9,2,6,7,5,6,10

Bluestreak, A,6,6,7,9,5,2,9,7

## Notes

- Future improvements could be made by decoupling the 'Battle Rules' from the Battle class. A possible approach would be to use a Strategy Pattern.
- Dependency Injection could be used to modularize code for better maintainability, mocking and unit testing.
- Additional robustness could be added around the file input and scanning.
