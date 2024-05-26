// functions.h

#ifndef FUNCTIONS_H
#define FUNCTIONS_H

#include <stdbool.h>

// Struct to hold the data
typedef struct {
    int number1;
    int number2;
    int product;
    int sum;
} Data;

// Function to generate random numbers between 1 and 100
void generateNumbers(int *number1, int *number2);

// Function to verify the solution
bool verifySolution(Data data);

#endif // FUNCTIONS_H
