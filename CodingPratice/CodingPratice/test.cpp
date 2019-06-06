#include <map>
using namespace std;
class SinglyLinkedListNode {
public:
    int data;
    SinglyLinkedListNode *next;
    
    SinglyLinkedListNode(int node_data) {
        this->data = node_data;
        this->next = nullptr;
    }
};

class SinglyLinkedList {
public:
    SinglyLinkedListNode *head;
    SinglyLinkedListNode *tail;
    
    SinglyLinkedList() {
        this->head = nullptr;
        this->tail = nullptr;
    }
    
    void insert_node(int node_data) {
        SinglyLinkedListNode* node = new SinglyLinkedListNode(node_data);
        
        if (!this->head) {
            this->head = node;
        } else {
            this->tail->next = node;
        }
        
        this->tail = node;
    }
};


SinglyLinkedListNode* condense(SinglyLinkedListNode* head) {
    SinglyLinkedListNode* pointer = head;
    SinglyLinkedListNode* prev = head;
    map<int,int> map;
    while(pointer->next != NULL){
        printf("%d ",pointer->data);
        if(map.find(pointer->data) == map.end()){\
            map.insert(make_pair(pointer->data,1));
            prev = pointer;
        }else {
            prev->next = pointer->next;
        }
        pointer = pointer->next;
        if(pointer->next == NULL){
            if(map.find(pointer->data) != map.end()){
                prev->next = NULL;
            }
        }
    }
    return head;
}
int main() {
    
    SinglyLinkedList t1;
    t1.insert_node(3);
    t1.insert_node(4);
    t1.insert_node(3);
    t1.insert_node(2);
    t1.insert_node(6);
    t1.insert_node(1);
    t1.insert_node(2);
    t1.insert_node(6);
    condense(t1.head);
}
