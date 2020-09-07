#include <string.h>
#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
#include <assert.h>
#include <ctype.h>

int *add(int *a, int *b)
{
    int *c = malloc(sizeof(int));
    *c = *a + *b;
    return c;
}

int main()
{
    int x = 2, y = 3;
    int *k = add(&x, &y);
    free(k);
    printf("sum = %d", *k);
}