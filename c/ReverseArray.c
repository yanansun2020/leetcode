#include <string.h>
#include <stdio.h>
#include <stdlib.h>

int * reverse(int * array, int size){
    for (int i =0; i < size/2; i++) {
        int tmp = array[i];
        array[i] = array[size - i - 1];
        array[size - i - 1] = tmp;
    }
    return array;
}

int * reverse1(int * array, const int size){
    //int result[size]; cannot return local varible, because when the function
    // is executed, the variable is gone. Do in-place reverse or use malloc
    //int *result = int[size];
    int* result = malloc(sizeof(int) * size);
    for (int i =0; i < size; i++) {
        result[size - i - 1] = array[i];
    }
    return result;
}

void main(){
    int array[] = {1, 2, 3, 4};
    int *ans = reverse1(array, 4);
    // reverse(array, 4);
    for (int i = 0; i < 4; i++) {
        printf("%d\n", ans[i]);
    }
    free(ans);
}