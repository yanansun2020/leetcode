#include <stdio.h>
#include <stdlib.h>

double fun(int i){
    return i * i;
}

void sayhi(char s[]){
    printf("hello %s", s);
}

char* getNames(char s[]){
    return "abs";
}

int * getAge(){
    static int arr[5];
    for(int i=0;i<5;i++){
        //scanf("%d", &arr[i]);
        arr[i] = 1;
    }
    return arr;
}

int main()
{
    int *ages = getAge();
    printf("ages : %d\n", ages[1]);

    int age = 30;
    int *p = &age;
    printf("age : %p\n", p);
    printf("age : %p\n", &*p);


    char *ans0 = getNames("12");
    printf("ans0 is %p\n", ans0);
    double ans = fun(2);
    printf("%lf\n", ans);
    sayhi("yanan");
}
