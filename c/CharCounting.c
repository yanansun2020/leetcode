#include <stdio.h>
#include <stdlib.h>

int main()
{
    int c  ;
    while ((c= getchar()) != EOF){
        putchar(c);
    }


    double nc;
    for (nc = 0; getchar() != EOF; ++nc);
    printf("%.0f\n", nc);
}