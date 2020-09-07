#include <string.h>
#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
#include <assert.h>
#include <ctype.h>
// a is a copy
// C application memory: Heap, stack, static/global, code(text)
//wrong
void increment(int a){
    a = a + 1;
    // printf("address1 is %d\n", &a);
}


void increment2(int *a){
    *a = *a + 1;
    // printf("address1 is %d\n", &a);
}


int main(){
    int a = 10;
    increment2(&a);
    printf("a is %d, address is\n", a);

    int b = 1;
    int *pB = &b;
    int **pBB = &pB;
    printf("PBB is %d", **pBB);
}


int increment1(int a){
    a = a + 1;
    // printf("address1 is %d\n", &a);
    return a;
}
