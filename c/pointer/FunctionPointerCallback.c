#include <string.h>
#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
#include <assert.h>
#include <ctype.h>
void A()
{
    printf("Test function pointer");
}

void B(void (*ptr)())
{
    ptr();
}

int compare(int a, int b)
{
    if (a > b)
    {
        return 1;
    }
    return -1;
}
void sort(int *A, int size, int (*compare)(int, int))
{
    int i, j, tmp;
    for (i = 0; i < size; i++)
    {
        for (j = 0; j < size - 1; j++)
        {
            if (compare(A[j], A[j + 1]) > 0)
            {
                tmp = A[j];
                A[j] = A[j + 1];
                A[j + 1] = tmp;
            }
        }
    }
}
int main()
{
    //create a function pointer, return type + parameters
    //void (*p)() = A;
    //B(p);
    //B(A);
    int a[] = {5, 4, 3};
    sort(a, 3, compare);
    for (int i = 0; i < 3; i++)
    {
        printf("%d", a[i]);
    }
}