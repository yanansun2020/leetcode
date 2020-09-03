#include <stdio.h>
#include <stdlib.h>

int main()
{
    int nums[] = {567, 89, 90};
    // int a = sizeof(nums);
    for (int i =0; i < 3; i++) {
        printf("%d\n", nums[i]);
    }

    int eles[2][2] = {{1,2}, {2,3}};
    for (int i =0; i<2; i++) {
        for (int j =0; j < 2; j++) {
            printf("%d\n", eles[i][j]);
        }

    }
}
