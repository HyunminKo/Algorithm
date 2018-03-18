#include <cstdio>
//const int Sunday = 0;
//const int Monday = 1;
//const int Tuesday = 2;
//const int Wednesday = 3;
//const int Thursday = 4;
//const int Friday = 5;
//const int Saturday = 6;

enum DayOfWeek {
    Sunday = 0,
    Monday,
    Tuesday,
    Wednesday,
    Thursday,
    Friday,
    Saturday
};

int main()
{
    enum DayOfWeek week;    // 열거형 변수 선언
    
    week = Tuesday;    // 열거형 값 할당
    
    printf("%d\n", week);   // 2: Tuesday의 값 출력
    
    return 0;
}
