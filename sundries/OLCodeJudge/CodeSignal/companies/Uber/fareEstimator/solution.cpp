/* CodeSignal Company Challenges
 *
 * A solution to Uber's "fareEstimator" challenge
 * By A. S. "Aleksey" Ahmann, hackermaneia@riseup.net
 *
 * UPDATE 8 Aug., 2021: I fixed a few amateurish mistakes based on the advice on this StackExchange thread: 
 * https://codereview.stackexchange.com/questions/265810/an-implementation-of-ubers-fare-estimator
*/

double estimationForumla(int ride_time, int ride_distance, double cost_per_minute, double cost_per_mile) {
    return (cost_per_minute * ride_time) + (cost_per_mile * ride_distance);
}

vector<double> fareEstimator(int ride_time, int ride_distance, const vector<double>& cost_per_minute, const vector<double>& cost_per_mile) {
    
    vector<double> estimates;
    for (size_t i = 0; i < cost_per_minute.size(); i++)
        estimates.push_back(estimationForumla(ride_time, ride_distance, cost_per_minute[i], cost_per_mile[i]));
    
    return estimates;
}
