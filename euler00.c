//https://www.hackerrank.com/contests/projecteuler/challenges/euler001
#include <math.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <assert.h>
#include <limits.h>
#include <stdbool.h>

int main(){
    int t;
    scanf("%d",&t);
    for(int a0 = 0; a0 < t; a0++){
        int n;
        scanf("%d",&n);
        unsigned long int tmp1 = (n-1)/3, tmp2=(n-1)/5, tmp3=(n-1)/15;
        printf("%lu\n", (((tmp1*(tmp1+1))/2)*3) + (((tmp2*(tmp2+1))/2)*5) - (((tmp3*(tmp3+1))/2)*15));
    }
    return 0;
}
