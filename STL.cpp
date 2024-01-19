#include<bits/stdc++.h>
using namespace std;

int main(){
    pair<int,string> p;
    p = {2,"abc"};
    cout<<p.first<<" "<<p.second<<endl;

    pair<int,int> pair_array[3];
    pair_array[0] = {2,3};
    pair_array[1] = {3,2};
    pair_array[2] = {3,3};

    for(int i =0; i<3; i++)
        cout<<pair_array[i].first<<" "<<pair_array[i].second<<endl;
}