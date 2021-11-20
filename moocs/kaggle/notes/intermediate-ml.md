
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

### Categorical variables

Code for dropping categorical variables:

```python
drop_X_train = X_train.select_dtypes(exclude=["object"])
drop_X_valid = X_valid.select_dtypes(exclude=["object"])
```

Code for working out the "unique" entries in a column:

```python
print("Unique values in 'Condition2' column in training data:", X_train['Condition2'].unique())
print("\nUnique values in 'Condition2' column in validation data:", X_valid['Condition2'].unique())
```

Code for extracting out the categories in columns:

```python
# Categorical columns in the training data
object_cols = [col for col in X_train.columns if X_train[col].dtype == "object"]

# Columns that can be safely ordinal encoded
good_label_cols = [col for col in object_cols if 
                   set(X_valid[col]).issubset(set(X_train[col]))]
        
# Problematic columns that will be dropped from the dataset
bad_label_cols = list(set(object_cols)-set(good_label_cols))
        
print('Categorical columns that will be ordinal encoded:', good_label_cols)
print('\nCategorical columns that will be dropped from the dataset:', bad_label_cols)
```

Setup the ordinal encoder:

```python
from sklearn.preprocessing import OrdinalEncoder

# Make copy to avoid changing original data 
label_X_train = X_train.copy()
label_X_valid = X_valid.copy()

# Apply ordinal encoder to each column with categorical data
ordinal_encoder = OrdinalEncoder()
label_X_train[object_cols] = ordinal_encoder.fit_transform(X_train[object_cols])
label_X_valid[object_cols] = ordinal_encoder.transform(X_valid[object_cols])

print("MAE from Approach 2 (Ordinal Encoding):") 
print(score_dataset(label_X_train, label_X_valid, y_train, y_valid))
```

Get and print frequency of occurance for each category

```python
# Get number of unique entries in each column with categorical data
object_nunique = list(map(lambda col: X_train[col].nunique(), object_cols))
d = dict(zip(object_cols, object_nunique))

sorted(d.items(), key=lambda x: x[1]) # Print number of unique entries by column, in ascending order
```

Function to work out which columns to drop and be one-hot encoded:

```python
# Columns that will be one-hot encoded
low_cardinality_cols = [col for col in object_cols if X_train[col].nunique() < 10]

# Columns that will be dropped from the dataset
high_cardinality_cols = list(set(object_cols)-set(low_cardinality_cols))

print('Categorical columns that will be one-hot encoded:', low_cardinality_cols)
print('\nCategorical columns that will be dropped from the dataset:', high_cardinality_cols)
```
