#include<vector>
#include<iostream>
using namespace std;

vector<string> split_string(string);

/*
 * Complete the virusIndices function below.
 */
void virusIndices(string p, string v) {
    /*
     * Print the answer for this test case in a single line
     */
    vector<int> ans;
    int lenP = (int) p.length();
    int lenV = (int)v.length();
    for(int i = 0 ; i <= lenP-lenV; i++){
        string subStr = p.substr(i,lenV);
        int count=0;
        for(int j = 0; j < lenV; j++){
            if(subStr[j] == v[j])
                count++;
        }
        if(count >= lenV - 1)
            ans.push_back(i);
    }
    int vSize = (int) ans.size();
    if(vSize == 0){
        cout << "No Match!" << '\n';
    }else{
        for( auto i : ans){
            cout << i << ' ';
        }
        cout << '\n';
    }
    
}

int main()
{
    int t;
    cin >> t;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');
    
    for (int t_itr = 0; t_itr < t; t_itr++) {
        string pv_temp;
        getline(cin, pv_temp);
        
        vector<string> pv = split_string(pv_temp);
        
        string p = pv[0];
        
        string v = pv[1];
        
        virusIndices(p, v);
    }
    
    return 0;
}

vector<string> split_string(string input_string) {
    string::iterator new_end = unique(input_string.begin(), input_string.end(), [] (const char &x, const char &y) {
        return x == y and x == ' ';
    });
    
    input_string.erase(new_end, input_string.end());
    
    while (input_string[input_string.length() - 1] == ' ') {
        input_string.pop_back();
    }
    
    vector<string> splits;
    char delimiter = ' ';
    
    size_t i = 0;
    size_t pos = input_string.find(delimiter);
    
    while (pos != string::npos) {
        splits.push_back(input_string.substr(i, pos - i));
        
        i = pos + 1;
        pos = input_string.find(delimiter, i);
    }
    
    splits.push_back(input_string.substr(i, min(pos, input_string.length()) - i + 1));
    
    return splits;
}
