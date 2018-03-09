#include <cstdio>
#include <vector>
#include <algorithm>

using namespace std;

bool a[2000][2000];
vector<int> g[2000];
vector<pair<int, int>> edges;

int main(){
    int n,m;
    scanf("%d %d",&n,&m);
    for (int i = 0 ; i < m; i++){
        int u,v;
        scanf("%d %d",&u,&v);
        edges.push_back({u,v});
        edges.push_back({v,u});
        a[u][v] = a[v][u] = true;
        g[u].push_back(v);
        g[v].push_back(u);
    }
    
    m *= 2;
    for(int i = 0 ; i < m; i++){
        for(int j = 0 ; j < m ; j++){
            
        }
    }
}
