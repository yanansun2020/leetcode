#include <string.h>
#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
#include <assert.h>
#include <ctype.h>

int main(){
    int a = sizeof(int);
    int b = 10;
    int *pA = &b;
    printf("---> %p, %pn", pA, pA + 1);
    printf("size of int is %d \n", *pA);
    return 0;

    // pointer to pointer
    int ** q = &pA;

}