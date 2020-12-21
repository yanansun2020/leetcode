#include <stdio.h>
#include <stdlib.h>

int main()
{
    int nums[] = {567, 89, 90};

    int *pNums = nums;
    // int a = sizeof(nums);
    for (int i =0; i < 3; i++) {
        printf("address is : %p, value is :%d :  %d\n", nums + i, *(nums + i), pNums[i]);
    }
    int a = 1;
    int const *  pA = &a;
    *pA = 2;
    printf("a is %d\n", *pA);

    int eles[2][2] = {{1,2}, {2,3}};
    for (int i =0; i<2; i++) {
        for (int j =0; j < 2; j++) {
            printf("%d\n", eles[i][j]);
        }

    }
}
