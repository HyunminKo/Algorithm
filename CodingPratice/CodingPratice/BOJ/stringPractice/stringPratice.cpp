//출처 http://gakari.tistory.com/entry/CC-STL-%EB%9D%BC%EC%9D%B4%EB%B8%8C%EB%9F%AC%EB%A6%AC-string-%ED%95%A8%EC%88%98-%EC%82%AC%EC%9A%A9%EB%B2%95

#include <string>
#include <iostream>
using namespace std;

int main(){
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    // 생성및 초기화
    string str1 = "ABCDE";
    string str2 = ("FGH");
    
    string str3 = str2;
    
    string str4 = str1 + str2;
    
    
    
    cout << "str1= " << str1 << " addr: "<< &str1 <<'\n';
    cout << "str2= " << str2 << " addr: "<< &str2 <<'\n';
    cout << "str3= " << str3 << " addr: "<< &str3 <<'\n';
    cout << "str4= " << str4 << " addr: "<< &str4 <<'\n';

    //string 객체생성시, 인자로 문자를 지정할수는 없다.
    // char ch = 'A';
    // string str6 = ch;  //에러발생
    // string str7 = 'A'; //에러발생
    // string str8('A');  //에러발생
    
    
    
    string str8(1, 'A');  //한문자 대입은 이렇게합니다.
    string str9(str1, 2, 3);// 2번째 인덱스에서 시작하여, 3개의 글자를 대입
    cout << "str8= " << str8 << " addr: "<< &str8 <<'\n';
    cout << "str9= " << str9 << " addr: "<< &str9 <<'\n';
    
    

    // 길이

    string str10 = "Hello, Hyunmin";
    string::size_type len;

    cout << "str10= " << str10 << '\n';
    len = str10.length();
    cout << "length()= " << len << '\n';
    
    len = str10.size();
    cout << "size()= " << len << '\n';
    


    // c_str

    string str11 = "Good Job";
    char arr[9];
    strcpy(arr, str11.c_str()); // string객체에서, char형 문자열 포인터로 변환은 c_str()함수로..
    cout << "arr= " << arr << endl;



    // insert

    string str12 = "abcdefghi";
    string str13 = "0123";

    str12.insert (3,str13); //3번째 인덱스에 str13내 문자열을 삽입
    cout << "str12= " << str12 << endl; // "abc0123defghi"


    
    // erase
    string str14 = "123456";
    str14.erase(2, 3); //2번째 인덱스부터, 3개의 문자를 삭제
    cout << "str14= " + str14 << endl;



    // replace
    string str15 = "abcdefghi";
    string str16 = "123";
    str15.replace (4,5,str16);//4번째 인덱스부터, 2개의 문자를 str16문자열로 대체..
    cout << "str15= " << str15 << endl;



    // find, rfind
    string str17 = "abcdefghi";
    string str18 = "cde";
    string::size_type pos = str17.find(str18, 0); //0번째 인덱스부터, "cde"가 일치하는 시작위치를 리턴

    cout << "Position of find is " << pos << endl; // 2

    pos = str17.find("123",0);
    
    if (pos == string::npos)
        cout << "Not found" << endl;

    pos = str17.rfind(str18, str17.length()-1); //str17의 마지막 인덱스부터, 뒤에서 검색하며, 맨처음 일치하는 위치를 리턴
    cout << "Position of rfind is " << pos << endl; // 2

//
//
//    // find_first_of, find_last_of
//
//    string str20 = "Hello Codein";
//    
//    string str21 = "abcde";
//
//    pos = str20.find_first_of (str21, 0); //0번째 인덱스부터, str21 문자열중 하나의 문자라도 일치하는 위치를 리턴
//    
//    cout <<  "Position of find_first_of is " << pos << endl; // 1
//
//    pos = str20.find_last_of ("abcde"); // str20의 마지막 인덱스부터, 뒤에서 검색하며, 맨처음 일치하는 위치를 리턴
//
//    cout << "Position of find_last_not_of is " << pos << endl; // 11
//
//    
//
//
//    
//    // substr
//    
//    string str22 = "123456789";
//
//    string str23 = str22.substr (6,2); //6번째 인덱스부터, 2개의 문자를 취해서 리턴
//
//    cout << "substr()= " << str23 << endl; // "78"
//
//
//
//    // 연산자(=, +, +=, ==, <<, >>, [])
//
//    // "=" (= 연산자를 사용하여, 다른 string 객체의 문자열을 대입가능)
//
//    string s1 = "Hello";
//
//    string s2;
//
//    s2 = s1;
//
//    cout << "s1= " << s1 << ", s2= " << s2 << endl;
//
//
//
//    string s3;
//
//    s3 = "Codein!!"; // 직접 문자열을 대입가능
//
//    cout << "s3= " << s3 << endl;
//
//
//
//    string s4;
//
//    char ch2 = 'C';
//
//    s4 = ch2; //문자 대입가능 (생성시, 대입은 허용되지 않음, string s4 = 'C': 잘못됨)
//    
//    s4 = 'A';
//
//
//
//    // "+" 연산자
//
//    // 두개의 string 객체에 "+" 연산자를 사용하여 연결가능
//
//    string s5 = "Hello ";
//
//    string s6 = "Korea";
//
//    string s7 = s5 + s6; // "Hello Korea"
//
//    cout << "s7= " << s7 << endl;
//    
//
//
//    // 하나의 string 객체와 직접문자열을 "+" 연산자를 사용하여 연결가능
//
//    string s8 = "Hello ";
//    
//    string s9 = s8 + "Mr Chin";
//
//    cout << "s9= " << s9 << endl;
//
//
//
//    // 하나의 string 객체와 문자를 "+" 연산자를 사용하여 연결가능
//
//    string s10 = "Hello ";
//
//    string s11 = s10  + '!';
//
//    cout << "s11= " << s11 << endl;
//
//
//
//    // "+=" 연산자
//
//    string s12 = "Hello ";
//
//    s12 += "*^^*";
//
//    cout << "s12= " << s12 << endl;
//
//
//
//    // "<<" 연산자
//
//    // string 객체를 출력스트림으로 전송
//
//    string s13 = "How are you?";
//
//    cout << s13 << endl;
//
//
//
//    // ">>" 연산자
//
//    // 입력스트림으로 부터 문자열을 읽어서 string 객체에 저장
//
//    string s14;
//
//    cout << "입력후 엔터키를 눌러주세요" <<endl;
//
//    cin >> s14;
//
//
//
//    // [] 연산자
//
//    // []는 string 객체내 하나의 문자에 접근할수 있도록 해줌
//
//    string s15 = "abcdef";
//
//    char ch3 = s15[3];
//
//    cout << "ch3= " << ch3 << endl;
//
//    s15[2] = 'Z';
//
//    cout << "s15= " << s15 << endl;
//
//
    
    return 1;
    
}
