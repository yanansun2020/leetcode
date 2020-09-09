#include <stdio.h>
#include <stdlib.h>
//x ^ y = (x & ~y) | (~x & y)
void inplace_swap(int *x, int *y)
{
    //with third location
    // int mask = *x ^ *y;
    // *x = *x ^ mask;
    // *y = *y ^ mask;
    // no third location
    *y = *x ^ *y;
    *x = *x ^ *y;
    *y = *x ^ *y;
}
//for array with oddd number, the middle ele is not applicable inplace_swap
//because x y point to same address, they will both become 0
void reverse_array(int a[], int cnt)
{
    int first, last;
    for (first = 0, last = cnt - 1;
         first < last; first++, last--)
        inplace_swap(&a[first], &a[last]);
}
int main()
{
    int array[] = {1, 2, 3, 4, 5};
    reverse_array(array, 5);
    int x = 2;
    int y = 2;
    inplace_swap(&x, &y);
    int c = !'b';
    if ('a' && ~'b')
    {
        printf("hahah\n");
    }

    int a = (int)2147483648U;
    printf("a = %d\n", a);
    float f = 7.0;
    short k = f;
    short s = *(short *)&f;
    printf("short is %d", s);
}