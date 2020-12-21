/* $begin hello */
#include <stdio.h>
// #include <stdlib.h>
double fun(int i);

int main()
{
    char name[] = "John";
    int age = 30;
    double ans = fun(0);
    printf("hello %s%lf\n", name, ans);
    ans = fun(1);
    printf("hello %s%lf\n", name, ans);
    ans = fun(2);
    printf("hello %s%lf\n", name, ans);
    ans = fun(3);
    printf("hello %s%lf\n", name, ans);
    return 0;
}

typedef struct {
    int a[2];
    double d;
} struct_t;

double fun(int i){
    volatile struct_t s;
    s.d = 3.14;
    s.a[i] = 3;
    return s.d;
}

/* $end hello */