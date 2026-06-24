
####################################
# Test Harness Script for customi- #
#  -sed Python CRUD Module         #
####################################

#
# By Alexander Ahmann 
#   <alexander.ahmann@snhu.edu>
#

# Basic Procedure:
#   (note that this might not work outside of a Jupyter Notebook)
# 1. Import CRUD Python module (and other relevant Python libraries)

import pprint # import for better print formatting
from IPython.display import Markdown, display # import for Markdown formatting

from CRUD_Python_Module import * # the custom CRUD module

# 2. Instantiate an instance of the CRUD Python module (and other variables)

mongo_instance = AnimalShelter()
MAX_PRINTOUT = 5 # the maximum number of BSON documents to print out
  # after running a find query.

def render_markdown(markdown):
    display(
        Markdown(
            markdown
        )
    )
    
# 3. Use the read function to return records from the aac database

read_test_cases = {
    "All documents": {},
    "Dogs with 'age_upon_outcome' under 2 years": {
        "animal_type":"Dog",
        "age_upon_outcome": { 
            "$in": [
                "0 years", "1 day", "1 month", "1 week",
                "11 months", "2 days", "2 months", "2 weeks",
                "2 years", "3 days", "3 months", "3 weeks",
                "1 weeks", "1 year", "10 months",
                "4 days", "4 months", "4 weeks", 
                "5 days", "5 months", "5 weeks",
                "6 days", "6 months", "6 weeks",
                "7 days", "7 months", "7 weeks",
                "8 days", "8 months", "8 weeks",
                "9 days", "9 months", "9 weeks",
            ]
        } # As specified in the Project 1 guidelines, an ideal kind of
          #   rescue dog is one that is no older than 2 years of age.
    }
}

render_markdown("## 1. Test cases for ``.read()`` function:")
  # A header for this script's section on testing read functionality

for k, v in read_test_cases.items():
    render_markdown("### Results for test case (read): \"{0}\": ".format(k))
        # print test case label as a markdown header
    
    results = mongo_instance.read(v)
    
    render_markdown(
        "\n\n__Total documents for {0}: {1}__\n\n".format(
            k, len(results)
        )
    )
    render_markdown(
        "\n\n__Sample output for {0}:__\n\n".format(
        k          
    ))
    if len(results) > MAX_PRINTOUT:
        pprint.pp(results[0:MAX_PRINTOUT]) # print out the first
          # five items in the returned list of documents
    else:
        pprint.pp(results) # print out all the documents (which
          # will have a count that is less than 5).
          
# 4. Use the create function to create a new record in the aac database

insert_test_cases = {
    
    "Test Case #1": {
        'tid': 'test_case_1',
        'rec_num': 20001,
        'age_upon_outcome': '1 year',
        'animal_id': 'TA736551',
        'animal_type': 'Dog',
        'breed': 'Labrador Retriever/Australian Cattle Dog',
        'color': 'Black',
        'date_of_birth': '2015-10-12',
        'datetime': '2016-11-27 18:00:00',
        'monthyear': '2016-11-27T18:00:00',
        'name': '*',
        'outcome_subtype': '',
        'outcome_type': 'Adoption',
        'sex_upon_outcome': 'Spayed Female',
        'location_lat': 30.4443212820182,
        'location_long': -97.7326980338793,
        'age_upon_outcome_in_weeks': 58.9642857142857
    },
    
    "Test Case #2": {
        "tid": 'test_case_2',
        'rec_num': 20002,
        'age_upon_outcome': '5 months',
        'animal_id': 'TA693288',
        'animal_type': 'Cat',
        'breed': 'Domestic Shorthair Mix',
        'color': 'Orange',
        'date_of_birth': '2013-09-28',
        'datetime': '2013-12-09 18:36:00',
        'monthyear': '2013-12-09T18:36:00',
        'name': '*Brain',
        'outcome_subtype': '',
        'outcome_type': 'Adoption',
        'sex_upon_outcome': 'Spayed Female',
        'location_lat': 30.4527678292931,
        'location_long': -97.4620507167676,
        'age_upon_outcome_in_weeks': 10.3964285714286
    }, # Regarding the first and second test cases, they have key/value pairs
      # that are very similar to the "average document" in the database.
    
    "Test Case #3": {
        'tid': 'test_case_3',
        'age_upon_outcome': '5 months',
        'animal_id': 'TA693288',
        'animal_type': 'Cat',
        'breed': 'Domestic Shorthair Mix',
        'color': 'Orange',
        'date_of_birth': '2013-09-28',
        'datetime': '2013-12-09 18:36:00',
        'name': '*Moning',
        'outcome_type': 'Adoption',
        'sex_upon_outcome': 'Spayed Female',
    }, # Regarding the third test case, it is a version of the second test case
      # but with some fields removed. This is to demonstrate the flexibility in
      # what fields get included in BSON documents.
    
    "Test Case #4": {
        'tid': 'test_case_4',
        'certificate_number': 666,
        'business_name': 'DarkSydePhil',
        'date': 'April 20, 1984',
        'result': 'Shoutout to HeyArVy',
        'sector': 'lolcow gamers'
    },
    
    "Test Case #5": {
        'tid': 'test_case_5',
        'certificate_number': 777,
        'business_name': 'WingsOfRedemption',
        'date': 'April 20, 1985',
        'result': 'Shoutout to HeyArVy (again :p)',
        'sector': 'lolcow gamers',
        'address': {
            'number': 7777,
            'street':'@WingsTings',
            'city':'Richards',
            'zip':90210
        }
    } # Regarding the next two test cases: the different fields in both 
      # test cases demonstrate the flexability in what kinds of data that MongoDB
      # collections can store, and how fields can vary from document-to-document.
}

