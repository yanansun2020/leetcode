#include <string.h>
#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
#include <assert.h>
#include <ctype.h>

void print(constchar *c)
{
    //c[0] = 'A';
    int i = 0;
    while (*c != '\0')
    {
        printf("++++++> %c", *c);
        c++;
    }
    printf("\n");
}

int main()
{
    char a[3];
    for (int i = 0; i < 3; i++)
    {
        a[i] = 'C';
    }
    printf("%s\n", a);
    // char b[4];
    // for (int i = 0; i < 3; i++){
    //     b[i] = 'C';
    // }
    // b[3] = '\0';

    // printf("%s\n", b);
    char c[] = "John"; //char c[5] = {'J', 'o', 'h', 'n', '\0'}; '\0' is needed   char c[5] = "John"
    int len = strlen(c);
    char *c1 = c; //return the first element of the array
    printf("Char is %c, %c\n", c1[0], *(c1 + 1));

    //arrays are always passed to function by reference

    char *C = "Hello"; //store as sonstant  C[] = "hello", C[0] = 'A'
    //C[0] = 'A';
    print(C);
}
