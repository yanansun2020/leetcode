#include <string.h>
#include <stdio.h>
#include <stdlib.h>
struct Student
{
    /* data */
    char name[50];
    char major[50];
    int age;
    double gpa;
} s ;

int main(){
    struct Student student1;
    student1.age = 22;
    student1.gpa = 3.2;
    strcpy(student1.name, "yanan");
    strcpy(student1.major, "business");

    printf("%f", student1.gpa);
    return 0;
}
