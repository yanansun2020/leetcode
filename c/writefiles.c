#include <string.h>
#include <stdio.h>
#include <stdlib.h>

int main(){
    // FILE *fpointer = fopen("a.txt", "w");
    // fprintf(fpointer, "Jim, Sal, \n Penny");

    char line[20];
    FILE *readpointer = fopen("a.txt", "r");
    fgets(line, 10, readpointer);
    printf("%s", line);
    fclose(readpointer);
    // fclose(fpointer);

}