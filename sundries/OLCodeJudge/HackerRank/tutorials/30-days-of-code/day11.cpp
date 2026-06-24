/*
 * Tutorial: 30 Days of Code.
 * A solution to "Day 11: 2D Arrays"
 *   Submitted by A. S. "Aleksey" Ahmann <alekseyyy2@outlook.com>
 *   Submitted on Feb. 28, 2024
 *   Link: https://www.hackerrank.com/challenges/30-2d-arrays/problem
 * 
 * Task description: 
 */


#include <bits/stdc++.h>

using namespace std;

int HourglassSum(vector<vector<int>> matrix, int row, int col);
int MaximalHGSum(vector<int> hgSums);

string ltrim(const string &);
string rtrim(const string &);
vector<string> split(const string &);

int main()
{
    vector<vector<int>> arr(6);
    for (int i = 0; i < 6; i++) {
        arr[i].resize(6);

        string arr_row_temp_temp;
        getline(cin, arr_row_temp_temp);

        vector<string> arr_row_temp = split(rtrim(arr_row_temp_temp));

        for (int j = 0; j < 6; j++) {
            int arr_row_item = stoi(arr_row_temp[j]);

            arr[i][j] = arr_row_item;
        }
    }
    
    vector<int> hourglassSums;
    for (int row = 1; row < 5; row++) {
        for (int col = 1; col < 5; col++) {
            int hourglassSum_crc = HourglassSum(arr, row, col);
            hourglassSums.push_back(hourglassSum_crc);
        }
    }
    
    int maxHourglassSum = MaximalHGSum(hourglassSums);
    cout << maxHourglassSum << endl;

    return 0;
}

int HourglassSum(vector<vector<int>> matrix, int row, int col) {
    int e1 = matrix[row][col]; // hour-glass centre
    int e2 = matrix[row - 1][col]; //hour-glass mid-top
    int e3 = matrix[row + 1][col]; //hour-glass mid-bottom
    int e4 = matrix[row - 1][col - 1]; //hour-glass top-left
    int e5 = matrix[row - 1][col + 1]; //hour-glass top-right
    int e6 = matrix[row + 1][col - 1]; //hour-glass bottom-left
    int e7 = matrix[row + 1][col + 1]; //hour-glass bottom-right
    return e1 + e2 + e3 + e4 + e5 + e6 + e7;
}

int MaximalHGSum(vector<int> hgSums) {
    int max = hgSums[0];
    for (int sum : hgSums) {
        if (sum > max)
            max = sum;
    }
    return max;
}

string ltrim(const string &str) {
    string s(str);

    s.erase(
        s.begin(),
        find_if(s.begin(), s.end(), not1(ptr_fun<int, int>(isspace)))
    );

    return s;
}

string rtrim(const string &str) {
    string s(str);

    s.erase(
        find_if(s.rbegin(), s.rend(), not1(ptr_fun<int, int>(isspace))).base(),
        s.end()
    );

    return s;
}

vector<string> split(const string &str) {
    vector<string> tokens;

    string::size_type start = 0;
    string::size_type end = 0;

    while ((end = str.find(" ", start)) != string::npos) {
        tokens.push_back(str.substr(start, end - start));

        start = end + 1;
    }

    tokens.push_back(str.substr(start));

    return tokens;
}

