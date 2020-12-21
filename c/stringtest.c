#include <string.h>
#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
#include <assert.h>
#include <ctype.h>

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
    long l = 123L;

    int testUnsigned = 123u;
    printf("this is unsigned int %d\n", testUnsigned);


    const char *s1 = "String";
    char *s2 = strdup(s1);
    printf("s2 is %s\n, length of s1 is %ld\n", s2, strlen(s1));
    free(s2);

    char dddd = 'a';
    printf("a is %d, %c", dddd, dddd);

    char digits = 'a';
    int x = 1;
    x = digits;
    // digits = x;

    float p = 2.2;
    int q = 1;
    if(p+q > 3){
        printf("<3");
    }

    int m = 2;
    int n = ~2;
    printf("%d", n);


    int isDigit = isdigit(digits);
    if(isDigit){
        printf("This is a digit");
    }else{
        printf("Not a digit");
    }

}