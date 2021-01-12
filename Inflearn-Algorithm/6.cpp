#include <stdio.h>
using namespace std;
int main()
{
    char n[50];
    int i, res = 0, cnt = 0;

    scanf("%s", &n);

    for (i = 0; n[i] != '\0'; i++) {
        if (n[i] >= 48 && n[i] <= 57) {
            res = res * 10 + (n[i] - 48);
        }
    }

    for (i = 1; i <= res; i++) {
        if ( res % i == 0 )
            cnt++;
    }

    printf("%d %d", res, cnt);

    return 0;
}