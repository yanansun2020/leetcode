#include <stdio.h>
#include <stdlib.h>
typedef unsigned char *byte_pointer;

void show_bytes(byte_pointer start, size_t len)
{
    size_t i;
    for (i = 0; i < len; i++)
        printf("%p\t 0x%.2x\n", start[i]);
    printf("\n");
}
void show_int(int x)
{
    show_bytes((byte_pointer)&x, sizeof(int));
}

void show_float(float x)
{
    show_bytes((byte_pointer)&x, sizeof(float));
}

void show_pointer(void *x)
{
    show_bytes((byte_pointer)&x, sizeof(void *));
}

int main()
{
    // int ival = 2;
    // float fval = (float)ival;
    // int *pval = &ival;
    // show_int(ival);
    // show_float(fval);
    // show_pointer(pval);

    int a = 15213;
    byte_pointer ap = (byte_pointer)&a;
    show_bytes(ap, sizeof(int)); /* A. */
    // show_bytes(ap, 2);           /* B. */
    // show_bytes(ap, 3);           /* C. */
}