#include <iostream>
using namespace std;
int main() {
    int n, a, max = -2147000000, min = 2147000000;
    cin >> n;

    for (int i = 0; i < n; i++) {
        cin >> a;
        if (a < min)
            min = a;
        if (a > max)
            max = a;
    }
    cout << max - min;
    
    return 0;
}
