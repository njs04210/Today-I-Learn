#include <iostream>
using namespace std;
int main() {
    
    char n[20];
    int age, year;

    cin >> n;

    //char형 아스키코드에서 int형 숫자로 변환
    n[0] -= 48; 
    n[1] -= 48;

    if (n[7] == '1' || n[7] == '2')
        year = 1900 + n[0] * 10 + n[1];
    else
        year = 2000 + n[0] * 10 + n[1];

    age = 2019 - year + 1;
   
    cout << age;

    if (n[7] == '1' || n[7] == '3')
        cout << " " << 'M';
    else
        cout << " " << 'W';

    return 0;
}