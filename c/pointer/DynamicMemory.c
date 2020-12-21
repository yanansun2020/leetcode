#include <string.h>
#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
#include <assert.h>
#include <ctype.h>
//malloc calloc realloc free
int loc()
{
    int a;
    int *p = malloc(sizeof(int));
    if (p == NULL)
    {
        return 0;
    }
    *p = 10;
    *(p + 1) = 11;
    printf("%d\n", *(p + 1));
    free(p);
    p = malloc(sizeof(int));
    if (p == NULL)
    {
        return 0;
    }
    *p = 20;
    printf("%d\n", *p);
    free(p);

    int *q = calloc(2, sizeof(int));
    // realloc(q, 3 * sizeof(int));
    free(q);
}

int main()
{
    int n;
    scanf("%d", &n);
    int *A = calloc(n, sizeof(int));
    // int *A = malloc(n * sizeof(int));

    for (int i = 0; i < n; i++)
    {
        *(A + i) = i + 1;
    }
    for (int i = 0; i < n; i++)
    {
        printf("%d ", *(A + i));
    }
    free(A);

    return 0;
}