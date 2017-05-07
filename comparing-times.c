//https://www.hackerrank.com/contests/rookierank-3/challenges/comparing-times
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
int main()
{
    int q;
    char t1[7], t2[7];
    int h1, h2, m1, m2, t1_int, t2_int;
    char tmp[2];
    scanf("%d\n", &q);
    while (q--) {
        scanf("%s %s", t1, t2);
        if (t1[0] == '1' && t1[1] == '2') {
            h1=0;
        } else {
            tmp[0] = t1[0];
            tmp[1] = t1[1];
            h1 = atoi(tmp);
        }
        if (t1[5] == 'P') {
            h1 = h1 + 12;
        }
        tmp[0] = t1[3];
        tmp[1] = t1[4];
        m1 = atoi(tmp);
        if (t2[0] == '1' && t2[1] == '2') {
            h2=0;
        } else {
            tmp[0] = t2[0];
            tmp[1] = t2[1];
            h2 = atoi(tmp);
        }
        if (t2[5] == 'P') {
            h2 = h2 + 12;
        }
        tmp[0] = t2[3];
        tmp[1] = t2[4];
        m2 = atoi(tmp);
        t1_int = (h1 * 100) + m1;
        t2_int = (h2 * 100) + m2;
        if (t1_int < t2_int) {
            printf("First\n");
        } else {
            printf("Second\n");
        }
    }
    return 0;
}
