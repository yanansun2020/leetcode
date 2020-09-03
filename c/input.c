/* $begin hello */
#include <stdio.h>
#include <stdlib.h>
double fun(int i);

int main()
{
     /*double gpa;
    printf("input your age: ");
    scanf("%lf", &gpa);
    printf("your age is %lf\n", gpa); */

    char name[4];
    printf("input your name: ");
    // scanf("%s", name);
    fgets(name, 2, stdin);
    printf("your name is %s\n", name);
    return 0;


    // array
    int numbers[] = {1,2,3};
    int array[4];
    //function
}