#include <stdio.h>
#include <stdlib.h>

double fun(int i){
    return i * i;
}

void sayhi(char s[]){
    printf("hello %s", s);
}

int main()
{
    double ans = fun(2);
    printf("%lf", ans);
    sayhi("yanan");
}
