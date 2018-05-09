#include <cstdio>
#define MAX 1000
class Stack{
    int top;
public:
    int a[MAX];
    Stack(){
        this->top = -1;
    }
    bool push(int x);
    int pop();
    bool isEmpty();
};
bool Stack::push(int x){
    if(top >= MAX){
        printf("The stack is full\n");
        return false;
    }else{
        a[++top] = x;
        return true;
    }
}
bool Stack::isEmpty(){
    return (top < 0);
}
int Stack::pop(){
    if(isEmpty()){
        printf("The stack is empty\n");
        return -1;
    }else{
        return a[top--];
    }
}
int main(){
    Stack s;
    s.push(5);
    s.push(3);
    s.push(7);
    s.push(8);
    while(!s.isEmpty()){
        printf("%d\n",s.pop());
    }
}
