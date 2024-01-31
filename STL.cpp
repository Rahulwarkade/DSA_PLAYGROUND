// #include<bits/stdc++.h>
#include <iostream>
using namespace std;

string array[] = {"",    "./",  "ABC",  "DEF", "GHI",
                  "JKL", "MNO", "PQRS", "TUV", "WXYZ"};
void revers(string str) {
  if (str.length() == 0)
    return;
  char ch = str[0];
  revers(str.substr(1));
  cout << ch;
}

void replacePi(string str) {
  if (str.length() == 0)
    return;
  if (str[0] == 'p' && str[1] == 'i') {
    cout << "3.14";
    replacePi(str.substr(2));
  } else {
    cout << str[0];
    replacePi(str.substr(1));
  }
}

void TOH(int disk, char start, char Aux, char end) {
  if (disk > 0) {
    TOH(disk - 1, start, end, Aux);
    cout << "disk " << start << " to disk " << end << endl;
    TOH(disk - 1, Aux, start, end);
  }
}

string removeDup(string str) {
  if (str.length() == 0)
    return "";
  char ch = str[0];
  string ans = removeDup(str.substr(1));
  if (ch == ans[0]) {
    return ans;
  } else {
    return ch + ans;
  }
}

string removeallX(string str) {
  if (str.length() == 0)
    return "";
  char ch = str[0];
  // string ans = removeallX(str.substr(1));
  if (ch == 'x') {
    return removeallX(str.substr(1)) + ch;
  } else {
    return ch + removeallX(str.substr(1));
  }
}

void substr(string str, string ans) {
  if (str.length() == 0) {
    cout << ans << endl;
    return;
  }

  char ch = str[0];
  string ros = str.substr(1);

  substr(ros, ans);
  substr(ros, ans + ch);
}

void subStrwithAscii(string str, string ans) {
  if (str.length() == 0) {
    cout << ans << endl;
    return;
  }

  char ch = str[0];
  int ascii = ch;
  string code = to_string(ascii);
  string ros = str.substr(1);

  subStrwithAscii(ros, ans);
  subStrwithAscii(ros, ans + ch);
  subStrwithAscii(ros, ans + code);
}

void keypad(string str, string ans) {
  if (str.length() == 0) {
    cout << ans << endl;
    return;
  }
  char ch = str[0];
  string code = array[ch - '0'];
  string ros = str.substr(1);

  for (int i = 0; i < code.length(); i++) {
    keypad(ros, ans + code[i]);
  }
}

int main() {
  string str;
  cin >> str;
  char A, B, C;

  revers(str);

  replacePi(str);

  TOH(3, 'A', 'B', 'C');

  cout << removeDup(str) << endl;

  cout << removeallX(str) << endl;

  substr(str, "");

  subStrwithAscii(str, "");

  keypad(str, "");
}