render_markdown("## 2.1. Test cases for ``.create()`` function:")
for k, v in insert_test_cases.items():
    render_markdown("### Test case (create): {0}".format(k))
    print("\nDocument to be inserted: {0}\n".format(v))
    
    successful = mongo_instance.create(v)
    if successful:
        render_markdown("__Successfully inserted new document.__")
    else:
        render_markdown("__Failed to insert new document.__")
        
test_documents_queries = {
    "Test Case #1": {"tid":"test_case_1"},
    "Test Case #2": {"tid":"test_case_2"},
    "Test Case #3": {"tid":"test_case_3"},
    "Test Case #4": {"tid":"test_case_4"},
    "Test Case #5": {"tid":"test_case_5"},
} # To avoid breaking the dataset, I will test the update / 
  # delete functions against the newly created test cases
    
render_markdown("## 2.2. Contents of the test cases:")

for k, v in test_documents_queries.items():
    render_markdown("### Specifically, contents of: {0}".format(k))
    
    results = mongo_instance.read(v)
    pprint.pp(results)

# 5. Use the update function to update an existing record in the aac database

update_test_cases = {
    "Test Case #1":[
        {"tid":"test_case_1"}, {"age_upon_outcome": "6 months"}
    ],
    
    "Test Case #2":[
        {"tid":"test_case_4"}, {"sector": "still a lolcow gamer"}
    ],
    
    "Test Case #3":[
        {"tid":"test_case_5"}, {"sector": "still a lolcow gamer"}
    ]
}

render_markdown("## 3.1. Test cases for ``.update()`` function:")
for k, v in update_test_cases.items():
    render_markdown("### Test case (update): {0}".format(k))
    results = mongo_instance.update(
        v[0], v[1]
    )
    render_markdown("__Number of documents affected: {0}__\n\n".format(results))
    render_markdown("__Contents of the documents affected:__\n\n")
    after = mongo_instance.read(v[0])
    
    if len(after) > MAX_PRINTOUT:
        pprint.pp(after[0:MAX_PRINTOUT])
    else:
        pprint.pp(after)

# 6. Use the delete function to delete an existing record in the aac database

delete_test_cases = {
    "Test Case 1": {"tid": "test_case_1"},
    "Test Case 2": {"tid": "test_case_2"},
    "Test Case 3": {"tid": "test_case_3"},
    "Test Case 4": {"tid": "test_case_4"},
    "Test Case 5": {"tid": "test_case_5"}
}

render_markdown("## 4.1. Test cases for ``.update()`` function:")
for k, v in delete_test_cases.items():
    render_markdown("### Test case (delete): {0}".format(k))
    results = mongo_instance.delete(v)
    
    render_markdown("Number of documents affected: {0}".format(results))

