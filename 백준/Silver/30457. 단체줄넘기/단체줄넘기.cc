#include <iostream>
#include <algorithm>
using namespace std;

int main(void)
{
    ios_base::sync_with_stdio(false); cin.tie(NULL);
    int N, i, x, cnt[1010] = { 0 }, ans = 0;
    cin >> N;
    for (i = 0; i < N; i++)
    {
        cin >> x;
        cnt[x]++;
    }
    for (i = 1; i <= 1000; i++)
        ans += min(cnt[i], 2);
    cout << ans;
}