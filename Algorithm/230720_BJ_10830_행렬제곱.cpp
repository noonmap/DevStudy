#include <iostream>
using namespace std;
#define DIV 1000

int N;
long long B;
//int ans[5][5] = {0,};

void init(int ans[5][5]){
    for(int r=0; r<N; r++){
        for(int c=0; c<N; c++){
            if(r==c) ans[r][c] = 1;
            else ans[r][c] = 0;
        }
    }
}
void multi(int m1[5][5], int m2[5][5]){
    int tmp[5][5] = {0,};
    for(int r=0; r<N; r++){
        for(int c=0; c<N; c++){
            for(int k=0; k<N; k++){
                tmp[r][c] += m1[r][k] * m2[k][c];
            }
        }
    }
    for(int r=0; r<N; r++){
        for(int c=0; c<N; c++){
            m1[r][c] = tmp[r][c] % DIV;
        }
    }
}
void printSolution(int ans[5][5]){
    for(int i=0; i<N; i++){
        for(int j=0; j<N; j++){
            cout << ans[i][j] << " ";
        }
        cout << '\n';
    }
}
void solve(int m[5][5]){
    int ans[5][5];
    init(ans);
    while(B!=0){
        if((long long)(1 & B) > 0){
            multi(ans, m);
        }
        multi(m, m);
        B = B >> 1;
    }
    printSolution(ans);
}

int main(){
	ios::sync_with_stdio(false);
    cin >> N >> B;

    int m[5][5];
    for(int i=0; i<N; i++){
        for(int j=0; j<N; j++){
            cin >> m[i][j];
        }
    }
    solve(m);

	return 0;
}
