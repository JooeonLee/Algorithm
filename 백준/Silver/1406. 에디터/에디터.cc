#include <bits/stdc++.h>

using namespace std;

std::stack<char> lStack;
std::stack<char> rStack;

void move_left();
void move_right();
void add_char(char c);
void delete_char();
void print_queue();

int main() {

    string str;
    char o1, c;
    int num;
    cin >> str;
    cin >> num;
    
    for(int i=0; i<str.size(); i++)
        lStack.push(str[i]);

    for(int i=0; i<num; i++) {
        cin >> o1;
        if(o1 == 'L')
            move_left();
        else if(o1 == 'D')
            move_right();
        else if(o1 == 'B')
            delete_char();
        else {
            cin >> c;
            add_char(c);
        }
    }
    print_queue();
    return 0;
}

void move_left() {
    char temp;

    if(lStack.empty())
        return;
    else {
        temp = lStack.top();
        lStack.pop();
        rStack.push(temp);
        return;
    }
}

void move_right() {
    char temp;

    if(rStack.empty())
        return;
    else {
        temp = rStack.top();
        rStack.pop();
        lStack.push(temp);
        return;
    }
}

void add_char(char c) {
    lStack.push(c);
}

void delete_char() {
    if(lStack.empty())
        return;
    else {
        lStack.pop();
        return;
    }
}

void print_queue() {
    char temp;
    while(!lStack.empty()) {
        move_left();
    }

    while(!rStack.empty()) {
        temp = rStack.top();
        cout << temp;
        rStack.pop();
    }
    cout << '\n';
    return;
}