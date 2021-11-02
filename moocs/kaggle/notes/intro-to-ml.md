# Intro to Machine Learning Notes

### Basic data exploration

Import ``pandas`` library
```python
import pandas as pd
```

Load and describe basic statistics
```python
melbourne_file_path = '../input/melbourne-housing-snapshot/melb_data.csv' # save filepath to variable for easier access
melbourne_data = pd.read_csv(melbourne_file_path) # read the data and store data in DataFrame titled melbourne_data
melbourne_data.describe() # print a summary of the data in Melbourne data
```

### Your first machine learning model

Get a list of columns:
```python
melbourne_file_path = '../input/melbourne-housing-snapshot/melb_data.csv'
melbourne_data = pd.read_csv(melbourne_file_path) 
melbourne_data.columns

melbourne_data = melbourne_data.dropna(axis=0) # dropna drops missing values (think of na as "not available")
```

Select a response variable and features:
```python
y = melbourne_data.Price #selecting the response variable
X = ['Rooms', 'Bathroom', 'Landsize', 'Lattitude', 'Longtitude'] #selecting the feature space
X.describe() #descriptive statistics re. the feature space
X.head() #list the first few entries in dataset
```

A simple DecisionTree model:
```python
from sklearn.tree import DecisionTreeRegressor

melbourne_model = DecisionTreeRegressor(random_state=1) # Define model. Specify a number for random_state to ensure same results each run
melbourne_model.fit(X, y) # Fit model
```

Make predictions with the model:
```python
print("Making predictions for the following 5 houses:")
print(X.head())
print("The predictions are")
print(melbourne_model.predict(X.head())) #the thing predicted
```

### Model validation

Prediction error formula: ``error = actual - predicted``

Calculation of the mean absolute error:
```python
from sklearn.metrics import mean_absolute_error

predicted_home_prices = melbourne_model.predict(X)
mean_absolute_error(y, predicted_home_prices)
```

Model validation implementation:
```python
from sklearn.model_selection import train_test_split

# split data into training and validation data, for both features and target
# The split is based on a random number generator. Supplying a numeric value to
# the random_state argument guarantees we get the same split every time we
# run this script.

train_X, val_X, train_y, val_y = train_test_split(X, y, random_state = 0)
melbourne_model = DecisionTreeRegressor() # Define model
melbourne_model.fit(train_X, train_y) # Fit model

val_predictions = melbourne_model.predict(val_X) # get predicted prices on validation data
print(mean_absolute_error(val_y, val_predictions))
```

### Underfitting and overfitting

Utility function for mean absolute error:
```python
from sklearn.metrics import mean_absolute_error
from sklearn.tree import DecisionTreeRegressor

# Function that works out mean absolute error given the maximum number of allowed leaf notes, as well as training and testing data set
def get_mae(max_leaf_nodes, train_X, val_X, train_y, val_y):
    model = DecisionTreeRegressor(max_leaf_nodes=max_leaf_nodes, random_state=0)
    model.fit(train_X, train_y)
    preds_val = model.predict(val_X)
    mae = mean_absolute_error(val_y, preds_val)
    return(mae)
```

For loop to compare the accuracy of different models:
```python
# compare MAE with differing values of max_leaf_nodes
for max_leaf_nodes in [5, 50, 500, 5000]:
    my_mae = get_mae(max_leaf_nodes, train_X, val_X, train_y, val_y)
    print("Max leaf nodes: %d  \t\t Mean Absolute Error:  %d" %(max_leaf_nodes, my_mae))
```

### Random forests

Setting up a statistical model for random forest:
```python
from sklearn.ensemble import RandomForestRegressor
from sklearn.metrics import mean_absolute_error

forest_model = RandomForestRegressor(random_state=1)
forest_model.fit(train_X, train_y)
melb_preds = forest_model.predict(val_X)
print(mean_absolute_error(val_y, melb_preds))
```

### Machine learning competitions (Kaggle)

Create a statistical model to be submitted:
```python
rf_model_on_full_data = RandomForestRegressor() # To improve accuracy, create a new Random Forest model which you will train on all training data
rf_model_on_full_data.fit(X, y) # fit rf_model_on_full_data on all data from the training data
```

Make predictions with statistical model:
```python
test_data_path = '../input/test.csv' # path to file you will use for predictions
test_data = pd.read_csv(test_data_path) # read test data file using pandas

# create test_X which comes from test_data but includes only the columns you used for prediction.
test_X = test_data[features] # The list of columns is stored in a variable called features
test_preds = rf_model_on_full_data.predict(test_X) # make predictions which we will submit. 

# The lines below shows how to save predictions in format used for competition scoring
# Just uncomment them.

output = pd.DataFrame({'Id': test_data.Id,
                       'SalePrice': test_preds})
output.to_csv('submission.csv', index=False)
```

### Submitting solution to Kaggle:

1. Join a competition
2. Begin by clicking on the blue Save Version button in the top right corner of the window. This will generate a pop-up window.
3. Ensure that the Save and Run All option is selected, and then click on the blue Save button.
4. This generates a window in the bottom left corner of the notebook. After it has finished running, click on the number to the right of the Save Version button. This pulls up a list of versions on the right of the screen. Click on the ellipsis (...) to the right of the most recent version, and select Open in Viewer. This brings you into view mode of the same page. You will need to scroll down to get back to these instructions.
5. Click on the Output tab on the right of the screen. Then, click on the blue Submit button to submit your results to the leaderboard.

