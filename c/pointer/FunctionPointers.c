#include <string.h>
#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
#include <assert.h>
#include <ctype.h>
int add(int x, int y)
{
    return x + y;
}
int main()
{
    //create a function pointer, return type + parameters
    int (*p)(int, int) = add;
    // p = &add;
    int c = (*p)(2, 3);
    printf("%d\n", c);
}