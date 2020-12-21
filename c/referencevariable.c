#include <string.h>
#include <stdio.h>
#include <stdlib.h>
//声明指针
void swap(int *num1, int *num2){
    int tmp = *num1;
    *num1 = *num2;
    *num2 = tmp;
}
int main(){
    // FILE *fpointer = fopen("a.txt", "w");
    // fprintf(fpointer, "Jim, Sal, \n Penny");
    int num1 = 1;
    int num2 = 2;
    swap(&num1, &num2);
    printf("num1 is %d, num2 is %d\n", num1, num2);
    return 0;

}
