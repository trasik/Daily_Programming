# Daily Programming Exercises

## November 6, 2021

### Print the Elements of a Linked List

This is an to practice traversing a linked list. Given a pointer to the head node of a linked list, print each node's data element, one per line. If the head pointer is null (indicating the list is empty), there is nothing to print.

#### Constraints

* 1 &leq; N &leq; 1000
* 1 &leq; list[i] &leq; 1000, where list[i] is the ith element of the linked list


### Sales by Match

There is a large pile of socks that must be paired by color. Given an array of integers representing the color of each sock, determine how many pairs of socks with matching colors there are.

#### Constraints

* 1 &leq; n &leq; 100
* 1 &leq; ar[i] &leq; 100, where 0 &leq; i &lt; n

## November 7, 2021

### Super Reduced String

Reduce a string of lowercase characters in range ascii[āaā..āzā]by doing a series of operations. In each operation, select a pair of adjacent letters that match, and delete them.

Delete as many characters as possible using this method and return the resulting string. If the final string is empty, return Empty String

#### Constraints

* 1 &leq; length of String s &leq; 100

### The Hurdle Race

A video player plays a game in which the character competes in a hurdle race. Hurdles are of varying heights, and the characters have a maximum height they can jump. There is a magic potion they can take that will increase their maximum jump height by  unit for each dose. How many doses of the potion must the character take to be able to jump all of the hurdles. If the character can already clear all of the hurdles, return .

#### Constraints

* 1 &leq; n, k &leq; 100
* 1 &leq; height[i] &leq; 100

## November 16, 2021

### Implementation of Singly LinkedList

#### Updates

- Implements a standard Singly Linked List data structure
- Adds the methods isEmpty, getSize, getFirst add, addFirst, removeFirst, contains, and get
- Adds testing to the Driver class to test all the methods for functionality
- Adds a check to the add method to check if the list is empty ? set the head to new node : carry on with rest of the add
- Adds a clear function to completely remove the list by setting the head to null

## November 17, 2021

### Implementation of Doubly LinkedList

#### Updates

- Implements a Node class with three properties prev, next, and data
- Implements the getSize, isEmpty, contains, add, get, and toString methods
- Added addTailLink helper method to connect with the add and addLast methods
- Added removeHeadLink helper method to connect with the removeFirst and remove methods
- Added getFirst and getLast auxiliary methods
- Added a new add method to add at a certain index with the help of auxiliary method addLinkBefore
- Added remove at a certain index which internally helps garbage collection