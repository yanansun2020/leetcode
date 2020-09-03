#include<stdio.h>
#include<stdlib.h>

int main(){
    int age = 30;
    int *pAge = &age;

    double gpa = 3.4;
    double *pGpa = &gpa;

    char grade = 'A';
    char *pGrade = &grade;

    printf("age %p\n", pAge);
    //dereference a pointer, get the value from the pointer
    printf("age %d\n", *pAge);

    printf("gpa %f\n", *&gpa);
    printf("grade %p\n", &grade);
}