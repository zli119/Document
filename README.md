# Document_Classify
# A program that reads documents of every kind, gueses what the contents are and creates index of documents.

### 1. target

A local program that reads documents of every kind. Gueses what the contents are and creates and index of documents.
(1) Open a folder, it will classify the documents automatically
(2) The Classifier could continue to update 
(2) Store the Classifier and dataset into database

### 2. technology

* Stanford CoreNLP 
* Protege
* Java  
* Java Swing

### 3. principle

⚫ Learning and utilizing ontological link distance to figure out the relationship and degree of words, using K means clustering to create its own categories of commonality

* Read document -> count key words -> ranking -> decide documents label

* Create folders -> classify documents to different folders

Machine learning part

result:  input pdf,  output label
need: 1) train dataset
       has label and pdf
      2) training algorithm   **
How to create the link between Stanford CoreNLP and dataset?

### 4. process
(1) create a program that can do statistics of words in a document.

### 5. The idea of 1th generation product
(1) set some labels in the database:
   1) computer science
   2) physics 
   3) math
   4) nutrition
   5) fiction
   6) poem
   7) 

