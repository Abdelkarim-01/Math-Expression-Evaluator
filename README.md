# Math-Expression-Evaluator
Math expression evaluator implemented with Java.
## Problem statement
We have been assigned the task of creating a command-line application capable of processing
mathematical expressions provided in the following format:
````
./your_binary '1 + (2 * 3 - 10.5)'
````
Our objective is to ensure that our solution produces a valid response for valid expressions, 
while also detecting and reporting malformed expressions.

Furthermore, our application should support basic arithmetic operations involving both integer
and double values. Additionally, it should accommodate standard mathematical functions such as:
- `cos`, `acos`, `sin`, `asin`, `tan`, `atan`
- `sqrt`, `pow`

## Solution statement

Evaluating mathematical expressions is a common task in computer science, often required in various
domains such as calculators, programming languages, automation systems, etc. The recursive descent parser
approach is a popular method for analyzing and evaluating these expressions.

In this solution, we will tackle the task of evaluating mathematical expressions using this approach.
The goal is to create a program capable of taking a mathematical expression as a string, analyzing it,
evaluating its components, and returning the result of the evaluation.

Here is an overview of the process:

#### Lexical Analysis:
We start by dividing the expression into tokens, such as numbers, operators, and functions. 
This step is performed by a lexical analyzer (lexer).
#### Syntax Analysis:
Using the recursive descent parser approach, we analyze the syntactic structure of the expression.
We break down the expression into simpler terms, such as terms, factors, operators, etc.
#### Recursive Evaluation:
We use recursive functions to evaluate each component of the expression. For example,
we evaluate each term, then each factor, and so on.
#### Handling Operators and Functions:
We handle operators (such as +, -, *, /) and mathematical functions (such as sin, cos, sqrt) according 
to their priorities and associations.
Error Handling:

We handle errors such as malformed expressions or division by zero appropriately to ensure 
the robustness of the program.

## Running the Project
1- Clone the Repository: Clone the forked repository to your local machine by
executing the following command in your terminal:
````
 git clone https://github.com/Abdelkarim-01/Math-Expression-Evaluator.git
````
2-Open the project in IntelliJ IDEA IDE.
3-Run the main class to execute the program.
4-Print the expression that you want to evaluate in the console and press Enter.