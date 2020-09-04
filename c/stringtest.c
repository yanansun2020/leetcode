#include <string.h>
#include <stdio.h>
#include <stdlib.h>
#include<limits.h>

void main(){
    // int c = getchar();
    // char * pCh ="abc";
    // printf("the length is : %ld\n", strlen(pCh));
    // int a = INT_MIN;
    // int b = abs(a);
    // printf("b is %d", b);

    int a = -1;
    unsigned int b = 0;
    unsigned int c = 2147483648;
    int d = (int)c;

    unsigned int g = -3;
    printf("%d", g);
    printf("d id %d\n", d);
    if(a > b){
        printf("a ");
    }else{
        printf("b");
    }
}