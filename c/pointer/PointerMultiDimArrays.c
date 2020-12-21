#include <string.h>
#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
#include <assert.h>
#include <ctype.h>

int main()
{
    //B[i][j] = *(B[i] + j) = *(*(B+i) + j)
    int B[2][3] = {{1, 2, 3}, {4, 5, 6}};
    int(*p)[3] = B;
    //same
    printf("%d\n", B);
    printf("%d\n", *B);
    printf("%d\n", B[0]);
    printf("%d\n", &B[0][0]);

    for (int i = 0; i < 2; i++)
    {
        for (int j = 0; j < 3; j++)
        {
            printf("%d", *(*(p + i) + j));
        }
    }
    return 0;
}