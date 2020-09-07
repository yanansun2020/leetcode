#include <string.h>
#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
#include <assert.h>
#include <ctype.h>
//address - &A[i] or
//value A[i] or *(A+i)


int sum(int *A, int size){
    int size1 = sizeof(A)/sizeof(A[0]);
    int sum = 0;
    for(int i =0; i< size; i++){
        sum += A[i];//*(A+i)
    }
    return sum;
}


int main(){
    int A[] = {1,2,3};
    printf("%d\n", A);
    printf("%d\n", &A[0]);
    printf("%d\n", A[0]);
    printf("%d\n", *(A+0));

    int *p = A;
    for(int i =0; i< 3; i++){
        printf("%d\n", p);
        printf("%d\n", *(p+i));
    }


    int b[] = {4,5,6,8,9,10};
    int size = sizeof(b)/sizeof(b[0]);
    int sum0 = sum(b, size);
    printf("sum is %d", sum0);

}


