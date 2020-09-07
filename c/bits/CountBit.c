#include <string.h>
#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
#include <assert.h>
#include <ctype.h>
int bitcount(unsigned x);

int main(){
    int a = 3;
    int count = bitcount(a);
    printf("count : %d\n", count);
    return 0;
}
int bitcount(unsigned x){
    int b;
    for (b = 0; x != 0; x >>= 1){
        if (x & 0x01){
            b++;
        }
    }
    return b;
}