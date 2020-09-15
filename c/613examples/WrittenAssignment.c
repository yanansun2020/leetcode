#include <stdint.h>
#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

float sum_elements(float a[], unsigned length)
{
    int i;
    float result = 0;
    for (i = 0; i <= length - 1; i++)
        result += a[i];
    return result;
}
int main()
{
    unsigned int a = 2147483648;
    int b = (int)a;
    printf("a = %d\n", a);
    printf("b = %d\n", b);

    float x = (3.14 + 1e20) - 1e20;
    float y = 3.14 + (1e10 - 1e10);
}