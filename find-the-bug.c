//https://www.hackerrank.com/contests/rookierank-3/challenges/find-the-bug
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
int main()
{
    int n, row = 0, col;
    scanf("%d\n", &n);
    char str[n];
    while (row < n) {
        scanf("%s", str);
        for (col = 0; col < n; col++) {
            if (str[col] == 'X') {
                printf("%d,%d\n", row, col);
                return 0;
            }
        }
        row++;
    }
    return 0;
}
