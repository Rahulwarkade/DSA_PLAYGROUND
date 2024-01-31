#include<bits/stdc++.h>
using namespace std;
void primeSieve(int n)
{
  int arr[n];
  for(int i=0; i<n; i++)
    arr[i] = 0;
  for(int i=2; i<n; i++)
    {
      if(arr[i]==0)
      {
        for(int j=i*i; j<n; j+=i)
          {
            arr[j] = 1;
          }
      }
    }
  for(int i=2; i<n; i++)
    {
      if(arr[i]==0)
        cout<<i<<" ";
    }
}

void primeFactor(int n)
{
  int spf[n];
  for(int i=2; i<=n; i++)
    spf[i] = i;

  for(int i=2; i<=n; i++)
    {
      if(spf[i]==i)
      {
        for(int j=i*i; j<=n; j+=i)
          {
            if(spf[j]==j)
              spf[j]=i;
          }
      }
    }
  while(n!=1)
    {
      cout<<spf[n]<<" ";
      n/=spf[n];
    }
}
int main()
{
  int n;
  cin>>n;
  // primeSieve(n);
  primeFactor(n);
  return 0;
}