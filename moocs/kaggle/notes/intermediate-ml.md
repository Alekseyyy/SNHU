
# Intermediate Machine Learning Notes

### Missing values

Methods to deal with missing data:

1. Drop rows with missing data
2. Imputation: fill in the missing values with a number (s.a. the arithmetic mean of existing data)
3. Extended imputation: imputate, but add an extra column stating that the cell was imputated

Libraries:
```python
import pandas as pd
from sklearn.model_selection import train_test_split
```

Code to work out the statistics re. shape of training data
and the number of missing data for each cell:
```python
print(X_train.shape) # Shape of training data (num_rows, num_columns)

# Number of missing values in each column of training data
missing_val_count_by_column = (X_train.isnull().sum())
print(missing_val_count_by_column[missing_val_count_by_column > 0])
```

Drop any rows with missing values:
```python
missing_cols = [col for col in X_train.columns 
                if X[col].isnull().any()] # Get names of columns with missing values

# Drop columns in training and validation data
reduced_X_train = X_train.drop(missing_cols, axis=1)
reduced_X_valid = X_valid.drop(missing_cols, axis=1)
```

__REMINDER:__ code to work out mean absolute error of random forest models:

```python
from sklearn.ensemble import RandomForestRegressor
from sklearn.metrics import mean_absolute_error

# Function for comparing different approaches
def score_dataset(X_train, X_valid, y_train, y_valid):
    model = RandomForestRegressor(n_estimators=100, random_state=0)
    model.fit(X_train, y_train)
    preds = model.predict(X_valid)
    return mean_absolute_error(y_valid, preds)
```

Code for imputation:
```python
from sklearn.impute import SimpleImputer

# Imputation
imputer = SimpleImputer() 
imputed_X_train = pd.DataFrame(imputer.fit_transform(X_train))
imputed_X_valid = pd.DataFrame(imputer.transform(X_valid))

# Imputation removed column names; put them back
imputed_X_train.columns = X_train.columns
imputed_X_valid.columns = X_valid.columns
```

### 
